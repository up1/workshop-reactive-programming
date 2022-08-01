package stream;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.*;

public class Demo {
    public static void main(String[] args) {
        List<String> datas = Arrays.asList("a1", "a2", "b1", "b2", "c1");
        // Imperative
        for (String data : datas) {
            if(data.startsWith("a")) {
                out.println(data);
            }
        }
        // Declarative with Stream API
        datas.stream()
                .filter( data -> data.startsWith("A") )
                .forEach(out::println);
    }
}
