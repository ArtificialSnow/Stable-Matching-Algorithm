package io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputWriter {

    private BufferedWriter writer;

    public OutputWriter() {
        this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
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
