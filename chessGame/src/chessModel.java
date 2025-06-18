import java.util.ArrayList;
import java.util.LinkedHashMap;

public class model {
	private String[][] chessBoard;
	private ArrayList moves;
	private LinkedHashMap<String,String> pieces;
	
	public model(){
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
	
	public String highlightedMoves(String piece, int row, int col) {	
		int[][] pawnMoves = {{0,2},{0,1},{1,1},{-1,1}};
		int[][] knightMoves = {{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},
								{2,-1},{2,1}};
		int[][] bishopMoves = {{1,1},{-1,1},{-1,-1},{1,-1}};
		int[][] queenMoves = {{1,1},{-1,1},{-1,-1},{1,-1},{0,1},{-1,0},
								{1,0},{0,-1}};
		int[][] krMoves = {{0,1},{-1,0},{1,0},{0,-1}};
		
		if (piece.contains("P")) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j<2; j++) {
					if (piece.contains("w")){
						String potentialSpace = chessBoard[row+i][col+j];
						if(potentialSpace.equals("--") || (potentialSpace.contains("b") && col+j == 0)){
							//highlight the space
						}
					}
					else if(piece.contains("b")) {
						String potentialSpace = chessBoard[(row*-1)+i][(col*-1)+j];
						if(potentialSpace.equals("--") || (potentialSpace.contains("w") && (col*-1)+j == 0)){
							//highlight the space
						}
					}
				}
			}
		}
		//maybe go back using polymorphism :)
		else if(piece.contains("N")) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j<2; j++) {
					if (piece.contains("w")){
						String potentialSpace = chessBoard[row+i][col+j];
						if(potentialSpace != null){
							//highlight the space
							//well it can move anywhere it looks! except the null spaces
							//
						}
					}
					else if(piece.contains("b")) {
						String potentialSpace = chessBoard[row+(i*-1)][col+(j*-1)];
						if(potentialSpace != null){
							//highlight the space
						}
					}
				}
			}
		}
		
		//depends whther or not continuing going down 
		else if(piece.contains("B")) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j<2; j++) {
					if (piece.contains("w")){
						String potentialSpace = chessBoard[row+i][col+j];
						
						int nextRow = row+i;
						int nextCol = col+j;
						//say im next to a white 
						if (potentialSpace.equals("--")) {
							// highlight the space but keep going 
							while (potentialSpace.equals("--")){
								potentialSpace = chessBoard[nextRow][nextCol];
								if (potentialSpace.contains("b")) {
									//highlight the space
								}
								nextRow+=i;
								nextCol+=j;
							}
						}
						else if(potentialSpace.contains("b")) {
							//highlight capturing space
						}
						// but add something for it to keep going
						
					}
					else if(piece.contains("b")) {
						String potentialSpace = chessBoard[row+(i*-1)][col+(j*-1)];
						int nextRow = row+(i*-1);
						int nextCol = col+(j*-1);
						//say im next to a white 
						if (potentialSpace.equals("--")) {
							// highlight the space but keep going 
							while (potentialSpace.equals("--")){
								potentialSpace = chessBoard[nextRow][nextCol];
								if (potentialSpace.contains("w")) {
									//highlight the space
								}
								nextRow+=(i*-1);
								nextCol+=(j*-1);
							}
						}
						else if(potentialSpace.contains("w")){
							//Highlight Space 
						}
					}
				}
			}
		}
		
		else if(piece.contains("Q")) {
			//if the piece contains a queen 
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j<2; j++) {
					if (piece.contains("w")){
						String potentialSpace = chessBoard[row+i][col+j];
						int nextRow = row+i;
						int nextCol = col+j;
						
						if (potentialSpace.equals("--")){
							//highlight the space but keep going
							while (potentialSpace.equals("--")) {
								potentialSpace = chessBoard[nextRow][nextCol];
								if (potentialSpace.contains("b")) {
									//highlight space
								}
								nextRow+=i;
								nextCol+=j;
							}
						}
						else if (potentialSpace.contains("b")) {
							//HighlightSpace
						}
					}
					else if (piece.contains("b")) {
						String potentialSpace = chessBoard[row+i][col+j];
						int nextRow = row+i;
						int nextCol = col+j;
						
						if (potentialSpace.equals("--")){
							//highlight the space but keep going
							while (potentialSpace.equals("--")) {
								potentialSpace = chessBoard[nextRow][nextCol];
								if (potentialSpace.contains("w")) {
									//highlight space
								}
								nextRow+=i;
								nextCol+=j;
							}
						}
						else if (potentialSpace.contains("w")) {
							//HighlightSpace
						}
					}
				}
			}
		}
		
		else if(piece.contains("K")) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j<2; j++) {
					if (piece.contains("w")) {
						String potentialSpace = chessBoard[row+i][col+j];
						if (potentialSpace.equals("--") || potentialSpace.contains("b")) {
							//highlight space
						}
					}
					else if (piece.contains("b")) {
						String potentialSpace = chessBoard[row+i][col+j];
						if (potentialSpace.equals("--") || potentialSpace.contains("w")) {
							//highlight space
						}
					}
				}
			}
		}
		
		//work on this 
	
		else if(piece.contains("R")) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j<2; j++) {
					if (piece.contains("w")) {
						String potentialSpace = chessBoard[row+i][col+j];
						if (potentialSpace.equals("--")) {
							//highlight space
						}
						else if(potentialSpace.contains("b")) {
							
						}
					}
					else if (piece.contains("b")) {
						String potentialSpace = chessBoard[row+i][col+j];
						if (potentialSpace.equals("--") || potentialSpace.contains("w")) {
							//highlight space
						}
					}
				}
			}
		}
		
		//so if the item they selected was blank.
		//so I can't move the 
		//need to consider where piece is on the board
		//
		
	}
	
	public String movePiece(String piece) {
		//so i take in orignal piece and the piece I want to replace
		return piece;
	}
	
	public LinkedHashMap<String,String> getPieces() {
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