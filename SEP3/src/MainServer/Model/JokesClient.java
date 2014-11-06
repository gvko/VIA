package MainServer.Model;
import java.io.*;
import java.util.Properties;

import org.omg.CORBA.*;

import MainServer.Model.JokesIDL.Jokes;
import MainServer.Model.JokesIDL.JokesHelper;


/**
 *
 * @author jbo
 */

public class JokesClient {
	
	private static Properties props;
    
    public static String getJoke()
    {
    	props = new Properties();
        props.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
        props.put("org.omg.CORBA.ORBInitialPort", "2809");
        
    	String[] args = new String[0];
    	String joke = "";
    	 try {
    	        ORB orb = ORB.init(args, props);
    	        
    	        File f = new File ("NS_Ref");
    	        BufferedReader br = new BufferedReader(new FileReader(f));
    	    
    	        org.omg.CORBA.Object obj = orb.string_to_object(br.readLine());
    	        
    	        br.close();
    	    
    	        Jokes jokes = JokesHelper.narrow(obj);
    	        
    	        joke += jokes.send_joke();
    	        
    	    }
    	    
    	    catch (Exception ex)
    	                {
    	                    System.out.println(ex);
    	                }
    	 return joke;
    	    }
}
