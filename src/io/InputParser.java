package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class InputParser {

    private BufferedReader reader;
    StringTokenizer tokenizer;
    String inputString;

    public InputParser(BufferedReader reader) {
        this.reader = reader;
    }

    public InputData parseInput(int numNodes) throws IOException {
        int[][] blueNodePrefList = new int[numNodes][numNodes];
        int[][] pinkNodeRankList = new int[numNodes][numNodes];
        int[] blueNextProposal = new int[numNodes];
        int[] pinkCurrentMatch = new int[numNodes];

        //Read in bluePref
        for (int i = 0; i < numNodes; i++) {
            tokenizer = new StringTokenizer(reader.readLine());

            for (int j = 0; j < numNodes; j++) {
                blueNodePrefList[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        //Read in pinkRank
        for (int i = 0; i < numNodes; i++) {
            tokenizer = new StringTokenizer(reader.readLine());

            for (int j = 0; j < numNodes; j++) {
                pinkNodeRankList[i][Integer.parseInt(tokenizer.nextToken())-1] = j;
            }
        }

        return new InputData(numNodes, blueNodePrefList, pinkNodeRankList, blueNextProposal, pinkCurrentMatch);
    }
}
