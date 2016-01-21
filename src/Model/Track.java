package Model;
import java.util.*;


public class Track {
	
	private String name;
	private ArrayList<TrackSegment> segments;
	
	public Track(String name, ArrayList<TrackSegment> segments) 	{
		super();
		this.name = name;
		this.segments = segments;
	}

	public Track() {
		super();
	}
	
	//Getters and Setters
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

	//Counter to how many TrackPoint has the Track
	public int countTrackPoints() {
		
		//Object to count the total
		int trackPointTotal = 0;
		
		//Object to count the total of TrackPoints from each TrackSegment
		int segmentTrackPoints = 0;
		
		//Creating a loop for each TrackSegment in the Track
		for (TrackSegment trackSegment : this.getSegments()){
			
			//Getting the total by using the function size
			segmentTrackPoints = trackSegment.getTrackPoints().size();
			
			//Summing the size
			trackPointTotal = trackPointTotal + segmentTrackPoints;
		}
		
		return trackPointTotal;
		
	}
		
}
