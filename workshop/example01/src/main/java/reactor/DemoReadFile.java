package reactor;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DemoReadFile {
    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderService();

        Path path = Paths.get("data.txt");

        fileReaderService.read(path)
                .take(5)
                .subscribe(item -> System.out.println(item));

        fileReaderService.read(path)
                .filter(line -> line.startsWith("a"))
                .map(str -> str.toUpperCase())
                .subscribe(item -> System.out.println(item));
    }
}
