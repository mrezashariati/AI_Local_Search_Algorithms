package AI_Local_Search.Algorithms;

import AI_Local_Search.Chart;

public abstract class LocalSearch {
    Chart chart;
    double[] A;

    public LocalSearch(double[] A) {
        this.chart = new Chart();
        this.A = A;
    }

    abstract public double getMin();

    public void printChart() {
        chart.setVisible(true);
    }

    abstract Integer getNeighbours(int state, byte direction);
}
