package StepDefinitions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomePage {
	
	public static WebDriver driver;
	
	@Given("^User navigates to GoHealth Urgent Care Automation test application$")
	public void user_navigates_to_GoHealth_Urgent_Care_Automation_test_application() throws Throwable {
	    try
	    {
	    	System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
			//Instantiate Web Driver
			driver = new ChromeDriver();
			String baseUrl = "https://gohealthuc.github.io/TestAutomationProject/index.html";
			driver.get(baseUrl);
			driver.manage().window().maximize();			
	    } catch(Exception e) {
	    	System.out.println(e);
	    }
	}

	@Then("^User should be able to view DOB and User input fields$")
	public void user_should_be_able_to_view_DOB_and_User_input_fields() throws Throwable {
		try
	    {
			
			String title = driver.getTitle();
			System.out.println("Title of the page is:"+title);
	    	WebElement usrip = driver.findElement(By.xpath("//label[contains(text(),'User Input')]"));
	    	if(usrip.getText().equals("User Input:"))
	    	{
	    		System.out.println("User input field is displayed");
	    	}
	    	else
	    	{
	    		System.out.println("User input field is not displayed");
	    	}
	    	WebElement dobfield = driver.findElement(By.xpath("//label[contains(text(),'Date of Birth')]"));
	    	if(dobfield.getText().equals("Please Select Date of Birth:"))
	    	{
	    		System.out.println("DOB field is displayed");
	    	}
	    	else
	    	{
	    		System.out.println("DOB field is not displayed");
	    	}
	    } catch(Exception e) {
	    	System.out.println(e);
	    }
	}

	@Then("^Click on the dropdown for the month$")
	public void click_on_the_dropdown_for_the_month() throws Throwable {
		try
	    {
			WebElement month = driver.findElement(By.xpath("//select[@placeholder='Month']"));
			month.click();	    	
	    } catch(Exception e) {
	    	System.out.println(e);
	    }
	}

	@Then("^User should be able to see all the months in a year$")
	public void user_should_be_able_to_see_all_the_months_in_a_year() throws Throwable {
		try
	    {
			int count = 0;
		    String[] exp = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		    WebElement month = driver.findElement(By.xpath("//select[@placeholder='Month']"));
			Select drpmonth = new Select(month);
			List<WebElement> months = drpmonth.getOptions();
			for (WebElement we : months) {
		        for (int i = 0; i < exp.length; i++) {
		            if (we.getText().equals(exp[i])) {
		                count++;
		            }
		        }
		    }
			if (count == exp.length) {
		        System.out.println("Month validation is scuccessful");
		    } else {
		        System.out.println("Month validation is failed");
		    }
			
	    } catch(Exception e) {
	    	System.out.println(e);
	    }
	}

	@Then("^Click on the dropdown for the date$")
	public void click_on_the_dropdown_for_the_date() throws Throwable {
		try
	    {
			WebElement day = driver.findElement(By.xpath("//select[@placeholder='Day']"));
			day.click();
	    	
	    } catch(Exception e) {
	    	System.out.println(e);
	    }
	}

	@Then("^User should be able to see all the dates for the selected month$")
	public void user_should_be_able_to_see_all_the_dates_for_the_selected_month() throws Throwable {
		try
	    {
			Thread.sleep(500);
			WebElement day = driver.findElement(By.xpath("//select[@placeholder='Day']"));
			Select drpday = new Select(day);
			
			List<WebElement> days = drpday.getOptions();
			int i = 0;
			for(WebElement e : days) {
				  i++;
				}
			if( i == days.size())
			{
				System.out.println("Date validation is successful");
			}
			else
			{
				System.out.println("Date validation is not successful");
			}
	    } catch(Exception e) {
	    	System.out.println(e);
	    }
	}

	@Then("^Click on the dropdown for the year$")
	public void click_on_the_dropdown_for_the_year() throws Throwable {
		try
	    {
			WebElement year = driver.findElement(By.xpath("//select[@placeholder='Year']"));
			year.click();
	    } catch(Exception e) {
	    	System.out.println(e);
	    }
	}

	@Then("^User should be able to see all the years$")
	public void user_should_be_able_to_see_all_the_years() throws Throwable {
		try
	    {
			WebElement year = driver.findElement(By.xpath("//select[@placeholder='Year']"));
			Select drpyear = new Select(year);
			
			List<WebElement> years = drpyear.getOptions();
		int i = 0;
		for(WebElement e : years) 
		{
			i++;
			
		}
		if(i == years.size())
		{
			System.out.println("Year validation is successful");
		}
		else
		{
			System.out.println("Year validation is not successful");
		}
	    } catch(Exception e) {
	    	System.out.println(e);
	    }
	}
	
	@Then("^User closes the application$")
	public void user_closes_the_application() throws Throwable {
	    try
	    {
	    	driver.close();
	    }catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	}
	
	@Then("^User selects a \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\" from dropdown and validates user input field$")
	public void user_selects_a_and_from_dropdown_and_validates_user_input_field(String month, String date, String year) throws Throwable 
	{
		
		try
		{
		String monthnumber= "00";
		switch(month)
		{
		case "Jan":
			monthnumber = "01";
			break;
		case "Feb":	
			monthnumber = "02";
			break;
		case "Mar":
			monthnumber = "03";
			break;
		case "Apr":
			monthnumber = "04";
			break;
		case "May":
			monthnumber = "05";
			break;
		case "Jun":
			monthnumber = "06";
			break;
		case "Jul":
			monthnumber = "07";
			break;
		case "Aug":
			monthnumber = "08";
			break;
		case "Sep":
			monthnumber = "09";
			break;
		case "Oct":
			monthnumber = "10";
			break;
		case "Nov":
			monthnumber = "11";
			break;
		case "Dec":
			monthnumber = "12";
			break;
		default:
			System.out.println("Invalid month" +month);	
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date curdate = new Date();
		String ip = year+"-"+monthnumber+"-"+date;
		String currentdate = dateFormat.format(curdate);
		
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(ip);
		Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(currentdate);
		
		    WebElement months = driver.findElement(By.xpath("//select[@placeholder='Month']"));
			Select drpmonth = new Select(months);
			drpmonth.selectByVisibleText(month);
			Thread.sleep(1000);
		
			WebElement day = driver.findElement(By.xpath("//select[@placeholder='Day']"));
			Select drpday = new Select(day);
			drpday.selectByVisibleText(date);
			Thread.sleep(1000);
			
			WebElement yr = driver.findElement(By.xpath("//select[@placeholder='Year']"));
			Select drpyear = new Select(yr);
			drpyear.selectByVisibleText(year);
			Thread.sleep(1500);
			
			WebElement userip = driver.findElement(By.xpath("//form[@class='form-horizontal']/div[2]/div"));
			String output = userip.getText();
			System.out.println("User input value is:" +output);
			
			if(date1.after(date2))
			{
				System.out.println(dateFormat.format(date1));
				if(output.equalsIgnoreCase("Future date is invalid"))
				{
					System.out.println("Pass");
				}
				else
				{
					System.out.println("Future date.So,Failed");
				}
							
			}
			else
			{
			System.out.println("Expected value is:"+ip);
			if(output.equals(ip))
			{
				System.out.println("User input value is as expected.Successful validation.");
			}
			else
			{
				System.out.println("User input value is not getting as expected. So validation failed");
			}
			}
				
		} catch(NoSuchElementException e)
		{
			System.out.println("Trying to enter invalid date.Failed");
		}
		
		
	}
}
