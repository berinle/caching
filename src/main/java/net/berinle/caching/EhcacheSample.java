package net.berinle.caching;

import java.io.File;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.Statistics;

public class EhcacheSample {
	private static final String CACHE_NAME = "testCache";
	public static void main(String[] args) {
		
		try{
			//CacheManager manager = new CacheManager("net/berinle/caching/ehcache.xml");
			CacheManager manager = new CacheManager(new File("src/main/resources/net/berinle/caching/ehcache.xml").getAbsolutePath());
			String[] cacheNames = manager.getCacheNames();
			for(String s: cacheNames)
				System.out.println(s);
			
			manager.addCache(CACHE_NAME); //add a test cache
			
			Cache cache = manager.getCache(CACHE_NAME);
			
			cache.put(new Element("key1", "value1"));
			
			System.out.println("Sleeping for 5 secs");
			Thread.sleep(5000);
			System.out.println("Awoken from sleep...");
			
			Element element = cache.get("key1");
			String value = (String) element.getValue();
			
			System.out.println("value= " + value);
			
			Statistics stats = cache.getStatistics();
			System.out.println("Hits: " + stats.getCacheHits());
			System.out.println("Miss: " + stats.getCacheMisses());
			System.out.println("in mem: " + stats.getMemoryStoreObjectCount());
			System.out.println("in disk: " + stats.getDiskStoreObjectCount());
			System.out.println("in mem hit: " + stats.getInMemoryHits());
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
