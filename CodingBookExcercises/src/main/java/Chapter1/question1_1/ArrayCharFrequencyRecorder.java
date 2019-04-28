package Chapter1.question1_1;

class ArrayCharFrequencyRecorder implements CharFrequencyRecorder {
	private static final int asciiAlphabetStartCode = 97;
	private int frequencyArray[];
	
	
	protected ArrayCharFrequencyRecorder() {
		frequencyArray = new int[26];
	}

	public void recordOccurrence(char character) {
		int placeInAlphabet = this.getPlaceInAlphabet(character);
		int letterOccurrences = frequencyArray[placeInAlphabet];
		letterOccurrences++;
		frequencyArray[placeInAlphabet] = letterOccurrences;
	}
	
	private int getPlaceInAlphabet(char character) {
		char lowerCase = Character.toLowerCase(character);
		int charAsciiCode = (int) lowerCase;
		int alphabetPlace = charAsciiCode - asciiAlphabetStartCode;
		return alphabetPlace;
	}

	public int getOccurences(char character) {
		int placeInAlphabet = this.getPlaceInAlphabet(character);
		int letterOccurences = frequencyArray[placeInAlphabet];
		return letterOccurences;
	}

}
