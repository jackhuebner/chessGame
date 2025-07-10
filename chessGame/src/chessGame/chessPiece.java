package chessGame;
import java.util.ArrayList;
import java.awt.*;

public abstract class chessPiece{
	protected String color;
	protected int row, col;
	
	public chessPiece(String color, int row, int col) {
		this.color = color;
		this.row = row;
		this.col = row;
	}
	
	public abstract ArrayList<Point> legalMoves(chessPiece[][] chessBoard, int row, int col);

	public String getColor() {
		return color;
	}
	
	public String getName() {
		return "Piece";
	}
	
}