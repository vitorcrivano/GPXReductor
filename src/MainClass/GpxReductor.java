package MainClass;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import Routine.Reductor;
import Routine.VerifyParametres;

public class GpxReductor {
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException  {
		
		String[] arguments = {args[0], args[1], args[2]};
		
		VerifyParametres.verify(arguments);
		
		Reductor.removePoints(arguments);

		
	}
}
