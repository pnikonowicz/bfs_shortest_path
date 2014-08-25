import graph.Bfs;
import graph.Node;
import graph.Path;
import io.FileInput;
import io.Printer;

import java.io.PrintWriter;
import java.util.List;

import util.Find;
import util.Transform;


public class Program {
	public static void main(String[] args) {
		String fileName = args[0];
		
		List<Integer> input = FileInput.readFile(fileName);
		
		Node startNode = Transform.arrayToNodes(input);
		Path path = Bfs.traverseGraph(startNode, input.size());
		
		List<Integer> exitNodes = Find.exitNodes(input);
		List<Node> shortestPath = path.getShortestPath(exitNodes);
		
		Printer.printShortestPath(new PrintWriter(System.out), shortestPath);
	}
}
