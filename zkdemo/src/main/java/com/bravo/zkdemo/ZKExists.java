package com.bravo.zkdemo;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZKExists {
	private static ZooKeeper zk;
	private static ZooKeeperConnection connection;
	
	public static Stat existZnode(String path) throws KeeperException, InterruptedException {
		return zk.exists(path, true);
	}

	public static void main(String[] args) 
			throws KeeperException, InterruptedException, IOException {
		String path = "/SecondZnode";
		
		connection = new ZooKeeperConnection();
		zk = connection.connect("localhost");
		Stat st = existZnode(path);

		if(st != null) {
			System.out.println("Node exists and the node version is " + st.getVersion());
		} else {
			System.out.println("Node does not exists");
		}
	}

}
