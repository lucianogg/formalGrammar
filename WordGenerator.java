package formalGrammar;
import org.jcsp.lang.CSProcess;
import org.jcsp.lang.Channel;
import org.jcsp.lang.Parallel;

/**
 * Created by luciano on 6/14/17.
 */
public class WordGenerator {
	public void main(final String[] args) throws InterruptedException {
		CSProcess[] processes = new CSProcess[2+1];
		CSProcess system;

		// Alphabet
		Alphabet alphabet = new Alphabet(new char[]{'a'}, new char[]{'A'});
		// Manager
		Manager manager = new Manager(alphabet);
		processes[0] = manager;
		// Writers
		processes[1] = new Writer(new Rule(1, "A", "aA"), manager);
		processes[2] = new Writer(new Rule(2, "A", "a"), manager);

		system = new Parallel(processes);

		system.run();
	}

}
