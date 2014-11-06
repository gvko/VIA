public class ExpressionParser
{
   static
   {
      System.loadLibrary("CalcFuncLib");
   }

   public boolean isAction(char in)
   {
      boolean contains = false;

      return (in == '+' || in == '-' || in == '*' || in == '/');
   }

   /**
    * Parses a string and extracts the variables from the expression
    * 
    * @param in
    *           - String to be parsed
    * @return the array containing the variables
    */
   public double[] parseNumbers(String in)
   {

      double out[] = new double[in.length()];

      String[] splitUpExpr = in.split("[\\D]"); // splits the string when it
      // encounters a NON-DIGIT
      // character

      for (int i = 0; i < splitUpExpr.length; i++)
      {
         out[i] = Double.parseDouble(splitUpExpr[i]);
      }

      return out;
   }

   /**
    * Gets all the actions containied in the expression
    * 
    * @param in
    *           String to be parsed
    * @return an array containing the actions between the operands (+,-,/,* ...
    *         etc.);
    */
   public char[] getActions(String in)
   {
      int count = 0;
      char[] actions = new char[in.length()];
      for (int i = 0; i < in.length(); i++)
      {
         if (isAction(in.charAt(i)))
         {
            actions[count] = in.charAt(i);
            count++;
         }
      }
      return actions;
   }

   public double calculateString(String in)
   {

      char[] actions = getActions(in);
      double[] params = parseNumbers(in);
      double result = params[0];

      for (int i = 0; i < actions.length; i++)
      {
         char act = actions[i];
         if (isAction(act))
         {
            switch (act)
            {
               case '+':
                  result = CalcFunc.sum(result, params[i + 1]);
                  break;
               case '-':
                  result = CalcFunc.subtract(result, params[i + 1]);
                  break;
               case '/':
                  if (params[i + 1] != 0)
                     result = CalcFunc.divide(result, params[i + 1]);
                  break;
               case '*':
                  result = CalcFunc.multiply(result, params[i + 1]);
                  break;
            }

         }
      }
      return result;
   }

   /*public static void main(String[] args)
   {

      ExpressionParser parser = new ExpressionParser();
      String expression = "10-2+4";

      // parser.parseNumbers(expression);
      System.out.println(expression + " = "
            + parser.calculateString(expression));

      double a = 5;
      double b = 2;

      System.out.println(CalcFunc.subtract(a, b));
      System.out.println(CalcFunc.sum(a, b));
      System.out.println(CalcFunc.divide(a, b));
      System.out.println(CalcFunc.multiply(a, b));
   }*/
}
