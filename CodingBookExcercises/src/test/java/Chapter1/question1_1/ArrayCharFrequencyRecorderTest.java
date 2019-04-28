package Chapter1.question1_1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayCharFrequencyRecorderTest {
	private ArrayCharFrequencyRecorder arrayFrequencyRecorder;

	@BeforeEach
	void setUp() throws Exception {
		arrayFrequencyRecorder = new ArrayCharFrequencyRecorder();
	}

	@Test
	void recordsMiddleAlphabeticalLetter() {
		char letterM = 'M';
		checkSingleCharRecorded(letterM);
	}
	
	@Test
	void recordsA() {
		char letterA = 'A';
		checkSingleCharRecorded(letterA);
	}

	@Test
	void recordsZ() {
		char letterZ = 'Z';
		checkSingleCharRecorded(letterZ);
	}
	
	@Test
	void recordsMultiple() {
		char letterM = 'M';
		checkCharRecordedTimes(letterM,3);
	}
	
	@Test
	void onlyRecordsPassedChars() {
		char letterM = 'M';
		int occurences = arrayFrequencyRecorder.getOccurences(letterM);
		assertEquals(occurences,0);
	}
	
	private void checkSingleCharRecorded(char character) {
		checkCharRecordedTimes(character,1);
	}
	
	private void checkCharRecordedTimes(char character,int times) {
		for(int i = 0;i<times;i++) {
			arrayFrequencyRecorder.recordOccurrence(character);
		}
		int occurences = arrayFrequencyRecorder.getOccurences(character);
		assertEquals(occurences,times);
	}
	
	
}
