package com.bandwidth.V2.controllers;

//Bandwidth V2 packages
import com.bandwidth.V2.controllers.MessageController;
import com.bandwidth.V2.models.SendMessageRequestBody;
import com.bandwidth.V2.BandwidthClient;

//Unit test packages
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//Mocking framework
import static org.mockito.Mockito.*;

//Exceptions
import java.net.MalformedURLException;
import java.io.IOException;

/**
 * Test cases for MessageController
 */
public class MessageControllerTest {

    /**
     * Test for proper functionality of MessageController.sendMessage()
     */
    @Test
    public void testSendMessage() throws MalformedURLException, IOException {
        //Build custom test values
        String testBody = "test";
        String testUserId = "12345";
        String testResponse = "67890";
        String fullUrl = MessageController.BASE_URL.replace("{userId}", testUserId) + MessageController.SEND_MESSAGE_URL;

        //Create mock classes for SendMessageRequestBody and BandwidthClient
        SendMessageRequestBody requestBody = mock(SendMessageRequestBody.class);
        BandwidthClient client = mock(BandwidthClient.class);

        //Mock return values for functions
        when(client.getUserId()).thenReturn(testUserId);
        when(client.makeRequestMessageControllerPost(fullUrl, testBody)).thenReturn(testResponse);
        when(requestBody.toJSON()).thenReturn(testBody);

        //Create MessageController and call sendMessage()
        MessageController messageController = new MessageController(client);
        String response = messageController.sendMessage(requestBody);

        //Check for proper response, and that the correct functions were called with the correct parameters
        assertTrue(response.equals(testResponse));
        verify(requestBody).toJSON();
        verify(client).getUserId();
        verify(client).makeRequestMessageControllerPost(fullUrl, testBody);
    }
}
