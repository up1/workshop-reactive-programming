package stream;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class GenerateData {
    public static void main(String[] args) throws IOException {
        File outputFile = new File("data.txt");
        if(outputFile.exists()){
            outputFile.delete();
        }
        outputFile.createNewFile();

        try (PrintWriter writer = new PrintWriter(outputFile)) {
            for (int i = 0; i < 20_000_000; i++) {
                writer.println(RandomStringUtils.randomAlphabetic(300));
                if (i % 1000 == 0) {
                    writer.flush();
                }
            }
        }
    }
}
