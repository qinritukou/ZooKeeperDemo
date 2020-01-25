package com.zooktutorial.app;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class UpdateZNode {

	private static ZooKeeper zk;
	
	private static ZkConnector zkc;
	
	public static void update(String path, byte[] data) throws KeeperException, InterruptedException {
		zk.setData(path, data, zk.exists(path, true).getVersion());
	}
	
	public static void main(String[] args) throws KeeperException, InterruptedException, IllegalStateException, IOException {
		String path = "/sampleznode";
		byte[] data = "i have been updated by my master!".getBytes();
		
		zkc = new ZkConnector();
		zk = zkc.connect("localhost");
		
		update(path, data);
		
		
		System.out.println("i changed the data successfully");
		
	}
}
