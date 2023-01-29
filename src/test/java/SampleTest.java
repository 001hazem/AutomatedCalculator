import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SampleTest {
    protected static ChromeDriver driver;
    @BeforeClass

    public void setUp(){
        ChromeOptions options = new BrowserOptions().getOptions(true);
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://www.calculator.net/");
    }


    @Test
    public void test1(){
        String expectedTitle = "Calculator.net: Free Online Calculators - Math, Fitness, Finance, Science";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @DataProvider(name = "Factroal data provider")
    public Object[][] dpMethod() {

        return new Object [][] {{1,"+",2,3},{1,"*",2,2},{7,"-",2,5} };

    }

    @Test(dataProvider = "Factroal data provider")
    public void verifyTheCalculatorIsFunctionality(int number1, String operation,int  number2, int number3)
    {

        String xpathNumber1="//span[@onclick='r("+number1+")']";
        WebElement FirstNumber1=driver.findElement(By.xpath(xpathNumber1));
        Assert.assertTrue(FirstNumber1.isDisplayed());
        FirstNumber1.click();


        String operationXpath="//span[@onclick=\"r('".concat(operation).concat("')\"]");
        WebElement xpathString=driver.findElement(By.xpath(operationXpath));
        Assert.assertTrue(xpathString.isDisplayed());
        xpathString.click();



        String xpathNumber2="//span[@onclick='r("+number2+")']";
        WebElement FirstNumber2=driver.findElement(By.xpath(xpathNumber2));
        Assert.assertTrue(FirstNumber2.isDisplayed());
        FirstNumber2.click();


        String equalsXpath="//span[@onclick=\"r('".concat("=").concat("')\"]");
        WebElement equalsString=driver.findElement(By.xpath(equalsXpath));
        Assert.assertTrue(equalsString.isDisplayed());
        equalsString.click();


        WebElement equalsResult=driver.findElement(By.id("sciOutPut"));
        Assert.assertTrue(equalsString.isDisplayed());
        Assert.assertEquals(equalsResult.getText().trim(), ""+number3);

    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }

}
