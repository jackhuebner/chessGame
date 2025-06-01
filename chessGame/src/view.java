import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class view{
	public static void main(String[] args) {
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
		//JLayered - organizes elements on the 
		//JFrame - the house
		//JPanel - room inside the house (deals with buttons?)
		//JLabel - images hung up in the house
		
		
		
		//can't use gridlayout (must have spaces around it saying: black's turn
		// etc.
		ArrayList<JButton> buttonList = new ArrayList();
		model chessLogic = new model();
	
		//must add pictures to buttons (maybe where a hashmap is necessary
		// 64 being the items in the hashmap
		//Make background
		//69 by 69, if button is on top ()
		
		int counter = 0;
		for(String image : chessLogic.getPieces().values()) {	

			JButton button = new JButton();
			ImageIcon originalIcon = new ImageIcon(image + ".png");
			
			Image scaledImage = originalIcon.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
			
			if (!image.equals("--")) {
				button = new JButton(new ImageIcon(scaledImage));
			}
			buttonPanel.add(button);
			button.setOpaque(false);                  
			button.setContentAreaFilled(false);
			button.setFocusPainted(false);
			buttonList.add(button);
		}
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
		frame.setVisible(true);
	}
	//MAKE THIS A CONSTRUCTOR AND NOT THE DRIVER CLASS
}