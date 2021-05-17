package Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import Pages.LoginTBKPage;
import commons.Browser;

class BaseTest {
	protected static LoginTBKPage page;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		page = new LoginTBKPage(Browser.CHROME);
		page.get();
		page.getAutomator().maximize();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		//page.getAutomator().closeAll();
	}
	

}
