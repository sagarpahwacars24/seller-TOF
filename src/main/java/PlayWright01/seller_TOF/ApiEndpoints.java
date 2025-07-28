package PlayWright01.seller_TOF;

public class ApiEndpoints {
	

	 private static final String BASE_URL_LEAD_SERVICE_STAGE = "https://lead-service-java-stage.qac24svc.dev";
	 private static final String BASE_URL_VEHICLE_SERVICE_STAGE = "https://vehicle-service-stage.qac24svc.dev";
	 private static final String BASE_URL_LOCATION_SERVICE_STAGE = "https://cars-consumer-gateway-stage.qac24svc.dev";
	 private static final String BASE_URL_LEAD_SERVICE_QA = "https://lead-service-java.qac24svc.dev";
	 private static final String BASE_URL_VEHICLE_SERVICE_QA = "https://vehicle-service.qac24svc.dev";
	 private static final String BASE_URL_LOCATION_SERVICE_QA = "https://cars-consumer-gateway.qac24svc.dev";
	 private static final String BASE_URL_LEAD_SERVICE_PROD = "https://seller-lead.cars24.team";
	 private static final String BASE_URL_VEHICLE_SERVICE_PROD = "https://vehicle.cars24.team";
	 private static final String BASE_URL_LOCATION_SERVICE_PROD = "https://cars-consumer.cars24.team";

	    // Current active base URL (default to DEV)
	    private static String activeBaseUrl = BASE_URL_LEAD_SERVICE_STAGE; // Now non-final

	    // Endpoints (Relative paths)
	    public static final String CREATE_LEAD = "/create-lead?source=original";
	    public static final String LEAD_DETAILS = "/lead-details/{token}";
	    public static final String UPDATE_LEAD = "update-lead?source=original-sell-online&token={token}";
	    public static final String CREATE_APPOINTMENT = "/appointment";
	    public static final String APPOINTMENT_DETAIL = "/appointment/token/{token}";
	    public static final String APPOINTMENT_RESCHEDULE = "/appointment/reschedule/{token}";
	    public static final String APPOINTMENT_CANCEL = "/appointment/cancel/{token}";
	    
	    

	    // Full URLs (Base + Endpoint)
	    public static String createLeadUrl() {
	        return activeBaseUrl + CREATE_LEAD;
	    }

	    public static String leadDetails(String token) {
	        return activeBaseUrl + LEAD_DETAILS.replace("{token}", token);
	    }

	    public static String leadUpdate(String token) {
	        return activeBaseUrl + UPDATE_LEAD.replace("{token}", token);
	    }
	    public static String createAppointment(String token) {
	        return activeBaseUrl + CREATE_APPOINTMENT;
	    }
	    public static String appointmentDetail(String token) {
	        return activeBaseUrl + APPOINTMENT_DETAIL.replace("{token}", token);
	    }
	    public static String appointmentReschedule(String token) {
	        return activeBaseUrl + APPOINTMENT_RESCHEDULE.replace("{token}", token);
	    }
	    public static String appointmentCancel(String token) {
	        return activeBaseUrl + APPOINTMENT_CANCEL.replace("{token}", token);
	    }

	    // Static method to update base URL
	    public static void setBaseUrl(String baseUrl) {
	        activeBaseUrl = baseUrl; // No 'this' needed
	    }

	    // Get current base URL (optional)
	    public static String getActiveBaseUrl() {
	        return activeBaseUrl;
	    }
	}