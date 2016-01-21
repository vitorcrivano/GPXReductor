package Model;

public class TrackPoint {
	private float latitude;
	private float longitude;
	private float ele;
	private String time;
	
	public TrackPoint(float latitude, float longitude, float ele, String time) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.ele = ele;
		this.time = time;
	}
	
	public TrackPoint() 
        {
		super();
	}

	public float getLatitude() 
        {
		return latitude;
	}
        
        public float getLongitude() 
        {
		return longitude;
	}
        
        public float getEle() 
        {
		return ele;
	}

	public String getTime() 
        {
		return time;	
        }
        
        public void setLatitude(float latitude) 
        {
		this.latitude = latitude;
	}
        
	public void setLongitude(float longitude) 
        {
		this.longitude = longitude;	
        }	

	public void setEle(float ele) 
        {
		this.ele = ele;
	}	
       
	public void setTime(String time) 
        {
		this.time = time;
	}

}
