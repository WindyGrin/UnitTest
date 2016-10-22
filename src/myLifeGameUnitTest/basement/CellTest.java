package myLifeGameUnitTest.basement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CellTest {

	private static Cell cellT;

    public void setAllCell(Cell cell, boolean now, boolean next) {
        cell.setAliveNow(now);
        cell.setAliveNext(next);
    }

    @Before
    public void setUp() throws Exception {
        cellT = new Cell();
    }
    
    @After
	public void tearDown() throws Exception {
	}

    @Test
    public void testTimePass() throws Exception {
        setAllCell(cellT, true, false);
        cellT.timePass();
        assertEquals(false, cellT.getAliveNow());
    }

    @Test
    public void testTimePass2() throws Exception {
        setAllCell(cellT, false, true);
        cellT.timePass();
        assertEquals(true, cellT.getAliveNow());
    }

    @Test
    public void testTimePass3() throws Exception {
        setAllCell(cellT, false, false);
        cellT.timePass();
        assertEquals(false, cellT.getAliveNow());
    }

    @Test
    public void testTimePass4() throws Exception {
        setAllCell(cellT, true, true);
        cellT.timePass();
        assertEquals(true, cellT.getAliveNow());
    }

    @Test
    public void testAliveNextReady() throws Exception {
        setAllCell(cellT, false, true);
        cellT.aliveNextReady(2);
        assertEquals(true, cellT.getAliveNext());
    }

    @Test
    public void testAliveNextReady2() throws Exception {
        setAllCell(cellT, false, true);
        cellT.aliveNextReady(3);
        assertEquals(true, cellT.getAliveNext());
    }

    @Test
    public void testAliveNextReady3() throws Exception {
        setAllCell(cellT, false, true);
        cellT.aliveNextReady(8);
        assertEquals(false, cellT.getAliveNext());
    }
}
