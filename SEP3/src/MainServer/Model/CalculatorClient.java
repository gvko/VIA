package MainServer.Model;
import java.util.Properties;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import MainServer.Model.CalculatorIDL.CalculateThisShit;
import MainServer.Model.CalculatorIDL.CalculateThisShitHelper;

public class CalculatorClient
{
   private static ORB orb;
   private static CalculateThisShit calculator;
   private static Properties props;

   public static double calculate(String input_)
   {
	  double result = 0;
	   try{
	   props = new Properties();
       props.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
       props.put("org.omg.CORBA.ORBInitialPort", "1050");
      String[] arr = new String[0];
      // create and initialize the ORB
      orb = ORB.init(arr, props);
      
      //get the root naming context
      org.omg.CORBA.Object NameService = orb
            .resolve_initial_references("NamingService");
      NamingContextExt NCE = NamingContextExtHelper.narrow(NameService);
      
      // resolve the Object Reference in Naming
      calculator = CalculateThisShitHelper.narrow(NCE
            .resolve_str("BindCalculator"));
     
      result = calculator.calculate(input_);
      System.out.println(input_ + " = " + result);
	   }
	   catch(Exception e){e.printStackTrace();}
      return result;
   }
}
