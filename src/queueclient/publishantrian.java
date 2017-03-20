/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package queueclient;

/**
 *
 * @author agung
 */
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import java.util.logging.Level;
import java.util.logging.Logger;


public class publishantrian extends Thread
{
       // private static final String JEDIS_SERVER = "localhost";

	private ArrayList<String> messageContainer = new ArrayList<String>();

	private CountDownLatch messageReceivedLatch = new CountDownLatch(1);
	private CountDownLatch publishLatch = new CountDownLatch(1);
        static final long startMillis = System.currentTimeMillis();
   private String number;
   private Jedis jserver;
   public publishantrian(String number,Jedis jserver)
   {
      this.number = number;
      this.jserver = jserver;
   }
   	private static void log(String string, Object... args) {
		long millisSinceStart = System.currentTimeMillis() - startMillis;
		//System.out.printf("%20s %6d %s\n", Thread.currentThread().getName(), millisSinceStart,
				//String.format(string, args));
	}
   public void run()
   {
          // vInt++;
				try {
					log("Connecting");
					//Jedis jedis = new Jedis(server);
					log("Waiting to publish");
					//publishLatch.await();
					//log("Ready to publish, waiting one sec");
					Thread.sleep(500);
					log("publishing");
					jserver.publish("realtime", number);
					//log("published, closing publishing connection");
					//jserver.quit();
					//log("publishing connection closed");
				} catch (Exception e) {
					log(">>> OH NOES Pub, " + e.getMessage());
					 e.printStackTrace();
				}
   }
}