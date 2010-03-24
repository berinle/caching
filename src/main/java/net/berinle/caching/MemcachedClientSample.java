package net.berinle.caching;

import net.spy.memcached.MemcachedClient;
import java.net.InetSocketAddress;

public class MemcachedClientSample
{
	public static final int PORT = 11211;
	public static final String HOST = "127.0.0.1";
	
	public static void main(String[] args) {
		try{
				MemcachedClient c = new MemcachedClient(new InetSocketAddress(HOST, PORT));
				//load some data from the database...
				String someObject = "myObject";
				c.set("someKey", 3600, someObject);
				
				Thread.sleep(10000); //sleep for 10 secs
				
				//synchronized get
				Object fetchedObject = c.get("someKey");
				
				Thread.sleep(3000); //sleep for 10 secs
				
				//async get
				c.asyncGet("someKey");
				
				System.out.println("done");
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
