import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Graph_STUDENT_Test {

	Graph graph;
	Town t1, t2, t3, t4;
	Road r1, r2, r3, r4, r5;
	
	@Before
	public void setUp() throws Exception {
		graph = new Graph();
		t1 = new Town("Rockville");
		t2 = new Town("Potomac");
		t3 = new Town("Bethesda");
		t4 = new Town("Olney");
		
		r1 = new Road(t1, t2, 6, "MD200");
		r2 = new Road(t1, t3, 5, "MD201");
		r3 = new Road(t2, t3, 8, "MD202");
		r4 = new Road(t1, t4, 14, "MD203");
		r5 = new Road(t2, t4, 4, "MD204");
		
		graph.addVertex(t1);
		graph.addVertex(t2);
		graph.addVertex(t3);
		graph.addVertex(t4);
		
		graph.addEdge(r1.getSource(), r1.getDestination(), r1.getWeight(), r1.getName());
		graph.addEdge(r2.getSource(), r2.getDestination(), r2.getWeight(), r2.getName());
		graph.addEdge(r3.getSource(), r3.getDestination(), r3.getWeight(), r3.getName());
		graph.addEdge(r4.getSource(), r4.getDestination(), r4.getWeight(), r4.getName());
		graph.addEdge(r5.getSource(), r5.getDestination(), r5.getWeight(), r5.getName());
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetEdge() {
		assertEquals(r1, graph.getEdge(t1, t2));
		assertEquals(r2, graph.getEdge(t1, t3));
		assertEquals(r3, graph.getEdge(t2, t3));
		assertEquals(r4, graph.getEdge(t1, t4));
		assertEquals(r5, graph.getEdge(t2, t4));
	}

	@Test
	public void testAddVertex() {
		
		assertFalse(graph.addVertex(t1));
		assertFalse(graph.addVertex(t4));
	}

	@Test
	public void testContainsEdge() {
		assertTrue(graph.containsEdge(t1, t2));
		assertTrue(graph.containsEdge(t1, t3));
		assertTrue(graph.containsEdge(t2, t3));
	}

	@Test
	public void testContainsVertex() {
		assertTrue(graph.containsVertex(t1));
		assertTrue(graph.containsVertex(t2));
		assertTrue(graph.containsVertex(t3));
		assertTrue(graph.containsVertex(t4));
	}

	@Test
	public void testEdgeSet() {
		Set<Road> set = graph.edgeSet();
		assertTrue(set.size()==5);
		assertTrue(set.contains(r1));
		assertTrue(set.contains(r2));
		assertTrue(set.contains(r3));
	}

	@Test
	public void testEdgesOf() {
		Set<Road> set = graph.edgesOf(t1);
		assertTrue(set.size()==3);
		assertTrue(set.contains(r1));
		assertTrue(set.contains(r2));
		assertTrue(set.contains(r4));
	}

	@Test
	public void testRemoveEdge() {
		graph.removeEdge(r1.getSource(), r1.getDestination(), r1.getWeight(), r1.getName());
		assertFalse(graph.containsEdge(t1, t2));
	}

	@Test
	public void testRemoveVertex() {
		graph.removeVertex(t1);
		assertFalse(graph.containsVertex(t1));
	}

	@Test
	public void testVertexSet() {
		assertTrue(graph.vertexSet().size() == 4);
		assertTrue(graph.vertexSet().contains(t1));
		assertTrue(graph.vertexSet().contains(t2));
		assertTrue(graph.vertexSet().contains(t3));
	}

	@Test
	public void testShortestPath() {
		graph.dijkstraShortestPath(t1);
		ArrayList<String> path = graph.shortestPath(t1, t2);
		assertEquals("Rockville via MD200 to Potomac 6 mi",
				path.get(0));
		
		
		path = graph.shortestPath(t1, t4);
		assertEquals("Rockville via MD200 to Potomac 6 mi",
				path.get(0));
		assertEquals("Potomac via MD204 to Olney 4 mi",
				path.get(1));
	}

}
