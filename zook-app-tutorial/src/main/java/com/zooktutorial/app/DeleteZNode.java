package com.zooktutorial.app;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class DeleteZNode {

	private static ZooKeeper zk;
	
	private static ZkConnector zkc;
	
	public static void delete(String path) throws IOException, InterruptedException, KeeperException {
		zk.delete(path, zk.exists(path, true).getVersion());
	}
	
	public static void main(String[] args) throws IllegalStateException, IOException, InterruptedException, KeeperException {
		// TODO Auto-generated method stub
		String path = "/sampleznode";
		
		zkc = new ZkConnector();
		
		zk = zkc.connect("localhost");
		
		delete(path);
	}

}
