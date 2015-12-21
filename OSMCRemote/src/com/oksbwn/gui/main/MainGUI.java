package com.oksbwn.gui.main;

import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.oksbwn.osmc.ClickManager;
import com.oksbwn.server_activity.SendData;

public class MainGUI extends Thread{
	private JFrame frame= new JFrame();
	JButton exit;
	JButton shutDown;
	private int buttonHeight;
	private int buttonWidth;
	private int buttonMarginHeight;
	private int buttonMarginWidth;
	final JEditorPane pane[]=new JEditorPane[20];
	ClickManager clm= new ClickManager(); 
	private JEditorPane detailsPane= new JEditorPane();
	private boolean isOn=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainGUI();
	}
	public MainGUI(){
		start();
	}
	public void run(){
		try {
			isOn=InetAddress.getByAddress(new byte[]{(byte) 192,(byte) 168,0,100}).isReachable(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		init();
		if(isOn){
			clm.clickedOn(17);
			detailsPane.removeAll();
			detailsPane.setText(clm.checkCurrent());
			detailsPane.repaint();
		}

		
		getImageButton(0,"redoo", buttonMarginWidth, 3*buttonMarginHeight+2*buttonHeight, true);
		getImageButton(12,"home", buttonMarginWidth*3+buttonWidth*2, 3*buttonMarginHeight+2*buttonHeight, true);
		
		getImageButton(1,"up", buttonMarginWidth*2+buttonWidth, 3*buttonMarginHeight+2*buttonHeight, true);
		getImageButton(2,"down", buttonMarginWidth*2+buttonWidth, 5*buttonMarginHeight+4*buttonHeight, true);
		getImageButton(3,"right", buttonMarginWidth, 4*buttonMarginHeight+3*buttonHeight, true);
		getImageButton(5,"dot", buttonMarginWidth*2+buttonWidth, 4*buttonMarginHeight+3*buttonHeight, true);
		getImageButton(4,"left",buttonMarginWidth*3+buttonWidth*2, 4*buttonMarginHeight+3*buttonHeight, true);
		

		getImageButton(6,"back", buttonMarginWidth, 6*buttonMarginHeight+5*buttonHeight, true);
		getImageButton(7,"play", buttonMarginWidth*2+buttonWidth, 6*buttonMarginHeight+5*buttonHeight, true);
		getImageButton(8,"next", buttonMarginWidth*3+buttonWidth*2, 6*buttonMarginHeight+5*buttonHeight, true);
		getImageButton(9,"rewind", buttonMarginWidth, 7*buttonMarginHeight+6*buttonHeight, true);
		getImageButton(10,"pause", buttonMarginWidth*2+buttonWidth, 7*buttonMarginHeight+6*buttonHeight, true);
		getImageButton(11,"forward", buttonMarginWidth*3+buttonWidth*2, 7*buttonMarginHeight+6*buttonHeight, true);
		

		getImageButton(13,"voldown", buttonMarginWidth, 8*buttonMarginHeight+7*buttonHeight, true);
		getImageButton(14,"mute", buttonMarginWidth*2+buttonWidth, 8*buttonMarginHeight+7*buttonHeight, true);
		getImageButton(15,"volup", buttonMarginWidth*3+buttonWidth*2, 8*buttonMarginHeight+7*buttonHeight, true);
		frame.setVisible(true);
	}
	
	
	private JEditorPane getImageButton(final int i,String image, int x, int y,boolean isEffect) {
		try {
			pane[i]= new JEditorPane();
			pane[i].setContentType("text/html");
			URL url= new File("C:/Alberto/desktopApp/osmc/"+image+".png").toURI().toURL();
			pane[i].setText("<html><img src="+url+" width=\""+buttonWidth+"\" height=\""+buttonHeight+"\"></img><br><b><i>Add Food Name</i></b></html>");
			pane[i].setBorder(BorderFactory.createMatteBorder(0,0, 0, 0, Color.black));
			pane[i].setEditable(false);
			pane[i].setFocusable(false);
			pane[i].setOpaque(false);
			pane[i].setBounds(x,y,buttonWidth,buttonHeight);
			pane[i].setBackground(new Color(Color.WHITE.getRed(), Color.WHITE.getGreen(),Color.WHITE.getBlue(),0));
			if(isEffect)
			pane[i].addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					clm.clickedOn(i);
					clm.clickedOn(17);
					detailsPane.setText(clm.checkCurrent());
					detailsPane.repaint();
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					pane[i].setBorder(BorderFactory.createMatteBorder(1,1, 1, 1, Color.black));
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					pane[i].setBorder(BorderFactory.createMatteBorder(0,0, 0, 0, Color.black));
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					pane[i].setBorder(BorderFactory.createMatteBorder(2,2, 2, 2, Color.BLUE));
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					pane[i].setBorder(BorderFactory.createMatteBorder(0,0, 0, 0, Color.black));
				}
				
			});
			frame.getContentPane().add(pane[i]);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pane[i];
	}
	private JButton getButton(String text, int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		JButton button = new JButton(text);
		button.setBounds(i, j, k, l);
		frame.getContentPane().add(button);
		return button;
	}
	private void init(){
      	frame.setUndecorated(true);
		frame.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),1));
		if(isOn)
	    	frame.getContentPane(). setBackground(new Color(Color.white.getRed(), Color.white.getGreen(),Color.white.getBlue(),40));
		else
	    	frame.getContentPane(). setBackground(new Color(Color.RED.getRed(), Color.RED.getGreen(),Color.RED.getBlue(),40));

        frame.setBounds(200,100,200,400);
    	frame.getContentPane().setLayout(null);
    	frame.addMouseListener(mouseListener);
  	  	frame.addMouseMotionListener(mouseListener);
  	  	frame.setType(Type.UTILITY);
  	  	frame.setAlwaysOnTop(true);
    	((JComponent)frame.getContentPane()).setBorder(BorderFactory.createMatteBorder( 1, 1, 1, 1, Color.black ) );

		exit= getButton("Exit",frame.getWidth()-70,frame.getHeight()-30,60,25);
		exit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		if(isOn)
			shutDown= getButton("Shutdown",frame.getWidth()-180,frame.getHeight()-30,100,25);
		else
			shutDown= getButton("Turn On",frame.getWidth()-180,frame.getHeight()-30,100,25);
		shutDown.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//clm.shutDown();

			if(isOn){
				Object[] choices = {"Shutdown", "Reboot","CANCEL"};
				Object defaultChoice = choices[0];
				int x=JOptionPane.showOptionDialog(null,
			             "Select one of the values",
			             "Title message",
			             JOptionPane.YES_NO_CANCEL_OPTION,
			             JOptionPane.QUESTION_MESSAGE,
			             null,
			             choices,
			             defaultChoice);
				if(x==0){
					clm.shutDown();
					frame.dispose();
					new SendData().sendPost("http://192.168.0.1/smart_home/API/utilities_all/xbmc/turnOn.php", new String[]{"WHAT","DEVICE"},new String[]{"0","desktop_app"});
				}
				else if(x==1)
					clm.reboot();

				System.out.println(x);
			}
			else{
				new SendData().sendPost("http://192.168.0.1/smart_home/API/utilities_all/xbmc/turnOn.php", new String[]{"WHAT","DEVICE"},new String[]{"1","desktop_app"});
			
				isOn=true;
				shutDown.setText("Shutdown");
			}
			}
		});
		buttonHeight=frame.getHeight()/10;
		buttonWidth=frame.getWidth()/4;
		
		buttonMarginHeight=buttonHeight/10;
		buttonMarginWidth=buttonWidth/4;
		
		detailsPane.setBounds(buttonMarginWidth,buttonMarginHeight,buttonWidth*3+2*buttonMarginWidth,buttonHeight*2+buttonMarginHeight);
		//detailsPane. setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),20));
		detailsPane.setEditable(false);
		//detailsPane.setOpaque(false);
		detailsPane.setFocusable(false);
		//detailsPane.set
		detailsPane.setForeground(Color.BLACK);
		frame.getContentPane().add(detailsPane);
	}

final MouseAdapter mouseListener = new MouseAdapter() {
    int x, y;
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            x = e.getX();
            y = e.getY();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
        	frame. setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
        }
    }
};
}

