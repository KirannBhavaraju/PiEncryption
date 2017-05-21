import java.awt.*;
import java.awt.event.*;
import java.io.*;
//import java.swing.*
;class Captcha extends Frame implements ActionListener
{
	int flag=0;
	String captcha="";
	String captchafin="";
	Button b1;
	TextField tf=new TextField();
	Captcha()	
	{
		add(tf,BorderLayout.SOUTH);
		Panel p=new Panel(new GridLayout(4,4));
		setSize(200,400);
		setTitle("Random Captcha Generation");
		b1=new Button("GENERATE");
		p.add(b1);
		add(p);	
     	b1.addActionListener(this);		
		setVisible(true);	
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1 && flag==0)
		{
			tf.setText("");
			captchafin=this.randomCaptcha();
			tf.setText(captchafin);
			captchafin="0";
			flag=1;
		}
		else
		{
			captchafin="\0";
		}
	}
	public String randomCaptcha()
	{
		try{
		FileReader input=new FileRead er("text.txt");
		int c;
		int counter=0;
		int fag=0;
		while((c=input.read())!=-1 && fag==0)
		{
			if(counter<5)
			{
				System.out.println(c);
				captcha=captcha+c;
				counter++;
			}
			else
			{
				fag=1;
				input.close();
				break;
			}
		}
		}
		catch(FileNotFoundException fe)
		{
				System.out.println("FileNotFoundException");
		}
		catch(IOException ae)
		{
				System.out.println("IOException");
		}
		return captcha;
	}
	
	public static void main(String[] args)
	{
		new Captcha();
	}
}