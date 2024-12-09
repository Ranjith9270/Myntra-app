package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCode {
	String url="jdbc:mysql://localhost:3306/myntraapp";
	String user="root";
	String pass="accord";

	private Connection con;
	
	public DBCode() throws SQLException {
		con=DriverManager.getConnection(url,user,pass);
	}
	
	public int insert(String name,String expiry,float price) throws SQLException{
		String q="insert into product(name,expiry,price) values(?,?,?)";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1, name);
		pst.setString(2, expiry);
		pst.setFloat(3, price);
		int r=pst.executeUpdate();
		return r;
	}
	
	public void view() throws SQLException{
		String q="select *from product";
		PreparedStatement pst=con.prepareStatement(q);
		ResultSet rs=pst.executeQuery();
		int k=0;
		while(rs.next()){
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String expiry=rs.getString("expiry");
			float price=rs.getInt("price");
			System.out.println("Data "+id);
			System.out.println(name+"-"+expiry+"  Rs."+price+"\n");
			k++;
		}	
		
		System.out.println((k==0)?"No Records":"No of Records : "+k);
	}
	
	public void view(int id) throws SQLException{
		String q="select *from product where id=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		int k=0;
		while(rs.next()) {
			String name=rs.getString("name");
			String expiry=rs.getString("expiry");
			float price=rs.getInt("price");
			System.out.println(name+"-"+expiry+"  Rs."+price+"\n");
			k++;
		}		
		System.out.println((k==0)?"No Records":"No of Records : "+k);
	}
	public int edit(int id,float price) throws SQLException{
		String q="update product set price=? where id=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setInt(2, id);	
		pst.setFloat(1, price);
		int r=pst.executeUpdate();
		return r;
	}

	public int delete(int id) throws SQLException{
		String q="delete from product where id=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setInt(1, id);		
		int r=pst.executeUpdate();
		return r;
	}
}










