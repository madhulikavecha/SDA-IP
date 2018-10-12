package com.kanbanboard.beans;

import java.sql.Date;

/**
 * Class Task - a Task in To-Do Application.
 *
 * This class is part of the "To-Do" application. 
 *
 * A "Task" is unique in scope of a project and can contain numerous tasks.
 * 
 * @author  Sudha Madhulika Vecha
 * @version 2018.10.12
 */

public class Task implements Comparable<Task>	 {
	private String taskName;
	private Date dueDate;
	private Project p;
	private String taskStatus;
	private int taskId;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	//	private enum taskStatus{
	//		TO_DO, STARTED, IN_PROGRESS, DONE
	//	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Project getP() {
		return p;
	}

	public void setP(Project p) {
		this.p = p;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public int compareTo(Task task) {
		return this.getDueDate().compareTo(task.getDueDate());

	}

}
