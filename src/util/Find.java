package util;
import java.util.ArrayList;
import java.util.List;


public class Find {

	public static List<Integer> exitNodes(List<Integer> array) {
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<array.size(); i++) {
			int value = array.get(i);
			if(value+i > array.size()) {
				result.add(i);
			}
		}
		return result;
	}
}
