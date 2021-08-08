package homepage;

import common.BaseAPI;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.WebDriverServlet;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class FormyHomepage extends BaseAPI {

    public FormyHomepage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * driver. quit() is used to exit the browser, end the session, tabs, pop-ups etc.
     * But the when you driver. close(), only the window that has focus is closed.
     */

    //***************** Keyboard And Mouse Input **********************8
    public void keyboardAndMouseInput() {

        WebElement name = driver.findElement(By.id("name"));
        name.click();
        name.sendKeys("Taniya");

        WebElement button = driver.findElement(By.id("button"));
        button.click();

    }

    //////////////////////////////////////////////////////////////////////////////////

    //Switch Window
    public void switchWindow() throws InterruptedException {

        WebElement switchWindowPage = driver.findElement(By.xpath("/html/body/div/div/li[13]/a"));
        switchWindowPage.click();

        Thread.sleep(4000);
        //find element for the button
        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));

        //click the button
        newTabButton.click();

        //handle both the windows and first focus on handle original window
        String originalHandle = driver.getWindowHandle();

        //for loop for to iterate though the two handles and switch back to original window

                              //will get two window handle
        for (String handle1 : driver.getWindowHandles()) {
            driver.switchTo().window(handle1);
        }

        //switch back to original window
        driver.switchTo().window(originalHandle);
    }

    ///////////////////////////////////////////////////////////////////////////////////////


    //Autocomplete
    public void autocomplete() {

        WebElement autocomplete = driver.findElement(By.id("autocomplete"));
        autocomplete.sendKeys("19220 circle gate drive, Germantown MD");

        WebElement autoCompleteResult = driver.findElement(By.className("pac-item"));
        autoCompleteResult.click();

    }

    ////////////////////////////////////////////////////////////////////////

    //Scroll to page

    public void scrollToElement() throws InterruptedException {

        WebElement pageScrollButton = driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Page Scroll']"));
        pageScrollButton.click();

        Thread.sleep(4000);
        WebElement name = driver.findElement(By.id("name"));
        Actions actions = new Actions(driver);
        actions.moveToElement(name);
        name.sendKeys("Taniya");

        WebElement date = driver.findElement(By.id("date"));
        date.sendKeys("02/04/2021");


    }

    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Switch to alert
     * Open the alert, switch to alert and close the alert
     */

    public void SwitchToAlert() throws InterruptedException {

        WebElement SwitchToWindowPageButton = driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Switch Window']"));
        SwitchToWindowPageButton.click();

        Thread.sleep(4000);

        WebElement alertButton = driver.findElement(By.xpath("//button[normalize-space()='Open alert']"));
        alertButton.click();

        Thread.sleep(4000);

        //Define new Alert object to switch to alert
        Alert alert = driver.switchTo().alert();

        //to click "OK" in the alert box
        alert.accept();

    }

    /////////////////////////////////////////////////////////////////////

    /**
     * Click on element that web driver fail to find
     * click "close" and "ok"
     * Buttons are hard to click inside the model and in this case we can use java script
     */


    public void modelButtonClick() throws InterruptedException {

        WebElement modelPage = driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Modal']"));
        modelPage.click();

        Thread.sleep(4000);

        WebElement modelButton = driver.findElement(By.id("modal-button"));
        modelButton.click();

        Thread.sleep(4000);

        WebElement closeButton = driver.findElement(By.id("close-button"));

        // JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", closeButton);

    }

    //////////////////////////////////////////////////////////////////////

    /**
     * Drag and Drop image into box
     */

    public void dragAndDrop() throws InterruptedException {

        WebElement dragAndDropPage = driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Drag and Drop']"));
        dragAndDropPage.click();

        Thread.sleep(4000);

        WebElement image = driver.findElement(By.id("image"));

        //Drop here box
        WebElement box = driver.findElement(By.id("box"));

        //Define new instance of the action class
        Actions actions = new Actions(driver);
        actions.dragAndDrop(image, box).build().perform();

    }

    /////////////////////////////////////////////////////////////////////////

    /**
     * Radio Button select
     */

    public void selectRadioButton() throws InterruptedException {

        WebElement radioButtonPage = driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Radio Button']"));
        radioButtonPage.click();

        Thread.sleep(4000);

        WebElement radioButton1 = driver.findElement(By.id("radio-button-1"));
        radioButton1.click();

        //This radio button doesn't have id so i am taking the value(create css selector)
        WebElement radioButton2 = driver.findElement(By.cssSelector("input[value='option2']"));
        radioButton2.click();

        WebElement radioButton3 = driver.findElement(By.xpath("//input[@value='option3']"));
        radioButton3.click();


    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Date Picker
     * Click date field
     * Select the date
     */

    public void datePicker() throws InterruptedException {
        WebElement DatePickerPage = driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Datepicker']"));
        DatePickerPage.click();

        Thread.sleep(4000);

        WebElement dateField = driver.findElement(By.id("datepicker"));
        dateField.sendKeys("04/05/2021");

        //To close the datePicker after type the date
        dateField.sendKeys(Keys.RETURN);

    }

    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Dropdown
     * Select item from dropdown menu
     */

    public void selectDropdown() throws InterruptedException {
        WebElement dropdownMenuPage = driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Dropdown']"));
        dropdownMenuPage.click();

        Thread.sleep(4000);

        WebElement dropdownMenu = driver.findElement(By.id("dropdownMenuButton"));
        dropdownMenu.click();

        //Select an option from dropdown
        WebElement autocompleteOption = driver.findElement(By.id("autocomplete"));
        autocompleteOption.click();

    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * File Upload
     * Choose a file
     */

    public void fileUpload() throws InterruptedException {
        WebElement fileUploadPage = driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='File Upload']"));
        fileUploadPage.click();

        Thread.sleep(4000);

        WebElement fileUploadField = driver.findElement(By.id("file-upload-field"));
        fileUploadField.sendKeys("Network-800x600px.jpg");
        Thread.sleep(4000);

    }


//////////////////////////////////////////////////////////////////////////

/**
 * ************* Implicit Waits **********************
 * Waits for a specified amount of time before throwing a no such element exception
 * Default wait time is 0
 * Doesn't depend on a certain element state, just time
 *
 * driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
 *
 * Easy to implement
 * Non-Intrusive
 * They can be applied to all element in a script
 */

///////////////////////////////////////////////////////////////////////////


    public void autocompleteExample1() {

        WebElement autocomplete = driver.findElement(By.id("autocomplete"));
        autocomplete.sendKeys("19220 circle gate drive, Germantown MD");

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        WebElement autoCompleteResult = driver.findElement(By.className("pac-item"));
        autoCompleteResult.click();
    }


///////////////////////////////////////////////////////////////////////////

    /**
     * *********************** Explicit wait ************************
     * Explicit wait is intelligent
     * Gives better options than implicit wait
     * Waits for dynamically located elements
     * First step is use new wait object
     *
     *WebDriverWait wait = new WebDriverWait(driver, 10);
     *
     * This method takes the driver in the max time to wait in the seconds as parameter
     *
     * expected condition - wait for an element
     *  WebElement element = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("element")));
     *
     *  elementToBeClickable()
     *  elementToBeSelected()
     *  presenceOfElementLocated()
     *  textToBePresentInElement()
     *
     *  check www.selenium.dev for more info about explicit wait
     *
     *  Allows flexibility to wait for an element to be in a specific condition
     *  will likely not take up unnecessary time
     */


    public void autocompleteExample2() {

        WebElement autocomplete = driver.findElement(By.id("autocomplete"));
        autocomplete.sendKeys("19220 circle gate drive, Germantown MD");

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("element")));

        element.click();

    }

    //////////////////////////////////////////////////////////////////////////

    /**
     * Form submitting
     * Complete all the fields in the form and submit
     */

    public void form() throws InterruptedException {

        WebElement formPage = driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Complete Web Form']"));
        formPage.click();

        Thread.sleep(4000);

        driver.findElement(By.id("first-name")).sendKeys("Taniya");
        driver.findElement(By.id("last-name")).sendKeys("Saparamadu");
        driver.findElement(By.id("job-title")).sendKeys("Software Tester");
        driver.findElement(By.id("radio-button-2")).click();
        driver.findElement(By.id("checkbox-2")).click();

        //Select Menu option 1
        driver.findElement(By.cssSelector("option[value='1']")).click();

        driver.findElement(By.id("datepicker")).sendKeys("06/23/2021");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);

        //Submit button
        driver.findElement(By.cssSelector("a[role='button']")).click();

    }

    ////////////////////////////////////////////////////////////////////

    /**
     * confirm the submission of the form
     */

    public void confirmSubmissionOfTheForm() throws InterruptedException {

        WebElement formPage = driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Complete Web Form']"));
        formPage.click();

        Thread.sleep(4000);

        driver.findElement(By.id("first-name")).sendKeys("Taniya");
        driver.findElement(By.id("last-name")).sendKeys("Saparamadu");
        driver.findElement(By.id("job-title")).sendKeys("Software Tester");
        driver.findElement(By.id("radio-button-2")).click();
        driver.findElement(By.id("checkbox-2")).click();

        //Select Menu option 1
        driver.findElement(By.cssSelector("option[value='1']")).click();

        driver.findElement(By.id("datepicker")).sendKeys("06/23/2021");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);

        //Submit button
        driver.findElement(By.cssSelector("a[role='button']")).click();

        //wait 10 seconds for alert class to be visible
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement alert = wait.until((ExpectedConditions.visibilityOfElementLocated(By.className("alert"))));

        String alertText = alert.getText();

        //Assert the confirm message
        softAssert.assertEquals("The form was successfully submitted!", alertText);
        softAssert.assertAll();

    }

