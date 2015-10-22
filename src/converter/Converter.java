/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

/**
 *
 * @author Edward T
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Converter extends JFrame implements ActionListener
{
	private 
		int i,r;
		JButton jbtgrade = new JButton("GRADE");
		JButton jbttemp = new JButton("C-K");
		JButton jbtfran = new JButton("C-F");
		JButton jbtadd =new JButton("ADD");
		JButton jbtarea =new JButton("AREA_C");
		JButton jbtmoney =new JButton("FOREX");
		JButton jbttranslate =new JButton("TRANSLATE");
                JButton jbtc = new JButton("REMOVE");
		char grade;
		int marks;
		int C;
		private final int X=273,Z=32; 
			private final double P=1.8;
	private JButton buttons[];
	private JTextArea field;
	private int num[];
	String output ="";
	private String buttonText = "789/456*123-0.=+";

  private double result = 0;

  private String operator = "";

  private boolean calculating = true;
  private String b;

	private JMenuItem jmiAbout = new JMenuItem("ABOUT US");
	JMenuItem jmiClose = new JMenuItem("CLOSE");
	public Converter()
	{
		num = new int[20];
		JPanel p4 = new JPanel();
    p4.setLayout(new GridLayout(4, 4));

    for (int i = 0; i < buttonText.length(); i++)
    	 {
      JButton b = new JButton(buttonText.substring(i, i + 1));
      p4.add(b);
       b.addActionListener(new ActionListener()
      {
      public void actionPerformed(ActionEvent e) 
      	{
    String cmd = e.getActionCommand();
    if ('0' <= cmd.charAt(0) && cmd.charAt(0) <= '9' || cmd.equals("."))
    	 {
      if (calculating)
        field.setText(cmd);
      else
        field.setText(field.getText() + cmd);
      calculating = false;
    } 
    	else
    		 {
      if (calculating) 
      	{
        if (cmd.equals("-"))
        	 {
          field.setText(cmd);
          calculating = false;
        }
         else
          operator = cmd;
      } 
      	else 
      		{
        double x = Double.parseDouble(field.getText());
        calculate(x);
        operator = cmd;
        calculating = true;
      }
    }
  }	
      });
      
     }
     
		JMenuBar jmb = new JMenuBar();
setJMenuBar(jmb);
	JMenu fileMenu = new JMenu("FILE");
  fileMenu.setMnemonic('F');
  fileMenu.add(jmiAbout= new JMenuItem("ABOUT US", 'A'));
jmb.add(fileMenu);
jmiAbout.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
			JOptionPane.showMessageDialog(null,"BASIC CONVERTER\nDESIGNED BY SLAU SOFTWARE COPERATION\nMEET US AT NAIRO AVENUE\nSLAU@gmail.COM\nWWW.SLAU SOFT.org");
	
				}
			});	
	JMenu exitMenu = new JMenu("EXIT");
  exitMenu.setMnemonic('X');
jmb.add(exitMenu);
exitMenu.add(jmiClose = new JMenuItem("CLOSE", 'C'));
jmiClose.addActionListener(new ActionListener()
 {
 public void actionPerformed(ActionEvent e) 
 	{
System.exit(0);
}
});
	field=new JTextArea(3,28);
JPanel p1 = new JPanel(new FlowLayout());
	p1.add(field);
JPanel p2 = new JPanel(new FlowLayout());	


JPanel p3 = new JPanel(new FlowLayout());



p3.add(jbtc);
jbtgrade.addActionListener(this);
setLayout(new BorderLayout(2,3));
				add(p1,BorderLayout.NORTH);
				add(p2,BorderLayout.EAST);
					add(p3,BorderLayout.SOUTH);
					add(p4,BorderLayout.CENTER);
					
				
				
				
		}
		public void actionPerformed(ActionEvent e)
		{
			
		int marks = Integer.parseInt(field.getText());

if(marks>=80 && marks<=100)
{
field.setText(String.valueOf("your grade is A\n\n COMMENT\n EXCELLENT"));

}
if(marks>=75 && marks<=79)
{
field.setText(String.valueOf("your grade is B+\n\n COMMENT\n VERY GOOD"));
}
if(marks>=70 && marks<=74)
{
field.setText(String.valueOf("your grade is B\n\n COMMENT\n GOOD"));
}
if(marks>=65 && marks<=69)
{
field.setText(String.valueOf("your grade is B-\n\n COMMENT\n FAIR GOOD"));
}
if(marks>=60 && marks<=64)
{
field.setText(String.valueOf("your grade is C+\n\n COMMENT\n FAIR"));
}
if(marks>=55 && marks<=59)
{
field.setText(String.valueOf("your grade is C\n\n COMMENT\n TRIED"));
}
if(marks>=50 && marks<=54)
{
field.setText(String.valueOf("your grade is C-\n\n COMMENT\n PULL UP"));
}if(marks>=0 && marks<=49)
{
field.setText(String.valueOf("your grade is F\n\n COMMENT\n WEAK\n you have to redo the paper\nRETAKE FEE-100000"));
}
if(marks<0 && marks>100)
{

field.setText(String.valueOf("NOT APPLICABLE"));	
}

		}
	 private void calculate(double n) {
    if (operator.equals("+"))
      result += n;
    else if (operator.equals("-"))
      result -= n;
    else if (operator.equals("*"))
      result *= n;
    else if (operator.equals("/"))
      result /= n;
    else if (operator.equals("="))
      result = n;
    field.setText("" + result);
  }
		public static void main(String args[])
		{
			Converter frame = new Converter();
			frame.setSize(400,300);
			frame.setTitle("CAROLINE SIMPLE CALCULATOR 2015 ");
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
		}
		
	}
