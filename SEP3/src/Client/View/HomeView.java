package Client.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

import Client.Controller.Controller;

public class HomeView extends JFrame {

	   private static final int WINDOW_WIDTH = 1000;
	   private static final int WINDOW_HEIGHT = 600;  
	   
	   public HomeView()
	   {
		   super("Chat Me Up Bro!");
		   
		   initializeComponents();
		   addComponents(getContentPane());
		   
	   }
	   
	   //Buttons
	   private static JButton sendButton;
	   private static JButton calculateButton;
	   private static JButton scrabbleButton;
	   private static JButton bookingButton;
	   private static JButton musicButton;
	   private static JButton jokesButton;
	   
	   //Text Displayer
	   public static JTextArea messageWindow;
	   public static JTextArea chatWindow;
	   
	   //Actions
	   private static Action enterAction = new AbstractAction()
	   {

		@Override
		public void actionPerformed(ActionEvent e)
		{
			Controller.sendMessage();
		}
	   };
	   
	   
	   private static void addComponents(Container panel)
	   {
	   panel.setLayout(new GridBagLayout());
	   GridBagConstraints c = new GridBagConstraints();
	   
	   //Fonts
	   Font chatFont = new Font("Verdana", Font.PLAIN, 14);
	   Font buttonFont = new Font("Verdana", Font.BOLD, 12);
	   
	   //Dimensions
//	   Dimension messageDimensions = new Dimension(695, 700);
//	   Dimension chatDimensions = new Dimension(695, 270);
	   
	   messageWindow = new JTextArea("Tell us your name.");
	   messageWindow.setFont(chatFont);
	   messageWindow.setLineWrap(true);
	   messageWindow.setEditable(false);
	   JScrollPane messageScroll = new JScrollPane(messageWindow);
	   messageScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	   c.fill = GridBagConstraints.BOTH;
	   c.insets = new Insets(5, 5, 0, 300);
	   c.gridx = 0;
	   c.gridy = 0;
	   c.gridwidth = 3;
	   c.gridheight = 5;
	   c.weightx = 0.5;
	   c.weighty = 0.5;
	   panel.add(messageScroll, c);
	   
	   chatWindow = new JTextArea();
	   chatWindow.setFont(chatFont);
	   chatWindow.setLineWrap(true);
	   JScrollPane chatScroll = new JScrollPane(chatWindow);
	   chatScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	   c.fill = GridBagConstraints.BOTH;
	   c.insets = new Insets(25, 5, 5, 300);
	   c.gridx = 0;
	   c.gridy = 5;
	   c.gridwidth = 3;
	   c.gridheight = 1;
	   c.weightx = 0.5;
	   c.weighty = 0.5;
	   panel.add(chatScroll, c);
	   
	   //Change enter key binding on chat window
	   int condition = JComponent.WHEN_FOCUSED;
	   InputMap im = chatWindow.getInputMap(condition);
	   ActionMap am = chatWindow.getActionMap();
	   im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "ENTER");
	   am.put("ENTER", enterAction);
	   
	   sendButton = new JButton("Send Message");
	   sendButton.setFont(buttonFont);
	   c.fill = GridBagConstraints.HORIZONTAL;
	   c.insets = new Insets(25, 710, 0, 3);
	   c.gridx = 1;
	   c.gridy = 5;
	   c.gridwidth = 1;
	   c.gridheight = 1;
	   c.weightx = 0.5;
	   c.weighty = 0.5;
	   panel.add(sendButton, c);
	   
	   calculateButton = new JButton("Calculate Shit!");
	   calculateButton.setFont(buttonFont);
	   c.fill = GridBagConstraints.BOTH;
	   c.insets = new Insets(5, 710, 1, 3);
	   c.gridx = 1;
	   c.gridy = 0;
	   c.gridwidth = 1;
	   c.gridheight = 1;
	   c.weightx = 0.5;
	   c.weighty = 0.5;
	   panel.add(calculateButton, c);
	   
	   jokesButton = new JButton("Hear Some Jokes.");
	   jokesButton.setFont(buttonFont);
	   c.fill = GridBagConstraints.BOTH;
	   c.insets = new Insets(1, 710, 1, 3);
	   c.gridx = 1;
	   c.gridy = 1;
	   c.gridwidth = 1;
	   c.gridheight = 1;
	   c.weightx = 0.5;
	   c.weighty = 0.5;
	   panel.add(jokesButton, c);
	   
	   bookingButton = new JButton("Book Some Stuff.");
	   bookingButton.setFont(buttonFont);
	   c.fill = GridBagConstraints.BOTH;
	   c.insets = new Insets(1, 710, 1, 3);
	   c.gridx = 1;
	   c.gridy = 2;
	   c.gridwidth = 1;
	   c.gridheight = 1;
	   c.weightx = 0.5;
	   c.weighty = 0.5;
	   panel.add(bookingButton, c);
	   
	   musicButton = new JButton("Play Musica.");
	   musicButton.setFont(buttonFont);
	   c.fill = GridBagConstraints.BOTH;
	   c.insets = new Insets(1, 710, 1, 3);
	   c.gridx = 1;
	   c.gridy = 3;
	   c.gridwidth = 1;
	   c.gridheight = 1;
	   c.weightx = 0.5;
	   c.weighty = 0.5;
	   panel.add(musicButton, c);
	   
	   scrabbleButton = new JButton("Scrabble Help.");
	   scrabbleButton.setFont(buttonFont);
	   c.fill = GridBagConstraints.BOTH;
	   c.insets = new Insets(1, 710, 1, 3);
	   c.gridx = 1;
	   c.gridy = 4;
	   c.gridwidth = 1;
	   c.gridheight = 1;
	   c.weightx = 0.5;
	   c.weighty = 0.5;
	   panel.add(scrabbleButton, c);
	   }
	   
	   private void initializeComponents()
	   {
		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		   
		   setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		   setLocationRelativeTo(null);
	   }
	   
	   public void start(ActionListener controller)
	   {
		   sendButton.addActionListener(controller);
		   calculateButton.addActionListener(controller);
		   bookingButton.addActionListener(controller);
		   musicButton.addActionListener(controller);
		   scrabbleButton.addActionListener(controller);
		   jokesButton.addActionListener(controller);
	   }
	   public void stop(ActionListener controller)
	   {
		   sendButton.removeActionListener(controller);
		   calculateButton.removeActionListener(controller);
		   bookingButton.removeActionListener(controller);
		   musicButton.removeActionListener(controller);
		   scrabbleButton.removeActionListener(controller);
		   jokesButton.removeActionListener(controller); 
	   }
}
