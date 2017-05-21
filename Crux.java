import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font; 
import java.awt.AWTEventMulticaster;
import java.awt.event.*;
import java.security.KeyPairGenerator;
import java.security.KeyPairGeneratorSpi;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.security.Security;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import java.util.Random;
import java.nio.*;
import java.math.BigInteger;
import java.math.*;
class CropImage
	{
		public static Long rdtscno=0L;
	public void cropBufferedImage(BufferedImage image)
	{
		try{
			System.out.println("Running Entropy Generation");
			Process probject= Runtime.getRuntime().exec("a.exe");
			System.out.println("Entropy Generation Complete");
			System.out.println("File Entropy.txt Created and can be used for reference");
			int s,t;
			int thid=0,pid=0;
			Long upt= 0L;
			
			String temp="";
			String uptime="";
			String threadid="";
			String prid="";
			String rdtsc="";
			//boolean 1;
			//boolean 2;
			//1= TRUE;
			//2= FALSE;
			FileReader input=new FileReader("Entropy.txt");
			BufferedReader breader=new BufferedReader(input);
			s=0;
			while((temp=breader.readLine())!=null)
			{
				if(s==0)
				{
					uptime=uptime+temp;
					//uptime=uptime+'\n';
					s++;
				}
				else if(s==1)
				{
					threadid=threadid+temp;
					s++;
				}	
				else if(s==2)
				{
					prid=prid+temp;
					s++;
				}
				else if(s==3)
				{
					rdtsc=rdtsc+temp;
					s++;
				}
			}
			Dimension dsize=Toolkit.getDefaultToolkit().getScreenSize();
			double dwidth=dsize.getWidth();
			double dheight=dsize.getHeight();
			System.out.println(uptime);
			System.out.println(threadid);
			System.out.println(prid);
			System.out.println(rdtsc);
			breader.close();
			upt=Long.valueOf(uptime);
			thid=Integer.parseInt(threadid);
			pid=Integer.parseInt(prid);
			rdtscno=Long.valueOf(rdtsc);
			int max1=(int)(dwidth/2);
			int max2=(int)(dheight/2);
			BufferedImage croppedImage= image.getSubimage((thid%max1),(pid%max2),(int)(upt%max1),(int)(rdtscno%max2));
			ImageIO.write(croppedImage,"jpg",new File("Crop1.jpg"));
			//ImageIO.write(croppedImage,"jpg",new File("Test_100.jpg"));
			System.out.println("Image Cropped");
			}
			catch(IOException exceptionobject)
			{
				System.out.println(exceptionobject);
			}
			GetChars objectSnitcher= new GetChars();
			objectSnitcher.snitch();
	}
}
class GetChars
{
	public void snitch()
	{
	try{
		Process probject= Runtime.getRuntime().exec("C:/Users/Kirann Bhavaraju/Desktop/Capstone/Dump/runMatlab.bat");
		System.out.println("Waiting for Simulinks execution to Complete");
		System.out.println("...........................................");
		Thread.sleep(8000);
	}
	catch(IOException exceptionobject)
			{
				System.out.println(exceptionobject);
			}
	catch(InterruptedException exceptionobject)
			{
				System.out.println(exceptionobject);
			}		
	Encryptor eventencryption=new Encryptor();
	}		

}
class Encryptor
{
		//Initial encryption Layer 1 RSA before byte encryption using PI-Cryptosuite.
		private static final String ALGORITHM = "RSA";
		public static byte[] encrypt(byte[] publicKey, byte[] inputData) throws Exception 
		{
        PublicKey key = KeyFactory.getInstance(ALGORITHM).generatePublic(new X509EncodedKeySpec(publicKey));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.PUBLIC_KEY, key);
        byte[] encryptedBytes = cipher.doFinal(inputData);
        return encryptedBytes;
	    }

	    //Final Decryption Layer 4 RSA after decryption of PI-CryptoSuite.
	    public static byte[] decrypt(byte[] privateKey, byte[] inputData) throws Exception 
    	{
        PrivateKey key = KeyFactory.getInstance(ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(privateKey));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.PRIVATE_KEY, key);
        byte[] decryptedBytes = cipher.doFinal(inputData);
        return decryptedBytes;
    	}
	Encryptor()
	{   
		String message="";	
		String magicnumber="";
		String tempx="";
		String tempy="";
		try
		{
		KeyPairGenerator keyGenerator= KeyPairGenerator.getInstance(ALGORITHM);
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
		keyGenerator.initialize(1024,random);
		KeyPair pair=keyGenerator.generateKeyPair();
		byte[] publicGen = pair.getPublic().getEncoded();
        byte[] privateGen =pair.getPrivate().getEncoded();
        
        //reading input message from client file.
        FileReader inputx=new FileReader("Message.txt");
        BufferedReader breaderx=new BufferedReader(inputx);
        while((tempx=breaderx.readLine())!=null)
        {
        	message=message+tempx;
        }
 		//  System.out.println("message");
        byte[] encryptedData = encrypt(publicGen,message.getBytes());
    	
    	PrintWriter midwriter = new PrintWriter("Midway_Encryption.txt","UTF-8");
    	midwriter.println(new String(encryptedData));
    	midwriter.close();

        // Stage 2 Encryption with Pi-encryptor
        int pad=0;
       	FileReader inputy=new FileReader("text.txt");
        BufferedReader breadery=new BufferedReader(inputy);
        while((tempy=breadery.readLine())!=null && pad<=16)
        {
        	magicnumber=magicnumber+tempy;
        	pad+=1;
        }
        String magicnumberfinal= magicnumber.substring(0, Math.min(magicnumber.length(), 15));
        System.out.println("THE SMN BEING USED");
        System.out.println(magicnumberfinal);

        byte[] decryptedData = decrypt(privateGen, encryptedData);

        //Writing to text file for final shipping.
        PrintWriter writer = new PrintWriter("Final_Message.txt","UTF-8");
    	writer.println(new String(decryptedData));
    	writer.close();
        //System.out.println(new String(decryptedData));
		System.out.println("Decryption Done.. Check Final_Message.txt");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
}
class Crux
{
	public static void main(String[] args) {
		//screencap snippet.
		/*try
		{
			Robot robot=new Robot();
			Rectangle screenRectangle=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage fullScreenImage= robot.createScreenCapture(screenRectangle);
			ImageIO.write(fullScreenImage,"jpeg", new File("TEST_0.jpg"));
			System.out.println("1");
		}
		catch (AWTException | IOException exceptionobject)
		{
			System.err.println(exceptionobject);
		}*/
		// writing to an image.
		try
		{
			String sample="";
			FileInputStream in=new FileInputStream("C:/Users/Kirann Bhavaraju/Desktop/Capstone/piraw.txt");
			int c;
			while((c=in.read())!= -1)
			{
				sample=sample+c;
			}
			in.close();
			//System.out.println(sample);
			Font piFont=new Font("Trebuchet_MS",Font.BOLD,15);
			Dimension disp_size=Toolkit.getDefaultToolkit().getScreenSize();
			double disp_width=disp_size.getWidth();
			double disp_height=disp_size.getHeight();
			BufferedImage bufferedImage=new BufferedImage((int)disp_width,(int)disp_height,BufferedImage.TYPE_INT_RGB);
			Graphics graphics=bufferedImage.getGraphics();
			graphics.setColor(Color.WHITE);
			graphics.fillRect(0,0,(int)disp_width,(int)disp_height);
			graphics.setFont(piFont);
			graphics.setColor(Color.BLACK);
			int x=15;
			char [] digits=sample.toCharArray();
			//System.out.println(digits);
			//graphics.drawString(sample,0,15);
			int lines=0;
			for(int k=0;k<(int)disp_height/17;k++)
			{
				graphics.drawChars(digits,lines,(int)(disp_width/8),0,x);
				x+=17;
				lines=lines+(int)(disp_width/8);
			}
			ImageIO.write(bufferedImage,"jpg",new File("TEST_0.jpg"));
			System.out.println("Main Image Created");
			CropImage cropper= new CropImage();
			cropper.cropBufferedImage(bufferedImage);
		}
		catch(IOException exceptionobject)
		{
			System.err.println(exceptionobject);
		}
	}
}
