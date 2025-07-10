package chessGame;
import java.util.ArrayList;
import java.awt.*;
//So store the pieces on the board
//so if it is black do this (add to legal mvoes)
public class Pawn extends chessPiece{
	public Pawn(String color, int row, int col) {
		super(color, row, col);
	}
	
	public ArrayList<Point> legalMoves(chessPiece[][] chessBoard, int row, int col){
		ArrayList<Point> legalMoves = new ArrayList<>();
		//so if it's white it goes in the negative direction
		int direction = color.contains("w") ? -1 :1;
		
		int nextRow = row + direction;
		int nextCol = col;
		
		String other_color = "N/A";
		
		//so if the color is white or blacks
		//so if the nextRow which is one forward isn't null
		
		//go based off of color

	
		if (nextRow >= 0 && nextRow < 8 && nextCol >= 0 && nextCol < 8) {
			if (direction == -1) {
				other_color = "b";
			}
			
			else if (direction == 1) {
				other_color = "w";
			}
			
			//so must make sure the next space contains 
			if (chessBoard[nextRow][col] != null && chessBoard[nextRow][col].getName().equals("NullPiece")){
				legalMoves.add(new Point(nextRow, col));
				if ((row == 6 || row == 1) && chessBoard[nextRow+direction][col] != null &&chessBoard[nextRow+direction][col].getName().equals("NullPiece")) {
					//move two spaces 
					legalMoves.add(new Point(nextRow+direction, col));
				}
	
			}
			
			//so if the color is black 
			if ((nextCol = col+1) >= 0 && nextCol < 8) {
				if(chessBoard[nextRow][nextCol].getColor().contains(other_color)) {
					legalMoves.add(new Point(nextRow, nextCol));
				}
			}
			if ((nextCol = col - 1) >= 0 && nextCol < 8) {
				
				if (chessBoard[nextRow][nextCol].getColor().contains(other_color)) {
					legalMoves.add(new Point(nextRow, nextCol));
				}
			

			}
		}
		return legalMoves;
	}
	
	public String getName() {
		return "Pawn";
	}
	public String getColor() {
		return color;
	}
}