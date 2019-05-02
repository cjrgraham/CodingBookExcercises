package Chapter1.question1_2;

import java.util.function.IntUnaryOperator;

class ArrayCharFrequencyRecorder implements CharFrequencyRecorder {
	private static final int asciiLowerAlphabetStartCode = 97;
	private static final int asciiUpperAlphabetStartCode = 1;
	private int frequencyArray[];
	
	
	protected ArrayCharFrequencyRecorder() {
		frequencyArray = new int[90];
	}
	
	public int getOccurences(char character) {
		int placeInAlphabet = this.getPlaceInAlphabet(character);
		int letterOccurences = frequencyArray[placeInAlphabet];
		return letterOccurences;
	}

	public void removeOccurence(char character) {
		this.modifyCharOccurence(character, i -> i - 1);
	}
	
	public void recordOccurrence(char character) {
		this.modifyCharOccurence(character, i -> i + 1);
	}
	
	private void modifyCharOccurence(char character,IntUnaryOperator function) {
		int placeInAlphabet = this.getPlaceInAlphabet(character);
		int letterOccurrences = frequencyArray[placeInAlphabet];
		letterOccurrences = function.applyAsInt(letterOccurrences);
		frequencyArray[placeInAlphabet] = letterOccurrences;
	}
	
	private int getPlaceInAlphabet(char character) {
		int charAsciiCode = (int) character;
		int asciiAlphabetStartCode = getAsciiAlphabetStartCode(character);
		int alphabetPlace = charAsciiCode - asciiAlphabetStartCode;
		return alphabetPlace;
	}
	
	private int getAsciiAlphabetStartCode(char character) {
		int AsciiAlphabetStartCode;
		boolean isCharacterUppercase = Character.isUpperCase(character);
		if (isCharacterUppercase){
			AsciiAlphabetStartCode = asciiUpperAlphabetStartCode;
		}
		else {
			AsciiAlphabetStartCode = asciiLowerAlphabetStartCode;
		}
		return AsciiAlphabetStartCode;
	}

}
