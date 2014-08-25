package io;

import graph.Node;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class Printer {
	public static void printShortestPath(Writer out, List<Node> shortestPath) {
		if(shortestPath.size() == 0) {
			write(out, "failure\n");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=shortestPath.size()-1; i>=0; i--) {
			Node n = shortestPath.get(i);
			sb.append(n.id).append(", ");
		}
		
		sb.append("out\n");
		write(out, sb.toString());
	}
	
	private static void write(Writer out, String s) {
		try {
			out.write(s);
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				out.flush();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
