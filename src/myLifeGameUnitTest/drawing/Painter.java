package myLifeGameUnitTest.drawing;

/**
 * �ѻ��ƺõ�ͼ�η����ڿ����
 */
public class Painter {

    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 800;

    private  GameFrame frame;
    private  DrawPanel panel;

    public Painter() {
        frame = new GameFrame(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public void paint(boolean[][] arr) {
        frame.remove(panel);
        panel = new DrawPanel(arr, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        frame.add(panel);
        frame.paintAll(panel.getGraphics());
    }

}