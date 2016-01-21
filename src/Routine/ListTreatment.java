
package Routine;

import java.util.ArrayList;
import Model.Track;
import Model.TrackPoint;
import Model.TrackSegment;

public class ListTreatment {
    
    static public Track includingTrkPointsToTrk(String trackName, ArrayList<TrackPoint> trackPointList) {
	
		
		TrackSegment trackSegment = new TrackSegment();
		ArrayList<TrackSegment> trackSegmentList = new ArrayList<TrackSegment>();
		
		//Setting the input TrackPoint list into the new TrackSegment list
		trackSegment.setTrackPoints(trackPointList);
		
		//Adding the new segment to a list
		trackSegmentList.add(trackSegment);
		
		//Setting the new TrackSegment into a new track
		Track track = new Track(trackName, trackSegmentList);
		
		return track;
		
	}

    static public ArrayList<TrackPoint> getTrackPointList(Track trk) {
		
		ArrayList<TrackPoint> trackPointList = new ArrayList<TrackPoint>();
		
		int TotalOfTrackPoints = 0;
					
			//loop for each TrackSegment
			for (TrackSegment trackSegment : trk.getSegments()){
				//loop for each TrackPoint
				for (TrackPoint trackPoint : trackSegment.getTrackPoints()){
					
					//TrackPoint Sum
					TotalOfTrackPoints++;
					
					//new TrackPoint
					TrackPoint newTrackPoint = new TrackPoint(trackPoint.getLatitude(),
							trackPoint.getLongitude(),trackPoint.getEle(),
							trackPoint.getTime());

					//Adding the new trackpoint to the list for the segments
					trackPointList.add(newTrackPoint);
				}
			
		}
		return trackPointList;
	}

}
