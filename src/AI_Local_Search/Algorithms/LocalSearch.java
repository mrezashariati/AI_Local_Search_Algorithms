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
        this.chart.setVisible(true);
    }


}
