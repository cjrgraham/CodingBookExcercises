package Chapter1.question1_4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegrationTests {

	private ArrayCharFrequencyRecorder arrayCharFrequencyRecorder;
	private PalindromePermutationChecker permutationChecker;
	private static final String isPalindromePermutation = "Tact coa";
	private static final String isNotPalindromePermutation = "Tac coa";
	

	@BeforeEach
	void setUp() throws Exception {
		this.arrayCharFrequencyRecorder = new ArrayCharFrequencyRecorder();
		this.permutationChecker = new PalindromePermutationChecker(this.arrayCharFrequencyRecorder);
	}
	
	@Test
	void checkIsPalindromePermutation() {
		boolean isPalindromPermutation = this.permutationChecker.checkPalPermutations(isPalindromePermutation);
		assertTrue(isPalindromPermutation);
	}
	
	@Test
	void checkIsPalindromeNotPermutation() {
		boolean isPalindromPermutation = this.permutationChecker.checkPalPermutations(isNotPalindromePermutation);
		assertFalse(isPalindromPermutation);
	}

}
