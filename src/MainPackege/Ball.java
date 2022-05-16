package MainPackege;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball implements Runnable{
    private static final int MAX_RADIUS =40;
    private static final int MIN_RADIUS =5;
    private static final int MAX_SPEED = 15;
    private static final double g = 1.1;

    private Field field;
    private int radius;
    private Color color;

    private double x;
    private double y;

    private int speed;
    private double speedX;
    private double speedY;

    private boolean _paused = false;

    Ball(Field field){
        this.field = field;

        radius = new Double(Math.random()*(MAX_RADIUS - MIN_RADIUS)).intValue() + MIN_RADIUS;


        speed = new Double(Math.round(10*MAX_SPEED / radius)).intValue();

        double angle = Math.random()*2*Math.PI;
        //System.out.println(Math.toDegrees(angle));

        speedX = 25*Math.cos(angle);
        speedY = 25*Math.sin(angle);

        color = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());

        x = Math.random()*(field.getSize().getWidth()-2*radius) + radius;
        y = Math.random()*(field.getSize().getHeight()-2*radius) + radius;

        Thread thisThread = new Thread(this);

        thisThread.start();
    }


    @Override
    public void run() {
        try {
            while(true) {
                field.canMove(this);
                if (x + speedX <= radius+100) {
                    speedX = -speedX;
                    x = radius+100;
                } else
                if (x + speedX >= field.getWidth() - radius-100) {
                    speedX = -speedX;
                    x=new Double(field.getWidth()-radius-100).intValue();
                } else
                if (y + speedY <= radius+100) {
                    speedY = -speedY;
                    y = radius+100;
                } else
                if (y + speedY >= field.getHeight() - radius-100) {
                    speedY = -speedY;
                    y=new Double(field.getHeight()-radius-100).intValue();
                } else {
                    x += speedX;
                    y += speedY;
                }
                Thread.sleep(16-speed);
            }
        } catch (InterruptedException ex) {}
    }

    public void paint(Graphics2D canvas) {
        canvas.setColor(color);
        canvas.setPaint(color);
        Ellipse2D.Double ball = new Ellipse2D.Double(x-radius, y-radius,
                2*radius, 2*radius);
        canvas.draw(ball);
        canvas.fill(ball);
    }

    public boolean getPaused(){
        return _paused;
    }

    public void setPaused(boolean paused){
        _paused = paused;
    }

    public int getAngel(){
        if (speedY > 0 && speedX < 0)
            return 1;
        else
            return 0;
    }
}
