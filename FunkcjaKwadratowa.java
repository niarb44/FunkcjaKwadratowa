
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;



public class FunkcjaKwadratowa extends JFrame{

	JLabel labelA = new JLabel("Podaj a:");
	JLabel labelB = new JLabel("Podaj b:");
	JLabel labelC = new JLabel("Podaj c:");

	JTextArea wynik = new JTextArea(); // okno wyniku
	
	JButton oblicz = new JButton("OBLICZ");
	
	JTextArea qpwo = new JTextArea(); // obiekt pomocniczy
	JTextArea qpwo1 = new JTextArea(); //obiekt pomocniczy2
	
	
	
	
	JTextField poleA = new JTextField(); //pole wpisania "a"
	JTextField poleB = new JTextField(); //pole wpiania "b"
	JTextField poleC = new JTextField(); //pole wpisania "c"

	
		

		
class ButtonListener implements ActionListener{	
public void actionPerformed(ActionEvent e){
		
		
	Object source = e.getSource();
	
		String tekst1 = "";
		String tekst2 = "";
		String tekst3 = "";

if(source == oblicz){


	String wartoscA = poleA.getText();
	String wartoscB = poleB.getText();
	String wartoscC = poleC.getText();


	double a = Double.parseDouble(wartoscA);
	double b = Double.parseDouble(wartoscB);
	double c = Double.parseDouble(wartoscC);


      double dwaA = a*2;
      double minusB = -b;
      double p = minusB / dwaA;

      

      
      
      double b_kw = Math.pow(b, 2);
      double cztery_a_c = 4 * a * c;
      double Delta = b_kw - cztery_a_c;		
      double minusDelta = -Delta;
      double cztery_a = 4*a;
      double q = minusDelta / cztery_a;

      
      
      double pierwiastekDelta = Math.sqrt(Delta);
      double dzialanie1 = minusB - pierwiastekDelta;
      double dzialanie2 = minusB + pierwiastekDelta;
       
	 String pWynik ="\"p\" wynosi: "+p;
     String qWynik ="\"q\""+" wynosi : "+q;
     String deltaWynik ="Delta wynosi : "+Delta;    
     String ogolnaWynik ="postac ogolna : y = "+a+"x^2 + "+b+"x + "+c;
     String yWynik ="punkt przeciecja z osia OY : (0;"+c+")";
     String xWynik = " ";
	 String wierzcholekWynik ="Wierzcholek : (" + p + ", " + q + ")";
	 String kanonicznaWynik = " ";
	 String tekstWynik = " ";

	 
if(p > 0 && q>0)

{    
 kanonicznaWynik ="postac kanoniczna : y = "+a+"( x - "+p+" )^2 + "+q;
}

else if(p <0 && q<0)

{
	double pp = -p;
	kanonicznaWynik ="postac kanoniczna : y = "+a+"( x + "+pp+" )^2 + "+q;
}	
else if(p>0 && q<0)
{
	kanonicznaWynik ="postac kanoniczna : y = "+a+"( x - "+p+" )^2 + "+q;
}
else if(p<0 && q>0)
{
	double pp = -p;
	kanonicznaWynik ="postac kanoniczna : y = "+a+"( x + "+pp+" )^2 + "+q;
}

if (Delta > 0) 

{
      double x1 = dzialanie1/dwaA;
      double x2 = dzialanie2/dwaA;
      tekst1 = "Miejsca zerowe :";
      tekst2 = "* x1 = "+x2;
      tekst3 = "* x2 = "+x1;
	  xWynik ="punkt przeciecja z osia OX : ("+x2+";0); ("+x1+";0)";	
	  tekstWynik +=  "\n" + tekst1 + "\n" + tekst2 + "\n" + tekst3 + "\n" + xWynik ;
	String iloczynowaWynik = " ";
	
	if (Delta  >= 0) {
		double x11 = -x1;
		double x22 = -x2;
		
		if(x1>0 && x2>0)
{   
		iloczynowaWynik = "postac iloczynowa : y = " + a + "(x" + x22 + ") * (x" + x11 + ")";
}
		else if(x1>0 && x2<0)
{
		iloczynowaWynik = "postac iloczynowa : y = " + a + "(x+" + x22 + ") * (x" + x11 + ")";			
}
		else if(x2<0 && x1<0)
{
		iloczynowaWynik = "postac iloczynowa : y = " + a + "(x+" + x22 + ") * (x+" + x11 + ")";
}
		else if(x2>0 && x1<0)
{
		iloczynowaWynik = "postac iloczynowa : y = " + a + "(x" + x22 + ") * (x+" + x11 + ")";
}//


      	
		tekstWynik += "\n" + iloczynowaWynik; 
	
	}
      
    }

else if (Delta == 0) 

{
      double deltaZero=minusB / dwaA;
	  xWynik ="punkt przeciecja z osia OX : ("+deltaZero+";0);";	
      tekst1 += "\n" + "Miejsce zerowe :" + "\n" + "x0 " + deltaZero + "\n" + xWynik ;
	  tekstWynik += tekst1;	  
}

else if (Delta < 0) 

{
    tekstWynik += "Funkcja nie ma miejsc zerowych (rozwiazan)" + "\nnie ma przeciecia z osia OX";
	}

if  (a < 0) 

{

	  qpwo1.setText("Ramiona paraboli skierowane w dol" + "\n" + "funkcja rosnaca dla XE (- nieskonczonosc;"+c+")" + "\n" + "funkcja malejaca dla XE ("+c+";+ nieskonczonosc)");
}

if  (a > 0) 

{
    qpwo1.setText("Ramiona paraboli skierowane w gore" + "\n" + "funkcja malejaca dla XE (- nieskonczonosci;"+c+")" + "\n" + "funkcja rosnaca dla XE ("+c+";+ nieskonczonosci)");
	//grr += "\n" + qpwo1.getText();
}
	
	
String kla = qpwo1.getText();	
	qpwo.setText("\n" + ogolnaWynik + "\n" + kanonicznaWynik + "\n" + pWynik + "\n" + qWynik + "\n" + deltaWynik + "\n" + wierzcholekWynik + "\n" + kla + "\n" + yWynik); 
	tekstWynik += qpwo.getText();
	wynik.setText(tekstWynik);
				

}	

}

}

private ButtonListener alll = new ButtonListener();
public FunkcjaKwadratowa(){
	
	oblicz.addActionListener(alll);
	
		JPanel panell = new JPanel();
	panell.setLayout(new GridLayout(1, 6));
	panell.add(labelA);
	panell.add(poleA);
	panell.add(labelB);
	panell.add(poleB);
	panell.add(labelC);
	panell.add(poleC);
	
	labelA.setFont(new Font("Courier New", Font.ITALIC, 20));
	labelB.setFont(new Font("Courier New", Font.ITALIC, 20));
	labelC.setFont(new Font("Courier New", Font.ITALIC, 20));
	//aa.setForeground(Color.BLUE);
	
	poleA.setBackground(Color.PINK);
	poleB.setBackground(Color.PINK);
	poleC.setBackground(Color.PINK);
	poleA.setFont(new Font("Courier New", Font.BOLD, 16));
	poleB.setFont(new Font("Courier New", Font.BOLD, 16));	
	poleC.setFont(new Font("Courier New", Font.BOLD, 16));	
	
		JPanel panel2 = new JPanel();
	panel2.setLayout(new GridLayout());
	panel2.add(oblicz);
	
		/*JPanel panel3 = new JPanel();
	panel3.setLayout(new GridLayout());
	panel3.add(yy);
	yy.setPreferredSize(new Dimension(750, 240));*/
	
	wynik.setBackground(Color.LIGHT_GRAY);	
	wynik.setForeground(Color.BLACK);
	wynik.setFont(new Font("Courier New", Font.BOLD, 15));	
	
	oblicz.setFont(new Font("Courier New", Font.BOLD, 24));
	//zz.setForeground(Color.RED);

	JScrollPane scroll = new JScrollPane(wynik);
	scroll.setPreferredSize(new Dimension(750, 270));
	scroll.setBackground(Color.LIGHT_GRAY);

	
		setLayout(new BorderLayout());
	add(panell, BorderLayout.NORTH);
	add(panel2, BorderLayout.CENTER);
	add(scroll, BorderLayout.SOUTH);
	//add(new JScrollPane(yy));
	setPreferredSize(new Dimension(800, 555));
	setLocation(100, 100);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
	setVisible(true);

}

 public static void main(String[] args){
	         EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FunkcjaKwadratowa();
            }
        });
 }

}
