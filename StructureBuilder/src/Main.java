import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
//		ContentBank.ContentLoader();
		JFrame frame = new JFrame();
		GamePanel gameFrame = new GamePanel();
		frame.setSize(350, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(gameFrame);
		frame.setVisible(true);
	}

}
