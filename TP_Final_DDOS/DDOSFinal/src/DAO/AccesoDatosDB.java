package DAO;

import java.sql.*;
import java.util.*;

public class AccesoDatosDB
{
     String url = "jdbc:mysql://localhost:3306/DDOS";
     String user = "root";
     String password = "test";
     
     public void ejecutarConsulta(String query)
     {
    	 
    	 Connection con = null;
         Statement st = null;
         ResultSet rs = null;
    	 try
    	 {
    		 Class.forName("com.mysql.jdbc.Driver"); 
	    	 con = DriverManager.getConnection(url, user, password);
	    	 st = con.createStatement();
	    	 st.execute(query);
	    	 if (st != null) {
	             st.close();
	         }
	         if (con != null) {
	             con.close();
	         }
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e.getMessage());
    	 }
     }
     
     /*public ResultSet consultarDatos(String query)
     {
    	 ResultSet resultado = null;
    	 try
    	 {
	    	 con = DriverManager.getConnection(url, user, password);
	    	 st = con.createStatement();
	    	 rs = st.executeQuery(query);
	    	 resultado = rs;
	    	 if (rs != null) {
	             rs.close();
	         }
	         if (st != null) {
	             st.close();
	         }
	         if (con != null) {
	             con.close();
	         }
	     }
    	 catch(Exception e)
    	 {
    		 
    	 }
		return resultado;
     }*/
     
     public ArrayList<String[]> consultarDatos(String query)
     {
    	 Connection con = null;
         Statement st = null;
         ResultSet rs = null;
    	 ArrayList<String[]> lista = new ArrayList<String[]>();
  
    	 try
    	 {
    		 Class.forName("com.mysql.jdbc.Driver"); 
	    	 con = DriverManager.getConnection(url, user, password);
	    	 st = con.createStatement();
	    	 
	    	 rs = st.executeQuery(query);
	    	 
	    	 if (rs != null) {
	    		 
	    		 int columnas = rs.getMetaData().getColumnCount();
		    	 while(rs.next())
		    	 {
		    		 String[] record = new String[columnas];
		    		 for(int i = 0; i < columnas; i++)
		    		 {
		    			 record[i] = rs.getString(i+1);
		    		 }
		    		 lista.add(record);
		    	 }
	             rs.close();
	         }
	         if (st != null) {
	             st.close();
	         }
	         if (con != null) {
	             con.close();
	         }
	     }
    	 catch(Exception e)
    	 {
    		 System.out.println(e.getMessage());
    	 }
		return lista;
     }
}
    	 