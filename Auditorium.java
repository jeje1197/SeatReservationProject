package com.cognixia.jump.seatreservationproject;

import java.util.Scanner;

public class Auditorium implements Reservable{
	String name;
	String[][] seats;
	
	public Auditorium(String name, int rows, int columns) {
		this.name = name;
		seats = new String[rows][columns];
		
		for (int row = 0; row < seats.length; row++) {
			for (int col = 0; col < seats[row].length; col++) {
				seats[row][col] = "o";
			}
		}
	}
	
	public void run() {
		System.out.println("--- Viewing auditorium " + name + "---\n");
		Scanner sc = new Scanner(System.in);
		
		boolean systemInUse = true;
		while (systemInUse) {
			showSeats();
			System.out.println("What would you like to do (Type the number of your choice):");
			System.out.println("1) Book a reservation");
			System.out.println("2) Delete a reservation");
			System.out.println("3) Leave");
			
			int selectedOption = sc.nextInt();
			switch (selectedOption) {
				case 1: // Adding a reservation
					try {
						addReservation(promptRow(sc), promptColumn(sc));
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 2: // Deleting a reservation
					try {
						deleteReservation(promptRow(sc), promptColumn(sc));
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 3: // Exit auditorium
					System.out.println("--- Leaving auditorium ---");
					systemInUse = false;
			}
		}
		
		sc.close();
	}
	
	
	
	public int promptRow(Scanner sc) throws Exception {
		System.out.print("Enter a row: ");
		return sc.nextInt() - 1;
	}
	
	public int promptColumn(Scanner sc) throws Exception {
		System.out.print("Enter a column: ");
		return sc.nextInt() - 1;
	}
	
	public String promptName(Scanner sc) throws Exception {
		System.out.print("Enter a name for the reservation: ");
		return sc.nextLine().trim();
	}

	@Override
	public void addReservation(int row, int column) {
		if (!isValidSeat(row, column)) {
			return;
		}
		
		if (!seatIsAvailable(row, column)) {
			System.out.println("The seat at row: " + row + " column: " + 
					column + " is not available.");
			return;
		}
		
		String viewerName = "client";
		try {
			viewerName = promptName(new Scanner(System.in));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		seats[row][column] = "x";
		System.out.println("The seat at row: " + row + " column: " + column + 
				" has been reserved for "+ viewerName +".");
	}
	
	@Override
	public void deleteReservation(int row, int column) {
		if (!isValidSeat(row, column)) {
			return;
		}
		seats[row][column] = "o";
	}
	
	@Override
	public boolean isValidSeat(int row, int column) {
		if (row < 0 || row >= seats.length || column < 0 || column >= seats[row].length) {
			System.out.println("Invalid row column pairing. Row: " + row + " Column: " + column);
			return false;
		}

		return true;
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
		
		sb.append("    ");
		for (int col = 0; col < seats[0].length; col++) {
			sb.append(col + 1 + " ");
		}
		sb.append("\n");
		
		sb.append("   ");
		for (int col = 0; col < seats[0].length * 2; col++) {
			sb.append('_');
		}
		
		sb.append('\n');
		
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
