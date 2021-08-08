package homepageTest;


import common.BaseAPI;
import homepage.FormyHomepage;
import io.cucumber.java.an.E;
import org.testng.annotations.Test;

import java.io.IOException;

public class FormyTestHomepage extends BaseAPI {

    FormyHomepage homepage;

    @Test(enabled = false)
    public void testKeyboardInput(){
        homepage = new FormyHomepage();
        homepage.keyboardAndMouseInput();
    }

    @Test(enabled = false)
    public void testSwitchWindow() throws InterruptedException {

        homepage = new FormyHomepage();
        homepage.switchWindow();
        Thread.sleep(4000);
    }

    @Test(enabled = false)
    public void testAutoComplete(){
        homepage = new FormyHomepage();
        homepage.autocomplete();
    }

    @Test(enabled = false)
    public void testScrollToElement() throws InterruptedException {
        homepage = new FormyHomepage();
        homepage.scrollToElement();

    }

    @Test(enabled = false)
    public void testSwitchAlert() throws InterruptedException {
        homepage = new FormyHomepage();
        homepage.SwitchToAlert();

    }

    @Test(enabled = false)
    public void testJavascriptModelClick() throws InterruptedException {
        homepage = new FormyHomepage();
        homepage.modelButtonClick();

    }

    @Test(enabled = false)
    public void testDragAndDrop() throws InterruptedException {
        homepage = new FormyHomepage();
        homepage.dragAndDrop();
    }

    @Test(enabled = false)
    public void testRadioButtonSelection() throws InterruptedException {
        homepage = new FormyHomepage();
        homepage.selectRadioButton();
    }

    @Test(enabled = false)
    public void testDatePicker() throws InterruptedException {
        homepage = new FormyHomepage();
        homepage.datePicker();
    }

    @Test(enabled = false)
    public void testDropdown() throws InterruptedException {
        homepage = new FormyHomepage();
        homepage.selectDropdown();
    }

    @Test(enabled = false)
    public void testFileUpload() throws InterruptedException {
        homepage = new FormyHomepage();
        homepage.fileUpload();
    }

    @Test(enabled = false)
    public void testForm() throws InterruptedException {
        homepage = new FormyHomepage();
        homepage.form();
    }

    @Test(enabled = false)
    public void testFormSubmitMessage() throws InterruptedException {
        homepage = new FormyHomepage();
        homepage.confirmSubmissionOfTheForm();

    }
    @Test
    public void testScreenshots() throws IOException, InterruptedException {
        homepage = new FormyHomepage();
        homepage.screenshot();
    }
}
