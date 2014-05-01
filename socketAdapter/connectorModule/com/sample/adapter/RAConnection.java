package com.sample.adapter;

public interface RAConnection

{

   /**

    * write

    * @return String

    */

   public String write();


   /**

    * write

    * @param name A name

    * @return String

    */

   public String write(String name);

   
   /**  
   * Call the EIS ListFiles and get response 
   */  
   public String listFiles(String dir);

   /**

    * Close

    */

   public void close();

}

