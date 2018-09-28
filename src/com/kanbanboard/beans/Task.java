package com.kanbanboard.beans;

import java.util.Date;

public class Task {
	private String taskName;
	private Date dueDate;
	private Project p;
    private String taskStatus;
	
	private enum taskStatus{
		TO_DO, STARTED, IN_PROGRESS, DONE
	}

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


}
