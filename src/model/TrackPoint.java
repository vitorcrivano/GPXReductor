package Model;

public class TrackPoint {

	private float ele;
	private String time;
	private float longitude;
	private float latitude;
	
	public TrackPoint(float latitude, float longitude, float ele, String time) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.ele = ele;
		this.time = time;
	}
	
	public TrackPoint() {
		super();
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getEle() {
		return ele;
	}

	public void setEle(float ele) {
		this.ele = ele;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
