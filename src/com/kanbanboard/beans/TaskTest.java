package com.kanbanboard.beans;
import static org.junit.Assert.*;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import java.sql.Date;


//import org.junit.Assert;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
/**
 * Class TaskTest - to perform simple unit test of the application.
 *
 * 
 * @author  Sudha Madhulika Vecha
 * @version 2018.10.12
 */

class TaskTest {

	@Test
	void testCompareTasks() {
		Task t1 = new Task();
		Task t2 = new Task();

		@SuppressWarnings("deprecation")
		Date date = new Date(11, 12, 2019);
		t1.setDueDate(date);
		assertEquals(date, t1.getDueDate());
		//assert(what value do we expect, what value is returned)
		//assertEquals(true, true);


	}

}
