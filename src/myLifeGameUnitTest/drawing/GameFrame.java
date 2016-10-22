package myLifeGameUnitTest.drawing;

import javax.swing.*;
import java.awt.*;

/**
 * Í¼ÐÎÏÔÊ¾¿ò¼Ü
 */
public class GameFrame extends JFrame {

    public GameFrame(int width, int height){

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int screenWidth = dimension.width;
        int screenHeight = dimension.height;

        setTitle("Life Game Auto");

        setLocation(screenWidth/2 - width/2,screenHeight/2 - height/2);
        setSize(width + 30, height + 30);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    @Override
    public void remove(Component comp) {
        if(comp != null)
            super.remove(comp);
    }
}