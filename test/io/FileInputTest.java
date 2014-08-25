package io;
import java.util.List;

import org.junit.Test;
import junit.framework.Assert;

public class FileInputTest {
	@Test
	public void canReadFile() {
		String filename="input";
		
		List<Integer> input = FileInput.readFile(filename);
		
		Assert.assertEquals(10, input.size());
		Assert.assertEquals(5, (int)input.get(0));
		Assert.assertEquals(6, (int)input.get(1));
		Assert.assertEquals(0, (int)input.get(2));
		Assert.assertEquals(4, (int)input.get(3));
		Assert.assertEquals(2, (int)input.get(4));
		Assert.assertEquals(4, (int)input.get(5));
		Assert.assertEquals(1, (int)input.get(6));
		Assert.assertEquals(0, (int)input.get(7));
		Assert.assertEquals(0, (int)input.get(8));
		Assert.assertEquals(4, (int)input.get(9));
	}
}
