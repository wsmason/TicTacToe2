import java.util.Scanner;

public class HumanPlayer extends Player {
	TicTacToe.State state;
	HumanPlayer(TicTacToe.State a) {
		state = a;
	}
	

	void move() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please choose a cell...");
		int pos = scanner.nextInt() - 1;
		TicTacToe.board.cells[pos].state = state;
		TicTacToe.board.cells[pos].setMarker();
		TicTacToe.movesMade++;
		TicTacToe.board.display();
		TicTacToe.updateGame();
		
	}
}
