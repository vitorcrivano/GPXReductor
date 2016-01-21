package MainClass;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Routine.Reductor;
import Routine.VerifyParametres;

public class GpxReductor {
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException  {
		
		String[] argsal = {"0.1", "../GPXReductor/src/Files/foxboro.gpx", "../GPXReductor/src/Files/NewFilefoxboro.gpx"};
		
		VerifyParametres.verify(argsal);
		
		Reductor.removePoints(argsal);

		
	}
}
