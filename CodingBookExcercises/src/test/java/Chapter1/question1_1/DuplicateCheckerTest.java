package Chapter1.question1_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DuplicateCheckerTest {
	
	@Mock
	private CharFrequencyRecorder frequencyRecorder;
	
	@InjectMocks
	private DuplicateChecker duplicateChecker;
	
	@BeforeEach
	void setUp() throws Exception {
		for(char characterOfAlphabet = 'a'; characterOfAlphabet <='z'; characterOfAlphabet ++ )
        {
			/* Has to be lenient because all letters
			 * of alphabet get mocked for each test 
			 * but not neccessarily used. Otherwise 
			 * mocking code would be much longer
			 * 
			 */
			Mockito.lenient()
				   .doReturn(1,2)
				   .when(frequencyRecorder)
				   .getOccurences(characterOfAlphabet);
        }
		
		for(char characterOfAlphabet = 'A'; characterOfAlphabet <='Z'; characterOfAlphabet ++ )
        {
			Mockito.lenient()
				   .doReturn(1,2)
				   .when(frequencyRecorder)
				   .getOccurences(characterOfAlphabet);
        }
	}

	@Test
	void hasDuplicateLetters() {
		boolean hasDuplicate;
		String testString = "abcddefg";
		hasDuplicate = duplicateChecker.checkForDuplicates(testString);
		assertTrue(hasDuplicate);
	}
	
	@Test
	void lacksDuplicateLetters() {
		boolean hasDuplicate;
		String testString = "abcdDefg";
		hasDuplicate = duplicateChecker.checkForDuplicates(testString);
		assertFalse(hasDuplicate);
	}

}
