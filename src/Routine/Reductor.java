import org.xml.sax.SAXException;

import Model.Track;
import Model.TrackPoint;
import XMLTreatment.XMLWriter;
import XMLTreatment.XMLReader;
import Routine.TrackPointListFromTrack;
import MathLogic.TrackPointReducer;
import Routine.TrackPointToTrack;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;

public class Reductor {
	
	static public void removePoints(String[] args) throws IOException, ParserConfigurationException, SAXException{
		
		String reduction = args[0];
		String filesOrigin = args[1];
		String filesDestination = args[2];
		
		ArrayList<Track> trackList = new ArrayList<Track>();
		
		trackList = XMLReader.ReadXML(filesOrigin);
		
		//Empty list?
		if(!emptyList(trackList)){
			System.exit(0);
		}
		
		//Apllying the reduction to the list
		trackList = reduceTrack(trackList, reduction);
		
		//Writing the new XML File
		XMLWriter.xmlWriter(trackList, filesDestination);
		
		System.out.println("Done.");
	}
	
	//Verify if there is at least one Track in the list.
	static public boolean emptyList(ArrayList<Track> trackList){
		if (trackList.size() > 0){
			return true;
		} else {
			return false;
		}
	}
	
	//Reduce the Track
	static public ArrayList<Track> reduceTrack(ArrayList<Track> trackList, String toReduce) {
		
		//Creating list objects
		ArrayList<TrackPoint> trackPointList = new ArrayList<TrackPoint>();
		ArrayList<Track> newTrackList = new ArrayList<Track>();
		
		//Creating a loop to get into each Track
		for (Track track : trackList) { 
			
			//Count the TrackPoints from the Track before reducing
			track.countTrackPoints();
			
			//Get all the TrackPoints from the Track
			trackPointList = TrackPointListFromTrack.getTrackPointList(track);
					
			//Reduce TrackPoints
			//Verify if it's percentage
			if(toReduce.endsWith("%")) {
				
				//Change the characters to int without getting the %
				int percentageToReduce = Integer.parseInt(toReduce.substring(0, toReduce.length()-1));
				
				//Reducing using the percentage function
				trackPointList = TrackPointReducer.reduceByPercentage(trackPointList, percentageToReduce);
			
			} else {
				
				//If it's a distance in km, change it to double
				double distanceToReduce = Double.parseDouble(toReduce);
				
				//Reducing using the distance function
				trackPointList = TrackPointReducer.reduceByDistance(trackPointList, distanceToReduce);
			}
			
			//Adding the TrackPoints back to the Track
			track =  TrackPointToTrack.addingTrackPointsToTrack(track.getName(), trackPointList);
					
			//Count the TrackPoints from the track after reducing
			track.countTrackPoints();
				
			//Adding the changed Track to the new TrackList
			newTrackList.add(track);
		}
		
		return newTrackList;
	}
	

}
