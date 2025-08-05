package CreateAppointment;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;

public final class leadRequestEnhancer {
	  private static final ObjectMapper mapper = new ObjectMapper();
    
    private leadRequestEnhancer() {}

//    public static JsonNode enhanceLeadRequest(JsonNode vehicleData, 
//            JsonNode leadRequest,
//            String phoneNumber) {
//return enhanceLeadRequest(vehicleData, leadRequest, phoneNumber, 
//List.of("gs_eligible", "luxury"));
//}

//public static JsonNode enhanceLeadRequest(JsonNode vehicleData,
//            JsonNode leadRequest,
//            String phoneNumber,
//            List<String> eligibilityTypes) {
//validateInputs(vehicleData, leadRequest, eligibilityTypes);
//
//ObjectNode enhancedRequest = (ObjectNode) leadRequest.deepCopy();
//
//// 1. Add phone number if field exists
//if (enhancedRequest.has("phone")) {
//enhancedRequest.put("phone", phoneNumber);
//}
//
//// 2. Add vehicle IDs
//JsonNode vehicle = findFirstEligibleVehicle(vehicleData, eligibilityTypes);
//enhancedRequest.put("make_id", vehicle.path("make_id").asInt());
//enhancedRequest.put("model_id", vehicle.path("model_id").asInt());
//enhancedRequest.put("year_id", vehicle.path("year_id").asInt());
//enhancedRequest.put("variant_id", vehicle.path("variant_id").asInt());
//
//return mapper.writeValueAsString(requestBody);
//}
    public static String getCompleteRequestBody(JsonNode vehicleData,
            JsonNode baseRequest,
            String phoneNumber,
            String vehicleType) throws Exception {
// Validate vehicle type exists
if (!vehicleData.has(vehicleType)) {
throw new IllegalArgumentException("Vehicle type '" + vehicleType + "' not found in data");
}

JsonNode vehicles = vehicleData.path(vehicleType);
if (vehicles.isEmpty()) {
throw new IllegalArgumentException("No vehicles available for type '" + vehicleType + "'");
}

// Take the first vehicle of specified type
JsonNode vehicle = vehicles.get(0);

ObjectNode requestBody = mapper.createObjectNode();
requestBody.setAll((ObjectNode) baseRequest);

requestBody.put("phone", phoneNumber);
requestBody.put("make_id", vehicle.path("make_id").asInt());
requestBody.put("model_id", vehicle.path("model_id").asInt());
requestBody.put("year_id", vehicle.path("year_id").asInt());
requestBody.put("variant_id", vehicle.path("variant_id").asInt());

return mapper.writeValueAsString(requestBody);
}

private static JsonNode findFirstEligibleVehicle(JsonNode vehicleData, List<String> eligibilityTypes) {
for (String type : eligibilityTypes) {
if (vehicleData.has(type)) {
JsonNode vehicles = vehicleData.path(type);
if (!vehicles.isEmpty()) {
return vehicles.get(0);
}
}
}
throw new IllegalArgumentException("No eligible vehicles found in types: " + eligibilityTypes);
}

private static void validateInputs(JsonNode vehicleData, JsonNode leadRequest, List<String> eligibilityTypes) {
if (vehicleData == null || leadRequest == null) {
throw new IllegalArgumentException("Input JSON nodes cannot be null");
}
if (eligibilityTypes == null || eligibilityTypes.isEmpty()) {
throw new IllegalArgumentException("Eligibility types list cannot be empty");
}
}
}