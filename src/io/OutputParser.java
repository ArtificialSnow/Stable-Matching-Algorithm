package io;

import java.io.BufferedWriter;
import java.io.IOException;

public class OutputParser {

    private BufferedWriter writer;

    public OutputParser(BufferedWriter writer) {
        this.writer = writer;
    }

    public void writeOutput(int iteration, OutputData outputData) throws IOException {
        int numNodes = outputData.getNumNodes();
        int[][] blueNodePrefList = outputData.getBlueNodePrefList();
        int[] blueNextProposal = outputData.getBlueNextProposal();

        writer.write(String.format("Instance %d:", iteration));
        writer.newLine();
        writer.flush();

        for (int i = 0; i < numNodes; i++) {
            writer.write(String.format("Blue node %d matched with pink node %d", i+1, blueNodePrefList[i][blueNextProposal[i]-1]));
            writer.newLine();
            writer.flush();
        }
    }
}
