import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TownGraphManager_STUDENT_Test {

	TownGraphManager graph;
	Town t1, t2, t3, t4;
	Road r1, r2, r3, r4, r5;
	
	@Before
	public void setUp() throws Exception {
		graph = new TownGraphManager();
		t1 = new Town("Rockville");
		t2 = new Town("Potomac");
		t3 = new Town("Bethesda");
		t4 = new Town("Olney");
		
		r1 = new Road(t1, t2, 6, "MD200");
		r2 = new Road(t1, t3, 5, "MD201");
		r3 = new Road(t2, t3, 8, "MD202");
		r4 = new Road(t1, t4, 14, "MD203");
		r5 = new Road(t2, t4, 4, "MD204");
		
		graph.addTown(t1.getName());
		graph.addTown(t2.getName());
		graph.addTown(t3.getName());
		graph.addTown(t4.getName());
		
		graph.addRoad(r1.getSource().getName(), r1.getDestination().getName(),
				r1.getWeight(), r1.getName());
		graph.addRoad(r2.getSource().getName(), r2.getDestination().getName(), 
				r2.getWeight(), r2.getName());
		graph.addRoad(r3.getSource().getName(), r3.getDestination().getName(), 
				r3.getWeight(), r3.getName());
		graph.addRoad(r4.getSource().getName(), r4.getDestination().getName(),
				r4.getWeight(), r4.getName());
		graph.addRoad(r5.getSource().getName(), r5.getDestination().getName(), 
				r5.getWeight(), r5.getName());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddRoad() {
		
	}

	@Test
	public void testGetRoad() {
		assertEquals(r1.getName(), graph.getRoad(t1.getName(), t2.getName()));
		assertEquals(r2.getName(), graph.getRoad(t1.getName(), t3.getName()));
		assertEquals(r3.getName(), graph.getRoad(t2.getName(), t3.getName()));
		assertEquals(r4.getName(), graph.getRoad(t1.getName(), t4.getName()));
	}

	@Test
	public void testAddTown() {
		assertFalse(graph.addRoad(r3.getSource().getName(), r3.getDestination().getName(), 
				r3.getWeight(), r3.getName()));
	}

	@Test
	public void testGetTown() {
		assertEquals(t1, graph.getTown("Rockville"));
		assertEquals(t2, graph.getTown("Potomac"));
		assertEquals(t3, graph.getTown("Bethesda"));
	}

	@Test
	public void testContainsTown() {
		assertTrue(graph.containsTown(t1.getName()));
		assertTrue(graph.containsTown(t2.getName()));
		assertTrue(graph.containsTown(t3.getName()));
		assertTrue(graph.containsTown(t4.getName()));
	}

	@Test
	public void testContainsRoadConnection() {
		assertTrue(graph.containsRoadConnection(t1.getName(), t2.getName()));
		assertTrue(graph.containsRoadConnection(t1.getName(), t3.getName()));
		assertTrue(graph.containsRoadConnection(t2.getName(), t3.getName()));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> set = graph.allRoads();
		assertTrue(set.size()==5);
		assertTrue(set.contains(r1.getName()));
		assertTrue(set.contains(r2.getName()));
		assertTrue(set.contains(r3.getName()));
	}

	@Test
	public void testDeleteRoadConnection() {
		graph.deleteRoadConnection(r1.getSource().getName(), 
				r1.getDestination().getName(), r1.getName());
		assertFalse(graph.containsRoadConnection(t1.getName(), t2.getName()));
	}

	@Test
	public void testDeleteTown() {
		graph.deleteTown(t1.getName());
		assertFalse(graph.containsTown(t1.getName()));
	}

	@Test
	public void testAllTowns() {
		assertTrue(graph.allTowns().size() == 4);
		assertTrue(graph.allTowns().contains(t1.getName()));
		assertTrue(graph.allTowns().contains(t2.getName()));
		assertTrue(graph.allTowns().contains(t3.getName()));
	}

	@Test
	public void testGetPath() {
		
		ArrayList<String> path = graph.getPath(t1.getName(), t2.getName());
		assertEquals("Rockville via MD200 to Potomac 6 mi",
				path.get(0));
		
		
		path = graph.getPath(t1.getName(), t4.getName());
		assertEquals("Rockville via MD200 to Potomac 6 mi",
				path.get(0));
		assertEquals("Potomac via MD204 to Olney 4 mi",
				path.get(1));
	}

	@Test
	public void testPopulateTownGraph() {
		
		File file = new File("src/MD Towns.txt");
		try {
			graph.populateTownGraph(file);
			assertTrue(graph.containsTown("Clarksburg"));
			assertTrue(graph.containsRoadConnection("Frederick", "Clarksburg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
