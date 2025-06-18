package chessGame;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.awt.*;

public class chessModel {
	private String[][] chessBoard;
	private ArrayList moves;
	private LinkedHashMap<String,String> pieces;
	
	public chessModel(){
		this.pieces = new LinkedHashMap();
		this.chessBoard = new String[8][8];
		chessBoard[0] = new String[]{"bR", "bN","bB","bQ","bK","bB2","bN2","bR2"};
		chessBoard[1] = new String[]{"bP1","bP2","bP3","bP4","bP5","bP6","bP7","bP8"};
		chessBoard[6] = new String[]{"wP1","wP2","wP3","wP4","wP5","wP6","wP7","wP8"};
		chessBoard[7] = new String[]{"wR", "wN","wB","wQ","wK","wB2","wN2","wR2"};
		
		int k = 2;
		
		while (k<6) {
				chessBoard[k] = new String[]{"--","--","--","--","--","--","--","--"};
				k++;
		}
		int counter = 0;
		int emptyCounter = 0;
		for (int i = 0; i <=7; i++) {
			for (int j = 0; j<=7; j++) {
				String piece = chessBoard[i][j];
				if (i == 0) {
					if (piece.contains("R")) {
						pieces.put(piece,"img/chessPieces/black-rook");
					}
					else if(piece.contains("N")) {
						pieces.put(piece,"img/chessPieces/black-knight");
					}
					else if(piece.contains("B")) {
						pieces.put(piece,"img/chessPieces/black-bishop");
					}
					else if(piece.contains("Q")) {
						pieces.put(piece,"img/chessPieces/black-queen");
					}
					else if(piece.contains("K")) {
						pieces.put(piece,"img/chessPieces/black-king");
					}
				}
				else if(i==1) {
					pieces.put(piece, "img/chessPieces/black-pawn");
				}
				else if(i==6) {
					pieces.put(piece, "img/chessPieces/white-pawn");
				}
				else if (i == 7) {
					if (piece.contains("R")) {
						pieces.put(piece,"img/chessPieces/white-rook");
					}
					else if(piece.contains("N")) {
						pieces.put(piece,"img/chessPieces/white-knight");
					}
					else if(piece.contains("B")) {
						pieces.put(piece,"img/chessPieces/white-bishop");
					}
					else if(piece.contains("Q")) {
						pieces.put(piece,"img/chessPieces/white-queen");
					}
					else if(piece.contains("K")) {
						pieces.put(piece,"img/chessPieces/white-king");
					}
				}
				else{
					emptyCounter++;
					pieces.put("emptySlot" + emptyCounter,"--");
				}
			}
		}
		//matrix not necessary!
		//Eventually create a hashmap with the images
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
		
		ArrayList<Point> legalMoves = new ArrayList();
		//I pass the button clicked to over here,
		String piece = chessBoard[row][col];
		System.out.println(piece);
		if (piece.contains("P")) {
			for (int i = 0; i < 4; i++) {
				//errors with the perimeter of the board, and errors with space it moves to 
					if (piece.contains("w")){
						//so if the column above 
						//I SEE so the pieces by the white IS 7
						//so 
						
						int nextRow = row + (pawnMoves[i][0]*-1);
						int nextCol = col +(pawnMoves[i][1]*-1);
							if (nextRow < 8 && nextCol>= 0 && nextRow>=0 && nextCol < 8) {

								//here we are in spot 1, 6 of chessboard
								String potentialSpace = chessBoard[nextRow][nextCol];
								//have to check if the next will be 
								if(chessBoard[nextRow][nextCol].equals("--") && ((pawnMoves[i][0] == 1 && pawnMoves[i][1] == 0) || (pawnMoves[i][0] == 2))) {
									legalMoves.add(new Point(nextRow,nextCol));
								}
								else if(chessBoard[nextRow][nextCol].contains("b")) {
									legalMoves.add(new Point(nextRow,nextCol));
								}
							}
							
							//add the row and column it can move i
						//Can't hgihlihgt so it'll return the legal moves
					}
					else if(piece.contains("b")) {
						int nextRow =row + (pawnMoves[i][0]);
						int nextCol = col+(pawnMoves[i][1]);
						if (nextRow < 8 && nextCol>= 0 && nextRow>=0 && nextCol < 8) {
						String potentialSpace = chessBoard[nextCol][nextRow];
						if(chessBoard[nextRow][nextCol].equals("--") && ((pawnMoves[i][0] == 1 && pawnMoves[i][1] == 0) || (pawnMoves[i][0] == 2))) {
							legalMoves.add(new Point(nextRow,nextCol));
						}
						else if(chessBoard[nextRow][nextCol].contains("w")) {
							legalMoves.add(new Point(nextRow,nextCol));
						}
						}
					}
			}
		}
		// go back using polymorphism :)
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
		
		//so if the item they selected was blank.
		//so I can't move the 
		//need to consider where piece is on the board
		//
		
	}
	
	public void movePiece(int recentRow, int recentCol, int row, int col) {
		//so i take in orignal piece and the piece I want to replace
		
		//NEED to consider taking out opponents too!
		//
		
		String recentPieceSpace = chessBoard[recentCol][recentRow];
		System.out.println("RECENT PIECE:" + recentPieceSpace);
		String newPieceSpace = chessBoard[col][row];
		System.out.println("NEW PIECE: " + chessBoard[row][col]);
		System.out.println("ROW: " + row + "COL: " + col);

			//Then take it out!
			//Have to consider getting pieces back in ADD LATER (after eliminated)
			chessBoard[col][row] = recentPieceSpace;
			chessBoard[recentCol][recentRow] = newPieceSpace;		
		//NEED TO UNDERSTAND ROW/Col
		//so if selected the piece in the matrix goes to that position
		// so i take the legal move and move it to that spot.
		//to do that I need row and col of the current postion of piece and the column
		// it wants to move to.
	}
	
	public String[][] getBoard() {
		return chessBoard;
	}
	
	public LinkedHashMap<String,String> getPieces() {
		//String of having the piece and then linking it to the image
		return pieces;
	}
	//maybe return the point in the matrix
	
	//so need to design pieces moving
	// need to design the board
	
	//design piece movements 
	
	//store the mvoements in array list
	
	//so there is king, queen, pawn, knight, rook
	
	//
	
	
	
//	Game Logic Implementation: Craft the fundamental logic for chess, including piece movements, capturing mechanics, and game-ending conditions like checkmate.
//	Graphical User Interface (GUI) Design: Utilize the Swing framework to design and implement a user-friendly and visually appealing interface for the chess game.
//	Event-Driven Programming: Manage user interactions through event listeners, enabling players to move pieces, respond to game states, and interact with the game dynamically.
//	Advanced State Management: Develop sophisticated game state management to handle the various states of a chess game, including tracking turns, game status, and special moves.
//	Problem-Solving: Demonstrate advanced problem-solving abilities in implementing chess rules, strategizing piece movements, and validating legal moves.
//	Best Practices in Java: Write clean, efficient, and well-structured Java code, following best practices for software design, maintainability, and GUI development.

	
}