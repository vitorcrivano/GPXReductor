
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XMLTreatment;

/**
 *
 * @author Gian
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Model.Track;
import Model.TrackPoint;
import Model.TrackSegment;

public class XMLReader {
	
	//Read a xml and treat it like elements
	public static ArrayList<Track> ReadXML(String file) throws IOException, ParserConfigurationException, SAXException {
		
			File XMLFile = new File(file);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(XMLFile);
	
			doc.getDocumentElement().normalize();
			
			ArrayList<Track> trackList = new ArrayList<Track>();
			
			NodeList nodeListTrak = doc.getElementsByTagName("trk");
			int trackListSize = nodeListTrak.getLength();
			
			//For each of the list to read its elements
			for(int i = 0; i < trackListSize; i++) { 
				//get the Track name
				Node nodeTrk = nodeListTrak.item(i);
				Element elementTrk = (Element) nodeTrk;
				String trkName = elementTrk.getElementsByTagName("name").item(i).getTextContent();
				System.out.println("NAME: " +trkName);
				
				//get TrackSegment List
				NodeList nodeListTrkseg = doc.getElementsByTagName("trkseg");
				int trackSegmentListSize = nodeListTrkseg.getLength();
				ArrayList<TrackSegment> TrackSegmentList = new ArrayList<TrackSegment>();

				//Second in the hierarchy comes the "trkseg" node 
				for(int j = 0; j < trackSegmentListSize; j++){ 
					Element trackSeg = (Element) nodeListTrkseg.item(j);
					
					//Getting TrackPoints
					NodeList nodeListTrkpt = trackSeg.getElementsByTagName("trkpt");
					int trackPointListSize = nodeListTrkpt.getLength();
					ArrayList<TrackPoint> TrackPointlist = new ArrayList<TrackPoint>();
					
					for(int k = 0; k < trackPointListSize; k++) { 
						Node nNode = nodeListTrkpt.item(k);
						
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							Element eElement = (Element) nNode;
							
							String latitude = eElement.getAttribute("lat");
							String longitude = eElement.getAttribute("lon");
							String ele = eElement.getElementsByTagName("ele").item(i).getTextContent();
							String time	= eElement.getElementsByTagName("time").item(i).getTextContent();	
							
														TrackPoint trackpoint = new TrackPoint(Float.valueOf(latitude),Float.valueOf(longitude),Float.valueOf(ele),time);	
							TrackPointlist.add(trackpoint);
						}
					}
					TrackSegment trackSegment = new TrackSegment(TrackPointlist);
					TrackSegmentList.add(trackSegment);
				}
				
					Track track = new Track(trkName,TrackSegmentList);
				trackList.add(track);
			}
			return trackList;
			
	}	
	
=======
package XMLTreatment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Model.Track;
import Model.TrackPoint;
import Model.TrackSegment;

public class XMLReader {
	
	//Read a xml and treat it like elements
	public static ArrayList<Track> ReadXML(String file) throws IOException, ParserConfigurationException, SAXException {
		
			File XMLFile = new File(file);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(XMLFile);
	
			doc.getDocumentElement().normalize();
			
			ArrayList<Track> trackList = new ArrayList<Track>();
			
			NodeList nodeListTrak = doc.getElementsByTagName("trk");
			int trackListSize = nodeListTrak.getLength();
			
			//For each of the list to read its elements
			for(int i = 0; i < trackListSize; i++) { 
				//get the Track name
				Node nodeTrk = nodeListTrak.item(i);
				Element elementTrk = (Element) nodeTrk;
				String trkName = elementTrk.getElementsByTagName("name").item(i).getTextContent();
				System.out.println("NAME: " +trkName);
				
				//get TrackSegment List
				NodeList nodeListTrkseg = doc.getElementsByTagName("trkseg");
				int trackSegmentListSize = nodeListTrkseg.getLength();
				ArrayList<TrackSegment> TrackSegmentList = new ArrayList<TrackSegment>();

				//Second in the hierarchy comes the "trkseg" node 
				for(int j = 0; j < trackSegmentListSize; j++){ 
					Element trackSeg = (Element) nodeListTrkseg.item(j);
					
					//Getting TrackPoints
					NodeList nodeListTrkpt = trackSeg.getElementsByTagName("trkpt");
					int trackPointListSize = nodeListTrkpt.getLength();
					ArrayList<TrackPoint> TrackPointlist = new ArrayList<TrackPoint>();
					
					for(int k = 0; k < trackPointListSize; k++) { 
						Node nNode = nodeListTrkpt.item(k);
						
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							Element eElement = (Element) nNode;
							
							String latitude = eElement.getAttribute("lat");
							String longitude = eElement.getAttribute("lon");
							String ele = eElement.getElementsByTagName("ele").item(i).getTextContent();
							String time	= eElement.getElementsByTagName("time").item(i).getTextContent();	
							
														TrackPoint trackpoint = new TrackPoint(Float.valueOf(latitude),Float.valueOf(longitude),Float.valueOf(ele),time);	
							TrackPointlist.add(trackpoint);
						}
					}
					TrackSegment trackSegment = new TrackSegment(TrackPointlist);
					TrackSegmentList.add(trackSegment);
				}
				
					Track track = new Track(trkName,TrackSegmentList);
				trackList.add(track);
			}
			return trackList;
			
	}	
	
>>>>>>> origin/master
}