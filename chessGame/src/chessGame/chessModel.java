package chessGame;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.awt.*;

public class chessModel {
	private chessPiece[][] chessBoard;
	private ArrayList moves;
	private LinkedHashMap<String,String> pieces;
	
	//get Ready to change things
	public chessModel(){
		this.pieces = new LinkedHashMap();
		this.chessBoard = new chessPiece[8][8];
		chessBoard[0] = new chessPiece[]{new Rook("black",0,0), new Knight("black",0,1),new Bishop("black",0,2),new Queen("black",0,3), new King("black",0,4),new Bishop("black",0,5), new Knight("black",0,6),new Rook("black",0,7)};
		chessBoard[1] = new chessPiece[]{new Pawn("black",1,0),new Pawn("black",1,1),new Pawn("black",1,2),new Pawn("black",1,3),new Pawn("black",1,4),new Pawn("black",1,5),new Pawn("black",1,6),new Pawn("black",1,7)};
		chessBoard[6] = new chessPiece[]{new Pawn("white",6,0),new Pawn("white",6,1),new Pawn("white",6,2),new Pawn("white",6,3),new Pawn("white",6,4),new Pawn("white",6,5),new Pawn("white",6,6),new Pawn("white",6,7)};
		chessBoard[7] = new chessPiece[]{new Rook("white",7,0), new Knight("white",7,1),new Bishop("white",7,2),new Queen("white",7,3), new King("white",7,4),new Bishop("white",7,5), new Knight("white",7,6),new Rook("white",7,7)};
		
		int k = 2;
		
		// so at these spots in the board
		while (k<6) {
			//this has got to be null for pieces 
				chessBoard[k] = new chessPiece[]{new NullPiece(), new NullPiece(),new NullPiece(),new NullPiece(),new NullPiece(),new NullPiece(),new NullPiece(),new NullPiece()};
				k++;
		}
		//so edit this
		int counter = 0;
		int emptyCounter = 0;
		int pawnCounter = 1;
		int knightCounter = 1;
		int bishopCounter = 1;
		int rookCounter = 1;
		
		for (int i = 0; i <=7; i++) {
			for (int j = 0; j<=7; j++) {
				chessPiece piece = chessBoard[i][j];
				//so if the piece is a pawn
				String pieceName = piece.getName();
				if (i == 0) {
					if (pieceName.equals("Rook")) {
						pieces.put(pieceName + rookCounter,"img/chessPieces/black-rook");
						rookCounter++;
					}
					else if(pieceName.equals("Knight")) {
						pieces.put(pieceName + knightCounter,"img/chessPieces/black-knight");
						knightCounter++;
					}
					else if(pieceName.equals("Bishop")) {
						pieces.put(pieceName + bishopCounter,"img/chessPieces/black-bishop");
						bishopCounter++;
					}
					else if(pieceName.equals("Queen")) {
						pieces.put(pieceName,"img/chessPieces/black-queen");
					}
					else if(pieceName.equals("King")) {
						pieces.put(pieceName,"img/chessPieces/black-king");
					}
					
				}
				else if(i==1) {
					pieces.put(pieceName + pawnCounter, "img/chessPieces/black-pawn");
					pawnCounter++;
				}
				else if(i==6) {
					pieces.put(pieceName+ pawnCounter, "img/chessPieces/white-pawn");
					pawnCounter++;
				}
				else if (i == 7) {
					if (pieceName.equals("Rook")) {
						rookCounter++;
						pieces.put(pieceName + rookCounter,"img/chessPieces/white-rook");
					}
					else if(pieceName.equals("Knight")) {
						knightCounter++;
						pieces.put(pieceName + knightCounter,"img/chessPieces/white-knight");
					}
					else if(pieceName.equals("Bishop")) {
						bishopCounter++;
						pieces.put(pieceName+ bishopCounter,"img/chessPieces/white-bishop");
					}
					else if(pieceName.equals("Queen")) {
						pieces.put(pieceName+ "1","img/chessPieces/white-queen");
					}
					else if(pieceName.equals ("King")) {
						pieces.put(pieceName+ "1","img/chessPieces/white-king");
					}
				}
				else{
					emptyCounter++;
					pieces.put("emptySlot" + emptyCounter,"--");
				}
			}
		}
	}
	
	public ArrayList<Point> highlightedMoves(int row, int col) {	
		//y,x
		System.out.println("highlighted row: " + row);
		System.out.println("highlighted col: " + col);
		chessPiece piece = chessBoard[row][col];
		//correct row and col here, same as the piece
		//here's the problem i pass in the chessBoard 
		return piece.legalMoves(chessBoard, row, col);
		
	}
	
	public void movePiece(int recentRow, int recentCol, int row, int col) {
		chessPiece recentPieceSpace = chessBoard[recentRow][recentCol];
		//has a piece 
		System.out.println("RECENT PIECE:" + recentPieceSpace);
		chessPiece newPieceSpace = chessBoard[row][col];
		
		//Else if condiiton
		chessBoard[row][col] = recentPieceSpace;
		chessBoard[recentRow][recentCol] = newPieceSpace;
	}
	
	public	chessPiece[][] getBoard() {
		return chessBoard;
	}
	
	/**
	 * This has a linked hashmap of strings of the pieces
	 * @return
	 */
	public LinkedHashMap<String,String> getPieces() {
		//so i pass in pieces 
		return pieces;
	}

	
	//ALRIGHT!
	//SO the code 
//	Game Logic Implementation: Craft the fundamental logic for chess, including piece movements, capturing mechanics, and game-ending conditions like checkmate.
//	Graphical User Interface (GUI) Design: Utilize the Swing framework to design and implement a user-friendly and visually appealing interface for the chess game.
//	Event-Driven Programming: Manage user interactions through event listeners, enabling players to move pieces, respond to game states, and interact with the game dynamically.
//	Advanced State Management: Develop sophisticated game state management to handle the various states of a chess game, including tracking turns, game status, and special moves.
//	Problem-Solving: Demonstrate advanced problem-solving abilities in implementing chess rules, strategizing piece movements, and validating legal moves.
//	Best Practices in Java: Write clean, efficient, and well-structured Java code, following best practices for software design, maintainability, and GUI development.

	
}