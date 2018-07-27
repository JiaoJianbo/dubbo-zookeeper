package com.bravo.zkdemo;

import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZKGetChildren {
	private static ZooKeeper zk;
	private static ZooKeeperConnection connection;

	public static Stat exist_node(String path) throws KeeperException, InterruptedException {
		return zk.exists(path, true);
	}
	
	public static void main(String[] args) {
		String path = "/";
		
		try {
			connection = new ZooKeeperConnection();
			zk = connection.connect("localhost");
			Stat st = exist_node(path);
			
			if(st != null) {
				List<String> children = zk.getChildren(path, false);
				children.stream().forEach(System.out::println);
			} else {
				System.out.println("Node does not exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
