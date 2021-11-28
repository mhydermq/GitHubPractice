package datePicker;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.WebElement;

public class DateUtil {
	
	//get current day
	public static String getCurrentDay() {
		//create a calendar object
		Calendar calendar=Calendar.getInstance(TimeZone.getDefault());
		
		//get current day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("Today Int: "+todayInt +"\n");
		
		//integer to string conversion
		String todayStr=Integer.toString(todayInt);
		System.out.println("Today Str: "+ todayStr+"\n");
		
		return todayStr;
	    }
	
	//get The Current Day plus days. we can change this method based on our needs.
	public static String getCurrentDayPlus(int days) {
		
		LocalDate currentDate=LocalDate.now();
		int dayOfWeekPlus=currentDate.getDayOfWeek().plus(days).getValue();
		
		return Integer.toString(dayOfWeekPlus);
	   }
	
	//click on given day
	public static void clickGivenDay(List<WebElement> elementList, String day) {
		//datepicker is a table. Hence we can navigate to each cell
		//and if a cell matches the current date then we will click on it
		
		/*functional java version of this method*/
		elementList.stream()
		.filter(element->element.getText().contains(day))
		.findFirst()
		.ifPresent(WebElement::click);
		
		/*
		 * non funcional Java version of this method
		 * 
		 * for(WebElement cell:elementList){
		 * String cellText=cell.getText();
		 * if(cellText.conatins(day){
		 * cell.click();
		 * break;
		 *    }
		 * }
		 */
		
	}

}
