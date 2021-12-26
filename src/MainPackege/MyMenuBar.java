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

    MyMenuBar(){
        add(ballsMenu);
        add(controlMenu);

        ballsMenu.add(addMenuItem);
        ballsMenu.add(deleteMenuItem);
        controlMenu.add(pauseMenuItem);
        controlMenu.add(resumeMenuItem);

        addMenuItem.addActionListener(this);
        deleteMenuItem.addActionListener(this);
        pauseMenuItem.addActionListener(this);
        resumeMenuItem.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
