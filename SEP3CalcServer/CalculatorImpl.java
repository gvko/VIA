import CalculatorIDL.CalculateThisShitPOA;


public class CalculatorImpl extends CalculateThisShitPOA
{
   private ExpressionParser parser = new ExpressionParser();

   @Override
   public double calculate(String input)
   {
      double result;
      result = parser.calculateString(input);
      return result;
   }

}
