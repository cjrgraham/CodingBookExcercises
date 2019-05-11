package Chapter1.question1_5;

public class EditDistanceChecker {
	
	public boolean isOneEditAway(String stringA, String stringB) {
		boolean isOneEditAway = false;
		
		int stringALength = stringA.length();
		int stringBLength = stringB.length();
		int sizeDifference = Math.abs(stringALength - stringBLength);
		
		if(sizeDifference>1) {
			return false;
		}
		
		String maxLengthString;
		String secondString;
		
		if(stringALength > stringBLength) {
			maxLengthString = stringA;
			secondString = stringB;
		}
		else {
			maxLengthString = stringB;
			secondString = stringA;
		}
		
		isOneEditAway = checkDifferences(maxLengthString,secondString,sizeDifference);
		
		return isOneEditAway;
	}
	
	
	private boolean checkDifferences(String maxLengthString, String secondString,int differenceDecrementAmount) {
		int differencesCount = 0;
		boolean tooManyEdits = false;
		
		for(int i = 0, j = 0;i < maxLengthString.length() && j < secondString.length();i++,j++) {
			char firstCurrChar = maxLengthString.charAt(i);
			char secondCurrChar = secondString.charAt(j);
			
			if(firstCurrChar!=secondCurrChar)
			{
				differencesCount = differencesCount + 1;
				j = j - differenceDecrementAmount;
				if(differencesCount>1) {
					tooManyEdits = true;
					break;
				}
			}
		}
		
		return !tooManyEdits;
	}
	
}
