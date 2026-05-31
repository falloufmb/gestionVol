package model;

import java.sql.Date;

public class Reservation {
	int idReservation;
	Date dateReservation;
	String siege;
	
	//constructeur
	
	public Reservation() {}
	
	//getters et setters

	public int getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public String getSiege() {
		return siege;
	}

	public void setSiege(String siege) {
		this.siege = siege;
	}
	
	

}
