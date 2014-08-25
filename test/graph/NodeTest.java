package graph;
import graph.Node;
import junit.framework.Assert;

import org.junit.Test;


public class NodeTest {
	@Test
	public void linkAddsToNeighborCollection() {
		Node node_A = new Node(0);
		Node node_B = new Node(1);
		
		node_A.link(node_B);
		
		Assert.assertEquals(1, node_A.getNeighbors().size());
	}
}
