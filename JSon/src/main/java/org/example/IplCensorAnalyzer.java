import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class IplCensorAnalyzer {

    public static void main(String[] args) {
        processJsonFile("ipl_data.json", "censored_ipl_data.json");
        processCsvFile("ipl_data.csv", "censored_ipl_data.csv");
    }

    private static void processJsonFile(String inputFile, String outputFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonArray = objectMapper.readTree(new File(inputFile));

            for (JsonNode match : jsonArray) {
                ((ObjectNode) match).put("team1", maskTeamName(match.get("team1").asText()));
                ((ObjectNode) match).put("team2", maskTeamName(match.get("team2").asText()));
                ((ObjectNode) match).put("player_of_match", "REDACTED");

                ObjectNode scoreNode = (ObjectNode) match.get("score");
                Iterator<String> fieldNames = scoreNode.fieldNames();
                Map<String, Integer> updatedScores = new LinkedHashMap<>();

                while (fieldNames.hasNext()) {
                    String team = fieldNames.next();
                    updatedScores.put(maskTeamName(team), scoreNode.get(team).asInt());
                }

                scoreNode.removeAll();
                updatedScores.forEach(scoreNode::put);
            }

            objectMapper.writeValue(new File(outputFile), jsonArray);
            System.out.println("✅ Censored JSON file generated: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processCsvFile(String inputFile, String outputFile) {
        try {
            File csvFile = new File(inputFile);
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader();

            MappingIterator<Map<String, String>> iterator =
                    csvMapper.readerFor(Map.class).with(schema).readValues(csvFile);

            List<Map<String, String>> records = new ArrayList<>();
            while (iterator.hasNext()) {
                Map<String, String> row = iterator.next();
                row.put("team1", maskTeamName(row.get("team1")));
                row.put("team2", maskTeamName(row.get("team2")));
                row.put("player_of_match", "REDACTED");
                records.add(row);
            }

            CsvSchema outputSchema = CsvSchema.builder()
                    .addColumns(records.get(0).keySet(), CsvSchema.ColumnType.STRING)
                    .setUseHeader(true)
                    .build();

            csvMapper.writer(outputSchema).writeValue(new File(outputFile), records);
            System.out.println("✅ Censored CSV file generated: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String maskTeamName(String teamName) {
        int spaceIndex = teamName.lastIndexOf(" ");
        return spaceIndex == -1 ? teamName : teamName.substring(0, spaceIndex) + " ***";
    }
}
