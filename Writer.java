package formalGrammar;
import org.jcsp.lang.CSProcess;
import org.jcsp.lang.ChannelOutput;

/**
 * Created by luciano on 6/14/17.
 */
public class Writer implements CSProcess {

	private Rule rule;
	private Manager manager;

	public Writer(Rule rule, Manager manager) {
		this.rule = rule;
		this.manager = manager;
	}

	public void run() {
		while (true) {
			manager.write(rule);
		}
	}

}
