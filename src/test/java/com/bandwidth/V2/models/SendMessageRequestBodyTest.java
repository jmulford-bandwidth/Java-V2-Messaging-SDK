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
     * Test for proper functionality of SendMessageRequestBody.toJSON() with multiple recipients
     */
    @Test
    public void testToJSONMultipleRecipients() throws JsonProcessingException {
        //Build custom test values
        String from = "123";
        ArrayList<String> to = new ArrayList<String>();
        String toAdd1 = "456";
        String toAdd2 = "567";
        to.add(toAdd1);
        to.add(toAdd2);
        String text = "789";
        String applicationId = "321";
        ArrayList<String> media = new ArrayList<String>();
        String mediaAdd = "654";
        media.add(mediaAdd);
        String tag = "987";

        String expectedJSON = "{\"to\":[\"456\",\"567\"],\"from\":\"123\",\"text\":\"789\",\"applicationId\":\"321\",\"media\":[\"654\"],\"tag\":\"987\"}";

        //Create SendMessageRequestBody and call toJSON()
        SendMessageRequestBody requestBody = new SendMessageRequestBody(to, from, text, applicationId, media, tag);
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
        String from = "123";
        ArrayList<String> to = new ArrayList<String>();
        String toAdd1 = "456";
        String toAdd2 = "567";
        to.add(toAdd1);
        to.add(toAdd2);
        String text = "789";
        String applicationId = "321";

        String expectedJSON = "{\"to\":[\"456\",\"567\"],\"from\":\"123\",\"text\":\"789\",\"applicationId\":\"321\"}";

        //Create SendMessageRequestBody and call toJSON()
        SendMessageRequestBody requestBody = new SendMessageRequestBody(to, from, text, applicationId, null, null);
        String json = requestBody.toJSON();

        //Check for correct value returned
        assertTrue(json.equals(expectedJSON));
    }

    /**
     * Test for proper functionality of SendMessageRequestBody.toJSON() with 1 recipient
     */
    @Test
    public void testToJSONOneRecipient() throws JsonProcessingException {
        //Build custom test values
        String from = "123";
        String to = "456";
        String text = "789";
        String applicationId = "321";
        ArrayList<String> media = new ArrayList<String>();
        String mediaAdd = "654";
        media.add(mediaAdd);
        String tag = "987";

        String expectedJSON = "{\"to\":[\"456\"],\"from\":\"123\",\"text\":\"789\",\"applicationId\":\"321\",\"media\":[\"654\"],\"tag\":\"987\"}";

        //Create SendMessageRequestBody and call toJSON()
        SendMessageRequestBody requestBody = new SendMessageRequestBody(to, from, text, applicationId, media, tag);
        String json = requestBody.toJSON();

        //Check for correct value returned
        assertTrue(json.equals(expectedJSON));
    }

}
