package com.example.extest;

public class OwnMathClass {

        public static double[] quadraticEquationSolver(double a, double b, double c) throws ArithmeticException{

            double[] result;

            double discriminant = b * b - 4.0 * a * c;
            if (discriminant > 0.0){
                result = new double[2];
                result[0] = (-b + Math.sqrt(discriminant)) / (2.0 * a);
                result[1] = (-b - Math.sqrt(discriminant)) / (2.0 * a);
                return result;
            }else if (discriminant == 0.0){
                result = new double[1];
                result[0] = -b / (2.0 * a);
                return result;
            }

            throw new ArithmeticException("No real roots");
        }
}
