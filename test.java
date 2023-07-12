import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class test {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();

        driver.get("https://accounts.spotify.com/uk/login?continue=https%3A%2F%2Fopen.spotify.com%2F");
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);

    }

    @Test
    public void testLoginWithEmptyCredentials() {

        loginPage.login("ddddda", "asdadsa");

        Assert.assertEquals(loginPage.getUsernameErrorMessage(), "Укажіть ім’я користувача Spotify або адресу електронної пошти.");
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), "Введіть пароль.");
    }

    @Test
    public void testLoginWithIncorrectCredentials() {

        loginPage.login("incorrect_username", "incorrect_password");

        Assert.assertEquals(loginPage.getErrorMessage(), "Неправильне ім’я користувача або пароль.");
    }

    @Test
    public void testLoginWithCorrectCredentials() {

        loginPage.login("correct_username", "correct_password");

        Assert.assertEquals(loginPage.getLoggedInUserName(), "Expected Name");
    }

    @AfterTest
    public void tearDown() {

        driver.close();
    }
}



