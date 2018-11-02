package com.bandwidth.V2.models;

//Bandwidth V2 packages
import com.bandwidth.V2.models.PartialUpdateApplicationRequestBody;

//Unit test packages
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//Java packages
import java.util.ArrayList;

/**
 * Test cases for PartialUpdateApplicationRequestBody
 */
public class PartialUpdateApplicationRequestBodyTest {

    /**
     * Test for proper functionality of PartialUpdateApplicationRequestBody.toXML()
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

        //Create PartialUpdateApplicationRequestBody and call toXML()
        PartialUpdateApplicationRequestBody requestBody = ImmutablePartialUpdateApplicationRequestBody.builder()
            .serviceType(serviceType)
            .appName(appName)
            .callbackUrl(callbackUrl)
            .callbackUsername(callbackUsername)
            .callbackPassword(callbackPassword)
            .build();
        String xml = requestBody.toXML();

        //Check for correct value returned
        assertTrue(xml.equals(expectedXML));
    }

    /**
     * Test that null values are not included in the return of toXML()
     */
    @Test
    public void testToXMLNullValues() {
        String expectedXML = "<Application></Application>";

        PartialUpdateApplicationRequestBody requestBody = ImmutablePartialUpdateApplicationRequestBody.builder().build();
        String xml = requestBody.toXML();

        assertTrue(xml.equals(expectedXML));
    }
}
