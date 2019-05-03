package Chapter1.question1_2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegrationTests {
	
	private ArrayCharFrequencyRecorder arrayCharFrequencyRecorder;
	private PermutationChecker permutationChecker;
	private static final String[] sameLengthNotPermutations = {"abcdef","ghijkl"};
	private static final String[] arePermutations = {"abcdef","fedabc"};
	private static final String[] differentLengths = {"abc","fedabc"};
	

	@BeforeEach
	void setUp() throws Exception {
		this.arrayCharFrequencyRecorder = new ArrayCharFrequencyRecorder();
		this.permutationChecker = new PermutationChecker(this.arrayCharFrequencyRecorder);
	}

	@Test
	void checkArePermutations() {
		boolean arePermutations = this.permutationChecker
				  						 .checkStringsArePermutations(
				  								 					  this.arePermutations[0],
				  								 					  this.arePermutations[1]);
		assertTrue(arePermutations);
	}
	
	@Test
	void checkNotPermutationsSameLength() {
		boolean arePermutations = this.permutationChecker
								  	  .checkStringsArePermutations(
															       this.sameLengthNotPermutations[0],
															       this.sameLengthNotPermutations[1]);
		assertFalse(arePermutations);
	}
	
	@Test
	void checkNotPermutationsDifferentLength() {
		boolean arePermutations = this.permutationChecker
								  	  .checkStringsArePermutations(
															       this.differentLengths[0],
															       this.differentLengths[1]);
		assertFalse(arePermutations);
	}
	
}
