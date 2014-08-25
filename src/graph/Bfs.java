package graph;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @see http://www.eecs.yorku.ca/course_archive/2006-07/W/2011/Notes/BFS_part2.pdf
 */
public class Bfs {
	public static Path traverseGraph(Node startNode, int size) {
		Path path = new Path(size);
		Queue<Node> queue = new ArrayDeque<Node>(size);
		
		queue.add(startNode);
		
		while(!queue.isEmpty()) {
			Node currentNode = queue.remove();
			for(Node neighborNode : currentNode.getNeighbors()) {
				if(!path.exists(neighborNode)) {
					path.link(currentNode, neighborNode);
					queue.add(neighborNode);
				}
			}
		}
		
		return path;
	}
}
