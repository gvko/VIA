import java.util.Properties;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import CalculatorIDL.CalculateThisShit;
import CalculatorIDL.CalculateThisShitHelper;


public class CalculatorServer
{
   private static ORB orb;
   private static POA poa;
   private static Properties props;
   
   public static void main(String[] args) throws Exception
   {
	   props = new Properties();
       props.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
       props.put("org.omg.CORBA.ORBInitialPort", "1050");
      // create and initialize the ORB
      orb = ORB.init(args, props);
      
      // get reference to rootPOA & activate the POAManager
      poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      poa.the_POAManager().activate();
      
      /**
       * Create servant and register it with the ORB
       * (Initialization of the IDL interface implementation)
       */
      CalculatorImpl calculator = new CalculatorImpl();
      
      // get object reference from the servant
      org.omg.CORBA.Object reference = poa.servant_to_reference(calculator);
      CalculateThisShit calc = CalculateThisShitHelper.narrow(reference);
      
      /**
       * get the root naming context
       * (Initializing the Naming Service)
       */
      // NameService invokes the name service
      org.omg.CORBA.Object NameService = orb.resolve_initial_references("NameService");
      NamingContextExt NCE = NamingContextExtHelper.narrow(NameService);
      
      //Bind the object Reference in Naming
      NameComponent calcName[] = NCE.to_name("BindCalculator");
      NCE.rebind(calcName, calc);
      
      // run the process
      System.out.println("The server runs smoothly!");
      orb.run();
   }
}
