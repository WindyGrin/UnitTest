package myLifeGameUnitTest.basement;

import myLifeGameUnitTest.drawing.Painter;

/**
 * 上帝类，随机产生世界，并控制时间的流逝
 */
public class God {

    private World world;
    private Painter painter;

    public God(){
        painter = new Painter();
    }

    public World getWorld() {
        return world;
    }

    public Painter getPainter() {
        return painter;
    }

    public void createWorld(int scale, int ratio) {
        int lenX = 50;
        int lenY = 50;
        world = new World(lenX ,lenY, scale, ratio);
    }

    public void createWorld(int[][] seeds) {
        int lenX = 50;
        int lenY = 50;
        world = new World(lenX ,lenY, seeds);
    }

    public void timePass() {
        world.timePass();
        painter.paint(world.aliveArray());
    }
}
