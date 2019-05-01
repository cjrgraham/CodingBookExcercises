package Chapter1.question1_1;

class DuplicateChecker {
	private CharFrequencyRecorder frequencyRecorder;
	
	protected DuplicateChecker(CharFrequencyRecorder frequencyRecorder) {
		this.frequencyRecorder = frequencyRecorder;
	}
	
	public boolean checkForDuplicates(String stringForCheck) {
		boolean isDuplicate = false;
		
		char[] letters = stringForCheck.toCharArray();
		for(char letter:letters) {
			this.frequencyRecorder.recordOccurrence(letter);
			if(hasDuplicateBeenFound(letter)) {
				isDuplicate = true;
				break;
			}
		}
		
		return isDuplicate;
	}
	
	private boolean hasDuplicateBeenFound(char letter) {
		int occurrencesSoFar = this.frequencyRecorder.getOccurences(letter);
		return occurrencesSoFar>1;
	}
	
}
