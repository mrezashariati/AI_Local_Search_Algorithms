package AI_Local_Search;

import AI_Local_Search.Algorithms.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] A;
        LocalSearch searchFunc = null;
        System.out.println("Enter the size of array");
        A = new double[scanner.nextInt()];
        fillArray(A);
        System.out.println("Select type of Search:\n1.Hill Climbing\n2.Gradient Descent\n3.Simulated Annealing\n4.Local Beam Search\n5.AI_Local_Search.Algorithms.Genetic");
        switch (scanner.nextInt()) {
            case 1:
                searchFunc = new HillClimbing(A);
                break;
            case 2:
                searchFunc = new GradientDescent(A);
                break;
            case 3:
                searchFunc = new SimulatedAnnealing(A);
                break;
            case 4:
                searchFunc = new LocalBeamSearch(A);
                break;
            case 5:
                searchFunc = new Genetic(A);
                break;
        }
        double min = searchFunc.getMin();
        double realMin = min;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < realMin) realMin = A[i];
        }
        System.out.println("Min value: " + min + "\nReal min value: " + realMin);
        searchFunc.printChart();
    }

    static void fillArray(double[] A) {
        A[0] = 1;
        for (int i = 1; i < A.length; i++) {
            A[i] = f(A[i - 1]);
        }
    }

    static double f(double lastElement) {
        int a = 1103515245;
        int c = 12345;
        double m = Math.pow(2, 31);
        return ((a * lastElement) + c) % m;
    }
}
