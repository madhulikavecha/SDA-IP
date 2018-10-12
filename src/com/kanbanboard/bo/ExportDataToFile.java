package com.kanbanboard.bo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.kanbanboard.beans.Task;

/**
 *  To export the task data to a file, create an instance of this class 
 *  and call the exportData method by passing the task arraylist as argument
 * 
 * 
 * @author  Sudha Madhulika Vecha
 * @version 2018.10.12
 */

public class ExportDataToFile {

	/*
	 * This method exportData is used to send the task data to a file located in WebContent folder of the project.
	 * The method uses FileWriter for writing streams of data
	 * The method takes the task array list as an argument does not return anything.
	 */
	
	public void exportData(ArrayList<Task> tList) {
		try {

			String workingDirectory = System.getProperty("user.dir");
			System.setProperty("user.dir", "/Users/tmp-sda-1187/eclipse-workspace/kanbanboard/WebContent");

			String absoluteFilePath = workingDirectory + File.separator + "taskList.txt";
			FileWriter writer = new FileWriter(absoluteFilePath);

			Task task;
			Iterator<Task> taskIterator = tList.iterator();

			while(taskIterator.hasNext()) {
				task = taskIterator.next();
				String taskName = task.getTaskName();
				String taskStatus = task.getTaskStatus();
				java.sql.Date taskDate = task.getDueDate();
				String projectName = task.getP().getProjectName();
				writer.write("taskName: "+taskName+" taskStatus: "+taskStatus+" task due date: "+taskDate+" Project Name: "+projectName+" \n");
			}

			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
