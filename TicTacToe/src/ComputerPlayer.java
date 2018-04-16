import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer extends Player {
	TicTacToe.State state;
	ComputerPlayer(TicTacToe.State a) {
		state = a;
	}
	
	
	void move() {
		
		//Board boardCopy = TicTacToe.board;
		int pos = miniMax(TicTacToe.board, TicTacToe.cp);
		TicTacToe.board.cells[pos].state = state;
		TicTacToe.board.cells[pos].setMarker();
		TicTacToe.movesMade++;
		TicTacToe.board.display();
		TicTacToe.updateGame();
		//boardCopy = TicTacToe.board;
	}
	
//	public void setMarker(int p) {
//		boolean moveMade = false;
//		while (!moveMade) {
//			//check for win
//			//check for block
//		}
	//	TicTacToe.board[p] = TicTacToe.State.PLAYER_TWO;
//	}
	
	int getRandomPosition() {
		ArrayList<Integer> possibleMoves = TicTacToe.board.getPossibleMoves();
		Random rand = new Random();
		int size = possibleMoves.size();
		int index = rand.nextInt(size);
		int pos = possibleMoves.get(index);
		
		System.out.println(size); 
		System.out.println(index);
		System.out.println(pos);
		return pos;
	}
	
	
	int minimax(Board boardCopy, Player player) {
	
		if(boardCopy.gameWon(TicTacToe.cp.state)) {
			return 10;
		}
		
		if(boardCopy.gameWon(TicTacToe.hp.state)) {
			return -10;
		}
		
		else if (boardCopy.getPossibleMoves().size() == 0) {
			return 0;
		}
		
		else {
			int stateScore;
			
			if (player == TicTacToe.cp) {
				
				stateScore = -1000;
				int bestPosition = 0;
				ArrayList<Integer> availablePositions = TicTacToe.board.getPossibleMoves();
				
				for (int i = 0; i < availablePositions.size(); i++) {
					
					boardCopy.cells[availablePositions.get(i)].state = TicTacToe.cp.state;
					boardCopy.cells[availablePositions.get(i)].setMarker();
	//				boardCopy.display();
					
					int value = minimax(boardCopy, TicTacToe.hp);
					if (value > stateScore) {
						stateScore = value;
						bestPosition = i;
					}
					//boardCopy.cells[availablePositions.get(i)].state = TicTacToe.State.EMPTY;
					boardCopy.cells[availablePositions.get(i)].setMarker();
				}
			//	System.out.println(bestPosition);
			//	System.out.println(stateScore);
				return bestPosition;
				
			}
			
			else {
				
				stateScore = 1000;
				int bestPosition = 0;
				ArrayList<Integer> availablePositions = TicTacToe.board.getPossibleMoves();
				
				for (int i = 0; i < availablePositions.size(); i++) {
					
					boardCopy.cells[availablePositions.get(i)].state = TicTacToe.hp.state;
					boardCopy.cells[availablePositions.get(i)].setMarker();
				//	boardCopy.display();
					
					int value = minimax(boardCopy, TicTacToe.cp);
					if (value < stateScore) {
						stateScore = value;
						bestPosition = i;
					}
					//boardCopy.cells[availablePositions.get(i)].state = TicTacToe.State.EMPTY;
					boardCopy.cells[availablePositions.get(i)].setMarker();
					
				}
				//System.out.println(bestPosition);
				//System.out.println(stateScore);
				return bestPosition;
				
			}
		}
	}


public int miniMax(Board boardCopy, Player player)
{
	
	
	if(boardCopy.gameWon(TicTacToe.cp.state)) {
		return 10;
	}
	
	if(boardCopy.gameWon(TicTacToe.hp.state)) {
		return -10;
	}
	
	
	else if (boardCopy.getPossibleMoves().size() == 0) {
		return 0;
	}
	
	else if(player == TicTacToe.cp) //AI
    {
        int bestVal = Integer.MIN_VALUE;
        int bestSpot = 0;
        for(int i = 0; i < 9; i++)
        {
            if(!boardCopy.containsMarker(i))
                continue;
            boardCopy.cells[i].state = TicTacToe.cp.state;
            int value = miniMax(TicTacToe.board, TicTacToe.hp); 
            if(value > bestVal)
            {
                bestVal = value;
                bestSpot = i;
            }

          //  boardCopy.cells[i].state = TicTacToe.State.EMPTY;
        }
        return bestSpot;
    }
    else
    {
    	 int bestVal = Integer.MAX_VALUE;
         int bestSpot = 0;
         for(int i = 0; i < 9; i++)
         {
             if(!boardCopy.containsMarker(i))
                 continue;
             boardCopy.cells[i].state = TicTacToe.hp.state;
             int value = miniMax(TicTacToe.board, TicTacToe.cp); 
             if(value < bestVal)
             {
                 bestVal = value;
                 bestSpot = i;
             }

            // boardCopy.cells[i].state = TicTacToe.State.EMPTY;
         }
         return bestSpot;
}
}
}