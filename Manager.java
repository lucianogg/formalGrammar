package formalGrammar;
import org.jcsp.lang.Any2OneChannel;
import org.jcsp.lang.CSProcess;
import org.jcsp.lang.Channel;

import java.util.Queue;

/**
 * Created by luciano on 6/15/17.
 */
public class Manager implements CSProcess{

	private Any2OneChannel ruleChannel;
	private Alphabet alphabet;

	public Manager(Alphabet alphabet) {
		ruleChannel = Channel.any2one();
		this.alphabet = alphabet;
	}

	public void write(Rule rule) {
		ruleChannel.out().write(rule);
	}

	public void run() {
		String word = "";



	}
}


/*
Still to think:
	- How to evaluate the rule
	- How to store the petitions
	- How to decide if the word is ready
 */