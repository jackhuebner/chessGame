package chessGame;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class chessView{
	private ArrayList<JButton> buttonList;
	private chessModel chessLogic;
	private JButton[][] buttonBoard;
	//so i have view, model and controller.
	//Controller allows me to click on button then i select where to move
	public chessView() {
		buttonBoard = new JButton[8][8];
		JFrame frame = new JFrame("Chess Game");
		frame.setSize(600,600);
		frame.setLocationRelativeTo(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		
		layeredPane.setPreferredSize(new Dimension(600,600));
		
		ImageIcon boardIcon = new ImageIcon("img/chessBoard.jpg");
		
		JLabel boardLabel = new JLabel(boardIcon);
		boardLabel.setBounds(0, 0, 600, 600);
		
		layeredPane.add(boardLabel,Integer.valueOf(0));
		//So the layered pane organizes what goes in front
		//Could add grid layout according to size of the chessBoard
		frame.setContentPane(layeredPane);		
		
		JPanel buttonPanel = new JPanel(new GridLayout(8,8));
		buttonPanel.setBounds(23,23,554,554);
		buttonPanel.setOpaque(false);
		layeredPane.add(buttonPanel, Integer.valueOf(1));
		
		this.chessLogic = new chessModel();
	
		//must add pictures to buttons (maybe where a hashmap is necessary
		// 64 being the items in the hashmap
		//Make background
		//69 by 69, if button is on top ()

		int row = 0;
		int col = 0;
		int images = 0;
		for(String image : chessLogic.getPieces().values()) {	
			
			//so 
			if (col % 8 == 0 && col>0) {
				col = 0;
				row++;
			}
			if(row == 8) {
				break;
			}
			
			JButton button = new JButton();
			
			if (!image.equals("--")) {
				ImageIcon originalIcon = new ImageIcon(image + ".png");
				Image scaledImage = originalIcon.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
				button = new JButton(new ImageIcon(scaledImage));
			}
			
			buttonPanel.add(button);
			button.setOpaque(false);                  
			button.setContentAreaFilled(false);
			button.setFocusPainted(false);
			buttonBoard[row][col] = button;
			//my buttonboard has 
			col++;
			//so I create a list of buttons and then pass trhough which button
			// I want to click 
		}
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
		frame.setVisible(true);
	}
	//MAKE THIS A CONSTRUCTOR AND NOT THE DRIVER CLASS
	public void highLighting(ArrayList<Point> legalMoves) {
		//So i have to pass in the button that was clicked
		//so I look at the legal moves and then highlight the buttons that
		//for (String move : chessLogic.highlightedMoves()) {
			
		//}
		//create button matrix with rows and cols
		for (Point square : legalMoves) {
		    buttonBoard[square.x][square.y].setContentAreaFilled(true);
			buttonBoard[square.x][square.y].setOpaque(true);
			buttonBoard[square.x][square.y].setBackground(new Color(144, 238, 144));
			//add a hashmap saying that it's highlighted
		}
		
	}
	
	public void unhighlight(ArrayList<Point> legalMoves) {
		for (Point square : legalMoves) {
		    buttonBoard[square.x][square.y].setContentAreaFilled(false);
			buttonBoard[square.x][square.y].setOpaque(false);
		}
	}
	
	public JButton[][] getButtons(){
		return buttonBoard;
	}
	
	public void updateBoard(int recentRow, int recentCol, int row, int col) {
				buttonBoard[col][row].setIcon(buttonBoard[recentCol][recentRow].getIcon());
				System.out.println(buttonBoard[recentCol][recentRow].getIcon());
				System.out.println("UPDATE!");
				buttonBoard[recentCol][recentRow].setIcon(null);
				//KEEP IN MIND col then row works for this to get the same location
		}
}