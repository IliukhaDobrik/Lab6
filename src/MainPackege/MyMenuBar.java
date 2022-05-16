package MainPackege;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMenuBar extends JMenuBar implements ActionListener {
    private JMenu ballsMenu = new JMenu("Мячи");
    private JMenu controlMenu = new JMenu("Управление");

    private JMenuItem addMenuItem = new JMenuItem("Добавить мяч");
    private JMenuItem deleteMenuItem = new JMenuItem("Удалить мяч");
    private JMenuItem pauseMenuItem = new JMenuItem("Приостановить движение");
    private JMenuItem resumeMenuItem = new JMenuItem("Возобновить движение");

    private Field field;

    MyMenuBar(Field field){
        this.field =  field;

        add(ballsMenu);
        add(controlMenu);

        ballsMenu.add(addMenuItem);
        ballsMenu.add(deleteMenuItem);
        controlMenu.add(pauseMenuItem);
        controlMenu.add(resumeMenuItem);

        addMenuItem.addActionListener(e -> field.addBall());
        deleteMenuItem.addActionListener(e -> field.deleteBall());
        pauseMenuItem.addActionListener(e -> field.pause());
        resumeMenuItem.addActionListener(e -> field.resume());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
