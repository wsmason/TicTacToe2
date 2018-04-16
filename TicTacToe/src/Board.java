import java.util.ArrayList;


public class Board {
	
	int position;
	Cell[] cells;
	
	Board() {
		cells = new Cell[9];
		for (int i = 0; i < 9; i++) {
			cells[i] = new Cell();
		}
	}
	
	public void initialize() {
		for (int i=0; i < 9; i++) {
			cells[i].clear();
			cells[i].setMarker();
		}
	}
	
	public void display() {
		System.out.println("  0  " + cells[0].marker + "|" + cells[1].marker + "|" + cells[2].marker);
		System.out.println("    --+-+--");
		System.out.println("  1  " + cells[3].marker + "|" + cells[4].marker + "|" + cells[5].marker);
		System.out.println("    --+-+--");
		System.out.println("  2  " + cells[6].marker + "|" + cells[7].marker + "|" + cells[8].marker);
		System.out.println("     0 1 2 ");
	}
	
	boolean containsMarker(int x) {
		return cells[x].state != TicTacToe.State.EMPTY;
	}
	
	ArrayList<Integer> getPossibleMoves() {
		ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
		for (int i=0; i < 9; i++) {
			
				if (cells[i].state.equals(TicTacToe.State.EMPTY)) {
					possibleMoves.add(i);
			
			}
		}
		return possibleMoves;
	}
		
	boolean gameWon(TicTacToe.State state) {
		return (
				
				//cells[0].state == cells[1].state == cells[2].state == state;
				//horizontal wins
				(cells[0].state.equals(cells[1].state) && cells[1].state.equals(cells[2].state)) && cells[0].state.equals(state) ||
				(cells[3].state.equals(cells[4].state) && cells[4].state.equals(cells[5].state)) && cells[3].state.equals(state) ||
				(cells[6].state.equals(cells[7].state) && cells[7].state.equals(cells[8].state)) && cells[6].state.equals(state) ||
				
				//vertical wins
				(cells[0].state.equals(cells[3].state) && cells[3].state.equals(cells[6].state)) && cells[0].state.equals(state) ||
				(cells[1].state.equals(cells[4].state) && cells[4].state.equals(cells[7].state)) && cells[1].state.equals(state) ||
				(cells[2].state.equals(cells[5].state) && cells[5].state.equals(cells[8].state)) && cells[2].state.equals(state) ||
				
				//diagonal wins
				(cells[0].state.equals(cells[4].state) && cells[4].state.equals(cells[8].state)) && cells[0].state.equals(state) ||
				(cells[2].state.equals(cells[4].state) && cells[4].state.equals(cells[6].state)) && cells[2].state.equals(state) 
				
				);
	}

	
	
}
