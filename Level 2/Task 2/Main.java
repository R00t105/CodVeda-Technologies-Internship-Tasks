import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            Path input = Path.of("input.txt");
            Path output = Path.of("output.txt");

            List<String> linesList = Files.readAllLines(input, StandardCharsets.UTF_8);
            long lines = linesList.size();
            long words = linesList.stream().flatMap(line -> Arrays.stream(line.trim().split("\\s+")))
                    .filter(word -> !word.isEmpty())
                    .count();
            int characters = linesList.stream().mapToInt(String::length).sum();

            String info = String.format("""
                Total Lines: %d
                Total Words: %d
                Total Characters: %d
                """, lines, words, characters);

            Files.writeString(output, info, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }
}