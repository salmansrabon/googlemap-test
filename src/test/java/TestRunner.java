import org.testng.annotations.Test;

public class TestRunner extends Setup {
    @Test
    public void searchLocation() throws InterruptedException {
        driver.get("https://www.google.com/maps");
        MapsPage mapsPage=new MapsPage(driver);
        mapsPage.searchLocation();
    }

}
