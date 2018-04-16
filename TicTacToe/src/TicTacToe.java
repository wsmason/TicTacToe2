
public class TicTacToe {
	
	enum State {
		EMPTY (false), 
		PLAYER_ONE (false), 
		PLAYER_TWO (false);
		State(boolean human) {
		}
	}
	//Scanner scanner = new Scanner(System.in);
	
	static Player currentPlayer;
	public static int movesMade = 0;
	public static Board board = new Board();
	static ComputerPlayer cp = new ComputerPlayer(TicTacToe.State.PLAYER_TWO);
	static HumanPlayer hp = new HumanPlayer(TicTacToe.State.PLAYER_ONE);
	
	public static void main(String[] args) {
	
		currentPlayer = hp;
		board.initialize();
		board.display();
		while (!board.gameWon(TicTacToe.State.PLAYER_ONE) && !board.gameWon(TicTacToe.State.PLAYER_TWO)) {
		playGame();
		}
	
	//	System.out.println((board.gameWon(TicTacToe.State.PLAYER_ONE)) + " " + (board.gameWon(TicTacToe.State.PLAYER_TWO)));

	}
	
	

	
//	static void move(State state, int pos) {
//		board.cells[pos].state = state;
//		board.cells[pos].setMarker();
//		movesMade++;
//		updateGame();
//	}
	
	static void updateGame() {
		if (currentPlayer == hp) {
			currentPlayer = cp;
		}
		
		else {
			currentPlayer = hp;
		}
	}
	
	static void playGame() {
		if (currentPlayer == hp) {
			hp.move();
		}
		else {
			cp.move();
		}
		
		
		
//		Scanner in = new Scanner(System.in);
//		System.out.println(currentPlayer);
//		int pos = in.nextInt() - 1;
//		move(currentPlayer, pos);
//		board.display();
	}

}

