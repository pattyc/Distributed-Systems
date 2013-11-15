import java.net.*;
import java.io.*;

public class SimpleClient 
{
	

	public static void main(String args[]) throws IOException 
	{
		String word = "king";
		Socket s1 = new Socket("localhost", 1234);
		OutputStream s1out = s1.getOutputStream();
		DataOutputStream dos = new DataOutputStream(s1out);
		dos.writeUTF(word);

		InputStream s1In = s1.getInputStream();
		DataInputStream dis = new DataInputStream(s1In);
		String st = new String(dis.readUTF());
		System.out.println(st);

		dos.close();
		s1out.close();
		dis.close();
		s1In.close();
		s1.close();
	}
}