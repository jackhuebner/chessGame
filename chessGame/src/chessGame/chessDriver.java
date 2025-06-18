package chessGame;
public class chessDriver{
	public static void main(String[] args) {
		chessModel model = new chessModel();
		chessView view = new chessView();
		chessController controller = new chessController(model,view);
	}
}