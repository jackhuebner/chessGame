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
		for (int i = 0; i <=7; i++) {
			for (int j = 0; j<=7; j++) {
				chessPiece piece = chessBoard[i][j];
				//so if the piece is a pawn
				String pieceName = piece.getName();
				if (i == 0) {
					if (pieceName.equals("Pawn")) {
						pieces.put(pieceName,"img/chessPieces/black-rook");
					}
					else if(pieceName.equals("Knight")) {
						pieces.put(pieceName,"img/chessPieces/black-knight");
					}
					else if(pieceName.equals("Bishop")) {
						pieces.put(pieceName,"img/chessPieces/black-bishop");
					}
					else if(pieceName.equals("Queen")) {
						pieces.put(pieceName,"img/chessPieces/black-queen");
					}
					else if(pieceName.equals("King")) {
						pieces.put(pieceName,"img/chessPieces/black-king");
					}
				}
				else if(i==1) {
					pieces.put(pieceName, "img/chessPieces/black-pawn");
				}
				else if(i==6) {
					pieces.put(pieceName, "img/chessPieces/white-pawn");
				}
				else if (i == 7) {
					if (pieceName.equals("Rook")) {
						pieces.put(pieceName,"img/chessPieces/white-rook");
					}
					else if(pieceName.equals("Knight")) {
						pieces.put(pieceName,"img/chessPieces/white-knight");
					}
					else if(pieceName.equals("Bishop")) {
						pieces.put(pieceName,"img/chessPieces/white-bishop");
					}
					else if(pieceName.equals("Queen")) {
						pieces.put(pieceName,"img/chessPieces/white-queen");
					}
					else if(pieceName.equals ("King")) {
						pieces.put(pieceName,"img/chessPieces/white-king");
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
		int[][] pawnMoves = {{1,0},{2,0},{1,1},{1,-1}};
		//in my array so nextRow (Y), nextCol (X)
		int[][] knightMoves = {{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},
								{2,-1},{2,1}};
		int[][] bishopMoves = {{1,1},{-1,1},{-1,-1},{1,-1}};
		int[][] queenMoves = {{1,1},{-1,1},{-1,-1},{1,-1},{0,1},{-1,0},
								{1,0},{0,-1}};
		int[][] krMoves = {{0,1},{-1,0},{1,0},{0,-1}};
		
		// So here is where i highlight moves, i pass in the row and col it's in 
		// and then i create pieces in the chessboard
		
		ArrayList<Point> legalMoves = new ArrayList();
		//I pass the button clicked to over here
		//so now make sure to move pieces.
		//the spaces are highlighted 
		else if(piece.contains("N")) {
			for (int i = 0; i < 8; i++) {
					if (piece.contains("w")){
						int nextRow = row + (knightMoves[i][0]*-1);
						int nextCol = col +(knightMoves[i][1]*-1);
						
						if (nextRow < 8 && nextCol>= 0 && nextRow>=0 && nextCol < 8) {
							String potentialSpace = chessBoard[nextRow][nextCol];
							if(potentialSpace != null && !potentialSpace.contains("w")){
							//highlight the space
							legalMoves.add(new Point(nextRow,nextCol));
							}
						}	
					}
					else if(piece.contains("b")) {
						int nextRow =row + (knightMoves[i][0]);
						int nextCol = col+(knightMoves[i][1]);
						if (nextRow < 8 && nextCol>= 0 && nextRow>=0 && nextCol < 8) {
							String potentialSpace = chessBoard[nextRow][nextCol];
							if(potentialSpace != null && !potentialSpace.contains("b")){
							//highlight the space
								legalMoves.add(new Point(nextRow,nextCol));
							}
						}
					}
		}
		}
		
//		//depends whther or not continuing going down 
//		else if(piece.contains("B")) {
//			for (int i = 0; i < 4; i++) {
//					if (piece.contains("w")){
//						int nextRow = row + bishopMoves[i][0];
//						int nextCol = col+bishopMoves[i][1];
//						String potentialSpace = chessBoard[nextRow][nextCol];
//						//say im next to a white 
//						if (potentialSpace.equals("--")) {
//							// highlight the space but keep going 
//							legalMoves.add(new Point(nextRow,nextCol));
//							while (potentialSpace.equals("--")){
//								potentialSpace = chessBoard[nextRow][nextCol];
//								if (potentialSpace.contains("b")) {
//									//highlight the space
//									legalMoves.add(new Point(nextRow,nextCol));
//								}
//								nextRow+= bishopMoves[i][0];
//								nextCol+= bishopMoves[i][1];
//							}
//						}
//						else if(potentialSpace.contains("b")) {
//							//highlight capturing space
//							legalMoves.add(new Point(nextRow,nextCol));
//						}
//						// but add something for it to keep going
//						
//					}
//					else if(piece.contains("b")) {
//						//so at 0,0 it returns the column, and then the 
//						int nextRow = row+(bishopMoves[i][0]*-1);
//						int nextCol = col+(bishopMoves[i][1]*-1);
//						String potentialSpace = chessBoard[nextRow][nextCol];;
//						//say im next to a white 
//						if (potentialSpace.equals("--")) {
//							// highlight the space but keep going 
//							legalMoves.add(new Point(nextRow,nextCol));
//							while (potentialSpace.equals("--")){
//								potentialSpace = chessBoard[nextRow][nextCol];
//								if (potentialSpace.contains("w")) {
//									//highlight the space
//									legalMoves.add(new Point(nextRow,nextCol));
//								}
//								//So basically exiting the for loop 
//								//so I add the row and the column
//								// so if bishop 
//								nextRow+=(bishopMoves[i][0]*-1);
//								nextCol+=(bishopMoves[i][1]*-1);
//							}
//						}
//						else if(potentialSpace.contains("w")){
//							//Highlight Space 
//							legalMoves.add(new Point(nextRow,nextCol));
//						}
//					}
//			}
//		}
//		
//		else if(piece.contains("Q")) {
//			//if the piece contains a queen 
//			for (int i = 0; i < 8; i++) {
//					if (piece.contains("w")){
//						int nextRow = row+queenMoves[i][0];
//						int nextCol = col+queenMoves[i][1];
//						String potentialSpace = chessBoard[nextRow][nextCol];
//						
//						if (potentialSpace.equals("--")){
//							//highlight the space but keep going
//							legalMoves.add(new Point(nextRow,nextCol));
//							while (potentialSpace.equals("--")) {
//								potentialSpace = chessBoard[nextRow][nextCol];
//								if (potentialSpace.contains("b")) {
//									//highlight space
//									legalMoves.add(new Point(nextRow,nextCol));
//								}
//								nextRow+=queenMoves[i][0];
//								nextCol+=queenMoves[i][1];
//							}
//						}
//						else if (potentialSpace.contains("b")) {
//							//HighlightSpace
//							legalMoves.add(new Point(nextRow,nextCol));
//						}
//					}
//					else if (piece.contains("b")) {
//						//check on this 
//						int nextRow = row+queenMoves[i][0];
//						int nextCol = col+queenMoves[i][1];
//						String potentialSpace = chessBoard[nextRow][nextCol];
//						
//						if (potentialSpace.equals("--")){
//							//highlight the space but keep going
//							legalMoves.add(new Point(nextRow,nextCol));
//							while (potentialSpace.equals("--")) {
//								potentialSpace = chessBoard[nextRow][nextCol];
//								if (potentialSpace.contains("w")) {
//									//highlight space
//									legalMoves.add(new Point(nextRow,nextCol));
//								}
//								nextRow+=queenMoves[i][0];
//								nextCol+=queenMoves[i][1];
//							}
//						}
//						else if (potentialSpace.contains("w")) {
//							//HighlightSpace
//							legalMoves.add(new Point(nextRow,nextCol));
//						}
//					}
//			}
//		}
//		
//		else if(piece.contains("K")) {
//			for (int i = 0; i < 4; i++) {
//					if (piece.contains("w")) {
//						int nextRow =row + krMoves[i][0];
//						int nextCol = col+krMoves[i][1];
//						String potentialSpace = chessBoard[nextRow][nextCol];
//						if (potentialSpace.equals("--") || potentialSpace.contains("b")) {
//							//highlight space
//							legalMoves.add(new Point(nextRow,nextCol));
//						}
//					}
//					else if (piece.contains("b")) {
//						int nextRow =row + (krMoves[i][0]*-1);
//						int nextCol = col+(krMoves[i][1]*-1);
//						String potentialSpace = chessBoard[nextRow][nextCol];
//						if (potentialSpace.equals("--") || potentialSpace.contains("w")) {
//							//highlight space
//							legalMoves.add(new Point(nextRow,nextCol));
//						}
//					}
//			}
//		}
//		
//		//work on this 
//	
//		else if(piece.contains("R")) {
//			for (int i = 0; i < 4; i++) {
//				//Make sure to add a while loop for contuning spaces
//					if (piece.contains("w")) {
//						int nextRow =row + krMoves[i][0];
//						int nextCol = col+krMoves[i][1];
//						String potentialSpace = chessBoard[nextRow][nextCol];
//						if (potentialSpace.equals("--")) {
//							//highlight space
//							legalMoves.add(new Point(nextRow,nextCol));
//						}
//						else if(potentialSpace.contains("b")) {
//							legalMoves.add(new Point(nextRow,nextCol));
//						}
//					}
//					else if (piece.contains("b")) {
//						int nextRow =row + krMoves[i][0];
//						int nextCol = col+krMoves[i][1];
//						String potentialSpace = chessBoard[nextRow][nextCol];
//						if (potentialSpace.equals("--") || potentialSpace.contains("w")) {
//							//highlight space
//							legalMoves.add(new Point(nextRow,nextCol));
//						}
//					}
//			}
//		}
		System.out.println(legalMoves);
		return legalMoves;
		
	}
	
	public void movePiece(int recentRow, int recentCol, int row, int col) {
		String recentPieceSpace = chessBoard[recentRow][recentCol];
		System.out.println("RECENT PIECE:" + recentPieceSpace);
		String newPieceSpace = chessBoard[row][col];
		
		//Else if condiiton
		chessBoard[row][col] = recentPieceSpace;
		chessBoard[recentRow][recentCol] = newPieceSpace;
	}
	
	public String[][] getBoard() {
		return chessBoard;
	}
	
	/**
	 * This has a linked hashmap of strings of the pieces
	 * @return
	 */
	public LinkedHashMap<String,String> getPieces() {
		return pieces;
	}

//	Game Logic Implementation: Craft the fundamental logic for chess, including piece movements, capturing mechanics, and game-ending conditions like checkmate.
//	Graphical User Interface (GUI) Design: Utilize the Swing framework to design and implement a user-friendly and visually appealing interface for the chess game.
//	Event-Driven Programming: Manage user interactions through event listeners, enabling players to move pieces, respond to game states, and interact with the game dynamically.
//	Advanced State Management: Develop sophisticated game state management to handle the various states of a chess game, including tracking turns, game status, and special moves.
//	Problem-Solving: Demonstrate advanced problem-solving abilities in implementing chess rules, strategizing piece movements, and validating legal moves.
//	Best Practices in Java: Write clean, efficient, and well-structured Java code, following best practices for software design, maintainability, and GUI development.

	
}