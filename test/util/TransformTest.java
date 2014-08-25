package util;
import java.util.Arrays;
import java.util.List;

import graph.Node;
import junit.framework.Assert;

import org.junit.Test;

import util.Transform;


public class TransformTest {
	@Test
	public void arrayToNodesCreatesAGraphFromArray() {
		List<Integer> array = Arrays.asList(1,1,1);
		
		Node node_A = Transform.arrayToNodes(array);
		Node node_B = node_A.getNeighbors().get(0);
		Node node_C = node_B.getNeighbors().get(0);
		
		Assert.assertEquals(0, node_A.id);
		Assert.assertEquals(1, node_B.id);
		Assert.assertEquals(2, node_C.id);
	}
	
	@Test
	public void arrayToNodesReusesNodes() {
		List<Integer> array = Arrays.asList(2,1,1);
		
		Node node_A = Transform.arrayToNodes(array);
		Node node_B = node_A.getNeighbors().get(0);
		Node node_C = node_A.getNeighbors().get(1);
		Node node_C_prime = node_B.getNeighbors().get(0);
		
		Assert.assertEquals(0, node_A.id);
		Assert.assertEquals(1, node_B.id);
		Assert.assertEquals(2, node_C.id);
		Assert.assertEquals(2, node_C_prime.id);
		Assert.assertSame(node_C, node_C_prime);
	}
	
	@Test
	public void arrayToNodesWorksForLargeSet() {
		List<Integer> array = Arrays.asList(5, 6, 0, 4, 2, 4, 1, 0, 0, 4);
		
		Node startNode = Transform.arrayToNodes(array);
		Node node_1 = startNode.getNeighbors().get(0);
		Node node_2 = startNode.getNeighbors().get(1);
		Node node_3 = startNode.getNeighbors().get(2);
		Node node_4 = startNode.getNeighbors().get(3);
		Node node_5 = startNode.getNeighbors().get(4);
		Node node_6 = node_1.getNeighbors().get(4);
		Node node_7 = node_1.getNeighbors().get(5);
		Node node_8 = node_5.getNeighbors().get(2);
		Node node_9 = node_5.getNeighbors().get(3);
		
		Assert.assertEquals(0, startNode.id);
		Assert.assertEquals(1, node_1.id);
		Assert.assertEquals(2, node_2.id);
		Assert.assertEquals(3, node_3.id);
		Assert.assertEquals(4, node_4.id);
		Assert.assertEquals(5, node_5.id);
		Assert.assertEquals(6, node_6.id);
		Assert.assertEquals(7, node_7.id);
		Assert.assertEquals(8, node_8.id);
		Assert.assertEquals(9, node_9.id);
		
		Assert.assertEquals(5, startNode.getNeighbors().size());
		Assert.assertEquals(6, node_1.getNeighbors().size());
		Assert.assertEquals(0, node_2.getNeighbors().size());
		Assert.assertEquals(4, node_3.getNeighbors().size());
		Assert.assertEquals(2, node_4.getNeighbors().size());
		Assert.assertEquals(4, node_5.getNeighbors().size());
		Assert.assertEquals(1, node_6.getNeighbors().size());
		Assert.assertEquals(0, node_7.getNeighbors().size());
		Assert.assertEquals(0, node_8.getNeighbors().size());
		Assert.assertEquals(0, node_9.getNeighbors().size());
	}
}
