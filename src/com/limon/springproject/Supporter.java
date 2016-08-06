
package com.limon.springproject;

import java.sql.*;
public class Supporter
{
    public static Connection getConnection()//connection with database using singleton design pattern.
    {
        try{
          Class.forName("com.mysql.jdbc.Driver");//mysql
          
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/springtest","root","12345");
            return con;
            
        }
        catch(Exception e)
        {
            System.out.println("Connection Error.");
            return null;
            
        }
    }
    
}
