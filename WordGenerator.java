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
		Manager manager = new Manager(alphabet, "A");
		processes[0] = manager;
		// Writers
		//CAREFUL: For the sake of consistency, the rules are always unique, so each one goes to one process. If
		// you REALLY want different processes with the same rule, create it two times by yourself
		processes[1] = new Writer(new Rule(1, "A", "aA", -1), manager);
		processes[2] = new Writer(new Rule(2, "A", "a", -1), manager);

		system = new Parallel(processes);

		system.run();
	}

}
