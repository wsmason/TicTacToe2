import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	
	enum State {EMPTY, PLAYER_ONE, PLAYER_TWO;}

	static Board board;
	static State currentPlayer = TicTacToe.State.PLAYER_ONE;
	static int movesMade = 0;
	
	public static void main(String[] args) {
		//ComputerPlayer computer = new ComputerPlayer();
		Board board = new Board();
		ComputerPlayer cp = new ComputerPlayer();
		HumanPlayer hp = new HumanPlayer();
		hp.setState(TicTacToe.State.PLAYER_ONE);
		cp.setState(TicTacToe.State.PLAYER_TWO);
		board.initialize();
		board.display();
		while (!board.gameWon(TicTacToe.State.PLAYER_ONE) && !board.gameWon(TicTacToe.State.PLAYER_TWO)) {
			playGame();
		}

	}
	
	static void move(State state, int pos) {
		//board.cells[pos].state = state;
		movesMade++;
		updateGame();
	}
	
	static void updateGame() {
		if (currentPlayer == TicTacToe.State.PLAYER_ONE) {
			currentPlayer = TicTacToe.State.PLAYER_TWO;
		}
		
		else {
			currentPlayer = TicTacToe.State.PLAYER_ONE;
		}
	}
	
	static void playGame() {
		Scanner in = new Scanner(System.in);
		int pos = in.nextInt();
		move(currentPlayer, pos);
		board.display();
	}

}

