
import java.sql.*;
import java.util.*;


public class Latihanuts
{
	private Connection conn;
	
	public boolean isConnected()
	{
		return (conn != null);
	}
	
	public Latihanuts() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryDB",
				"root","root");
	}
	
	public Vector<Vector<Object>> selectBook() throws SQLException
	{
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
		
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next())
		{
			Vector<Object> v = new Vector<Object>();
			v.add(rs.getString("kode_buku"));
			v.add(rs.getString("judul_buku"));
			v.add(rs.getString("penulis_buku"));
			v.add(rs.getString("penerbit_buku"));
			v.add(rs.getString("nomor_rak"));
			
			data.add(v);
		}		
		return data;
	}
}
