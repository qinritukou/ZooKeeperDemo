package com.zooktutorial.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class TestZkConnection {

	private static ZooKeeper zk;
	
	private static ZkConnector zkc;
	
	private static List<String> znodeList = new ArrayList<>();

	
	public static void main(String[] args) throws IllegalStateException, IOException, InterruptedException, KeeperException {
		zkc = new ZkConnector();
		
		zk = zkc.connect("localhost");
		
		znodeList = zk.getChildren("/", true);
		
		znodeList.stream().forEach(System.out::println);
	}
}
