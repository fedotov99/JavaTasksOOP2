package com.company;

public class Main {

    public static void main(String[] args) {
	    MyComplex c = new MyComplex(1.0, 2);
	    MyComplex c2 = new MyComplex(1.0, 2);

        System.out.println(c.equals(c2));
        System.out.println(c.equals(1.0, 2));

        MyPolynomial p1 = new MyPolynomial(5, 6, 7, 8, 9, 10);  // 10.0x^5+9.0x^4+8.0x^3+7.0x^2+6.0x^1+5.0
        System.out.println(p1.toString());
        System.out.println(p1.evaluate(2));  // 573.0

        MyPolynomial p2 = new MyPolynomial(5, 6, 7, 8, 9, 10);  // 10.0x^5+9.0x^4+8.0x^3+7.0x^2+6.0x^1+5.0
        MyPolynomial p3 = p1.add(p2);
        System.out.println(p3.toString());  // 20.0x^5+18.0x^4+16.0x^3+14.0x^2+12.0x^1+10.0
        p3 = p1.multiply(p2);
        System.out.println(p3.toString());  // 100.0x^5+81.0x^4+64.0x^3+49.0x^2+36.0x^1+25.0

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
