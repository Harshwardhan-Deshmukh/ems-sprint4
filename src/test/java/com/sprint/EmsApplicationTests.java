package com.sprint;

import com.sprint.controller.EmployeeController;
import com.sprint.controller.LoginController;
import com.sprint.controller.TimesheetController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmsApplicationTests {

	@Autowired
	EmployeeController employeeController;

	@Autowired
	LoginController loginController;

	@Autowired
	TimesheetController timesheetController;

	@Test
	void contextLoads() {

		Assert.assertNotNull(employeeController);
		Assert.assertNotNull(loginController);
		Assert.assertNotNull(timesheetController);
	}

}
