import java.io.*;
import java.net.*;

public class RequestHandler implements Runnable
{
	private Socket s;
	private Dictionary dictionary;
	
	public RequestHandler(Socket s)
	{
		this.s = s;
		dictionary = new Dictionary();
	}

	public void run()
	{
		try {
			InputStream sin = s.getInputStream();
			DataInputStream dis = new DataInputStream(sin);
			String word = new String(dis.readUTF());

			String meaning = new String(dictionary.getMeaning(word));

			OutputStream sout = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(sout);
			dos.writeUTF(meaning);

			dos.close();
			sout.close();
			s.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}