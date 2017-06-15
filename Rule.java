package formalGrammar;
import org.jcsp.lang.ChannelOutput;

/**
 * Created by luciano on 6/14/17.
 */
public class Rule {
	private String expression;
	private String input;
	private int id;
	private int blocksAfter;

	public Rule(int id, String input, String expression, int blocksAfter) {
		this.expression = expression;
		this.input = input;
		this.id = id;
		this.blocksAfter = blocksAfter;
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

		/*
		Count how many uses. If it is -1 then skip the process. When it blocks, just return a null
		 */
		return null;
	}

}
