package datePicker;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


//swtestacademy
/*for handling ElementClickInterceptedException help: 
 * http://makeseleniumeasy.com/2020/05/25/
 * elementclickinterceptedexception-element-click-
 * intercepted-not-clickable-at-point-other-element-would-receive-
 * the-click/#By_clicking_on_a_matching_option_from_auto_suggestions

*/
public class DatePickerTestsFlyDubai extends BaseTest{ 
	@Test
	public void flyDubaiDatePickerTest() throws InterruptedException {
		//open application
		driver.get("https://www.flydubai.com/en/");
		System.out.println("page tile: "+driver.getTitle());
		
		//click on place of deperture
		wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.cssSelector(".airportPickerTo"
						+ ".makeBookingTo.mat-form-group"))).click();
		
		//wait for drop down and click on the first city
		wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.cssSelector(
						".makeBookingTo .search-list-dropdown [data-metro-active='false']:nth-of-type(1)"))).click();
		
		//wait for the datepicker to open
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".lightpick__inner")));
		
		//get all elements from the cells of the date picker table
		List<WebElement> cellsOfDepartureDate = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
	            		By.cssSelector("section:nth-of-type(1) > .lightpick__days > div")));
		//click today for deperture
		DateUtil.clickGivenDay(cellsOfDepartureDate,DateUtil.getCurrentDay());
		
		//get all elements from the cells of the from date picker table arrival
		List<WebElement> cellsOfArrivalDate=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
				(By.cssSelector("section:nth-of-type(2) > .lightpick__days > div")));
		
		//click on the 4th day element
		cellsOfArrivalDate.get(4).click();
		
		//wait and see the selection 
		Thread.sleep(0);

	}
}
