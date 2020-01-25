package com.zooktutorial.app;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;

public class GetACL {

	private static ZooKeeper zk;
	
	private static ZkConnector zkc;
	
	private static List<ACL> getacl(String path) throws KeeperException, InterruptedException {
		return zk.getACL(path, zk.exists(path, true));
	}

	/**
	 * crdwa = 31 
	 * 2^0 = read 
	 * 2^1 = write 
	 * 2^2 = create 
	 * 2^3 = delete 
	 * 2^4 = admin
	 */
	public static void main(String[] args) throws KeeperException, InterruptedException, IllegalStateException, IOException {
		// TODO Auto-generated method stub
		String path = "/sampleznode";
		
		zkc = new ZkConnector();
		
		zk = zkc.connect("localhost");
		
		List<ACL> acl = getacl(path);
		
		acl.stream().forEach(System.out::println);
	}

}
