package CalculatorIDL;

/**
* CalculatorIDL/CalculateThisShitHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from calculator.idl
* Wednesday, November 28, 2012 2:18:40 PM CET
*/

public final class CalculateThisShitHolder implements org.omg.CORBA.portable.Streamable
{
  public CalculatorIDL.CalculateThisShit value = null;

  public CalculateThisShitHolder ()
  {
  }

  public CalculateThisShitHolder (CalculatorIDL.CalculateThisShit initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CalculatorIDL.CalculateThisShitHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CalculatorIDL.CalculateThisShitHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CalculatorIDL.CalculateThisShitHelper.type ();
  }

}
