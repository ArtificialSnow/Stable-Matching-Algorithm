package main;

import io.InputData;
import io.OutputData;

import java.util.LinkedList;
import java.util.Queue;

public class StableMatching {

    public OutputData stableMatching(InputData inputData) {
        int numNodes = inputData.getNumNodes();
        int[][] blueNodePrefList = inputData.getBlueNodePrefList();
        int[][] pinkNodeRankList = inputData.getPinkNodeRankList();
        int[] blueNextProposal = inputData.getBlueNextProposal();
        int[] pinkCurrentMatch = inputData.getPinkCurrentMatch();

        //Create blue node stack
        Queue<Integer> blueNodeStack = new LinkedList<>();
        for (int blueNode = 0; blueNode < numNodes; blueNode++) {

            boolean matched = false;
            while (!matched) {

                //Update next and get a pink node
                int pink = blueNodePrefList[blueNode][blueNextProposal[blueNode]] - 1;
                blueNextProposal[blueNode]++;

                //If pink is unmatched, match with blue
                int currentMatch = pinkCurrentMatch[pink] - 1;
                if (currentMatch == -1) {
                    pinkCurrentMatch[pink] = blueNode + 1;
                    matched = true;

                    //Else if pink is matched, check the preference of pink
                } else {
                    //new blue > old matching
                    if (pinkNodeRankList[pink][blueNode] < pinkNodeRankList[pink][currentMatch]) {
                        pinkCurrentMatch[pink] = blueNode + 1;
                        blueNodeStack.add(currentMatch);
                        matched = true;
                    }
                }
            }
        }

        //Apply GS-Algorithm
        while (!blueNodeStack.isEmpty()) {
            int blueNode = blueNodeStack.remove();

            boolean matched = false;
            while (!matched) {

                //Update next and get a pink node
                int pink = blueNodePrefList[blueNode][blueNextProposal[blueNode]] - 1;
                blueNextProposal[blueNode]++;

                //If pink is unmatched, match with blue
                int currentMatch = pinkCurrentMatch[pink] - 1;
                if (currentMatch == -1) {
                    pinkCurrentMatch[pink] = blueNode + 1;
                    matched = true;

                    //Else if pink is matched, check the preference of pink
                } else {
                    //new blue > old matching
                    if (pinkNodeRankList[pink][blueNode] < pinkNodeRankList[pink][currentMatch]) {
                        pinkCurrentMatch[pink] = blueNode + 1;
                        blueNodeStack.add(currentMatch);
                        matched = true;
                    }
                }
            }
        }

        return new OutputData(numNodes, blueNodePrefList, blueNextProposal);
    }
}
