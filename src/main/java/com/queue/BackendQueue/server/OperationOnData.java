package com.queue.BackendQueue.server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.TreeMap;

public class OperationOnData {

	
	private TreeMap<String, String> queue = new TreeMap<String,String>();
	
	
	public void insertData(String data) throws IOException
	{
		Instant instant = Instant.now();
	    long seconds = instant.getEpochSecond();
	    
		queue.put(Long.toString(seconds), data);
		
		//storing in a file
		BufferedWriter writer = new BufferedWriter(
	            new FileWriter("/home/anindra/Downloads/BackendQueue/BackupFile.txt", true));

	    writer.newLine();   //Add new line
	    String dataToAppend = Long.toString(seconds) + " " + data;
	    writer.write(dataToAppend);
	    writer.close();
	}
	
	
	
	public ArrayList<String> returnData()
	{
		ArrayList<String> data = new ArrayList<>();
		
		for(int i=0;i<queue.size();i++)
		{
			data.add(queue.get(i));
		}
		
		return data;
	}
}
