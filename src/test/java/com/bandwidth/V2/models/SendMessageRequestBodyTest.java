package com.bandwidth.V2.models;

//Bandwidth V2 packages
import com.bandwidth.V2.models.SendMessageRequestBody;

//Unit test packages
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//Exceptions
import java.net.MalformedURLException;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;

//Java packages
import java.util.ArrayList;

/**
 * Test cases for SendMessageRequestBody
 */
public class SendMessageRequestBodyTest {

    /**
     * Test for proper functionality of SendMessageRequestBody.toJSON()
     */
    @Test
    public void testToJSON() throws JsonProcessingException {
        //Build custom test values
        String from = "123";
        ArrayList<String> to = new ArrayList<String>();
        String toAdd = "456";
        to.add(toAdd);
        String text = "789";
        String applicationId = "321";
        ArrayList<String> media = new ArrayList<String>();
        String mediaAdd = "654";
        media.add(mediaAdd);
        String tag = "987";

        String expectedJSON = "{\"from\":\"123\",\"to\":[\"456\"],\"text\":\"789\",\"applicationId\":\"321\",\"media\":[\"654\"],\"tag\":\"987\"}";

        //Create SendMessageRequestBody and call toJSON()
        SendMessageRequestBody requestBody = new SendMessageRequestBody(from, to, text, applicationId, media, tag);
        String json = requestBody.toJSON();

        //Check for correct value returned
        assertTrue(json.equals(expectedJSON));
    }

    /**
     * Test for exclusion of null values in toJSON()
     */
    @Test
    public void testToJSONNullValues() throws JsonProcessingException {
        //Test variables
        String expectedJSON = "{}";

        //Create SendMessageRequestBody and call toJSON()
        SendMessageRequestBody requestBody = new SendMessageRequestBody(null, null, null, null, null, null);
        String json = requestBody.toJSON();

        //Check for correct value returned
        assertTrue(json.equals(expectedJSON));
    }
}
