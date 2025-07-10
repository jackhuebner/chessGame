package chessGame;
import java.util.ArrayList;
import java.awt.*;
//So store the pieces on the board
//so if it is black do this (add to legal mvoes)
public class Bishop extends chessPiece{
	public Bishop(String color, int row, int col) {
		super(color, row, col);
	}
	
	public ArrayList<Point> legalMoves(chessPiece[][] chessBoard, int row, int col){
		ArrayList<Point> legalMoves = new ArrayList<>();
		//so if it's white it goes in the negative direction
		int[][] bishopMoves = {{1,1},{-1,1},{-1,-1},{1,-1}};

		//well this can move in any direction!
				//so if it's white it goes in the negative direction
		
		for (int i = 0; i<4; i++) {
			int nextRow = bishopMoves[i][0] + row;
			int nextCol = bishopMoves[i][1] + col;

			
			if (nextRow >= 0 && nextRow < 8 && nextCol >= 0 && nextCol < 8) {
				System.out.println("nextRow: " + nextRow);
				System.out.println("nextCol: " + nextCol);
				// it assumes empty space is a pawn
				System.out.println(chessBoard[nextRow][nextCol].getName());
				if (chessBoard[nextRow][nextCol].getName().equals("NullPiece")) {
					System.out.println("yo!");
	
					while (chessBoard[nextRow][nextCol].getName().equals("NullPiece")){
						//so im coding the open pieces 
						legalMoves.add(new Point(nextRow, nextCol));
						nextRow+= bishopMoves[i][0];
						nextCol += bishopMoves[i][1];



						if (nextRow >= 0 && nextRow < 8 && nextCol >= 0 && nextCol < 8) {
	
							if (!chessBoard[nextRow][nextCol].getColor().equals(this.color)) {
								legalMoves.add(new Point(nextRow,nextCol));
							}
						}
						else {
							break;
						}
					}
				}
				else if(!chessBoard[nextRow][nextCol].getColor().equals(this.color)){
					legalMoves.add(new Point(nextRow,nextCol));
				}
				
				//so if the piece aint outside the perimeter
				
			}
			
		}
		//so if the color is white you go in the negative direction
		//so if the color is white check if the spaces next to it are empty
		return legalMoves;
	}
	public String getName() {
		return "Bishop";
	}
	
	public String getColor() {
		return color;
	}
}