package MainPackege;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 800;

    Field field = new Field();

    MyFrame(){
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setJMenuBar(new MyMenuBar(field));
        add(field, BorderLayout.CENTER);

        setVisible(true);
    }
}
