import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class GamePanel  extends JPanel{
	public static final double ACCEL = .5;
	int timer = 0;
	Timer mainTimer;
	public List<AttachmentRod> attachRods = new ArrayList<>();
	public List<AttachmentPoint> attachPoints = new ArrayList<>();
	boolean placeRod = true;
	AttachmentPoint tempPointHead = null;
	PopupListener popupListener;
	
	public GamePanel(){
		setFocusable(true);
		
		//creates the pop up menu
		CreatePopupMenu();
		
		//adds the keyboard listener for keyboard input
		addKeyListener(new KeyboardListener());
		
		//timer for updating game every 10 milliseconds
		mainTimer = new Timer(10, new TimerListener());
		mainTimer.start();
	}
	
	/**
	 * CreatePopupMenu class is only called when the gamePanel is created to instantiate the popup menu
	 */
	public void CreatePopupMenu() {
		setLayout(new BorderLayout());
		
        //Create the popup menu.
		MenuListener menuListener = new MenuListener();
        JMenuItem menuItem;
        menuItem = new JMenuItem("Button Text Here");
        menuItem.addActionListener(menuListener);
        JPopupMenu popup = new JPopupMenu();
        popup.add(menuItem);
 
        //Add listener to the text area so the popup menu can come up.
        popupListener = new PopupListener(popup);
        this.addMouseListener(popupListener);
        
//        JPanel buttonPane = new JPanel();
//		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
//		buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
//        
//		JButton rodButton = new JButton("Rod");
//		
//		buttonPane.add(Box.createHorizontalGlue());
//		buttonPane.add(rodButton);
//		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
//		
//		ButtonListener buttonListener = new ButtonListener(this);
//		rodButton.addActionListener(buttonListener);
//		
//		add(buttonPane, BorderLayout.PAGE_END);
    }
	
	/**
	 * Update Method, Action performed calls this to update game
	 */
	public void update(){
		for( int i = 0; i < attachRods.size(); i++){
			attachRods.get(i).update();
		}
	}
	
	/**
	 * Paint Method, Action performed repaint to paint the game
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
//		if(this.isFocusOwner()){
			for( int i = 0; i < attachRods.size(); i++){
				attachRods.get(i).paintComponent(g);
			}
			
			for( int i = 0; i < attachPoints.size(); i++){
				attachPoints.get(i).paintComponent(g);
			}
			
			if(!placeRod){
				Point mouseLoc = getMouseLocationOnComp();
				g.drawLine((int)tempPointHead.position[0], (int)tempPointHead.position[1], 
						mouseLoc.x, mouseLoc.y);
				g.drawOval(mouseLoc.x - 5, mouseLoc.y - 5, 10, 10);
			}
//		}
	}
	
	/**
	 * gets the mouse location of this component
	 * @return - point
	 */
	private Point getMouseLocationOnComp(){
		return new Point((int) (MouseInfo.getPointerInfo().getLocation().getX() - this.getLocationOnScreen().getX()), 
				(int) (MouseInfo.getPointerInfo().getLocation().getY() - this.getLocationOnScreen().getY()));
	}
	
	/**
	 * TimerListener class, implements ActionListener, this class only calls the update methods that
	 * run for every cycle/scene of the game
	 * 
	 * @author Preston Delano
	 */
	class TimerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			update();
			repaint();
			
//			if(timer >= 25){
//				timer = 0;
//				Random random = new Random();
//				double t1 = random.nextDouble() * 350;
//				
//				double[] position1 = {t1, 20};
//				TestObject temp = new TestObject(0.0, position1);
//				test.add(temp);
////				Creep tempCreep = new Creep(1.0, level.map.mapPath, 10.0, 1);
////				creeps.add(tempCreep);
////				timer = 0;
//			}
//			timer++;
		}
	}
	
	/**
	 * KeyboardListener class, implements ActionListener, this class is used when there is a key press,
	 * release, or type
	 * 
	 * @author Preston Delano
	 *
	 */
	class KeyboardListener implements KeyListener{
		@Override
		public void keyPressed(KeyEvent arg0) {
			
			int key = arg0.getKeyCode();
			
			if(key == KeyEvent.VK_SPACE){
//				Creep tempCreep = new Creep(1.0, level.map.mapPath, 10.0, 1);
//				creeps.add(tempCreep);
			}
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	}
	
	/**
	 * MenuListener class, implements ActionListener, this class is used when a menu item is selected,
	 * clicked or other things
	 * 
	 * @author Preston Delano
	 *
	 */
	class MenuListener implements ActionListener{
		
		/**
		 * ation performed, required for action listener
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(arg0.paramString().contains("Standard")){
//				
//				Point2D t = popupListener.GetPopupLocation();
//				double[] position = {t.getX(), t.getY()};
//				AttachmentRods temp = new AttachmentRods(0.0, position);
//				test.add(temp);
				
//				NewTower(ContentBank.TowerType.Standard);
			}/*
			if(arg0.paramString().contains("Fire")){
				NewTower(ContentBank.TowerType.Fire);
			}
			else if(arg0.paramString().contains("Ice")){
				NewTower(ContentBank.TowerType.Ice);
			}
			else if(arg0.paramString().contains("Poison")){
				NewTower(ContentBank.TowerType.Poison);
			}//*/
		}
	}
	
	/**
	 * PopupListener class, implements ActionListener, this is called when the user clicks anywhere, this is
	 * only used for right click for the popup at the momment
	 * 
	 * @author Preston Delano
	 *
	 */
	class PopupListener extends MouseAdapter{
		JPopupMenu popup;
		Point location = null;
		
		/**
		 * constructor for pop up listener
		 * @param popupMenu
		 */
	    PopupListener(JPopupMenu popupMenu) {
	        popup = popupMenu;
	    }
	    
	    /**
	     * getter for location of the pop up
	     * @return - point location
	     */
	    public Point GetPopupLocation(){
			return location;
		}
	    
	    /**
	     * mouse press method
	     */
	    public void mousePressed(MouseEvent e) {
	    	RodLogic(e);
	    }
	    
	    /**
	     * mouse release method
	     */
	    public void mouseReleased(MouseEvent e) {
	    	ShowPopup(e);
	    }
	    
	    /**
	     * the logic for placing the rods
	     */
	    private void RodLogic(MouseEvent e){
	    	if(e.getButton() == 1){
	    		Point t1 = getMouseLocationOnComp();
    			AttachmentPoint tPoint = GetAttachmentPoint(t1);
    			if(tPoint == null){
    				double[] t2 = {t1.getX(), t1.getY()};
	    			tPoint = new AttachmentPoint(.5, t2);
	    			attachPoints.add(tPoint);
    			}
	    		if(placeRod){
	    			placeRod = false;
	    			tempPointHead = tPoint;
	    		}else{
	    			placeRod = true;
	    			AttachmentRod tRod = new AttachmentRod(.5, tempPointHead, tPoint);
	    			attachRods.add(tRod);
	    			tempPointHead = null;
	    		}
	    	}
	    }
	    
	    /**
	     * logic for showing the pop up
	     * @param e - mouse event
	     */
	    private void ShowPopup(MouseEvent e) {
	        if (e.isPopupTrigger()) {
	            popup.show(e.getComponent(), e.getX(), e.getY());
	            location = new Point(e.getX(), e.getY());
	        }
	    }
	    
	    /**
	     * if there is an attachment point close to the click point it will return it
	     * @param clickLocation - click location
	     * @return - the attachment point close to the click point, or null
	     */
	    private AttachmentPoint GetAttachmentPoint(Point clickLocation){
	    	for(int i = 0; i < attachPoints.size(); i++){
	    		if(GetDistance(clickLocation, new Point((int)attachPoints.get(i).position[0], (int)attachPoints.get(i).position[1])) <= 10){
	    			return attachPoints.get(i);
	    		}
	    	}
	    	return null;
	    }
	    
	    /**
	     * returns distance in double
	     * @param obj1 - location of first object
	     * @param obj2 - location of second object
	     * @return - the distance in pixels (double)
	     */
	    private double GetDistance (Point obj1, Point obj2){
			double tempX = obj1.getX() - obj2.getX();
			double tempY = obj1.getY() - obj2.getY();
			
			return Math.sqrt(Math.pow(tempX, 2.0) + Math.pow(tempY, 2.0));
		}
	}
	
	/**
	 * MenuListener class, implements ActionListener, this class is used when a menu item is selected,
	 * clicked or other things
	 * 
	 * @author Preston Delano
	 *
	 */
	class ButtonListener implements ActionListener{
		GamePanel panelRef;
		
		/**
		 * constructor for button listener
		 * @param inRef - reference for game panel - not using right now
		 */
		public ButtonListener(GamePanel inRef){
			panelRef = inRef;
		}
		
		/**
		 * action performed method, required for action listener
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(arg0.paramString().contains("Rod")){
				
				System.out.println("stuffs");
				
				
				
			}
		}
	}
	
	
}
