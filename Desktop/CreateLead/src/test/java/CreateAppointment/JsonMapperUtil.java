package CreateAppointment;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class JsonMapperUtil {
	
	private static final ObjectMapper mapper = new ObjectMapper();

    public static JsonNode readJsonFile(String filePath) throws IOException {
        return mapper.readTree(new File(filePath));
    }

    public static void writeJsonFile(String filePath, JsonNode content) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), content);
    }

    public static JsonNode deepCopy(JsonNode node) {
        return node.deepCopy();
    }


//    private static final ObjectMapper mapper = new ObjectMapper();
//
    public static String enhanceLeadRequestWithIds(String referenceDataPath, String leadRequestPath) throws IOException {
        // 1. Load JSON files from specified paths
        File referenceFile = new File(referenceDataPath);
        File requestFile = new File(leadRequestPath);

        // 2. Parse JSON files
        JsonNode referenceData = mapper.readTree(referenceFile);
        ObjectNode requestBody = (ObjectNode) mapper.readTree(requestFile);

        // 3. Get vehicle details from request
        JsonNode vehicleNode = requestBody.path("lead").path("vehicle");
        String makeName = vehicleNode.path("make").asText();
        String modelName = vehicleNode.path("model").asText();

        // 4. Find matching make/model IDs
        int makeId = findMakeId(referenceData, makeName);
        int modelId = findModelId(referenceData, modelName, makeId);

        // 5. Update request body with IDs
        ((ObjectNode)vehicleNode).put("makeId", makeId);
        ((ObjectNode)vehicleNode).put("modelId", modelId);

        // 6. Return the modified JSON as string
        return mapper.writerWithDefaultPrettyPrinter()
                   .writeValueAsString(requestBody);
    }

    private static int findMakeId(JsonNode referenceData, String makeName) {
        for (JsonNode make : referenceData.path("makes")) {
            if (make.path("name").asText().equalsIgnoreCase(makeName)) {
                return make.path("id").asInt();
            }
        }
        throw new RuntimeException("Make not found: " + makeName);
    }

    private static int findModelId(JsonNode referenceData, String modelName, int makeId) {
        for (JsonNode model : referenceData.path("models")) {
            if (model.path("name").asText().equalsIgnoreCase(modelName) && 
                model.path("makeId").asInt() == makeId) {
                return model.path("id").asInt();
            }
        }
        throw new RuntimeException("Model not found: " + modelName + " for makeId: " + makeId);
    }
}