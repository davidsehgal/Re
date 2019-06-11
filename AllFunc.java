package IBMProjectMain;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllFunc {
	WebDriver dr;
	WebElement wb;
	Select s;
	WriteInExcel we = new WriteInExcel();
	

	public AllFunc(WebDriver dr) {
		this.dr =dr;
		// TODO Auto-generated constructor stub
	}
	public void enter_txt(String xp,String data){
		dr.findElement(By.xpath(xp)).sendKeys(data);
	}
	public void click(String xp){
		//dr.findElement(By.xpath(xp)).click();
		
		wb = dr.findElement(By.xpath(xp));
		Actions action = new Actions(dr);
		action.moveToElement(wb).click().perform();
	}
	public void checkbox(String xp){
		wb = dr.findElement(By.xpath(xp));							
		wb.click();
	}
	public void launchChrome(String url){
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		dr=new ChromeDriver();
		dr.manage().window().maximize();
		dr.get(url);
	}
	public void popup() {
		String s2 = "Are you sure?";
		String s1 = dr.switchTo().alert().getText();
		if(s1.equals(s2))
			System.out.println(s1+"  = Case Passed");
		dr.switchTo().alert().accept();
	}
	public String verify(String xp,String td,int r) {
		//String s3 = "Success: You have modified customers!";
		String s4 = dr.findElement(By.xpath(xp)).getText();
		System.out.println(td);
		//td = s4;
		System.out.println(s4);
		if(td.equalsIgnoreCase(s4))
		{
			we.write("Pass",r,6,"KeywordSheet");
			return "Pass";
		}
		else
		{
			we.write("Fail",r,6,"KeywordSheet");
			return "Fail";
		}
	}
	
	public void dropdown(String xp,String data) {
		wb = dr.findElement(By.xpath(xp));	
		//wb.click();
		s = new Select(wb);
		s.selectByVisibleText(data);
	}
	/*public void selecting_vailddata(String xp,String data) {
		wb = dr.findElement(By.xpath(xp));
		s = new Select(wb);
		s.selectByVisibleText(data);
	}*/
	/*public void Wait(String xp){
		Object WebDriverWait = new WebDriverWait(dr,10).until(ExpectedConditions.elementToBeClickable(By.xpath(xp)));
		
	}*/
	public String countrows(String xp,String td,int r) {
		List<WebElement> rows = dr.findElements(By.xpath(xp));
		System.out.println(rows.size());
		int a = rows.size();
		String td1 = Integer.toString(a);
		td = td.substring(1, td.length() - 1);
		System.out.println(td);
		if(td.equals(td1))
		{
			we.write("Pass",r,6,"KeywordSheet");
			return "Pass";
		}
		else
		{
			we.write("Fail",r,6,"KeywordSheet");
			return "Fail";
		}
	}
	public void radiobutton(String xp)
	{
		List rb = dr.findElements(By.name(xp));
		((WebElement) rb.get(1)).click();
	}
	public void cleartextbox(String xp) {
		dr.findElement(By.xpath(xp)).clear();
		
		
	}	


}
