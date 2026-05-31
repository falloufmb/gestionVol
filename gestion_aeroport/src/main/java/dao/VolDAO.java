package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Vol;
import util.ConnectDB;
 

public class VolDAO implements Common<Vol>{

	@Override
	public List<Vol> selectAll() {
		List<Vol> vol=new ArrayList<>();
		Connection conn=null;
		ResultSet rs= null;
		Statement stmt=null;
		
		try {
			conn= ConnectDB.getConnection();
			String sql="select * from vol";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Vol v= new Vol();
				
				v.setIdVol(rs.getInt("idVol"));
				v.setIdCompagnie(rs.getInt("idCompagnie"));
				v.setNumVol(rs.getInt("numVol"));
				v.setDestination(rs.getString("destination"));
				v.setDateVol(rs.getDate("dateVol"));
				v.setHeureArrive(rs.getDate("heureArrive"));
				v.setHeureDepart(rs.getDate("heureDepart"));
				v.setStatut(rs.getString("statut"));
				
				vol.add(v);
			}
		}catch(SQLException e) {e.printStackTrace();}
		finally {
			//6.fermer les ressources
			try {
				if(rs !=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(SQLException e) {e.printStackTrace();}
		}
		return vol;
	}

	@Override
	public void add(Vol vol) {
		try {
			Connection conn= ConnectDB.getConnection();
			String sql="Insert into vol(idVol,idCompagnie,numVol,heureDepart,HeureArrive,statut,dateVol,destination)values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,vol.getIdVol());
			ps.setInt(2, vol.getIdCompagnie());
			ps.setInt(3, vol.getNumVol());
			ps.setString(4,vol.getDestination());
			ps.setString(5, vol.getStatut());
			ps.setDate(6, vol.getDateVol());
			ps.setDate(7, vol.getHeureArrive());
			ps.setDate(8,vol.getHeureDepart());
			
			ps.executeUpdate();
			
		}catch(Exception e) {e.printStackTrace();}
		
	}

	@Override
	public void delete(int idVol) {
		 try {
		        Connection conn = ConnectDB.getConnection();

		        String sql = "DELETE FROM etudiant WHERE idVol = ?";

		        PreparedStatement ps = conn.prepareStatement(sql);
		        ps.setInt(1, idVol);

		        ps.executeUpdate();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		
	}

	@Override
	public void update(Vol vol) {
		try {
			Connection conn= ConnectDB.getConnection();
			String sql="Insert into vol(idVol,idCompagnie,numVol,heureDepart,HeureArrive,statut,dateVol,destination)values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,vol.getIdVol());
			ps.setInt(2, vol.getIdCompagnie());
			ps.setInt(3, vol.getNumVol());
			ps.setString(4,vol.getDestination());
			ps.setString(5, vol.getStatut());
			ps.setDate(6, vol.getDateVol());
			ps.setDate(7, vol.getHeureArrive());
			ps.setDate(8,vol.getHeureDepart());
			
			ps.executeUpdate();
			
		}catch(Exception e) {e.printStackTrace();}
		
	}

	@Override
	public Vol getById(int idVol) {
		Vol v=null;
		try {
			Connection conn= ConnectDB.getConnection();
			String sql="SELECT * FROM vol WHERE idVol = ?";
			PreparedStatement ps=conn.prepareStatement(sql);
			 ps.setInt(1, idVol);

		        ResultSet rs = ps.executeQuery();
		        while(rs.next()) {
				    v = new Vol();
					v.setIdVol(rs.getInt("idVol"));
					v.setIdCompagnie(rs.getInt("idCompagnie"));
					v.setNumVol(rs.getInt("numVol"));
					v.setDestination(rs.getString("destination"));
					v.setDateVol(rs.getDate("dateVol"));
					v.setHeureArrive(rs.getDate("heureArrive"));
					v.setHeureDepart(rs.getDate("heureDepart"));
					v.setStatut(rs.getString("statut"));	
					
				}
		}catch(Exception e) {e.printStackTrace();}
		return v;
	}

	@Override
	public int getIDMax() {
		int max = 0;

	    try {
	        Connection conn = ConnectDB.getConnection();

	        String sql = "SELECT MAX(idVol) AS max_id FROM vol";

	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        if (rs.next()) {
	            max = rs.getInt("max_id");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return (max == 0) ? 1 : max + 1;
	}
	
	 public List<Vol> selectByCompagnie(int idCompagnie){
		 List<Vol> liste=new ArrayList<>();
		 try {
		 Connection conn = ConnectDB.getConnection();
         
         String req = "SELECT * FROM vol WHERE idCompagnie = ?";

         PreparedStatement ps = conn.prepareStatement(req);

         ps.setInt(1, idCompagnie);

         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
        	 Vol v1 = new Vol();
        		v1.setIdVol(rs.getInt("idVol"));
				v1.setIdCompagnie(rs.getInt("idCompagnie"));
				v1.setNumVol(rs.getInt("numVol"));
				v1.setDestination(rs.getString("destination"));
				v1.setDateVol(rs.getDate("dateVol"));
				v1.setHeureArrive(rs.getDate("heureArrive"));
				v1.setHeureDepart(rs.getDate("heureDepart"));
				v1.setStatut(rs.getString("statut"));
				
				liste.add(v1);
         }
	 }catch (Exception e) {
	        e.printStackTrace();
	    }
		 return liste;
		 }
	 public boolean reserverVol(int idVol){

		    boolean status = false;

		    try{

		        Connection conn = ConnectDB.getConnection();

		        String query =
		        "UPDATE livre SET reserve = true WHERE id=?";

		        PreparedStatement ps =
		                conn.prepareStatement(query);

		        ps.setInt(1, idVol);

		        int rows = ps.executeUpdate();

		        if(rows > 0){
		            status = true;
		        }

		    }catch(Exception e){
		        e.printStackTrace();
		    }

		    return status;
		}


}


