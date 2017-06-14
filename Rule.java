package formalGrammar;
import org.jcsp.lang.ChannelOutput;

/**
 * Created by luciano on 6/14/17.
 */
public class Rule {
	private String expression;
	private String input;
	private int id;

	public Rule(int id, String input, String expression) {
		this.expression = expression;
		this.input = input;
		this.id = id;
	}

	public String getExpression() {
		return expression;
	}

	public int getId() {
		return id;
	}

	public String evaluateAndUpdate(String word, Alphabet alphabet) {
		/*
		Returns null if it doesn't fit!!!!
		 */
		return null;
	}

}
