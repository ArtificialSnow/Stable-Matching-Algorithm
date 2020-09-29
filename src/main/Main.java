package main;

import io.InputData;
import io.InputParser;
import io.OutputData;
import io.OutputWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputParser inputParser = new InputParser(reader);
        OutputWriter outputWriter = new OutputWriter();

        int iteration = 1;
        while (true) {
            int numNodes = Integer.parseInt(reader.readLine());
            if (numNodes == 0) {
                System.exit(0);
            }

            InputData inputData = inputParser.parseInput(numNodes);

            StableMatching algorithm = new StableMatching();
            OutputData outputData = algorithm.stableMatching(inputData);

            outputWriter.writeOutput(iteration, outputData);

            iteration++;
        }
    }
}