//////////////////////////////////////////////////////////////////////////////////

    /**
     * Clean up the test(steps) for readability
     * Example: Submit form
     * create new method
     */


    public void completingForm() throws InterruptedException {

        WebElement formPage = driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Complete Web Form']"));
        formPage.click();

        Thread.sleep(4000);

        //calling the lines in the new method
        submitForm(driver);

        //calling wait method
        waitForAlertBanner(driver);

        softAssert.assertEquals("The form was successfully submitted!",getAlertBannerText(driver) );
        softAssert.assertAll();

    }

    //method will take WebDriver driver as parameter
    public static void submitForm(WebDriver driver){

        driver.findElement(By.id("first-name")).sendKeys("Taniya");
        driver.findElement(By.id("last-name")).sendKeys("Saparamadu");
        driver.findElement(By.id("job-title")).sendKeys("Software Tester");
        driver.findElement(By.id("radio-button-2")).click();
        driver.findElement(By.id("checkbox-2")).click();

        //Select Menu option 1
        driver.findElement(By.cssSelector("option[value='1']")).click();

        driver.findElement(By.id("datepicker")).sendKeys("06/23/2021");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);

        //Submit button
        driver.findElement(By.cssSelector("a[role='button']")).click();

    }

    //wait method
    public static void waitForAlertBanner(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.className("alert"))));
    }

    //Assertion method
    public static String getAlertBannerText(WebDriver driver){

        return driver.findElement(By.className("alert")).getText();
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * ********** Page Objects ******************
     *
     * Allows functionality to be separated into different classes based on area of functionality
     * Benefits: Organize test code and keep test clean
     *
     */

    /**
     * ********** Selenium Grid ******************
     *
     * Proxy server that routes command to remote browser instances
     * It spreads the load of testing across several machines
     * Those machines can run different browsers and browser versions, and different platforms as well
     *
     */


    //Take Screenshots

    /**
     * The use of a screenshot captured during automated test runs becomes very useful.
     * You would not want to monitor your application every time the tests are executed.
     * The script can take a screenshot, which helps check the application functionality/state when the test execution completes.
     * Screenshots also help you when your test case fails so that you can identify what went wrong in your script or your application.
     * A Screenshot in Selenium Webdriver is used for bug analysis.
     * Selenium webdriver can automatically take screenshots during the execution.
     * If users need to capture a screenshot on their own, they need to use the TakeScreenshot method which notifies the WebDrive to take the screenshot and store it in Selenium.
     */

    public void screenshot() throws IOException{


         //Method to take screenshot, create package(ts) and link to driver ((TakesScreenshot)driver;)
        TakesScreenshot ts = (TakesScreenshot)driver;

        // Capture the Screenshot and save in location in file format
        File source = ts.getScreenshotAs(OutputType.FILE);

        //Copy the file from source and save in new files called "screenshots"(under name homepage) .png is the image format
        FileUtils.copyFile(source, new File("screenshots/homepage.png"));
        System.out.println("Screenshot taken");


    }


}