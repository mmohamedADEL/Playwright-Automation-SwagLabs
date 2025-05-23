package utilities;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;

public class Utility {
    private static final String SCREENSHOTPATH = "Test-output/screenshots/";
    public static void clickOnElement(Page page ,String locator)
    {
        page.locator(locator).click();
    }
    // Sending date to elements
    public static void sendData(Page page, String locator, String text) {
        page.locator(locator).fill(text);
    }
    //Method to get text from element
    public static String getTextFromElement(Page page, String locator) {
        return page.locator(locator).textContent();
    }
    //Method to take screenshot and attach it with the allure report
    public static void takeScreenshot(Page page, String screenShotName) throws IOException {
        String fileName = screenShotName + "-" + getCurrentTime() + ".png";
        Path screenshotPath = Paths.get(SCREENSHOTPATH + fileName);

        byte[] screenshotBytes = page.screenshot(new Page.ScreenshotOptions()
                .setPath(screenshotPath)
                .setFullPage(true));

        Allure.addAttachment(screenShotName, new ByteArrayInputStream(screenshotBytes));

    }

    //Method to get current time
    public static String getCurrentTime() {
        java.util.Date date = new java.util.Date();
        return date.toString().replace(":", "-").replace(" ", "_");
    }

    public static File getLatestFile(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        assert files != null;
        if (files.length == 0)
            return null;
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());

        return files[0];
    }
    public static int generateRandomNumber(int upper){
        return new Random().nextInt(upper)+1;
    }
    //Generate set with unique random numbers
    public static Set<Integer> generateUniqueRandomNumbers(int numberOfProductToSelect, int NumberOfAllProducts) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < numberOfProductToSelect) {
            int randomNumber = generateRandomNumber(NumberOfAllProducts) ;
            uniqueNumbers.add(randomNumber);
        }
        return uniqueNumbers;
    }
}
