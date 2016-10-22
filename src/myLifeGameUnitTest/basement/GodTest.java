package myLifeGameUnitTest.basement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GodTest {

	private static God god;

    public static final int LengthX = 50;
    public static final int LengthY = 50;

    private static int[][] seeds;

    public int[][] produceRandom01Matrix(int Lx, int Ly){
        int[][] test = new int[Lx][Ly];
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length; j++) {
                int t = (int) (Math.random() * 2);
                test[i][j] = t;
            }
        }
        return test;
    }


    @Before
    public void setUp() throws Exception {
        seeds = produceRandom01Matrix(LengthX,LengthY);
        god = new God();
    }
    
    @After
	public void tearDown() throws Exception {
	}

    @Test
    public void testCreateWorld1() throws Exception {
        god.createWorld(seeds);

        World res =  god.getWorld();
        boolean[][] resAlive = res.aliveArray();

        boolean[][] res2int = new boolean[LengthX][LengthY];
        for(int i = 0; i < LengthX; i++)
            for(int j = 0; j < LengthY; j++) {
                if (seeds[i][j]==1)
                    res2int[i][j] = true;
                else
                    res2int[i][j] = false;
            }

        assertEquals(res2int,resAlive);
    }

    /*static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTimePass() throws Exception {
        god.createWorld(seeds);
        god.timePass();
        sleep(5000);
        
    }*/
}
