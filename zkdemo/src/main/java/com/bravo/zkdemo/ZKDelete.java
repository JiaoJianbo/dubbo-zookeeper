package com.bravo.zkdemo;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class ZKDelete {
	private static ZooKeeper zk;
	private static ZooKeeperConnection connection;

	public static void delete(String path) throws InterruptedException, KeeperException {
		zk.delete(path, zk.exists(path, true).getVersion());
	}

	public static void main(String[] args) {
		String path = "/SecondZnode";
		
		try {
			connection = new ZooKeeperConnection();
			zk = connection.connect("localhost");
			delete(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
