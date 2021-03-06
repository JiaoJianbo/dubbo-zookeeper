package com.bravo.zkdemo;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class ZooKeeperConnection {
	private ZooKeeper zoo;
	
	final CountDownLatch connectedSignal = new CountDownLatch(1);

	public ZooKeeper connect(String host) throws IOException, InterruptedException {
		zoo = new ZooKeeper(host, 5000, we -> {
			if (we.getState() == KeeperState.SyncConnected) {
				connectedSignal.countDown();
			}
		});
		
		connectedSignal.await();
		return zoo;
	}
	
	public void close() throws InterruptedException {
		zoo.close();
	}
}
