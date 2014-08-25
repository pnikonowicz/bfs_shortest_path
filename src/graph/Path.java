package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Path {
	private final Node[] forwardMatrix;
	private int size;

	public Path(int size) {
		this.size = size;
		forwardMatrix = new Node[size];
	}

	public Node closestFrom(Node node) {
		return closestFrom(node.id);
	}
	
	private Node closestFrom(int i) {
		if(i>size) return null;
		
		return forwardMatrix[i];
	}

	public void link(Node currentNode, Node neighborNode) {
		forwardMatrix[neighborNode.id] = currentNode; 
	}
	
	public boolean exists(Node n) {
		return forwardMatrix[n.id]!=null;
	}

	public List<Node> getShortestPath(List<Integer> indicies) {
		if(indicies.size()==0) return Collections.emptyList();
		
		List<Node> shortest = null;
		
		for(Integer i : indicies) {
			List<Node> working = new ArrayList<Node>();
			
			working.add(new Node(i));
			
			Node n = closestFrom(i);
			
			while(n!=null && n.id!=0) {
				working.add(n);
				n = closestFrom(n.id);
			}
			working.add(n);
			
			if(shortest==null || working.size() < shortest.size()) {
				shortest = working;
			}
		}
		return shortest;
	}
}
