package myLifeGameUnitTest.basement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WorldTest {

	private static World world;

    //public static final int LengthX = 25;
    //public static final int LengthY = 25;
	public static final int LengthX = 3;
	public static final int LengthY = 3;

	private static int[][] seed;
    private static int[][] seeds;
    
    public int[][] producefinal01Matrix(int Lx, int Ly){
    	int [][] test = new int[Lx][Ly];
    	for(int i = 0; i < test.length; i++){
    		for (int j = 0; j < test[i].length; j++) {
    			if((i==0||i==(LengthX-1))&&(j==0||j==LengthX-1)){
    	            test[i][j]=1;
    	        }else{
    	            test[i][j]=0;
    	        }
    		}
    	}
    	return test;
    }
    

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
    	seed = producefinal01Matrix(LengthX,LengthY);
        seeds = produceRandom01Matrix(LengthX,LengthY);
    }
    
    @After
	public void tearDown() throws Exception {
    }

    @Test
    public void testaliveRoundCount() throws Exception {
    	world = new World(LengthX,LengthY,seed);
        assertEquals(4 ,world.getAliveRoundCount(1,1));
    }

    @Test
    public void testAliveArray() throws Exception {
    	world = new World(LengthX,LengthY,seeds);
        boolean[][] aliveTest = new boolean[LengthX][LengthY];

        for(int i = 0; i < LengthX; i++)
            for(int j = 0; j < LengthY; j++) {
                if (seeds[i][j] == 1)
                    aliveTest[i][j] = true;
                else
                    aliveTest[i][j] = false;
            }

        assertEquals(aliveTest,world.aliveArray());
    }
}
