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
        int randomRestart = 1;
        for (int i = 0; i < randomRestart; i++) {
            int currentState = random.nextInt(A.length - 1) + 1;
            stepLimit = 10;
            byte direction;
            if (currentState - 1 > 0 && A[currentState - 1] < A[currentState]) direction = -1;
            else if (currentState + 1 < A.length && A[currentState + 1] <= A[currentState]) direction = 1;
            else direction = -1;
            double potentialMin = step(currentState, direction);
            min = min > potentialMin ? potentialMin : min;
        }
        return min;
    }

    private double step(int currentState, byte direction) {
        double potentialMin = A[currentState];
        int newState = currentState;
        Integer nextState = getNextState(currentState, direction);
        this.chart.addData(newState, A[newState]);
        if (newState == 0) return potentialMin;
        if (A[newState] < A[currentState]) {
            newState = nextState;
            potentialMin = step(newState, direction);
        }
        if (newState == currentState && stepLimit != 0) {
            if (A[nextState] == A[currentState]) {
                newState = nextState;
                stepLimit--;
                potentialMin = step(newState, direction);
            }
        }
        return potentialMin;
    }

    Integer getNextState(int state, byte direction) {
        if (direction == -1) {
            if (state > 1) return state - 1;
        } else {
            if (state < A.length - 1) return state + 1;
        }
        return 0;
    }
}
