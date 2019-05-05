package Chapter1.question1_2;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class PermutationChecker {
	private CharFrequencyRecorder frequencyRecorder;
	private IntUnaryOperator getOccurencesLambda;
	
	protected PermutationChecker(CharFrequencyRecorder frequencyRecorder) {
		this.frequencyRecorder = frequencyRecorder;
		this.getOccurencesLambda = i->this.frequencyRecorder.getOccurences((char) i);
	}
	
	public boolean checkStringsArePermutations(String stringA, String stringB) {
		boolean arePermutations;
		
		if (stringA.length()!=stringB.length()) {
			arePermutations = false;
		}
		else
		{
			arePermutations = this.checkStringsHaveSameLetters(stringA,stringB);
		}
		
		return arePermutations;
	}
	
	private boolean checkStringsHaveSameLetters(String stringA, String stringB) {
		this.tryBalanceOccurences(stringA,stringB);
		boolean haveSameLetters = this.checkStringOccurencesBalance(stringA,stringB);
		return haveSameLetters;
	}
	
	private void tryBalanceOccurences(String stringA,String stringB) {
		this.recordOccurences(stringA);
		this.removeOccurences(stringB);
	}
	
	private boolean checkStringOccurencesBalance(String stringA, String stringB) {
		boolean occurencesCancelOut = false;
		
		IntStream stringACharStream = stringA.chars();
		IntStream stringBCharStream = stringB.chars();
		IntStream bothStringsCharsStream = IntStream.concat(stringACharStream, stringBCharStream);
		
		occurencesCancelOut = bothStringsCharsStream.distinct()
							  						.map(this.getOccurencesLambda)
							  						.allMatch(i->i==0);
		return occurencesCancelOut;
	}
	
	private void recordOccurences(String stringToRemove) {
		modifyOccurences(stringToRemove,
						 i->this.frequencyRecorder.recordOccurrence(i));
	}
	
	private void removeOccurences(String stringToRemove) {
		modifyOccurences(stringToRemove,
						 i->this.frequencyRecorder.removeOccurence(i));
	}
	
	private void modifyOccurences(String stringToRecord, Consumer<Character>occurenceModifier) {
		char[] stringLetters = stringToRecord.toCharArray();
		for(char letter:stringLetters) {
			occurenceModifier.accept(letter);
		}
	}
	
}
