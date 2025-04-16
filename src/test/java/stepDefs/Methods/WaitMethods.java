    package stepDefs.Methods;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.edge.EdgeDriver;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.sql.Driver;
    import java.time.Duration;

    public class WaitMethods {



       public static void click(WebDriver driver, By by){
            (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.elementToBeClickable(by));
            driver.findElement(by).click();
        }
        public static   void sendKeys(WebDriver driver, By by, String text) {
            (new WebDriverWait(driver, Duration.ofSeconds(3)))
                    .until(ExpectedConditions.elementToBeClickable(by));
            driver.findElement(by).sendKeys(text+ Keys.ENTER);
        }

    }
