package com.company;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        try {
            if (width < 0 || height < 0) {
                throw new Exception("Width and height must be > 0");
            }
            this.x1 = x;
            this.y1 = y;
            this.x2 = this.x1 + width;
            this.y2 = this.y1 + height;
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return x2 - x1;
    }

    public int getHeight() {
        return y2 - y1;
    }

    public boolean collides(Ball ball) {
        float topOfBall = ball.getY() - ball.getRadius();
        float bottomOfBall = ball.getY() + ball.getRadius();
        float leftOfBall = ball.getX() - ball.getRadius();
        float rightOfBall = ball.getX() + ball.getRadius();

        return topOfBall >= y1 && bottomOfBall <= y2 && leftOfBall >= x1 && rightOfBall <= x2;
    }

    @Override
    public String toString() {
        return "Container[" +
                "(" + x1 +
                ", " + y1 +
                "), (" + x2 +
                ", =" + y2 +
                ")]";
    }
}
