package Routine;

import org.xml.sax.SAXException;

import Model.Track;
import Model.TrackPoint;
import XMLTreatment.XmlWriter;
import XMLTreatment.XmlReader;
import MathLogic.TrackPointReducer;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;

public class Reductor {
	
	static public void removePoints(String[] args) throws IOException, ParserConfigurationException, SAXException{
		
		String reduction = args[0];
		String filesOrigin = args[1];
		String filesDestination = args[2];
		
		ArrayList<Track> trackList = new ArrayList<Track>();
		
		trackList = XmlReader.ReadXML(filesOrigin);
		
		//Empty list?
		if(!emptyList(trackList)){
			System.exit(0);
		}
		
		//Apllying the reduction to the list
		trackList = reduceTrack(trackList, reduction);
		
		//Writing the new XML File
		XmlWriter.xmlWriter(trackList, filesDestination);
		
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
		
		ArrayList<TrackPoint> trackPointList = new ArrayList<TrackPoint>();
		ArrayList<Track> newTrackList = new ArrayList<Track>();
		
		//loop for each Track
		for (Track track : trackList) { 
			
			//TrackPoints before the reduction
			track.TrackPointsCounter();
			
			//all the TrackPoints
			trackPointList = ListTreatment.getTrackPointList(track);
					
			//%?
			if(toReduce.endsWith("%")) {
				
				//excludin the "%" character
				int percentageToReduce = Integer.parseInt(toReduce.substring(0, toReduce.length()-1));
				
				//percentage redution
				trackPointList = TrackPointReducer.reduceByPercentage(trackPointList, percentageToReduce);
			
			} else {
				
				//distance in km? so change it to double
				double distanceToReduce = Double.parseDouble(toReduce);
				
				//distance reduction
				trackPointList = TrackPointReducer.reduceByDistance(trackPointList, distanceToReduce);
			}
			
			//Adding the TrackPoints back to the Track
			track =  ListTreatment.includingTrkPointsToTrk(track.getName(), trackPointList);
					
			//TrackPoints after the reduction
			track.TrackPointsCounter();
				
			//Adding the changed Track to the new TrackList
			newTrackList.add(track);
		}
		
		return newTrackList;
	}
	

}
