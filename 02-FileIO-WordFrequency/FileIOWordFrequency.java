import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileIOWordFrequency {
    public static void main(String[] args) {
        Path inputPath = Paths.get("input.txt");
        Path outputPath = Paths.get("word_frequency_output.txt");
        Map<String, Integer> wordCounts = new LinkedHashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(inputPath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String cleanedLine = line.toLowerCase().replaceAll("[^a-z0-9'\\s]", " ");
                String[] words = cleanedLine.trim().split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException exception) {
            System.out.println("Could not read input.txt: " + exception.getMessage());
            System.out.println("Create input.txt in the same folder and try again.");
            return;
        }

        try (BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardCharsets.UTF_8)) {
            writer.write("Word Frequency Report");
            writer.newLine();
            writer.write("=====================");
            writer.newLine();

            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException exception) {
            System.out.println("Could not write output file: " + exception.getMessage());
            return;
        }

        System.out.println("Word frequency report created: " + outputPath.toAbsolutePath());
        System.out.println("Unique words counted: " + wordCounts.size());
    }
}
