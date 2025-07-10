package chessGame;
import java.util.ArrayList;
import java.awt.*;
//So store the pieces on the board
//so if it is black do this (add to legal mvoes)
public class King extends chessPiece{
	public King(String color, int row, int col) {
		super(color, row, col);
	}
	
	public ArrayList<Point> legalMoves(chessPiece[][] chessBoard, int row, int col){
		ArrayList<Point> legalMoves = new ArrayList<>();
		//so if it's white it goes in the negative direction
		int[][] kingMoves = {{0,1},{-1,0},{1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
		int direction = color.contains("w") ? -1 :1;
		
		for (int i = 0; i<8; i++) {
			
			int nextRow = kingMoves[i][0]*direction + row;
			int nextCol = kingMoves[i][1]*direction + col;
			
			if (nextRow >= 0 && nextRow < 8 && nextCol >= 0 && nextCol < 8) {
				if (chessBoard[nextRow][nextCol] != null && chessBoard[nextRow][nextCol].getName().equals("NullPiece")){
					legalMoves.add(new Point(nextRow,nextCol));
				}
				else if (!chessBoard[nextRow][nextCol].getColor().equals(this.color)) {
					legalMoves.add(new Point(nextRow,nextCol));
				}			
			}
		}
		return legalMoves;		
	}
	
	public String getName() {
		return "King";
	}
	
	public String getColor() {
		return color;
	}
}