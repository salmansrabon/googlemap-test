import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MapsPage {
    WebDriver driver;
    @FindBy(id="searchboxinput")
    WebElement txtSearch;
    @FindBy(xpath="/html[1]/body[1]/div[3]/div[9]/div[3]/div[1]/div[2]/div[1]/div[3]/button[1]/div[1]/div[1]")
    WebElement btnAddDestination;
    @FindBy(className = "tactile-searchbox-input")
    List<WebElement> txtAddDestination;

    public MapsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void searchLocation() throws InterruptedException {
        txtSearch.sendKeys("From Police Plaza to Shahjalal International Airport");
        txtSearch.sendKeys(Keys.ENTER);
        btnAddDestination.click();
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(100));
//        wait.until(ExpectedConditions.visibilityOfElementLocated((By) txtAddDestination.get(0)));

        Thread.sleep(2000);
        txtAddDestination.get(5).sendKeys("Radison Blu Hotel");
        txtAddDestination.get(5).sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement fromElement=driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[9]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]"));
        WebElement toElement=driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[9]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/div[1]"));
        actions.dragAndDrop(fromElement,toElement).perform();

    }
}
