package chessGame;
import java.util.ArrayList;
import java.awt.*;

public class NullPiece extends chessPiece{
	
	public NullPiece() {
		super("--", 100, 100);
	}
	
	public ArrayList<Point> legalMoves(chessPiece[][] chessBoard, int row, int col){
		return new ArrayList<>();
	}

	public String getColor() {
		return color;
	}
	
	public String getName() {
		return "NullPiece";
	}
}