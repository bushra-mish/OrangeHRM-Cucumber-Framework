package com.qa.hrm.testbase;

import com.qa.hrm.pages.DashboardPage;
import com.qa.hrm.pages.DisciplinaryCasesPage;
import com.qa.hrm.pages.EmployeeListPage;
import com.qa.hrm.pages.LoginPage;
import com.qa.hrm.pages.MembershipPage;
import com.qa.hrm.pages.AddEmployeePage;
import com.qa.hrm.pages.PersonalDetailsPage;

/**
 * Lazy-initializes all page objects once after WebDriver is ready. Step
 * definitions access pages through the static fields exposed here.
 */
public class PageInitializer extends BaseClass {

	public static LoginPage loginPage;
	public static DashboardPage dashboardPage;
	public static AddEmployeePage addEmployeePage;
	public static PersonalDetailsPage personalDetailsPage;
	public static EmployeeListPage employeeListPage;
	public static DisciplinaryCasesPage disciplinaryPage;
	public static MembershipPage membershipPage;

	public static void initialize() {
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		addEmployeePage = new AddEmployeePage();
		personalDetailsPage = new PersonalDetailsPage();
		employeeListPage = new EmployeeListPage();
		disciplinaryPage = new DisciplinaryCasesPage();
		membershipPage = new MembershipPage();
	}
}
