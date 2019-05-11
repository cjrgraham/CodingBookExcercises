package Chapter1.question1_4;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class PalindromePermutationChecker {
	private static final IntPredicate isOddLambda = i -> (i%2) != 0;
	private static final IntPredicate isWhiteSpaceLambda = i->!Character.isWhitespace(i);
	private static final IntUnaryOperator toLowerCaseLambda = i->Character.toLowerCase(i);
	
	private CharFrequencyRecorder frequencyRecorder;
	private IntUnaryOperator getOccurencesLambda;
	
	protected PalindromePermutationChecker(CharFrequencyRecorder frequencyRecorder) {
		this.frequencyRecorder = frequencyRecorder;
		this.getOccurencesLambda = i->this.frequencyRecorder.getOccurences((char) i);
	}
	
	public boolean checkPalPermutations(String stringToCheck) {
		this.recordOccurences(stringToCheck);
		boolean isPalPermutation = this.checkOddOccurencesLimited(stringToCheck);
		return isPalPermutation;
	}
	
	
	private boolean checkOddOccurencesLimited(String stringToCheck) {
		int oddOccurencesLimit = this.getOddOccurencesLimit(stringToCheck);
		
		boolean oddOccurencesBelowLimit = stringToCheck.chars()
													   .filter(isWhiteSpaceLambda)
													   .map(toLowerCaseLambda)
													   .distinct()
										  	     	   .map(getOccurencesLambda)
										  	           .filter(isOddLambda)
			 							  		       .count() <= oddOccurencesLimit;
		
		return oddOccurencesBelowLimit;
	}
	
	private int getOddOccurencesLimit(String stringToCheck) {
		int oddOccurencesLimit = 0;
		int characterCount = getCharacterCount(stringToCheck);
		boolean stringLengthIsOdd = (characterCount%2) != 0;
		if(stringLengthIsOdd) {
			oddOccurencesLimit = 1;
		}
		return oddOccurencesLimit;
	}
	
	private int getCharacterCount(String stringToCount) {
		int characterCount = 0;
		char[] stringChars = stringToCount.toCharArray();
		for(char character:stringChars) {
			if (Character.isLetter(character)){
				characterCount++;
			}
		}
		return characterCount;
	}
	
	private void recordOccurences(String stringToRemove) {
		modifyOccurences(stringToRemove,
						 i->this.frequencyRecorder.recordOccurrence(i));
	}
	
	private void modifyOccurences(String stringToRecord, Consumer<Character>occurenceModifier) {
		char[] stringLetters = stringToRecord.toCharArray();
		for(char letter:stringLetters) {
			if(Character.isLetter(letter)) {
				occurenceModifier.accept(Character.toLowerCase(letter));
			}
		}
	}
	
}
