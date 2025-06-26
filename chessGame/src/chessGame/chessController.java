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
	// add inheritance for legal moves take moves 
	// Next focus on inheritance next time working on this!
	public chessController(chessModel model, chessView view) {
		this.chessLogic = model;
		this.chessBoard = view;
		this.moves = new ArrayList<>();
		addListeners();
	}
	
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
		else if(moves.contains(new Point(row,col))){
			chessBoard.unhighlight(moves);
			moves.clear();
			chessLogic.movePiece(recentRow, recentCol, row,col);
			chessBoard.updateBoard(recentRow,recentCol, row, col);
		}
		
	}
	
}