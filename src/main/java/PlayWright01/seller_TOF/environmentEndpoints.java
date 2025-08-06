package PlayWright01.seller_TOF;

public class environmentEndpoints {
	 private Environment envType;
	    private String baseUrl;
//	    private String apiEndpoint;
//	    private int timeout;

	    // Constructor (private to control creation)
	    private environmentEndpoints(Environment envType, String baseUrl) {
	        this.envType = envType;
	        this.baseUrl = baseUrl;
//	        this.apiEndpoint = apiEndpoint;
//	        this.timeout = timeout;
	    }

	   

	    public static final environmentEndpoints QA = new environmentEndpoints(
	    		Environment.QA,
	        "http://qa-sell-c2b-website.qac24svc.dev/sell-used-cars"
	      
	    );

	    public static final environmentEndpoints STAGE = new environmentEndpoints(
	    		Environment.STAGE,
	        "https://stage-c2b-website.qac24svc.dev/sell-used-cars"
	    );
	    public static final environmentEndpoints PROD = new environmentEndpoints(
	    		Environment.PROD,
	    		   "https://www.cars24.com/sell-used-cars/"
	        );

	        // --- Getters ---
	        public Environment getEnvType() { return envType; }
	        public String getBaseUrl() { return baseUrl; }
//	        public String getApiEndpoint() { return apiEndpoint; }
//	        public int getTimeout() { return timeout; }

	        // Helper to get full API URL
//	        public String getFullApiUrl() {
//	            return baseUrl + apiEndpoint;
//	        }
	        
	        public static environmentEndpoints getEnvironment(Environment type) {
	            switch (type) {
	               
	                case QA: return QA;
	                case STAGE: return STAGE;
	                case PROD: return PROD;
	                default: throw new IllegalArgumentException("Invalid environment: " + type);
	            }
	        }
	    }
