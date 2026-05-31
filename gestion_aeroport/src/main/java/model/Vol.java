package model;

import java.sql.Date;

public class Vol {
	int idVol, numVol, idCompagnie;
	String destination , statut;
	Date heureDepart ,heureArrive,dateVol ;
	
//constructeur
	public Vol() {}
	
	//getters et setters

	public int getIdVol() {
		return idVol;
	}

	public void setIdVol(int idVol) {
		this.idVol = idVol;
	}

	public int getNumVol() {
		return numVol;
	}

	public void setNumVol(int numVol) {
		this.numVol = numVol;
	}

	public int getIdCompagnie() {
		return idCompagnie;
	}

	public void setIdCompagnie(int idCompagnie) {
		this.idCompagnie = idCompagnie;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Date getHeureArrive() {
		return heureArrive;
	}

	public void setHeureArrive(Date heureArrive) {
		this.heureArrive = heureArrive;
	}

	public Date getDateVol() {
		return dateVol;
	}

	public void setDateVol(Date dateVol) {
		this.dateVol = dateVol;
	}
	
	
}
