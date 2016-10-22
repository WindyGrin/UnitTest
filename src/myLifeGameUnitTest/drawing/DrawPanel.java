package myLifeGameUnitTest.drawing;

import javax.swing.*;
import java.awt.*;


public class DrawPanel extends JPanel {

    private boolean[][] arr;
    private int width;
    private int height;

    public boolean[][] getArr() {
        return arr;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public DrawPanel(boolean[][] array, int wid, int hei){
        this.arr = array;
        this.width = wid;
        this.height = hei;
    }

    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;

        int lenX = arr.length;
        int lenY = arr[0].length;

        float unitX = (float)width/lenX;
        float unitY = (float)height/lenY;

        for(int i = 0; i < lenX; i++){
            for(int j = 0; j < lenY; j++){
                Paint paint = arr[i][j] ? Color.BLACK : Color.WHITE;
                LifeRect rect = new LifeRect(unitX * i, unitY * j, unitX, unitY);
                g2.setPaint(paint);
                g2.fill(rect);
                g2.setPaint(Color.LIGHT_GRAY);
                g2.draw(rect);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
}