package MainServer.Model.JokesIDL;

/**
* jokes/JokesHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from jokes.idl
* Wednesday, November 28, 2012 11:54:27 AM CET
*/

public final class JokesHolder implements org.omg.CORBA.portable.Streamable
{
  public MainServer.Model.JokesIDL.Jokes value = null;

  public JokesHolder ()
  {
  }

  public JokesHolder (MainServer.Model.JokesIDL.Jokes initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = MainServer.Model.JokesIDL.JokesHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    MainServer.Model.JokesIDL.JokesHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return MainServer.Model.JokesIDL.JokesHelper.type ();
  }

}