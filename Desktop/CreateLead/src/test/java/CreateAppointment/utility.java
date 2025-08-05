package CreateAppointment;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class utility {

//	 private static final String JSON_FILE = "Users/a35294/eclipse-workspace/CreateLead/resource/test-data/MMVY.json";
	 private static Map<String, List<Vehicle>> testDataMap = new HashMap<>();

	    static {
	        try {
	        	 File file = new File("src/test/java/resources/MMVY");
	            ObjectMapper mapper = new ObjectMapper();
//	            InputStream is = utility.class.getClassLoader().getResourceAsStream("CreateLead/src/test/java/resources/MMVY");
//	            if (is == null) {
//	            	 System.err.println("❌ testdata.json not found in resources folder!");
//	            	 throw new RuntimeException("testdata.json not found in resources");
//	            }
	            

	            testDataMap = mapper.readValue(file, new TypeReference<Map<String, List<Vehicle>>>() {});
	            System.out.println("✅ JSON loaded successfully");
	        } catch (Exception e) {
	        	 e.printStackTrace(); // This is what triggers ExceptionInInitializerError
	             throw new RuntimeException("Failed to parse testdata.json", e);
	         }
	     }

	    // ✅ Get full list of vehicles by case name
	    public static List<Vehicle> getVehiclesByCase(String caseName) {
	        return testDataMap.get(caseName);
	    }

	    // ✅ Get first vehicle in the list (most common use case)
	    public static Vehicle getFirstVehicle(String caseName) {
	        List<Vehicle> list = testDataMap.get(caseName);
	        if (list == null || list.isEmpty()) {
	            throw new RuntimeException("No vehicles found for case: " + caseName);
	        }
	        return list.get(0);
	    }
	}