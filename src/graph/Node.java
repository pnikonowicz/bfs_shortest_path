package graph;
import java.util.ArrayList;
import java.util.List;


public class Node {
	public final int id;
	
	private final List<Node> neighbors = new ArrayList<Node>();

	public Node(int id) {
		this.id = id;
	}

	public List<Node> getNeighbors() {
		return neighbors;
	}

	public void link(Node node) {
		neighbors.add(node);
	}

	@Override
	public String toString() {
		return id+"";
	}

	@Override //generated from eclipse
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
