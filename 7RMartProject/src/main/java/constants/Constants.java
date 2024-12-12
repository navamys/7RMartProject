package constants;

public class Constants {
	// constants are not modifiable or changeable
	public static final String TEST_DATA_FILE = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\TestData.xlsx";
	// right click on excel under src/test/resources->properties->copy path starting
	// from src till end from the appeared window
	public static final String APPLE_IMAGE = System.getProperty("user.dir") + "\\src\\test\\resources\\apple.jpg";
	public static final String GLUCOSE_MONITOR_IMAGE = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\glucose monitor.jpg";

	public static final String CONFIG_FILE = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\config.properties";

	public static final String ADMINUSER_MESSAGE = "Alert not displayed";
	public static final String HOME_MESSAGE = "signin button is not displayed as logout is not successful";
	public static final String LOGIN_MESSAGE_1 = "Homepage is not loaded when user is entering valid credentials";
	public static final String MANAGECONTACT_MESSAGE = "Update Button not displayed";
	public static final String MANAGEPRODUCT_MESSAGE = "Red error Alert not displayed";
	public static final String SUBCATEGORY_MESSAGE = "Green success Alert not displayed";

}
