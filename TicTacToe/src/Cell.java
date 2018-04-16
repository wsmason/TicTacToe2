
public class Cell {

	TicTacToe.State state;
	char marker;
	
	Cell() {
		//position = p;
		//clear();
	}
	
	public void clear() {
		state = TicTacToe.State.EMPTY;
	}
	
	public void setMarker() { 
		
		switch (state) {
		
		case EMPTY: marker = ' '; break;
		case PLAYER_ONE: marker = 'X'; break;
		case PLAYER_TWO: marker = 'O'; break;
		
		}
	}
}
