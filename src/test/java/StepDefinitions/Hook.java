package StepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hook {

    public static WebDriver driver;
    @Before
    public void setupDriver(){
        System.setProperty("webdriver.gecko.driver",
                System.getProperty("user.dir")+"//Driver/geckodriver.exe");
        driver=new FirefoxDriver();
    }

    @After
    public void tearDown(Scenario scenario){
        try {
            String screenshotName=scenario.getName().replaceAll(" ","_");
            if(scenario.isFailed()){
                scenario.log("this is a failure message");
                TakesScreenshot ts=(TakesScreenshot)driver;
                byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot,"image/png",screenshotName);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
