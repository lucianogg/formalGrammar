package formalGrammar;
import org.jcsp.lang.CSProcess;
import org.jcsp.lang.Channel;
import org.jcsp.lang.One2OneChannel;


/**
 * Created by luciano on 6/14/17.
 */
public class Writer implements CSProcess {

	private Rule rule;
	private Manager manager;
	private One2OneChannel channel;

	public Writer(Rule rule, Manager manager) {
		this.rule = rule;
		this.manager = manager;
		this.channel = Channel.one2one();
	}

	public void run() {
		while (true) {
			Object[] object = new Object[2];
			object[0] = channel;
			object[1] = rule;
			manager.write(object);
		}
	}

}
