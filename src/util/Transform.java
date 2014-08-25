package util;
import java.util.List;

import graph.Node;


public class Transform {
	public static Node arrayToNodes(List<Integer> array) {
		Node[] nodes = new Node[array.size()];
		
		for(int i=0; i<array.size(); i++) {
			int value = array.get(i);
			
			Node node = getNodeAt(nodes, i);
			
			for(int j=i+1; j<array.size() && j<=i+value; j++) {
				node.link(getNodeAt(nodes, j));
			}
		}
		
		return nodes[0]; 
	}

	private static Node getNodeAt(Node[] nodes, int i) {
		if(nodes[i]==null)
			nodes[i] = new Node(i);
		
		return nodes[i];
	}
}
