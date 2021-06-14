import java.sql.*;


public class AccesoDatosBD 
{
	
	 Connection con = null;
     Statement st = null;
     ResultSet rs = null;
	 
     String url = "jdbc:mysql://localhost:3306/DDOS";
     String user = "root";
     String password = "test";
     
     public void ejecutarConsulta(String query) throws SQLException
     {
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
     
     public ResultSet consultarDatos(String query) throws SQLException
     {
    	 con = DriverManager.getConnection(url, user, password);
    	 st = con.createStatement();
    	 rs = st.executeQuery(query);
    	 ResultSet resultado = rs;
    	 if (rs != null) {
             rs.close();
         }
         if (st != null) {
             st.close();
         }
         if (con != null) {
             con.close();
         }
    	 return resultado;
     }
}
    	 