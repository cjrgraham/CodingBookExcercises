package Chapter1.question1_5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EditDistanceCheckerTest {
	
	private EditDistanceChecker EditDistanceChecker;

	@BeforeEach
	void setUp() throws Exception {
		EditDistanceChecker = new EditDistanceChecker();
	}

	@Test
	void checkShorterInRange() {
		assertTrue(EditDistanceChecker.isOneEditAway("pale", "ple"));
	}

	@Test
	void checkLongerInRange() {
		assertTrue(EditDistanceChecker.isOneEditAway("pales", "pale"));
	}
	
	@Test
	void checkSameInRange() {
		assertTrue(EditDistanceChecker.isOneEditAway("pale", "bale"));
	}
	
	@Test
	void checkSameLengthOutOfRange() {
		assertFalse(EditDistanceChecker.isOneEditAway("pale", "bake"));
	}
}
