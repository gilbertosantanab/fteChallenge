package Tests;

import org.testng.Assert;

public class CustomAsserts extends Assert {

    public static void isTextEqual (String expectedText, String actualText) {
        String errorMsg = "Text " + actualText + " is not as expected. Expected was: " + expectedText;
        Assert.assertEquals(actualText, expectedText, errorMsg);
    }



}
