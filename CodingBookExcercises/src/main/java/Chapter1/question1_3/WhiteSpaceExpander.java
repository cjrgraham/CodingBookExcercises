package Chapter1.question1_3;

public class WhiteSpaceExpander {

	// just done quickly. may rework later.
	public static void main(String[] args) {
		char[] stringChars = "Mr John Smith    ".toCharArray();
		int realStringSize = 13;
		expandWhiteSpace(stringChars,realStringSize);
	}
	
	private static void expandWhiteSpace(char[] stringChars, int realStringSize) {
		int shiftAmount = stringChars.length - realStringSize;
		for(int i = realStringSize -1 ;i > 0;i--) {
			char currentChar = stringChars[i];
			boolean currentCharWhitespace = Character.isWhitespace(currentChar);
			int indexToModify = i + shiftAmount;
			if(currentCharWhitespace) {
				writeExpandedWhiteSpace(stringChars,indexToModify);
				shiftAmount = shiftAmount - 2;
			}
			else {
				stringChars[indexToModify] = currentChar;
			}
		}
		System.out.println(stringChars);
	}
	
	private static void writeExpandedWhiteSpace(char[]stringChars,int indexToModify) {
		stringChars[indexToModify-2] = '%';
		stringChars[indexToModify-1] = '2';
		stringChars[indexToModify] = '0';
	}
	


}
