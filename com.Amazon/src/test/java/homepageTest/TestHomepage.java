package homepageTest;


import common.BaseAPI;
import homepage.Homepage;
import org.testng.annotations.Test;

public class TestHomepage extends BaseAPI {

    Homepage homepage;

    @Test
    public void doSearchCareers() throws InterruptedException {

        homepage = new Homepage();
        //homepage.switchWindow();
       // homepage.searchCareers();
        Thread.sleep(4000);
    }


}
