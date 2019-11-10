package com.company;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder polynomial = new StringBuilder();
        polynomial.append(coeffs[0]);

        for (int i = 1; i < coeffs.length; i++) {
            polynomial.insert(0, coeffs[i] + "x^" + i + "+");
        }

        return polynomial.toString();
    }

    public double evaluate(double x) {
        double result = 0.0;

        for (int i = 0; i < coeffs.length; i++) {
            result += coeffs[i] * Math.pow(x, i);
        }

        return result;
    }

    public MyPolynomial add(MyPolynomial right) {
        MyPolynomial newMyPolynomial = new MyPolynomial(this.coeffs.clone());  // if not clone(), then it creates reference, not new MyPolynomial

        try {
            if (this.coeffs.length != right.coeffs.length) {
                throw new Exception("Please, provide all coefficients of polynomials, according to the max one");
            }

            for(int i = 0; i < this.coeffs.length; i++) {
                newMyPolynomial.coeffs[i] += right.coeffs[i];
            }
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return newMyPolynomial;
    }

    public MyPolynomial multiply(MyPolynomial right) {
        MyPolynomial newMyPolynomial = new MyPolynomial(this.coeffs.clone());  // if not clone(), then it creates reference, not new MyPolynomial

        try {
            if (this.coeffs.length != right.coeffs.length) {
                throw new Exception("Please, provide all coefficients of polynomials, according to the max one");
            }

            for(int i = 0; i < this.coeffs.length; i++) {
                newMyPolynomial.coeffs[i] *= right.coeffs[i];
            }
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return newMyPolynomial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPolynomial that = (MyPolynomial) o;
        return Arrays.equals(coeffs, that.coeffs);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coeffs);
    }
}
