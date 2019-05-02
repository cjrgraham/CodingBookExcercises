package Chapter1.question1_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegrationTests {
	
	private ArrayCharFrequencyRecorder arrayCharFrequencyRecorder;
	private DuplicateChecker duplicateChecker;
	private static final String duplicateString = "abbcde";
	private static final String noDuplicateString = "abBcde";
	

	@BeforeEach
	void setUp() throws Exception {
		this.arrayCharFrequencyRecorder = new ArrayCharFrequencyRecorder();
		this.duplicateChecker = new DuplicateChecker(this.arrayCharFrequencyRecorder);
	}

	@Test
	void checkDuplicateString() {
		boolean isDuplicate = this.duplicateChecker.checkForDuplicates(duplicateString);
		assertTrue(isDuplicate);
	}
	
	@Test
	void checkNoDuplicateString() {
		boolean isDuplicate = this.duplicateChecker.checkForDuplicates(noDuplicateString);
		assertFalse(isDuplicate);
	}
	
}
