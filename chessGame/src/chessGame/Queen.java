package chessGame;
import java.util.ArrayList;
import java.awt.*;
//So store the pieces on the board
//so if it is black do this (add to legal mvoes)
public class Queen extends chessPiece{
	public Queen(String color, int row, int col) {
		super(color, row, col);
	}
	
	//Must take in type 
	public ArrayList<Point> legalMoves(chessPiece[][] chessBoard, int row, int col){
		
		int[][] queenMoves = {{1,1},{-1,1},{-1,-1},{1,-1},{0,1},{-1,0},
				{1,0},{0,-1}};


		
		ArrayList<Point> legalMoves = new ArrayList<>();
		//so if it's white it goes in the negative direction
		

		for (int i = 0; i<8; i++) {
			int nextRow = queenMoves[i][0] + row;
			int nextCol = queenMoves[i][1] + col;
			int counter = 0;
			
			if (nextRow >= 0 && nextRow < 8 && nextCol >= 0 && nextCol < 8) {
				
				//so this makes sure the spaces in the null spots will be highlighted
				//so if the 
				
				//Also need to assign new space it's in to NullPiece
				//so if the nextPiece is null piece
				if (chessBoard[nextRow][nextCol].getName().equals("NullPiece")) {
					// while there is a null piece 
					while (chessBoard[nextRow][nextCol].getName().equals("NullPiece")){
						//so im coding the open pieces 
						legalMoves.add(new Point(nextRow, nextCol));
						// the nextRow and nextCol it can move to 
						nextRow+= queenMoves[i][0];
						nextCol += queenMoves[i][1];
						System.out.println("counter: " + counter++);
						
						// so for capture 
						// everything is right here, ther is somethign with having to assign 
						// null piece to the spaces captured/ gone in
						
						//so look at hihglihging.. and the model with how it looks like
						// look at button board too
						
						//TO DO:
						// need to get done: switch off which player goes which (next)
						// if pawn goes to other side get knocked off pieces (store pieces somewhere)
						// tell who the winner is based off if the king gets captured 
						
						//some problem with the perimeters/ it wont do nextRow/NextCol
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
				// so if the nextRow and nextCol
				// hgere is the problem
				// so if the nextRow and col is black 
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
	public String getName(){
		return "Queen";
	}
	
	public String getColor() {
		return color;
	}
	
}
