package com.company;

public class Main {

    public static void main(String[] args) {
	    MyComplex c = new MyComplex(1.0, 2);
	    MyComplex c2 = new MyComplex(1.0, 2);

        System.out.println(c.equals(c2));
        System.out.println(c.equals(1.0, 2));

        Container container = new Container(0, 0, 10, 10);
        Ball ball = new Ball(1, 1, 1, 1, 135);
        System.out.println(container.collides(ball)); // true (left top corner of container)

        ball.setXDelta(8);
        ball.setYDelta(8);
        ball.move();
        System.out.println(container.collides(ball)); // true (right bottom corner of container)

        ball.setXDelta(1);
        ball.setYDelta(1);
        ball.move();
        System.out.println(container.collides(ball)); // false, because of crossing the border
    }
}
