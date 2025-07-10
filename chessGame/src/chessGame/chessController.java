package chessGame;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class chessController{
	private chessView chessBoard;
	private chessModel chessLogic;
	private int recentRow = -1;
	private int recentCol = -1;
	private ArrayList<Point> moves;
	private String player = "White";
	private String opponent = "Black";
	
	// add inheritance for legal moves take moves 
	// Next focus on inheritance next time working on this!
	public chessController(chessModel model, chessView view) {
		this.chessLogic = model;
		this.chessBoard = view;
		this.moves = new ArrayList<>();
		// So what do i do 
		//so i add listeners to 
		addListeners();
		
	}
	
	//so keeping track of truns,
	// so i must store previous moves maybe 0, 1 (0 white, 1 black)
	private void addListeners() {
		int i = 0;
		int j = 0;
		//NEW problem here (no longer have a list of buttons, but a matrix)
		JButton[][] buttons = chessBoard.getButtons();
		
		for(int row = 0; row<8; row++) {
			for(int col = 0; col<8; col++) {
				final int finalRow = row;
				final int finalCol = col;
				//so when i do final Row and column here, i say that when at 1,0
				//So nextRow = y;
				//x = 1;
				//0,0 is top left corner
				//so it passes in the row it's in and the col it's in (first button being 0,0)
				
				//so row is [0][1] [0][2]
				
				//ah square clicked is the row
				
				buttons[row][col].addActionListener(e -> squareClicked(finalRow,finalCol));

			}
		}
	}
	
	/**
	 * This method selects a piece then highlights the open spaces
	 * @param col
	 * @param row
	 */
	//so if the square clicked highlighted the moves
	
	//so i pass in the col
	
	//so col supposed to be row
	//so i c,ick on the
	private void squareClicked(int row, int col) {
		//so
		// so if it is white then this operate now it must be if it is black it operates
		
		//so if this is the desired color;
		// 
		// so if the color of the piece is white operate
		// but then if the color of the piece is black, operate
		
		// while the color != previousColor
		// now white == white \\
		
		
		//so i keep track of
		// if the square clicked has a color and it's opposite of player etc
		
	
		if (!chessLogic.getBoard()[row][col].getColor().equals("--") && chessLogic.getBoard()[row][col].getColor().equals(player.toLowerCase())) {
			
			if (moves.isEmpty()) {
				//then row
				//good here for moves
				//row,col
				
				moves = chessLogic.highlightedMoves(row,col);
				//good here
				chessBoard.highLighting(moves);
				recentRow = row;
				recentCol = col;
			}

			//SO POINT OPERATES COL ROW TO GET THE SAME BUTTOn
			//row, col
			//SO if the piece
			//if the moves it can move to are highlighted 
			else if (recentRow == row && recentCol == col) {
				chessBoard.unhighlight(moves);
				moves.clear();
			}
			//so if the piece is moved the new color is opposite of recentRow recentCol

		}
		else if(moves.contains(new Point(row,col))){
			chessBoard.unhighlight(moves);
			moves.clear();
			chessLogic.movePiece(recentRow, recentCol, row,col);
			chessBoard.updateBoard(recentRow,recentCol, row, col);
			
			String oppositeColor = player;
			//opp color = white
			
			player = opponent;
			//player = black
			opponent = oppositeColor;
			
			chessBoard.changeTurn(player);

			// white now = black

			// PRINT BLACK TURN, WHITE TURN
			
			// black now = white
		}
		
	}
	
}