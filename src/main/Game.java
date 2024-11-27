package main;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Game {

	public void fillBoard(String[][] board) {
		for(int k = 0; k < 8; ++k) {
			for(int i=0; i<board[k].length; i++) board[0][i] = "⬜";
		}
	}

	void printBoard(String[][] board) {
		for(String[] row : board) {
			for(String elem : row)
				System.out.print(" " + elem + " ");
			System.out.println("");
		}
	}

	void threadSleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public void play() {
		int player = 0;
		String[][] board = {{"⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜"},
				{"⬜", "⬜", "⬜", "⬛", "⬛", "⬛", "⬜", "⬜"},
				{"⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬛", "⬜"},
				{"⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬛", "⬜"},
				{"⬜", "⬜", "⬜", "⬜", "⬜", "⬛", "⬜", "⬜"},
				{"⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬛", "⬜"},
				{"⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬛", "⬜"},
				{"⬜", "⬜", "⬜", "⬛", "⬛", "⬛", "⬜", "⬜"}};

		printBoard(board);
		threadSleep();

		fillBoard(board);
		board[1][3] = "⬛"; board[1][4] = "⬛"; board[1][5] = "⬛";
		board[2][2] = "⬛"; board[2][5] = "⬛"; 
		board[3][6] = "⬛"; 
		board[4][5] = "⬛"; 
		board[5][4] = "⬛"; 
		board[6][3] = "⬛"; 
		board[7][2] = "⬛"; board[7][3] = "⬛"; board[7][4] = "⬛"; board[7][5] = "⬛"; board[7][6] = "⬛";

		printBoard(board);
		threadSleep();

		fillBoard(board);
		board[1][4] = "⬛"; 
		board[2][3] = "⬛"; board[2][3] = "⬛"; 
		board[3][4] = "⬛"; 
		board[4][4] = "⬛"; 
		board[5][4] = "⬛"; 
		board[6][4] = "⬛"; 
		board[7][2] = "⬛"; board[7][3] = "⬛"; board[7][4] = "⬛"; board[7][5] = "⬛"; 

		printBoard(board);
		threadSleep();

		fillBoard(board);

		boolean playing = true;
		while(playing) {
			try {
				Random r = new Random();
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				int newCar = r.nextInt(8);
				board[0][newCar] = "🚙";
				board[7][player] = "🚗";
				
				printBoard(board);

				//input
				String key = br.readLine();

				if(key.equals("q")) {
					playing = false;
					break;
				} else if(key.equals("a") && player > 0) {
					board[7][player] = "⬜";
					player -= 1;
				} else if(key.equals("d") && player < 7) {
					board[7][player] = "⬜";
					player += 1;
				}
				if(board[7][player].equals("🚙") || board[6][player].equals("🚙")) {
					playing = false;
					System.out.println("Perdiste!");

					//move cars down
					for(int i=0; i<7; i++) 
						board[7-i] = board[6-i];

					for(int i=0; i<board[0].length; i++) board[0][i] = "⬜";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {
		Game game = new Game();
		game.play();
	}
}
