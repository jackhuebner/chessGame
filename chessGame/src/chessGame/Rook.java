package chessGame;
import java.util.ArrayList;
import java.awt.*;
//So store the pieces on the board
//so if it is black do this (add to legal mvoes)
public class Rook extends chessPiece{
	public Rook(String color, int row, int col) {
		super(color, row, col);
	}
	
	public ArrayList<Point> legalMoves(chessPiece[][] chessBoard, int row, int col){
		ArrayList<Point> legalMoves = new ArrayList<>();
		//so if it's white it goes in the negative direction
		int[][] rookMoves = {{0,1},{-1,0},{1,0},{0,-1}};
		int direction = color.contains("w") ? -1 :1;
		
		for (int i = 0; i<4; i++) {
			int nextRow = rookMoves[i][0]*direction + row;
			int nextCol = rookMoves[i][1]*direction + col;
			
			if (nextRow >= 0 && nextRow < 8 && nextCol >= 0 && nextCol < 8) {
				if (chessBoard[nextRow][nextCol].getName().equals("NullPiece")) {

					while (chessBoard[nextRow][nextCol] != null && chessBoard[nextRow][nextCol].getName().equals("NullPiece")){
						//so im coding the open pieces 
						legalMoves.add(new Point(nextRow, nextCol));
						nextRow+= rookMoves[i][0]*direction;
						nextCol += rookMoves[i][1]*direction;
						if (nextRow >= 0 && nextRow < 8 && nextCol >= 0 && nextCol < 8) {
	
							if (!chessBoard[nextRow][nextCol].getColor().equals(this.color)) {
								//so if the chessBoard area's color isn't equal, you can move there YES!
								legalMoves.add(new Point(nextRow,nextCol));
							}
						}
						else {
							break;
						}
					}
					//so if the piece aint outside the perimeter	\ // LOOK AT
				}
				else if(!chessBoard[nextRow][nextCol].getColor().equals(this.color)){
					legalMoves.add(new Point(nextRow,nextCol));
				}
			}
		}
		//so if the color is white you go in the negative direction
		//so if the color is white check if the spaces next to it are empty
		return legalMoves;
			
		}
	
	public String getName() {
		return "Rook";
	}
	
	public String getColor() {
		return color;
	}
}