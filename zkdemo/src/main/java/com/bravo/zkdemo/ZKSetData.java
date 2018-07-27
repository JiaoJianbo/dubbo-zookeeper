package com.bravo.zkdemo;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class ZKSetData {
	private static ZooKeeper zk;
	private static ZooKeeperConnection connection;
	
	public static void update(String path, byte[] data) throws KeeperException, InterruptedException {
		int version = zk.exists(path, true).getVersion();
		zk.setData(path, data, version);
	}
	
	public static void main(String[] args) {
		String path = "/SecondZnode";
		String data = "My Second Znode";
		
		try {
			connection = new ZooKeeperConnection();
			zk = connection.connect("localhost");
			update(path, data.getBytes());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
