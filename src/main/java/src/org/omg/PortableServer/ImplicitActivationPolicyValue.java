package org.omg.PortableServer;


/**
* org/omg/PortableServer/ImplicitActivationPolicyValue.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/jenkins/workspace/8-2-build-windows-amd64-cygwin/jdk8u301/1513/corba/src/share/classes/org/omg/PortableServer/poa.idl
* Wednesday, June 9, 2021 6:48:04 AM PDT
*/


/**
	 * ImplicitActivationPolicyValue has the following
	 * semantics.
	 * IMPLICIT_ACTIVATION to indicate implicit activation
	 * of servants.  This requires SYSTEM_ID and RETAIN 
	 * policies to be set.
	 * NO_IMPLICIT_ACTIVATION to indicate no implicit 
	 * servant activation.
	 */
public class ImplicitActivationPolicyValue implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 2;
  private static org.omg.PortableServer.ImplicitActivationPolicyValue[] __array = new org.omg.PortableServer.ImplicitActivationPolicyValue [__size];

  public static final int _IMPLICIT_ACTIVATION = 0;
  public static final org.omg.PortableServer.ImplicitActivationPolicyValue IMPLICIT_ACTIVATION = new org.omg.PortableServer.ImplicitActivationPolicyValue(_IMPLICIT_ACTIVATION);
  public static final int _NO_IMPLICIT_ACTIVATION = 1;
  public static final org.omg.PortableServer.ImplicitActivationPolicyValue NO_IMPLICIT_ACTIVATION = new org.omg.PortableServer.ImplicitActivationPolicyValue(_NO_IMPLICIT_ACTIVATION);

  public int value ()
  {
    return __value;
  }

  public static org.omg.PortableServer.ImplicitActivationPolicyValue from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected ImplicitActivationPolicyValue (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class ImplicitActivationPolicyValue
