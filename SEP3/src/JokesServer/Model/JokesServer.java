package JokesServer.Model;
import java.io.*;
import java.util.Properties;

import org.omg.CORBA.*;
import org.omg.PortableServer.*;


/**
 *
 * @author jbo
 */
public class JokesServer {
	private static Properties props;
    
    public static void main(String[] args)
    {
    	props = new Properties();
        props.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
        props.put("org.omg.CORBA.ORBInitialPort", "2809");
        
        try 
        {
            ORB orb = ORB.init(args, props);
            
            POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            poa.the_POAManager().activate();
            
            JokesImpl jokesImpl = new JokesImpl();
            org.omg.CORBA.Object obj = poa.servant_to_reference(jokesImpl);
            
            PrintWriter pw = new PrintWriter(new FileWriter("NS_Ref"));
            
            pw.println(orb.object_to_string(obj));
            pw.flush();
            pw.close();
            
            System.out.println("Jokes Server Started.");
            
            orb.run();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
