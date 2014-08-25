package graph;
import graph.Bfs;
import graph.Node;
import graph.Path;
import junit.framework.Assert;

import org.junit.Test;

public class BfsTest {
	@Test
	public void handleGraphIfOnlyEndNode() {
		Node node = new Node(0);
		
		Path result = Bfs.traverseGraph(node, 1);
		
		Assert.assertNull(result.closestFrom(node));
	}
	
	@Test
	public void twoNodesThatAreConnectedShouldHaveAPath() {
		Node node_A = new Node(0);
		Node node_B = new Node(1);
		
		node_A.link(node_B);
		
		Path result = Bfs.traverseGraph(node_A, 2);
		
		Assert.assertEquals(node_A, result.closestFrom(node_B));
	}
	
	@Test
	public void visitedFromShowsCorrectPathForSingleLine() {
		Node node_0 = new Node(0);
		Node node_1 = new Node(1);
		Node node_2 = new Node(2);
		Node node_3 = new Node(3);
		Node node_4 = new Node(4);
		Node node_5 = new Node(5);
		
		node_0.link(node_1);
		node_1.link(node_2);
		node_2.link(node_3);
		node_3.link(node_4);
		node_4.link(node_5);
		
		Path result = Bfs.traverseGraph(node_0, 6);
		
		Assert.assertNull(result.closestFrom(node_0));
		Assert.assertEquals(node_0, result.closestFrom(node_1));
		Assert.assertEquals(node_1, result.closestFrom(node_2));
		Assert.assertEquals(node_2, result.closestFrom(node_3));
		Assert.assertEquals(node_3, result.closestFrom(node_4));
		Assert.assertEquals(node_4, result.closestFrom(node_5));
	}
	
	@Test
	public void closestFromShowsShortestPath_RightLargerThanLeft() {
		Node node_0 = new Node(0);
		Node node_1 = new Node(1);
		Node node_2 = new Node(2);
		Node node_3 = new Node(3);
		Node node_4 = new Node(4);
		
		node_0.link(node_1);
		node_1.link(node_2);
		node_0.link(node_3);
		node_3.link(node_4);
		node_4.link(node_2);
		
		Path result = Bfs.traverseGraph(node_0, 5);
		
		Assert.assertEquals(node_0, result.closestFrom(node_1));
		Assert.assertEquals(node_1, result.closestFrom(node_2));
	}
	
	@Test
	public void closestFromShowsShortestPath_LeftLargerThanRight() { 
		Node node_0 = new Node(0);
		Node node_1 = new Node(1);
		Node node_2 = new Node(2);
		Node node_3 = new Node(3);
		Node node_4 = new Node(4);
		
		node_0.link(node_3);
		node_3.link(node_4);
		node_4.link(node_2);
		node_0.link(node_1);
		node_1.link(node_2);
		
		Path result = Bfs.traverseGraph(node_0, 5);
		
		Assert.assertEquals(node_0, result.closestFrom(node_1));
		Assert.assertEquals(node_1, result.closestFrom(node_2));
	}
}
