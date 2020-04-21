package assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Validate_month_in_FB {

	static {
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}

	@Test
	public void validateDuplicateTest() throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream("./testData/input.xlsx"));
		int rowcount = wb.getSheet("Sheet1").getLastRowNum();
		System.out.println(rowcount);

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");

		WebElement list = driver.findElement(By.id("month"));

		Select sel = new Select(list);
		List<WebElement> allContents = sel.getOptions();

		int count = allContents.size();

		Assert.assertEquals(rowcount, count);

		driver.close();
	}

	@Test
	public void validateSortedTest() {
		ArrayList<String> act = new ArrayList<String>();
		act.add("Month");
		act.add("Jan");
		act.add("Feb");
		act.add("Mar");
		act.add("Apr");
		act.add("May");
		act.add("Jun");
		act.add("Jul");
		act.add("Aug");
		act.add("Sept");
		act.add("Oct");
		act.add("Nov");
		act.add("Dec");

		Collections.sort(act);

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");

		WebElement list = driver.findElement(By.id("month"));

		Select sel = new Select(list);
		List<WebElement> allContents = sel.getOptions();

		ArrayList<String> exp = new ArrayList<String>();
		for (WebElement content : allContents) {
			String text = content.getText();
			exp.add(text);
		}
		Collections.sort(exp);

		Assert.assertEquals(act, exp);
		
		driver.close();
	}

	@Test
	public void validateAllContentTest() {
		ArrayList<String> act = new ArrayList<String>();
		act.add("Month");
		act.add("Jan");
		act.add("Feb");
		act.add("Mar");
		act.add("Apr");
		act.add("May");
		act.add("Jun");
		act.add("Jul");
		act.add("Aug");
		act.add("Sept");
		act.add("Oct");
		act.add("Nov");
		act.add("Dec");

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");

		WebElement list = driver.findElement(By.id("month"));

		Select sel = new Select(list);
		List<WebElement> allContents = sel.getOptions();

		ArrayList<String> exp = new ArrayList<String>();
		for (WebElement content : allContents) {
			String text = content.getText();
			exp.add(text);
		}

		Assert.assertEquals(act, exp);
		
		driver.close();
	}

}
