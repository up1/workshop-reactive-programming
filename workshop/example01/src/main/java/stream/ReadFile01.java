package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.lang.System.out;

public class ReadFile01 {
    public static void main(String[] args) throws IOException {
        ReadFile01 p = new ReadFile01();
        p.readSimple("data.txt");
    }

    void readSimple(String filename) throws IOException {
        List<String> datas = Files.readAllLines(Path.of(filename));
        for (String data : datas) {
            if(data.startsWith("a")) {
                out.println(data);
            }
        }
    }
}
