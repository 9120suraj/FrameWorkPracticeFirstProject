package com.chandrac.advertisment.webutilies;

import java.time.Duration; 
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Mr Suraj Yadav (Engineer)
 *
 */
public class WebUtil {

	public static WebDriver driver;  ////  null

	public static void launchBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "E:\\programe by Rinku sir\\FrameWorkPracticeFirstProject\\DriverEXC\\chromedriver.exe");
			ChromeOptions options=	new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			System.out.println("Browser launched successfully");
		}catch (IllegalStateException e) {

			System.setProperty("webdriver.chrome.driver", "E:\\programe by Rinku sir\\WindowHandles\\Driver\\chromedriver.exe");
			ChromeOptions options=	new ChromeOptions();
			options.addArguments("-remote-allow-origins=");
			driver=new ChromeDriver(options);
			System.out.println("Browser launched successfully");

		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Browser launching is unsuccefull");
			throw e;
		}
	}
	public static void launchBrowserAndHitUrl(String Url) {
		WebUtil.launchBrowser();
		WebUtil.openUrl(Url);  
	}
	public static String myGetTitle() {
	String title=	driver.getTitle();
	return title;
	}

	public static void mouseOvermouseOverToThetElement(WebElement webObj) {

		//	WebElement we= myFindElement(xpath, elementName);  
		String elementName=webObj.getAccessibleName();
		try {
			WebDriverWait wait=	new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElements(webObj));
			Actions actionsObj=new Actions(driver);
			actionsObj.moveToElement(webObj).build().perform();
			System.out.println("Mouse is overed successfully on element "+elementName);
		}catch(StaleElementReferenceException e) {
			Actions actionsObj=new Actions(driver);
			actionsObj.moveToElement(webObj).build().perform();	
			System.out.println("Mouse is overed successfully on element "+elementName);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Mouseovered is not performed on element "+elementName);
			throw e;
		}
	}



	public static void openUrl(String url) {

		try {
			driver.get(url);
			System.out.println("the Given url :-"+url+" has opened successfully");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("the Given url :-"+url+" hasn't opened successfully");
			throw e;

		}
	}


	//	public static WebElement myFindElement(String xpath,String elementName) {
	//		WebElement webObj=null;
	//		try {
	//			webObj=driver.findElement(By.xpath(xpath));
	//			System.out.println(elementName+" is found successfully");
	//
	//		}catch(NoSuchElementException e) {
	//			WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(60));
	//			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	//			webObj=driver.findElement(By.xpath(xpath));
	//			System.out.println(elementName+"is found successfully");
	//			throw e;
	//
	//		}catch(InvalidSelectorException e) {
	//			e.printStackTrace();
	//			System.out.println(elementName+"is not found successfully because the syntax of xpath :-- "+xpath+"  is wrong");
	//
	//			throw e;
	//
	//		}catch(NullPointerException e){
	//
	//			driver=new ChromeDriver();	
	//
	//			System.out.println("browser has launched");
	//
	//			driver.get("http://localhost:8888");
	//			System.out.println("browser has lauched this link http://localhost:8888");
	//
	//			webObj=driver.findElement(By.xpath("//input[@name='user_name']"));
	//			System.out.println(elementName+"is found successfully");
	//			throw e;
	//
	//		}catch(Exception e) {
	//			e.printStackTrace();
	//			System.out.println(elementName+" is not found successfully");
	//
	//			throw e;
	//		}
	//		return webObj;
	//	}

	public static void myClick(WebElement webObj) {
		String elementName=	webObj.getAccessibleName();
		try {
			webObj.click();
			System.out.println(elementName+" is clicked succeesfull");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(elementName+" is  not clicked ");
			throw e;
		}
	}
	public static void myClear(WebElement webObj) {
		//WebElement webObj=myFindElement(xpath, elementName);
		String elementName=	webObj.getAccessibleName();
		System.out.println("we have found "+elementName+" successfully");

		try {
			webObj.clear();
			System.out.println(elementName+" textbox is cleared successfully");

		}catch(ElementNotInteractableException e) {

			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("arguments[0].value=''",webObj);
			System.out.println(elementName+" textbox is cleared successfully");
		}catch(StaleElementReferenceException e) {
			//  webObj=myFindElement(xpath, elementName);
			System.out.println("we have found "+elementName+" successfully");
			webObj.clear();
			System.out.println(elementName+" textbox is cleared successfully");
		}catch(Exception e) {

			e.printStackTrace();
			System.out.println(elementName+" textbox is  not cleared successfully");

			throw e;

		}

	}
	/*Alert  message popup method accept and cancel both*/
	public static void verifyAlertPopUpText(String axpectedAlertPopUpText) {
		try{
			String actualAlertPopUpText=driver.switchTo().alert().getText();
			if(actualAlertPopUpText.equalsIgnoreCase(axpectedAlertPopUpText)) {
				System.out.println("pass--asctual and expected Alert text is matched");
			}else{
				System.out.println("failed--asctual and expected Alert text is not matched");
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("VerifyAlertPopUpGetTex is failed");
		}
	}

	public static void alertPopUpCancel() {
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("PopUp alert message is dismissed");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("PopUp alert message is not dismissed");
		}
	}

	public static void alertPopUpAccept() {
		try {
			driver.switchTo().alert().accept();;
			System.out.println("PopUp alert message is Accepted");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("PopUp alert message is not Accepted");
			throw e;
		}
	}



	public  static void inputData( WebElement webObj,String inputValue) throws ElementClickInterceptedException {

		//WebElement webObj= myFindElement(xpath, elementName);
		String elementName=	webObj.getAccessibleName();
		try {
			webObj.sendKeys(inputValue);

			System.out.println(inputValue+" value is passed in "+elementName+" textbox successfully");
		}catch(ElementNotInteractableException e) {
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("arguments[0].value='"+inputValue+"'",webObj );
			System.out.println(inputValue+" value has entered in "+elementName+" textbox successfully");

		}catch(StaleElementReferenceException e) {
			webObj=driver.findElement(By.xpath("//input[@name='"+inputValue+"']"));
			System.out.println("we have found "+elementName+" successfully");
			webObj.sendKeys(inputValue);
			System.out.println(inputValue+" value has entered in "+elementName+" textbox successfully");

		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(inputValue+" value hasn't entered in "+elementName+" textbox successfully");
			throw e;
		}

	}

	public static void Click(WebElement webObj) {
		//WebElement webObj=myFindElement(xpath , elementName);
		String elementName= webObj.getAccessibleName();
		try {
			WebDriverWait wait=	new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfAllElements(webObj));
			webObj.click();
			System.out.println(elementName+" element is clicked successfully");

		}
		catch(ElementClickInterceptedException e) {

		}catch(ElementNotInteractableException e) {
			WebDriverWait webWait=	new WebDriverWait(driver, Duration.ofSeconds(30));
			webWait.until(ExpectedConditions.visibilityOf(webObj));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", webObj);
			System.out.println(elementName+" element is clicked successfully");

		}

		catch(StaleElementReferenceException e) {

			//webObj=myFindElement( xpath, elementName);

			WebDriverWait webWait=	new WebDriverWait(driver, Duration.ofSeconds(30));
			webWait.until(ExpectedConditions.visibilityOf(webObj));
			webObj.click();
			System.out.println(elementName+" element is clicked successfully");

		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(elementName+" element is not clicked successfully");
			throw e;

		}

	}

	public static String myGetText( WebElement webObj) {
		//WebElement webObj=myFindElement( xpath, elementName);
		String elementName=webObj.getAccessibleName();
		String innerText=null;
		try {
			innerText=webObj.getText();
			System.out.println(innerText+" - innertext of "+elementName+" got successfully");
		}catch(StaleElementReferenceException e) {

			//webObj=myFindElement(xpath, elementName);
			innerText=webObj.getText();
			System.out.println(innerText+" - innertext of "+elementName+" got successfully");

		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(" innertext not found");
			throw e;

		}
		return innerText;
	}

	public static void verifyString(String actualText, String expectedText) {
		if(actualText.equalsIgnoreCase(expectedText)) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
		}

	}

	/* Select class cutomize methods  */
	public static void selectByText(WebElement webObj, String selectText) {
		//	WebElement webObj = myFindElement(xpath, elementName);
		String elementName=webObj.getAccessibleName();
		try {
			Select selectObj=new Select(webObj);
			selectObj.selectByVisibleText(selectText);
			System.out.println(elementName+" is selected succesfully by text");
			///  css selector 
		}catch(ElementNotInteractableException e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("documents.getElementById("+e+").click()");			
			WebElement weOption = driver.findElement(By.xpath("//option[text()='"+selectText+"']"));
			js.executeScript(" var element = document   arguments[0].click()", weOption);
		}
	}
	public static void selectByValue(WebElement webObj, String valueAttributeValue) {
		//	WebElement webObj=       myFindElement(xpath, elementName);
		String elementName=webObj.getAccessibleName();
		try {
			Select selectObj=  new Select(webObj);
			selectObj.selectByValue(valueAttributeValue);
			System.out.println(elementName+" is selected succesfully by Value");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(elementName+" is not selected succesfully by Value");
		}
	}
	public static void selectByIndex(WebElement webObj, int indexNumber) {
		//	WebElement webObj=       myFindElement(xpath, elementName);
		String elementName=webObj.getAccessibleName();
		try {
			webObj.click();
			Select selectObj=  new Select(webObj);
			selectObj.selectByIndex(indexNumber);
			System.out.println(elementName+" is selected succesfully by indexNumber");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(elementName+" is not selected  by indexNumber");
		}
	}

	///  HTML DOM -  Document Object Model 

	///  Selenium IDE Java Script 
	//  Selnium RC  Java Script 


	public static void jsDragAndDrop() {

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("var evt = element.ownerDocument.createEvent('MouseEvents');\r\n"
				+ "\r\n"
				+ "    var RIGHT_CLICK_BUTTON_CODE = 2; // the same for FF and IE\r\n"
				+ "\r\n"
				+ "    evt.initMouseEvent('contextmenu', true, true,\r\n"
				+ "         element.ownerDocument.defaultView, 1, 0, 0, 0, 0, false,\r\n"
				+ "         false, false, false, RIGHT_CLICK_BUTTON_CODE, null);\r\n"
				+ "\r\n"
				+ "    if (document.createEventObject){\r\n"
				+ "        // dispatch for IE\r\n"
				+ "       return element.fireEvent('onclick', evt)\r\n"
				+ "     }\r\n"
				+ "    else{\r\n"
				+ "       // dispatch for firefox + others\r\n"
				+ "      return !element.dispatchEvent(evt);\r\n"
				+ " ");			

	}

	public static String getFirstSelectedText(WebElement webObj) {
		//	WebElement we=myFindElement(xpath, elementName);
		String elementName=webObj.getAccessibleName();
		Select selObj =	new Select(webObj);
		WebElement weSelectedItem=selObj.getFirstSelectedOption();
		String selectedText=weSelectedItem.getText();
		System.out.println("First selected option is found succesfully of "+elementName);
		return selectedText;
	}

	public static int getAllOptionsCount(WebElement webObj) {
		//	WebElement webObj=myFindElement(xpath, elementName);
		String elementName=webObj.getAccessibleName();
		Select selectObj=new Select(webObj);
		List<WebElement> listElement=selectObj.getOptions();
		int itemCount=listElement.size();
		System.out.println(elementName+"'s all options count is found succesfylly total option count is "+itemCount);
		return itemCount;
	}

	public static List<String> getTextOfAllOptions(WebElement webObj) {
		List<String> listOptionsText =  new ArrayList<String>();
		//WebElement webObj=myFindElement(xpath, elementName);
		String elementName=	webObj.getAccessibleName();
		Select selectObj=new Select(webObj);
		List<WebElement> weOptionsList=selectObj.getOptions();
		for(int i=0; i<=weOptionsList.size()-1; i++) {
			WebElement weOption =weOptionsList.get(i);
			String optionText=weOption.getText();
			listOptionsText.add(optionText);
		}
		System.out.println("All text of "+elementName+" has been found succesfully");
		return listOptionsText;
	}

	public static void switchToFrameByWebElemenet( WebElement weFrame) {
		//WebElement weFrame=myFindElement(frameXpath, elementName);
		String elementName=	weFrame.getAccessibleName();
		try {
			driver.switchTo().frame(weFrame);
			System.out.println("The window has been switched succesfully in the "+elementName+" frame");
		}catch(NoSuchFrameException e) {
			driver.switchTo().frame(weFrame);
			System.out.println("The window has been switched succesfully in the "+elementName+" frame");
		}catch(StaleElementReferenceException e) {
			//weFrame=myFindElement(frameXpath, elementName);
			driver.switchTo().frame(weFrame);
			System.out.println("The window has been switched succesfully in the "+elementName+" frame");
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void switchToWindowByTitle(String expectedTitle) {
		Set<String> handles = driver.getWindowHandles();
		for (String handleValue : handles) {
			driver.switchTo().window(handleValue);
			String title = driver.getTitle();
			if (title.equalsIgnoreCase(expectedTitle)) {
				break;
			}
		}
	}

	public static void switchToWindowByTitleContains(String expectedTitle) {
		Set<String> handles = driver.getWindowHandles();
		for (String handleValue : handles) {
			driver.switchTo().window(handleValue);
			String title = driver.getTitle();
			if (title.contains(expectedTitle)==true) {
				break;
			}
		}
	}

	public static void switchToWindowByUrl(String expectedUrl) {

		Set<String> handles = driver.getWindowHandles();
		for (String handleValue : handles) {
			driver.switchTo().window(handleValue);
			String url = driver.getCurrentUrl();
			if (url.equalsIgnoreCase(expectedUrl)) {

				break;
			}
		}
	}

	public static void switchToWindowByUrlContains(String expectedUrl) {

		Set<String> handles = driver.getWindowHandles();
		for (String handleValue : handles) {
			driver.switchTo().window(handleValue);
			String url = driver.getCurrentUrl();
			if (url.contains(expectedUrl)) {

				break;
			}
		}
	}	

	///  findElements 

	public static void checkAllCheckboxes(String xpath, String elementCollectionName) {
		List<WebElement> weListCheckboxes=  driver.findElements(By.xpath(xpath));
		for(int i=0; i<=weListCheckboxes.size()-1;i++) {
			WebElement weCheckbox=weListCheckboxes.get(i);
			if(weCheckbox.isSelected()==false) {
				weCheckbox.click();
			}

		}
	}

	public static void uncheckAllCheckboxes(String xpath, String elementCollectionName) {
		List<WebElement> weListCheckboxes=  driver.findElements(By.xpath(xpath));
		for(int i=0; i<=weListCheckboxes.size()-1;i++) {
			WebElement weCheckbox=weListCheckboxes.get(i);
			if(weCheckbox.isSelected()==true) {
				try {

					weCheckbox.click();
				}catch(ElementNotInteractableException e) {

				}


			}

		}
	}

	public static int getTableRowCount(String tableXpath, String elementName) {

		List<WebElement> weRowsList=driver.findElements(By.xpath(tableXpath+"//tr"));
		int rowCount=weRowsList.size()-1;
		return rowCount;
	}

	public static int getTableColumnHeaderCount(String tableXpath, String elementName) {
		List<WebElement> weListColumns=driver.findElements(By.xpath(tableXpath+"//tr[1]//td"));
		int columnCount=weListColumns.size();
		return columnCount;
	}


	/*  in this method we want all the column header names in a list<String>   */
	public static List<String>  getTableHeaderColumnNamesList(String tableXpath, String elementName) {
		List<WebElement> weListColumns=driver.findElements(By.xpath(tableXpath+"//tr[1]//td"));
		List<String> listColumnNames=new ArrayList<String>();
		int columnCount=weListColumns.size();
		for(int i=0; i<=columnCount-1;i++) {
			WebElement  weColumnHeader=weListColumns.get(i);
			String columnName=weColumnHeader.getText();
			listColumnNames.add(columnName);
		}
		return listColumnNames;
	}

	/*  this method returns column number on the basis of column name*/
	public static int getColumnNumberByColumnName(String tableXpath, String tableName, String columnName) {
		int columnNumber=-1;
		List<WebElement> listColumnNames=driver.findElements(By.xpath(tableXpath+"//tr[1]//td"));
		int columnCount=listColumnNames.size();
		for(int i=0; i<=columnCount-1;i++) {
			WebElement weTableColumn=listColumnNames.get(i);
			String tablColumnName=weTableColumn.getText();
			if(tablColumnName.equalsIgnoreCase(columnName)==true) {
				columnNumber=i;
				break;
			}
		}

		return columnNumber;

	}


	/* this method returns row data in list on the basis of row number*/
	public static List<String>  getRowDataListByRowNumber(String tableXpath, String tableName, int rowNumber) {
		List<WebElement> weListRowData=driver.findElements(By.xpath(tableXpath+"//tr["+(rowNumber+1)+"]//td"));
		List<String> rowDataList=new ArrayList<String>();
		for(int i=0;i<=weListRowData.size()-1;i++) {
			WebElement weRowData=weListRowData.get(i);
			String data=weRowData.getText();
			rowDataList.add(data);
		}
		return rowDataList;
	}


	public static List<String> getColumnDataListByColumnNumber(String tableXpath,String tableName,int columnNumber) {
		List<WebElement> columnsList=driver.findElements(By.xpath( tableXpath+"//tr//td["+(columnNumber+1)+"]"));
		List<String> columnNameList =new ArrayList<>();
		for (int i = 0; i <= columnsList.size()-1; i++) {
			String columnName=columnsList.get(i ).getText();
			columnNameList.add(columnName);
		}
		return columnNameList;
	}

	public static List<String> getColumnDataListByColumnName(String tableXpath,String tableName,String columnName) {
		//					int columnNumber=-1;
		//					List<WebElement> listColumnNames=driver.findElements(By.xpath(tableXpath+"//tr[1]//td"));
		//					int columnCount=listColumnNames.size();
		//					for(int i=0; i<=columnCount-1;i++) {
		//						WebElement weTableColumn=listColumnNames.get(i);
		//						String tablColumnName=weTableColumn.getText();
		//						if(tablColumnName.equalsIgnoreCase(columnName)==true) {
		//			                 columnNumber=i;
		//			                 break;
		//						}
		//					}
		//					
		//					List<WebElement> columnsList=driver.findElements(By.xpath( tableXpath+"//tr//td["+(columnNumber+1)+"]"));
		//					List<String> columnNameList =new ArrayList<>();
		//					for (int i = 0; i <=columnsList.size()-1; i++) {
		//						String tableColumnName=columnsList.get(i).getText();
		//						columnNameList.add(tableColumnName);
		//					}
		int columnNumber=getColumnNumberByColumnName(tableXpath, tableName, columnName);
		List<String>columnNameList=getColumnDataListByColumnNumber(tableXpath, tableName, columnNumber);

		return columnNameList;

	}


	public static int getRowNumberByUniqueColumnRowID(String tableXpath, String tableName, String uniqueData, String uniqueColumnName) {
		int rowNumber=-1;
		List<String> columnDataList=getColumnDataListByColumnName(tableXpath, tableName,uniqueColumnName);
		for(int i=0; i<=columnDataList.size()-1;i++) {
			String uniqueColumnData=columnDataList.get(i);
			if(uniqueColumnData.equalsIgnoreCase(uniqueData)) {
				rowNumber=i;
				break;
			}
		}
		return rowNumber;



	}

	public static List<String> getRowDataListByRowID(String tableXpath, String tableName, String uniqueData, String uniqueColumnName) {
		int rowNumber=getRowNumberByUniqueColumnRowID(tableXpath, tableName, uniqueData, uniqueColumnName);
		List<String>listRowData=getRowDataListByRowNumber(tableXpath, tableName, rowNumber);
		return listRowData;
	}



	public static List<String> printAllTableData(String tableXpath ,String elementName) {

		List<String> totalRowDataList=new ArrayList<String>();
		int totalRowNo=    getTableRowCount(tableXpath, tableXpath);
		for(int i=1;i<=totalRowNo;i++) {
			List<String> rowDataList=  getRowDataListByRowNumber(tableXpath, elementName, i);
			totalRowDataList.addAll(rowDataList);
		}
		return totalRowDataList;      

	}


	/// generic methods -  application independent methods 
	////  multiple time use 


	/////  selectByText

	///  getAttributeValue 
	////  Actions -  mouseClick , mouseOver, doubleCLick dragAndDrop , mouseRightClick , SendKeys

	/////  dropdown getSelectedText  , getOptionsCount ,  getTextListOfAllOptions

	///  getUrl
	/// getTitle

	//     switch

	//   1) 






}
