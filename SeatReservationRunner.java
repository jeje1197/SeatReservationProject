package com.cognixia.jump.seatreservationproject;

public class SeatReservationRunner {

	public static void main(String[] args) {
		Auditorium auditorium = new Auditorium("Endgame", 5, 5);
		
		System.out.println("Welcome to our Seat Reservation System!");
		auditorium.run();
	}

}
