package formalGrammar;
import org.jcsp.lang.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by luciano on 6/15/17.
 */
public class Manager implements CSProcess{

	public class Petition {
		ChannelOutput replyChannel;
		Rule rule;

		public Petition(ChannelOutput replyChannel, Rule rule) {
			this.replyChannel = replyChannel;
			this.rule = rule;
		}
	}

	private Any2OneChannel ruleChannel;
	private Alphabet alphabet;
	private String begin;

	public Manager(Alphabet alphabet, String begin) {
		ruleChannel = Channel.any2one();
		this.alphabet = alphabet;
		this.begin = begin;
	}

	public void write(Object[] obj) {
		ruleChannel.out().write(obj);
		((ChannelInput) obj[0]).read();
	}

	public void run() {
		String word;

		Queue<Petition> petitions = new LinkedList<>();

		while (true) {
			word = begin;
			Object[] obj = (Object[]) ruleChannel.in().read();
			Petition pet = new Petition((ChannelOutput) obj[0], (Rule) obj[1]);
			petitions.add(pet);

			Queue<Petition> newPetitions = new LinkedList<>();
			Petition petition;
			String newWord;
			while ((petition = petitions.poll()) != null) {
				if ((newWord = petition.rule.evaluateAndUpdate(word, alphabet)) != null) {
					word = newWord;
					petition.replyChannel.write(null);
				}
				else {
					newPetitions.add(petition);
				}
			}
			System.out.println("Word generated: " + word);
			petitions = newPetitions;
		}


	}
}


/*
Still to think:
	- How to evaluate the rule
	- How to decide if the word is ready - when all the characters are terminal
 */