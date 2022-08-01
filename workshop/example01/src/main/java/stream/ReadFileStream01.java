package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

import static java.lang.System.out;

public class ReadFileStream01 {
    public static void main(String[] args) throws IOException {
        ReadFileStream01 p = new ReadFileStream01();
//        p.readWithSequential("data.txt");
        p.readWithParallel("data.txt");
    }

    void readWithSequential(String filename) throws IOException {
        Instant start = Instant.now();
        Stream<String> datas = Files.lines(Path.of(filename));
        datas.filter( data -> data.startsWith("A") )
                .forEach(out::println);
        out.println("Processing time with sequential = " + ChronoUnit.SECONDS.between(start, Instant.now()));
    }

    void readWithParallel(String filename) throws IOException {
        Instant start = Instant.now();
        Stream<String> datas = Files.lines(Path.of(filename));
        datas.parallel().filter( data -> data.startsWith("A") )
                .forEach(out::println);
        out.println("Processing time with parallel = " + ChronoUnit.SECONDS.between(start, Instant.now()));
    }
}
