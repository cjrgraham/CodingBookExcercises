package Chapter1.question1_2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Consumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Chapter1.question1_2.ArrayCharFrequencyRecorder;

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
	void recordsLowerA() {
		char letterA = 'a';
		checkSingleCharRecorded(letterA);
	}

	@Test
	void recordsLowerZ() {
		char letterZ = 'z';
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
	
	@Test
	void checkCharsRemoved() {
		char letterM = 'M';
		checkCharRemovedTimes(letterM,-3);
	}
	
	private void checkSingleCharRecorded(char character) {
		checkCharRecordedTimes(character,
							   1);
	}
	
	private void checkCharRemovedTimes(char character,int times) {
		checkCharModifiedTimes(character,
							   times,
							   i->arrayFrequencyRecorder.removeOccurence(i));
	}
	
	private void checkCharRecordedTimes(char character,int times) {
		checkCharModifiedTimes(character,
							   times,
							   i->arrayFrequencyRecorder.recordOccurrence(i));
	}
	
	private void checkCharModifiedTimes(char character,int times,Consumer<Character> occurenceModifier) {
		modifyCharTimes(character,
						times,
						occurenceModifier);
		
		int occurences = arrayFrequencyRecorder.getOccurences(character);
		assertEquals(occurences,times);
	}
	
	private void modifyCharTimes(char character, int times, Consumer<Character> occurenceModifier) {
		for(int i = 0;i<Math.abs(times);i++) {
			occurenceModifier.accept(character);
		}
	}

}
