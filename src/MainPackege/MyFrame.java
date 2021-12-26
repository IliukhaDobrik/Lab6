package MainPackege;

import javax.swing.*;

public class MyFrame extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 800;

    MyFrame(){
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setJMenuBar(new MyMenuBar());

        setVisible(true);
    }
}
