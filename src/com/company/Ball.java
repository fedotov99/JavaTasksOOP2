package com.company;

import java.util.Objects;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        try {
            if (direction < -180 || direction > 180)
                throw new Exception("Wrong direction parameter (must be -180 <= direction <= 180");
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.xDelta = speed * (float)Math.cos(direction);
            this.yDelta = -1 * speed * (float)Math.sin(direction);
        }
        catch(Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getXDelta() {
        return xDelta;
    }

    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getYDelta() {
        return yDelta;
    }

    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        x += xDelta;
        y += yDelta;
    }

    public void reflectHorizontal() {
        xDelta = -1 * xDelta;
    }

    public void reflectVertical() {
        yDelta = -1 * yDelta;
    }

    @Override
    public String toString() {
        return "Ball[" +
                "(" + x +
                ", " + y +
                "), speed=(" + xDelta +
                ", " + yDelta +
                ")]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Float.compare(ball.x, x) == 0 &&
                Float.compare(ball.y, y) == 0 &&
                radius == ball.radius &&
                Float.compare(ball.xDelta, xDelta) == 0 &&
                Float.compare(ball.yDelta, yDelta) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, radius, xDelta, yDelta);
    }
}