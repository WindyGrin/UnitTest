package myLifeGameUnitTest.drawing;

import java.awt.geom.Rectangle2D;

/**
 * 继承Rectangle2D类，生命方格
 */
public class LifeRect extends Rectangle2D.Float{

    public LifeRect(float x, float y, float w, float h){
        super(x,y,w,h);
    }

}
