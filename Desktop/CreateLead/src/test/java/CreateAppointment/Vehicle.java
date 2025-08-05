package CreateAppointment;

public class Vehicle {
	 public String make;
	    public String model;
	    public int year;
	    public String variant;
	    public int make_id;
	    public int model_id;
	    public int year_id;
	    public int variant_id;

	   
	    @Override
	    public String toString() {
	        return make + " " + model + " " + variant + " (" + year + ")";
	    }
	}