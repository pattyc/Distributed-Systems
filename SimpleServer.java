import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class SimpleServer 
{
	static final int maxThreads = 10;
	static final int port = 1234;

	public static void main(String args[]) throws IOException 
	{
		// Register service on port 1234
		ServerSocket s = new ServerSocket(port);
		ExecutorService pool = Executors.newFixedThreadPool(maxThreads);

		// listen for new connections, create new request handler to process request
		try {
			while (true) {
				pool.execute(new RequestHandler(s.accept()));
			}
		} catch (IOException ioe) {
			pool.shutdown();
		}

		s.close();
	}
}