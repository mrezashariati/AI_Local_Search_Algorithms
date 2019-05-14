package AI_Local_Search.Algorithms;

public class LocalBeamSearch extends LocalSearch {

    public LocalBeamSearch(double[] A) {
        super(A);
    }

    @Override
    public double getMin() {
        return 0;
    }

    @Override
    Integer getNeighbours(int state, byte direction) {
        return null;
    }

}
