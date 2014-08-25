package io;

import graph.Node;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class PrinterTest {
	@Test
	public void printsFailure() {
		Writer writer = new StringWriter();
		List<Node> shortestPath = Collections.emptyList();
		
		Printer.printShortestPath(writer, shortestPath);
		
		Assert.assertEquals("failure\n", writer.toString());
	}
	
	@Test
	public void printsCorrectly() {
		Writer writer = new StringWriter();
		List<Node> shortestPath = Arrays.asList(new Node(0), new Node(1));
		
		Printer.printShortestPath(writer, shortestPath);
		
		Assert.assertEquals("1, 0, out\n", writer.toString());
	}
}
