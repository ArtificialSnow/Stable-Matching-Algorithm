package io;

public class OutputData {

    private int numNodes;
    private int[][] blueNodePrefList;
    private int[] blueNextProposal;

    public OutputData(int numNodes, int[][] blueNodePrefList, int[] blueNextProposal) {
        this.numNodes = numNodes;
        this.blueNodePrefList = blueNodePrefList;
        this.blueNextProposal = blueNextProposal;
    }

    public int getNumNodes() {
        return numNodes;
    }

    public int[][] getBlueNodePrefList() {
        return blueNodePrefList;
    }

    public int[] getBlueNextProposal() {
        return blueNextProposal;
    }
}
