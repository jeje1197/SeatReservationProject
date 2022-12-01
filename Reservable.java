package com.cognixia.jump.seatreservationproject;

public interface Reservable {
	
	public void addReservation(int row, int column);
	
	public void deleteReservation(int row, int column);
	
	public void isValidSeat(int row, int column) throws Exception;
	
	public boolean seatIsAvailable(int row, int column);
	
	public void showSeats();
}
