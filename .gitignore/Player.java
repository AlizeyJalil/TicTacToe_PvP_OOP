package ticTacToe;

public class Player {
	
	boolean b;
	Mark m;
	
	/*
	 * The player has a mark type, that is whether the player can make an 'x' move or a 'o' move 
	 * according to traditional tictactoe rules.
	 * 
	 * */
	
	Player(boolean b){
		this.b = b;
		
		if(b == false) {
			m = new Mark(false);
		}
		else
			m = new Mark(true);
	}
	
	/*
	 * The move method of the player, this method executes to make the move for the player. 
	 * */
	
	void move(int a, int b) {
		
		if(a >= 0 && a <= 2 && b >= 0 && b <= 2) {
		
			if(Board.board[a][b] == null) {
				Board.board[a][b] = m;
				
				Game.counter ++;
			}
		
		
			else {
			
				System.out.println("There's already a mark there, wrong move, please try again!");
		
			}
		}
		else
			System.out.println("Invalid inputs, please try again!");
		
	}
	
}
