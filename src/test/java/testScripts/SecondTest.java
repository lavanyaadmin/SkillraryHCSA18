package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class SecondTest  extends BaseClass{
	@Test
	public void FristTest() {
		SoftAssert soft=new SoftAssert();
		home.clickGears();
		home.clickSkillraryDemoApp();
		web.switchToChildBrowser();
		soft.assertEquals(demoApp.getPageHeader(),"SkillRary-ECommerce");
		demoApp.selectCategory(web,1);
		soft.assertEquals(testing.getPageHeader(),"Testing");
		web.dragAndDropElement(testing.getJavaImage(),testing.getMyCartArea());
		web.scrollToElement();
		testing.clickFacebookIcon();
		soft.assertAll();
		
		
		

	}

}
