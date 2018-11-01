package com.bandwidth.V2.models;

//Bandwidth V2 packages
import com.bandwidth.V2.models.CreateApplicationRequestBody;

//Unit test packages
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//Java packages
import java.util.ArrayList;

/**
 * Test cases for CreateApplicationRequestBody
 */
public class CreateApplicationRequestBodyTest {

    /**
     * Test for proper functionality of CreateApplicationRequestBody.toXML()
     */
    @Test
    public void testToXML() { 
        //Build custom test values
        String serviceType = "s";
        String appName = "a";
        String callbackUrl = "url";
        String callbackUsername = "user";
        String callbackPassword = "pass";

        String expectedXML = "<Application><ServiceType>s</ServiceType><AppName>a</AppName><CallbackUrl>url</CallbackUrl><CallbackCreds><UserId>user</UserId><Password>pass</Password></CallbackCreds></Application>";

        //Create CreateApplicationRequestBody and call toXML()
        CreateApplicationRequestBody requestBody = new CreateApplicationRequestBody(serviceType, appName, callbackUrl, callbackUsername, callbackPassword);
        String xml = requestBody.toXML();

        //Check for correct value returned
        assertTrue(xml.equals(expectedXML));
    }
}
