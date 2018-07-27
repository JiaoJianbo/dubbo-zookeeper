package com.bravo.zkdemo;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class ZKCreator {
	private static ZooKeeper zk;
	
	private static ZooKeeperConnection connection;
	
	public static void create(String path, byte[] data) throws KeeperException, InterruptedException {
		zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}
	
	public static void main(String[] args) {
		String path = "/SecondZnode";
		byte[] data = "My first zookeeper program".getBytes();
		
		try {
			connection = new ZooKeeperConnection();
			zk = connection.connect("localhost");
			create(path, data);
			connection.close();
		} catch (IOException | InterruptedException | KeeperException e) {
			System.out.println(e.getMessage()); //Catch error message
			e.printStackTrace();
		}
		
	}
}
