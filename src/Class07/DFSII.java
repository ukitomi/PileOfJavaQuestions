package Class07;

import java.util.ArrayList;
import java.util.List;

public class DFSII {

	// method 1: DFS solution
	public List<String> subSets(String set) {
		List<String> result = new ArrayList<String>();
		if (set == null) {
			return result;
		}
		
		char[] arraySet = set.toCharArray();
		StringBuilder sb = new StringBuilder();
		helperSS(arraySet, sb, 0, result);
		return result;
	}
	
	private void helperSS(char[] set, StringBuilder sb, int index, List<String> result) {
		if (index == set.length) {
			result.add(sb.toString());
			return;
		}
		
		// 1. not pick the character at index
		helperSS(set, sb, index + 1, result);
		// 2. pick the character at index
		helperSS(set, sb.append(set[index]), index + 1, result);
		
		// remove the added character when back tracking to the previous level
		sb.deleteCharAt(sb.length() - 1);
	}
}
