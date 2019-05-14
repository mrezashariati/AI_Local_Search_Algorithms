package AI_Local_Search.Algorithms;

import java.util.Random;

public class HillClimbing extends LocalSearch {

    private int stepLimit;

    public HillClimbing(double[] A) {
        super(A);
    }

    @Override
    public double getMin() {
        double min = Integer.MAX_VALUE;
        Random random = new Random();
        int randomRestart = 10;
        for (int i = 0; i < randomRestart; i++) {
            int currentState = random.nextInt(A.length - 1) + 1;
            stepLimit = 10;
            byte direction;
            if (currentState - 1 > 0 && A[currentState - 1] < A[currentState]) direction = -1;
            else if (currentState + 1 < A.length && A[currentState + 1] <= A[currentState]) direction = 1;
            else direction = -1;
            double potentialMin = walk(currentState, direction);
            chart.addData((i + 1), potentialMin);
            min = min > potentialMin ? potentialMin : min;
        }
        return min;
    }

    private double walk(int currentState, byte direction) {
        double potentialMin = A[currentState];
        int newState = currentState;
        Integer neighbour = getNeighbours(currentState, direction);
        if (neighbour == 0) return potentialMin;
        if (A[neighbour] < A[currentState]) {
            newState = neighbour;
            potentialMin = walk(newState, direction);
        }
        if (newState == currentState && stepLimit != 0) {
            if (A[neighbour] == A[currentState]) {
                newState = neighbour;
                stepLimit--;
                potentialMin = walk(newState, direction);
            }
        }
        return potentialMin;
    }

    Integer getNeighbours(int state, byte direction) {
        if (direction == -1) {
            if (state > 1) return state - 1;
        } else {
            if (state < A.length - 1) return state + 1;
        }
        return 0;
    }
}
