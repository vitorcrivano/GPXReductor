package Routine;

public class VerifyParametres {

	static public void verify(String[] args) {
		
            	//is GPX file?
		if(!GPXFiles(args[1], args[2])) {
                    System.exit(0);
		}

		//three parameters?
		if(!threeParametres(args)) {
			System.exit(0);
		}
		
		
		//is file is not null?
		if(!filesNotEmpty(args[1], args[2])) {						
                    System.exit(0);
		}
	}

	//three parameters?
	static private boolean threeParametres(String[] args) {
		if(args.length == 3) {
			return true;
		} else {
			return false;
		}
	}
	
	//are both gpx files?
	static public boolean GPXFiles(String arg2, String arg3) {
		if(arg2.endsWith(".gpx") && arg3.endsWith(".gpx")) {
			return true;
		} else {
			return false;
		}
	}
	
	//are both files empty?
	static public boolean filesNotEmpty(String arg2, String arg3) {
		if(arg2.equals(".gpx") && arg3.equals(".gpx")) {
			return false;
		} else {
			return true;
		}
	}

}
