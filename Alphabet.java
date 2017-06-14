package formalGrammar;
/**
 * Created by luciano on 6/15/17.
 */
public class Alphabet {
	private char[] terminalSymbols;
	private char[] nonTerminalSymbols;

	public Alphabet(char[] terminalSymbols, char[] nonTerminalSymbols) {
		this.terminalSymbols = terminalSymbols;
		this.nonTerminalSymbols = nonTerminalSymbols;
	}

	public boolean isTerminal(char a) {
		boolean term = false;
		for (int i=0; !term && i<terminalSymbols.length; i++) {
			if (terminalSymbols[i]==a)
				term = true;
		}
		return term;
	}

	public boolean isNonTerminal(char a) {
		boolean nonTerm = false;
		for (int i=0; !nonTerm && i<nonTerminalSymbols.length; i++) {
			if (nonTerminalSymbols[i]==a)
				nonTerm = true;
		}
		return nonTerm;
	}
}
