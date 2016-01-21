package Model;
import java.util.*;

public class TrackSegment {
	private ArrayList<TrackPoint> trackPoints;
	
	public TrackSegment(ArrayList<TrackPoint> trackPoints) 
        {
		super();
		this.trackPoints = trackPoints;
	}

	public TrackSegment() 
        {
		super();
	}

	public void setTrackPoints(ArrayList<TrackPoint> trackPoints) 
        {
		this.trackPoints = trackPoints;
	}
	
        public ArrayList<TrackPoint> getTrackPoints() 
        {
		return trackPoints;
	}
	
}