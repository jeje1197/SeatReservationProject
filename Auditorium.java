package com.cognixia.jump.seatreservationproject;

public class Auditorium implements Reservable{
	String[][] seats;
	
	public Auditorium(int rows, int columns) {
		seats = new String[rows][columns];
		
		for (int row = 0; row < seats.length; row++) {
			for (int col = 0; col < seats[row].length; col++) {
				seats[row][col] = "o";
			}
		}
	}

	@Override
	public void addReservation(int row, int column) {
		if (!seatIsAvailable(row, column)) {
			System.out.println("The seat at row: " + row + " column: " + 
					column + " is not available");
		}
		
		seats[row][column] = "x";
	}
	
	@Override
	public void deleteReservation(int row, int column) {
		seats[row][column] = "o";
	}
	
	@Override
	public void isValidSeat(int row, int column) throws Exception {
		if (row < 0 || row >= seats.length || column < 0 || column >= seats[row].length) {
			throw new Exception("Invalid row column pairing. Row: " + row + " Column: " + column);
		}
	}

	@Override
	public boolean seatIsAvailable(int row, int column) {
		return seats[row][column].equals("o");
	}

	
	@Override
	public void showSeats() {
		StringBuilder sb = new StringBuilder();
		sb.append("-----------------\n");
		sb.append("       SEATS     \n");
		sb.append("-----------------\n");
		
		sb.append("  ");
		for (int col = 0; col < seats[0].length; col++) {
			sb.append(col + " ");
		}
		sb.append("\n\n");
		
		sb.append("  ");
		for (int col = 0; col < seats[0].length; col++) {
			sb.append('_');
		}
		
		for (int row = 0; row < seats.length; row++) {
			sb.append((row + 1) + " | ");
			for (int col = 0; col < seats[row].length; col++) {
				sb.append(seats[row][col] +' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}

	

	
	
	
}
