package chessGame;
import java.util.ArrayList;
import java.awt.*;
//So store the pieces on the board
//so if it is black do this (add to legal mvoes)
public class Knight extends chessPiece{
	public Knight(String color, int row, int col) {
		super(color, row, col);
	}
	
	public ArrayList<Point> legalMoves(chessPiece[][] chessBoard , int row, int col){
		ArrayList<Point> legalMoves = new ArrayList<>();
		
		int[][] knightMoves = {{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},
				{2,-1},{2,1}};
		int direction = color.contains("w") ? -1 :1;
		//so if it's white it goes in the negative direction
		//I need to pass in the row and col dummy!
		

		System.out.println(chessBoard[row][col]);
		for (int i = 0; i<8; i++) {

			int nextRow = knightMoves[i][0]*direction + row;
			int nextCol = knightMoves[i][1]*direction + col;

			
			//I need this if condition everywhere
			if (nextRow >= 0 && nextRow < 8 && nextCol >= 0 && nextCol < 8) {

				if (chessBoard[nextRow][nextCol].getName().equals("NullPiece")){
					System.out.println("nullPiece");
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
		return "Knight";
	}
	public String getColor() {
		return color;
	}
}