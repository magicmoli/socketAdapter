package com.sample.adapter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.logging.Logger;


/**

 * RAConnectionImpl

 *

 * @version $Revision: $

 */

public class RAConnectionImpl implements RAConnection

{

   /** The logger */

   private static Logger log = Logger.getLogger("RAConnectionImpl");


   /** ManagedConnection */

   private RAManagedConnection mc;


   /** ManagedConnectionFactory */

   private RAManagedConnectionFactory mcf;


   
   

   
   Socket  socket = null;
   
 


public Socket getSocket() {
	return socket;
}


public void setSocket(Socket socket) {
	this.socket = socket;
}


public RAConnectionImpl(RAManagedConnection mc,

                                   RAManagedConnectionFactory mcf)

   {

      this.mc = mc;

      this.mcf = mcf;
      
      try {
    	 if (socket==null||socket.isClosed()) {
    		
    		 String host = ((SocketResourceAdapter)mcf.getResourceAdapter()).getHost();
    		 System.out.println("hostname:"+host);
    		 Integer port = ((SocketResourceAdapter)mcf.getResourceAdapter()).getPort();
    		 System.out.println("port:"+port);
    		 socket = new Socket(host, port);
		}

		 
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
      
    

   }


    

   public String write()

   {

	   
      return write(((SocketResourceAdapter)mcf.getResourceAdapter()).getName());

   }


 

   public String write(String name)

   {

      return mc.write(name);

   }



   public String listFiles(String dir) {
   	// TODO Auto-generated method stub
	   return mc.listFiles(dir); 
   }

   /**

    * Close

    */

   public void close()

   {

      mc.closeHandle(this);
      try {
		this.socket.close();
		System.out.println("client socket closed");
		log.info("Socket closed!");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

   }



}
