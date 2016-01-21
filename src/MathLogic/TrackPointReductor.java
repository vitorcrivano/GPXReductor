package MathLogic;

import java.util.ArrayList;

import MathLogic.MathCalculatorOfDistance;
import Model.TrackPoint;

public class TrackPointReductor {
    
        // are the Points in the same place?
	static public boolean pointsAtTheSamePlace(TrackPoint x1, TrackPoint x2) {
		if ((x1.getLatitude() == x2.getLatitude())
				&& (x1.getLongitude() == x2.getLongitude())) {
			return true;
		} else {
			return false;
		}
	}
    
        // are there at least one TrackPoint?
	static public boolean emptyList(ArrayList<TrackPoint> trackPointList) {
		if (trackPointList.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	// are there only 2 trackpoints?
	static private boolean onlyTwoTrackPoints(
			ArrayList<TrackPoint> trackPointList) {
		if (trackPointList.size() > 2) {
			return false;
		} else {
			return true;
		}
	}
	
	// are the Points in the same line?
	static public boolean pointsAtTheSameLine(double d) {
		if (d == 0) {
			return true;
		} else {
			return false;
		}
	}	

	static public ArrayList<TrackPoint> reduceByDistance(
			ArrayList<TrackPoint> trackPointList, Double distance) {
            
                //KM to Meters
		distance = distance * 1000;
                
		//Objects
		TrackPoint previous = null;
		TrackPoint next = null;
		ArrayList<TrackPoint> newTrackPointList = new ArrayList<TrackPoint>();
		double d = 0;
		int i = 0;
		int trackPointListSize = trackPointList.size();

		//is the list is empty?
		if (emptyList(trackPointList)) {
			System.exit(0);
		}

		//there's only two Points?
		if (onlyTwoTrackPoints(trackPointList)) {
                    System.exit(0);
		}

		//Removing TrackPoints in the same place
		trackPointList = removeTrackPointsAtTheSamePlace(trackPointList);

		//Creating Loop for TrackPoint List
		for (TrackPoint trackPoint : trackPointList) {

			//For the calc, the TrackPoint can't be the first or the last on the list
			if ((i != 0) && (i != trackPointListSize - 1)) {

				//Get the previous and the next TrackPoint
				previous = trackPointList.get(i - 1);
				next = trackPointList.get(i + 1);

				//Calculating the distance from the TrackPoints
				d = MathCalculatorOfDistance.getDistance(trackPoint, previous, next);

				//Verifying if the calculated distance is bigger than the desired one
				if (d > distance) {
					// Adding to the new TrackPoint list
					newTrackPointList.add(trackPoint);
				}
			//If it's the first or the last
			} else {
				newTrackPointList.add(trackPoint);
			}
			i++;
		}
		return newTrackPointList;
	}

	static public ArrayList<TrackPoint> reduceByPercentage(
			ArrayList<TrackPoint> trackPointList, int percentage) {

		//Counter to know how many TrackPoints were already removed
		int trackPointCount = 0;

		//Removing TrackPoints in the same place
		trackPointList = removeTrackPointsAtTheSamePlace(trackPointList);

		//Quantity of TrackPoints from percentage to remove
		int trackPointsToRemove = ((trackPointList.size() * percentage) / 100);
		System.out.println("TrackPoints to remove: " + trackPointsToRemove);

		//Index of the TrackPoint to remove from the list
		int trackPointToRemove;

		//Loop to last until the percentage is achieved
		while (trackPointsToRemove > trackPointCount) {

			//Get the smallest TrackPoint
			trackPointToRemove = smallestTrackPoint(trackPointList);

			//Remove it from the list
			trackPointList.remove(trackPointToRemove);

			trackPointCount++;
		}

		return trackPointList;

	}

	//Verify the TrackPoint with the smallest distance
	static private int smallestTrackPoint(ArrayList<TrackPoint> trackPointList) {
		
		// Object to identify smallest distance
		double smallestDistance = 1000000;

		// Index to return
		int indexSmallest = 0;

		// Creating objects
		TrackPoint previous = null;
		TrackPoint next = null;
		double d = 0;
		int i = 0;
		int trackPointListSize = trackPointList.size();

		// Verifying if the list is empty
		if (emptyList(trackPointList)) {
			System.out.println("There was an error while reading the file. Please verify it and try again later.");
			System.exit(0);
		}

		// Creating Loop for TrackPoint List
		for (TrackPoint trackPoint : trackPointList) {

			// For the calc, the TrackPoint can't be the first or the last on the list
			if ((i != 0) && (i != trackPointListSize - 1)) {

				// Get the previous and the next TrackPoint
				previous = trackPointList.get(i - 1);
				next = trackPointList.get(i + 1);

				// Calculating the distance from the TrackPoints
				d = MathCalculatorOfDistance.getDistance(trackPoint, previous, next);

				// Verifying if the calculated distance is bigger than the desired one
				// or if the point is at the line
				if ((d < smallestDistance) || (pointsAtTheSameLine(d))) {
					indexSmallest = i;
					smallestDistance = d;
				}
			}
			i++;
		}
		return indexSmallest;
	}

	// Remove Trackpoints in the same place
	static private ArrayList<TrackPoint> removeTrackPointsAtTheSamePlace(
			ArrayList<TrackPoint> trackPointList) {
		// Creating objects
		TrackPoint previous = null;
		TrackPoint next = null;
		int i = 0;
		int trackPointListSize = trackPointList.size();

		// Verifying if the list is empty
		if (emptyList(trackPointList)) {
			System.out.println("There was an error while reading the file. Please verify it and try again later.");
			System.exit(0);
		}

		// Creating Loop for TrackPoint List
		for (TrackPoint trackPoint : trackPointList) {

			// For the calc, the TrackPoint can't be the first or the last on
			// the list
			if ((i != 0) && (i != trackPointListSize - 1)) {

				// Get the previous and the next TrackPoint
				previous = trackPointList.get(i - 1);
				next = trackPointList.get(i + 1);

				// Verify if the current TrackPoint is at the same place as
				// the previous or the next one
				if (pointsAtTheSamePlace(trackPoint, previous)
						|| pointsAtTheSamePlace(trackPoint, previous)) {
					trackPointList.remove(trackPoint);
				}
			}
			i++;
		}
		return trackPointList;
	}

	
}
