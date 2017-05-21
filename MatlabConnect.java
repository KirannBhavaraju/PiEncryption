import matlabcontrol.*;
public class MatlabConnect{
	public static void main(String...args) 
	{
		try
		{
			 MatlabProxyFactoryOptions options=new MatlabProxyFactoryOptions.Builder()
       											 	.setMatlabLocation("C:/Program Files/MATLAB/R2010a/bin/win64")
    												.build();
			MatlabProxyFactory factory = new MatlabProxyFactory(options);
            MatlabProxy proxy = factory.getProxy();
			//proxy.eval("disp('hello world')");
			proxy.feval("C:/Users/Kirann Bhavaraju/Desktop/Capstone/Dump/OCR.m");
			proxy.disconnect(); 
			System.out.println("1");
		}
		catch(Exception e)
		{
			System.out.println("Exception");
		}
	}
}