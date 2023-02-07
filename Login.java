package loginFunctionality;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
private static WebDriver driver ;
@FindBy(id="username")
private static WebElement username;
@FindBy(id="password")
private static WebElement password;
@FindBy(xpath="//a[text()='Register']")
private static WebElement register;

@FindBy(id="email")
private static WebElement email;
@FindBy(id="password-confirm")
private static WebElement passworConfirm;
@FindBy(xpath="//input[@type='submit']")
private static WebElement register2;
@FindBy(xpath="//span[contains(@class,'exclamation-circle')]"
		+ "/parent::div/parent::div/span")
private static WebElement errormessage;
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://console.uat.asians.group/#/domain/list");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	@Test
	public static void registerCredentials() {
		register.click();
		email.sendKeys("nigam96@gmail.com");
		password.sendKeys("password");
		passworConfirm.sendKeys("password");
		register2.click();
		System.out.println(driver.getTitle());
		Assert.assertEquals("Sign in to Asians - User System", driver.getTitle());
		Assert.assertEquals("Email already exists.", errormessage.getText());
	}
}
