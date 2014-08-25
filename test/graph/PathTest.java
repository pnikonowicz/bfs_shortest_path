package graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PathTest {
	@Test
	public void existsReturnsTrueIfPathExistsForBothDirections() { //this is because i dont want to have to remember direction
		Path path = new Path(2);
		Node nodeA = new Node(0);
		Node nodeB = new Node(1);
		
		path.link(nodeA, nodeB);
		
		Assert.assertTrue(path.exists(nodeB));
		Assert.assertFalse(path.exists(nodeA));
	}
	
	@Test
	public void getShortestPath() {
		Path path = new Path(4);
		Node nodeA = new Node(0);
		Node nodeB = new Node(1);
		Node nodeC = new Node(2);
		Node nodeD = new Node(3);
		
		path.link(nodeA, nodeB);
		path.link(nodeB, nodeC);
		path.link(nodeC, nodeD);
		
		List<Integer> exitNodes = Arrays.asList(nodeD.id, nodeC.id);
		
		List<Node> result = path.getShortestPath(exitNodes);
		
		Assert.assertEquals(3, result.size());
		Assert.assertEquals(2, result.get(0).id);
		Assert.assertEquals(1, result.get(1).id);
		Assert.assertEquals(0, result.get(2).id);
	}
	
	@Test
	public void getShortestPath_ifInputIsEmptyReturnEmpty() {
		Path path = new Path(0);
		Assert.assertEquals(0, path.getShortestPath(new ArrayList<Integer>()).size());
	}
}
