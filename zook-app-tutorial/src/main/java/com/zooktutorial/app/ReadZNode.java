package com.zooktutorial.app;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class ReadZNode {

	private static ZooKeeper zk;
	
	private static ZkConnector zkc;
	
	public static byte[] read(String path) throws KeeperException, InterruptedException {
		return zk.getData(path, true, zk.exists(path, true));
	}
	
	public static void main(String[] args) throws IllegalStateException, IOException, InterruptedException, KeeperException {
		// TODO Auto-generated method stub
		String path = "/sampleznode";
		byte[] data;
		
		zkc = new ZkConnector();
		
		zk = zkc.connect("localhost");
		
		data = read(path);
		
		for (byte b : data) {			
			System.out.print((char)b);
		}
	}

}
