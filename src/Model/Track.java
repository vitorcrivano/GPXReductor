package Model;
import java.util.*;


public class Track {
	
	private String name;
	private ArrayList<TrackSegment> segments;
	
	public Track(String name, ArrayList<TrackSegment> segments) 	
        {
		super();
		this.name = name;
		this.segments = segments;
	}

	public Track() 
        {
		super();
	}
	
	
	public String getName() 
        {
		return name;
	}
        
       
	public ArrayList<TrackSegment> getSegments() 
        {
		return segments;
	}
        
       
	public void setName(String name) 
        {
		this.name = name;
	}
        
       
	public void setSegments(ArrayList<TrackSegment> segments) 
        {
		this.segments = segments;
	}

	//Count the number of track points
	public int countTrackPoints() 
        {
		
		//Total of points
		int trackPointTotal = 0;
		
		//Total of track points  per track segment
		int segmentTrackPoints = 0;
		
		//Creating a loop for each TrackSegment in the Track
		for (TrackSegment trackSegment : this.getSegments()){
			
			//Getting the total by using the function size
			segmentTrackPoints = trackSegment.getTrackPoints().size();
			
			//Summing the size
			trackPointTotal = segmentTrackPoints + trackPointTotal;
		}
		
		return trackPointTotal;
		
	}
		
}
