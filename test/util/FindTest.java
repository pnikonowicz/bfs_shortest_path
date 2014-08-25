package util;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import util.Find;

public class FindTest {
	@Test
	public void findIndicesOfExitNodes() {
		List<Integer> array = Arrays.asList(1,2);
		
		List<Integer> result = Find.exitNodes(array);
		
		Assert.assertEquals(1, result.size());
		Assert.assertEquals(1, (int) result.get(0));
	}
}
