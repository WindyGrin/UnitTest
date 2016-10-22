package myLifeGameUnitTest.basement;

import java.util.Random;

/**
 * 世界类，确定所有细胞及其位置，随时间获取当前细胞图
 */
public class World {

    private int LengthX;
    private int LengthY;
    private Cell[][] cells;

    public void setLengthX(int lengthX) {
        LengthX = lengthX;
    }

    public void setLengthY(int lengthY) {
        LengthY = lengthY;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getLengthX() {
        return LengthX;
    }

    public int getLengthY() {
        return LengthY;
    }

    public Cell[][] getCells() {
        return cells;
    }

    private World(int LenX, int LenY){

        this.LengthX = LenX;
        this.LengthY = LenY;

        this.cells = new Cell[LenX][LenY];

        for(int i = 0; i < LenX; i++)
            for(int j = 0; j < LenY; j++)
                this.cells[i][j] = new Cell();

    }

    public World(int LenX, int LenY, int[][] seeds){
        this(LenX,LenY);

        for(int i = 0; i < seeds.length; i++)
            for(int j = 0; j < seeds[i].length; j++)
                if(seeds[i][j] == 1) {
                    this.cells[i][j].setAliveNow(true);
                    this.cells[i][j].setAliveNext(true);
                }
    }

    public World(int LenX, int LenY, int scale, int ratio){
        this(LenX,LenY);

        Random random = new Random();

        for(int i = 0; i < LenX/scale; i++)
            for(int j = 0; j < LenY/scale; j++)
                if(random.nextInt() % ratio == 0) {
                    this.cells[i][j].setAliveNow(true);
                    this.cells[i][j].setAliveNext(true);
                }
    }

    public int getAliveRoundCount(int x,int y) {
        return this.aliveRoundCount(x, y);
    }

    private int aliveRoundCount(int x,int y){
        int count = 0;

        for(int i = -1; i <= 1; i++){
            int tempX = (x + i + this.LengthX) % this.LengthX;
            for(int j = -1; j <= 1; j++){
                if (i == 0 && j == 0)
                    continue;
                int tempY = (y + j + this.LengthY) % this.LengthY;
                if(this.cells[tempX][tempY].isAliveNow())
                    count++;
            }
        }

        return count;
    }

    public void timePass(){
        for(int i = 0; i < this.LengthX; i++)
            for(int j = 0; j < this.LengthY; j++)
                this.cells[i][j].timePass();

        for(int i = 0; i < this.LengthX; i++)
            for(int j = 0; j < this.LengthY; j++){
                int count = aliveRoundCount(i,j);
                this.cells[i][j].aliveNextReady(count);
            }
    }

    public boolean[][] aliveArray(){
        boolean[][] alive = new boolean[this.LengthX][this.LengthY];

        for(int i = 0; i < this.LengthX; i++)
            for(int j = 0; j < this.LengthY; j++)
                alive[i][j] = this.cells[i][j].isAliveNow();

        return alive;
    }

}
