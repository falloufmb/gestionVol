package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Compagnie;
import util.ConnectDB;

public class CompagnieDAO implements Common<Compagnie>{

	@Override
	public List<Compagnie> selectAll(){
		List<Compagnie> compagnie=new ArrayList<>();
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			 conn=ConnectDB.getConnection();
			String sql="select *from compagnie";
			 stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				Compagnie com=new Compagnie();
				com.setIdCompagnie(rs.getInt("idCompagnie"));
				com.setNomCompagnie(rs.getString("nomCompagnie"));
				
				compagnie.add(com);
			}
		}catch(SQLException e) {e.printStackTrace();}
		finally {

	        try {

	            if(rs != null)
	                rs.close();

	            if(stmt != null)
	                stmt.close();

	        } catch(SQLException e) {

	            e.printStackTrace();
	        }
	    }
		return compagnie;
	}

	@Override
	public void add(Compagnie obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Compagnie obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compagnie getById(int idCompagnie) {
		Compagnie com=null;
		try {
			Connection conn=ConnectDB.getConnection();
			String sql="Select * from compagnie where idCompagnie=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, idCompagnie);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				com=new Compagnie();
				
				com.setIdCompagnie(rs.getInt("idCompagnie"));
				com.setNomCompagnie(rs.getString("nomCompagnie"));
			}
			
		}catch(Exception e) {e.printStackTrace();}
		return com;
	}

	@Override
	public int getIDMax() {
		// TODO Auto-generated method stub
		return 0;
	}

}
