import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }



    public void login(String username, String password) {

        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='login-username']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='login-button']"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        usernameInput.clear();
        passwordInput.clear();

        loginButton.click();
    }

    public String getUsernameErrorMessage() {
        WebElement errorElement = driver.findElement(By.xpath("//p[text()='Укажіть ім’я користувача Spotify або адресу електронної пошти.']"));
        return errorElement.getText();
    }

    public String getPasswordErrorMessage() {
        WebElement errorElement = driver.findElement(By.xpath("//span[@class='Text-sc-g5kv67-0 jYLjty']"));
        return errorElement.getText();
    }

    public String getErrorMessage() {
        WebElement errorElement = driver.findElement(By.xpath("//span[@class='Message-sc-15vkh7g-0 dHbxKh']"));
        return errorElement.getText();
    }

    public String getLoggedInUserName() {
        WebElement loggedInUserElement = driver.findElement(By.id("logged-in-username"));
        return loggedInUserElement.getText();
    }
}