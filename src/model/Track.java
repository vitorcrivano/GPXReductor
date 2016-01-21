package Model;
import java.util.*;


public class Track {
	
	private String name;
	private ArrayList<TrackSegment> segments;
	
	public Track(String name, ArrayList<TrackSegment> segments) {
		super();
		this.name = name;
		this.segments = segments;
	}

	public Track() {
		super();
	}


	//Counter of TrackPoints 
	public int countTrackPoints() {
		
		int totalTrackPoint = 0;
		int segmentTrackPoints = 0;
		
		//Loop for each TrackSegment
		for (TrackSegment trackSegment : this.getSegments()){
			segmentTrackPoints = trackSegment.getTrackPoints().size();
			
			totalTrackPoint = totalTrackPoint + segmentTrackPoints;
		}
		
		System.out.println(totalTrackPoint);
		return trackPointTotal;
		
	}

public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<TrackSegment> getSegments() {
		return segments;
	}

	public void setSegments(ArrayList<TrackSegment> segments) {
		this.segments = segments;
	}
		
}
