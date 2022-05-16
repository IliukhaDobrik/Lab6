package MainPackege;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Field extends JPanel {

    private ArrayList<Ball> balls = new ArrayList<>(10);

    private Timer repaintTimer = new Timer(10, new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
            repaint();
        }
    });

    public Field() {
        setBackground(Color.WHITE);
        repaintTimer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D canvas = (Graphics2D) g;
        for (Ball ball: balls) {
            ball.paint(canvas);
        }
    }

    public void addBall() {
        balls.add(new Ball(this));
    }

    public void deleteBall(){
        if (!balls.isEmpty())
            balls.remove(0);
        else {
            JOptionPane.showMessageDialog(null,
                    "Упс, вы уже удалили все шары",
                    "Error" ,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public synchronized void pause() {
        for (Ball ball : balls){
            if (ball.getAngel() == 1)
                ball.setPaused(true);
        }
    }

    public synchronized void resume() {
        for (Ball ball : balls){
            if (ball.getPaused())
                ball.setPaused(false);
                notifyAll();
        }
    }

    public synchronized void canMove(Ball ball) throws
            InterruptedException {
        if (ball.getPaused())
            wait();
    }
}