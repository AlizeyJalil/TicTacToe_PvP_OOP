package ticTacToe;

import java.util.*;
/*
 * A simple OOP based tictactoe (the x and o game ). :)
 * Easy player vs player implementation. 
 * */

public class Game {
	
	Scanner sc = new Scanner(System.in);
	
	// The counter is for deciding which player's chance is there.
	static int counter = 0;
	// A cross/o type, used here to find the winner's type.
	static Mark m;
	
	Player p1;
	Player p2;
	Board b;
	
	Game(){
		b = new Board();
		p1 = new Player(false);
		p2 = new Player(true);
	}
	
	
	void start() {
		int row, col;
		boolean ch;
		boolean draw;
		boolean bool = true;
		
		while(bool) {
			
			// Printing the tictactoe board.
			int i, j;
			
			for(i = 0; i <= 2; i++) {
				
				for(j = 0; j <= 2; j++) {
				
					if(Board.board[i][j] == null) {
						System.out.print("-" + " ");
					}
					else if(Board.board[i][j].type == false) {
						System.out.print("x" + " ");
					}
					else if(Board.board[i][j].type == true) {
						System.out.print("o" + " ");
					}
					
				}
				System.out.println("");
			}
			
			System.out.println(" ");
			
			if(counter%2 == 0) {
				System.out.println("It's player 1's chance, make a move-");
				
				System.out.println("Enter row and col:");
				row = sc.nextInt();
				col = sc.nextInt();
				
				p1.move(row, col);
				ch = winner();
				draw = drawCheck();
				
				if(ch)
					bool = !bool;
				else if(draw) {
					bool = !bool;
					System.out.println("The match is a draw!");
				}
				else
					continue;
			}
			
			else {
				System.out.println("It's player 2's chance, make a move-");
				
				System.out.println("Enter row and col:");
				row = sc.nextInt();
				col = sc.nextInt();
				
				p2.move(row, col);
				ch = winner();
				draw = drawCheck();
				
				if(ch)
					bool = !bool;
				else if(draw) {
					bool = !bool;
					System.out.println("The match is a draw!");
				}
				else
					continue;
			}
		
		}
	}
	/*
	 * This method checks for whether the match is a draw or not by checking if the tictactoe 
	 * box is full or not.
	 * 
	 * The drawCheck also ends the game if there is a draw, the end method is thereby not needed here.
	 * 
	 * */
	boolean drawCheck() {
	
		boolean check = false;
		int i, j;
		int count = 0;
		
		for(i = 0; i <= 2; i++) {
			for(j = 0; j <=2; j++) {
				if(Board.board[i][j] != null)
					count ++;
			}
		}
		
		if(count == 9) {
			check = true;
		
			// Printing the box one last time after concluding that the game is a draw.
			
			for(i = 0; i <= 2; i++) {
				
				for(j = 0; j <= 2; j++) {
				
					if(Board.board[i][j] == null) {
						System.out.print("-" + " ");
					}
					else if(Board.board[i][j].type == false) {
						System.out.print("x" + " ");
					}
					else if(Board.board[i][j].type == true) {
						System.out.print("o" + " ");
					}
					
				}
				System.out.println("");
			}
			
			System.out.println(" ");
			
		}
		
		return check;
	}
	
	
	boolean winner() {
	
		if(horizontalCheck()) {
			end(m);
			return true;
		}
		
		else if(verticalCheck()) {
			end(m);
			return true;
		}
		
		else if(acrossCheckLeftToRight()) {
			end(m);
			return true;
		}
		
		else if(acrossCheckRightToLeft()) {
			end(m);
			return true;
		}
	return false;
		
	}
	
	/*
	 * This checks for winning condition horizontally through all columns.
	 * */
	
	boolean horizontalCheck() {
		
		int i = 0, j = 0;
		boolean check = false;
	
		int ch;
		
		for(i = 0; i <= 2; i++) {
			
			ch = 0;
			j = 0;
			Mark mCheck = Board.board[i][0];
			
			for(;j <= 2; j++) {
				if(Board.board[i][j] == null) {
					return check;
				}
				else {
					if(Board.board[i][j].type == mCheck.type) {
						ch ++;
					}
					else
						return check;
					
				}
				
				if(ch == 3) {
					check = true;
					m = Board.board[i][j];
					//System.out.println("i : " + i + "j : " + j);
					return check;
				}	
			}
			
		}
		
		return check;
	}
	/*
	 * This checks for winning condition vertically through every row.
	 * */
	
	boolean verticalCheck() {
		
		int i = 0, j = 0;
		boolean check = false;
		
		int ch;
		
		for(i = 0; i <= 2; i++) {
			
			ch = 0;
			j = 0;
			Mark mCheck = Board.board[0][i];
			
			for(; j <= 2; j++) {
				if(Board.board[j][i] == null) {
					return check;
				}
				else {
					if(Board.board[j][i].type == mCheck.type) {
						ch ++;
					}
					else
						return check;
					
				}
				
				if(ch == 3) {
					check = true;
					m = Board.board[j][i];
					//System.out.println("i : " + i + "j : " + j);
					return check;
					}
			}
		}
		
		
		return check;
	}
	
	/*
	 * This checks for winning condition across, from top left to bottom right.
	 * 
	 * */
	
	boolean acrossCheckLeftToRight() {
		
		int i = 0, j = 0;
		
		boolean check = false;
		
		int ch;
		Mark mCheck;
		
		if(Board.board[0][0] == null)
			return check;
		
		else {
			
			mCheck = Board.board[0][0];
			ch = 0;
				
			for(; i <= 2 && j <= 2; i++, j++) {
				
				if(Board.board[i][j] == null) {
					return check;
				}
				else {
					if (Board.board[i][j].type == mCheck.type)
						ch ++;
				}
				
				if(ch == 3) {
					check = true;
					m = Board.board[i][j];

					return check;
				}
			}
			
		}
		
		return check;
	}
	
	/*
	 * This checks for winning condition across i.e. from top right corner to bottom left.
	 * 
	 * */
	
	boolean acrossCheckRightToLeft() {
		
		int i = 0, j = 2;
		
		boolean check = false;
		
		int ch;
		Mark mCheck;
		
		if(Board.board[0][2] == null)
			return check;
		
		else {
			
			mCheck = Board.board[0][2];
			ch = 0;
		
			for(; i <= 2 && j >= 0; i++, j--) {
				
				if(Board.board[i][j] == null) {
					return check;
				}
				else {
					if (Board.board[i][j].type == mCheck.type)
						ch ++;
				}
				
				if(ch == 3) {
					check = true;
					m = Board.board[i][j];

					return check;
				}
			}
			
		}
		
		return check;
	}
	/*
	 * Ends the game once one of the winning condition is met with.
	 * */
	void end(Mark m) {
		
		// Printing the board a last time before announcing the winner.
		
		int i, j;
		
		for(i = 0; i <= 2; i++) {
			
			for(j = 0; j <= 2; j++) {
			
				if(Board.board[i][j] == null) {
					System.out.print("-" + " ");
				}
				else if(Board.board[i][j].type == false) {
					System.out.print("x" + " ");
				}
				else if(Board.board[i][j].type == true) {
					System.out.print("o" + " ");
				}
				
			}
			System.out.println("");
		}
		
		System.out.println(" ");
		
		
		if(m.type == false) {
			System.out.println("Player 1 is the winner!");
		}
		else
			System.out.println("Player 2 is the winner!");
		
	}
}
