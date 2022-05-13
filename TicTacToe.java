package main;

import java.util.*;

public class TicTacToe {

	static String[] board;
	static String werIstAmZug;

	public static void ausgabeSpielBrett() {
		System.out.println();
		System.out.println(board[6] + "|" + board[7] + "|" + board[8]);
		System.out.println("-+-+-");
		System.out.println(board[3] + "|" + board[4] + "|" + board[5]);
		System.out.println("-+-+-");
		System.out.println(board[0] + "|" + board[1] + "|" + board[2]);
		System.out.println();
	}

	static String winnerCheck() {
		for (int a = 0; a < 8; a++) {
			String line = null;

			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			}

			else if (line.equals("OOO")) {
				return "O";
			}
		}

		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
				break;
			} else if (a == 8) {
				return "unentschieden";
			}
		}
		System.out.println(werIstAmZug + " ist an der Reihe!");
		return null;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		board = new String[9];
		werIstAmZug = "X";
		String winner = null;

		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a + 1);
		}
		ausgabeSpielBrett();

		System.out.println("X fängt an!");
		
		// gamegoing schleife?
		while (winner == null) {
			int numInput;
			
			if (werIstAmZug == "O") {
				
				
		        int max = 9;
		        int min = 1;
		        int range = max - min + 1;
		        int random = (int)(Math.random() * range) + min; 
		        System.out.println("KI wählt: " + random);
		        numInput = random;

			        if (board[numInput - 1].equals(String.valueOf(numInput))) {
						board[numInput - 1] = werIstAmZug;
					
						if (werIstAmZug.equals("X")) {
							werIstAmZug = "O";
						} else {
							werIstAmZug = "X";
						}
						winner = winnerCheck();
						ausgabeSpielBrett();
					}
		        
			} else {
				try {
					numInput = sc.nextInt();
					if (!(numInput > 0 && numInput <= 9)) {
						System.out.println("Gib eine Zahl zwischen 1-9 ein!");
						continue;
					}
				} catch (InputMismatchException e) {
					System.out.println("Gib eine Zahl zwischen 1-9 ein!");
					continue;
				}
				if (board[numInput - 1].equals(String.valueOf(numInput))) {
					board[numInput - 1] = werIstAmZug;
				
					if (werIstAmZug.equals("X")) {
						werIstAmZug = "O";
					} else {
						werIstAmZug = "X";
					}
					winner = winnerCheck();
					ausgabeSpielBrett();
				} else {
					System.out.println("Belegt!");
				}
			}
			
			
		}
		if (winner.equalsIgnoreCase("unentschieden")) {
			System.out.println("Unentschieden!");
			sc.close();
		} else {
			System.out.println(winner + " gewinnt!");
			sc.close();
		}
	}
}
