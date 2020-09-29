package io;

public class InputData {

    private int numNodes;
    private int[][] blueNodePrefList;
    private int[][] pinkNodeRankList;
    private int[] blueNextProposal;
    private int[] pinkCurrentMatch;

    public InputData(int numNodes, int[][] blueNodePrefList, int[][] pinkNodeRankList, int[] blueNextProposal, int[] pinkCurrentMatch) {
        this.numNodes = numNodes;
        this.blueNodePrefList = blueNodePrefList;
        this.pinkNodeRankList = pinkNodeRankList;
        this.blueNextProposal = blueNextProposal;
        this.pinkCurrentMatch = pinkCurrentMatch;
    }

    public int getNumNodes() {
        return numNodes;
    }

    public int[][] getBlueNodePrefList() {
        return blueNodePrefList;
    }

    public int[][] getPinkNodeRankList() {
        return pinkNodeRankList;
    }

    public int[] getBlueNextProposal() {
        return blueNextProposal;
    }

    public int[] getPinkCurrentMatch() {
        return pinkCurrentMatch;
    }
}
