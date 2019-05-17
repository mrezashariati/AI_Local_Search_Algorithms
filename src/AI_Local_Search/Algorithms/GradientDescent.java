package AI_Local_Search.Algorithms;

import java.util.Random;

public class GradientDescent extends LocalSearch {

    int stepSize = 1;

    public GradientDescent(double[] A) {
        super(A);
    }

    @Override
    public double getMin() {
        double min;
        Random random = new Random();
        int currentState = random.nextInt(A.length - 1) + 1;
        while (true) {
            this.chart.addData(currentState, A[currentState]);
            int nextState = getNextState(currentState);
            if (currentState == nextState) break;
            currentState = nextState;
        }
        min = A[currentState];
        return min;
    }

    private int getDirection(Integer currentState) {
        double lDerv, rDerv;
        rDerv = A[currentState + 1] - A[currentState];
        lDerv = A[currentState - 1] - A[currentState];
        if (rDerv * lDerv > 0) {
            if (rDerv > 0) return 0;
        }
        if (rDerv > 0) return 1;
        else if (rDerv < 0) return -1;
        else return 0;
    }

    private Integer getNextState(Integer currentState) {
        int direction = getDirection(currentState);
        return currentState - stepSize * direction;
    }
}
