package com.bravo.zkdemo;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZKGetData {
	private static ZooKeeper zk;
	private static ZooKeeperConnection connection;
	
	public static Stat znode_exists(String path) throws KeeperException,InterruptedException {
		return zk.exists(path, true);
	}

	public static void main(String[] args) {
		String path = "/SecondZnode";
		final CountDownLatch connectedSignal = new CountDownLatch(1);
		
		try {
			connection = new ZooKeeperConnection();
			zk = connection.connect("localhost");
			Stat st = znode_exists(path);
			
			if(st != null) {
				byte[] data = zk.getData(path, we -> {
					if(we.getType() == EventType.None) {
						switch(we.getState()) {
							case Expired:
								connectedSignal.countDown();
							break;
							
							default:
							break;
						}
					} else {
						try {
							byte[] bt = zk.getData(path, false, null);
							String btdata = new String(bt, "UTF-8");
							System.out.println(btdata);
							connectedSignal.countDown();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}, null);
				
				String s = new String(data, "UTF-8");
				System.out.println(s);
				connectedSignal.await();
			} else {
				System.out.println("Node does not exist");
			}
			
		} catch (IOException | InterruptedException | KeeperException e) {
			e.printStackTrace();
		}
	}

}
