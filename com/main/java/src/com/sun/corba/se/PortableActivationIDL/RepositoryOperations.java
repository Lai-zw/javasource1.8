package com.sun.corba.se.PortableActivationIDL;


/**
* com/sun/corba/se/PortableActivationIDL/RepositoryOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/jenkins/workspace/8-2-build-windows-amd64-cygwin/jdk8u301/1513/corba/src/share/classes/com/sun/corba/se/PortableActivationIDL/activation.idl
* Wednesday, June 9, 2021 6:48:02 AM PDT
*/

public interface RepositoryOperations 
{

  /** register server definition.
	* This returns the serverId of the server.  A newly created server is
	* always uninstalled.
	*/
  String registerServer (com.sun.corba.se.PortableActivationIDL.RepositoryPackage.ServerDef serverDef) throws com.sun.corba.se.PortableActivationIDL.ServerAlreadyRegistered, com.sun.corba.se.PortableActivationIDL.BadServerDefinition;

  /** unregister server definition
	*/
  void unregisterServer (String serverId) throws com.sun.corba.se.PortableActivationIDL.ServerNotRegistered;

  /** get server definition
	*/
  com.sun.corba.se.PortableActivationIDL.RepositoryPackage.ServerDef getServer (String serverId) throws com.sun.corba.se.PortableActivationIDL.ServerNotRegistered;

  /** Return whether the server has been installed
	*/
  boolean isInstalled (String serverId) throws com.sun.corba.se.PortableActivationIDL.ServerNotRegistered;

  /** Mark the server as being installed.  Raises ServerAlreadyInstalled
	* if the server is currently marked as installed.
	*/
  void install (String serverId) throws com.sun.corba.se.PortableActivationIDL.ServerNotRegistered, com.sun.corba.se.PortableActivationIDL.ServerAlreadyInstalled;

  /** Mark the server as being uninstalled.  Raises ServerAlreadyUninstalled
	* if the server is currently marked as uninstalled.
	*/
  void uninstall (String serverId) throws com.sun.corba.se.PortableActivationIDL.ServerNotRegistered, com.sun.corba.se.PortableActivationIDL.ServerAlreadyUninstalled;

  /** list registered servers
	*/
  String[] listRegisteredServers ();

  /** Returns list of ALL applicationNames defined in ServerDefs of registered 
	* servers.
	*/
  String[] getApplicationNames ();

  /** Find the ServerID associated with the given application name.
	*/
  String getServerID (String applicationName) throws com.sun.corba.se.PortableActivationIDL.ServerNotRegistered;
} // interface RepositoryOperations
