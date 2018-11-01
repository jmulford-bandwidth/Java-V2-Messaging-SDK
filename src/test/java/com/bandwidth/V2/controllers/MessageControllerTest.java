package com.bandwidth.V2.controllers;

//Bandwidth V2 packages
import com.bandwidth.V2.controllers.MessageController;
import com.bandwidth.V2.models.SendMessageRequestBody;
import com.bandwidth.V2.BandwidthClient;

//Packages for http requests
import org.apache.http.entity.StringEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

//Unit test packages
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//Mocking framework
import static org.mockito.Mockito.*;

//Exceptions
import java.net.MalformedURLException;
import java.io.IOException;

//Java packages
import java.util.ArrayList;

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
        SendMessageRequestBody mockRequestBody = mock(SendMessageRequestBody.class);
        BandwidthClient mockBandwidthClient = mock(BandwidthClient.class);
        HttpClient mockHttpClient = mock(DefaultHttpClient.class);
        HttpPost mockHttpPost = mock(HttpPost.class);
        HttpResponse mockHttpResponse = mock(HttpResponse.class);
        StringEntity mockStringEntity = mock(StringEntity.class);

        //Mock return values for functions
        when(mockBandwidthClient.getStringEntity(testBody)).thenReturn(mockStringEntity);
        when(mockBandwidthClient.getUserId()).thenReturn(testUserId);
        when(mockBandwidthClient.getClient()).thenReturn(mockHttpClient);
        when(mockBandwidthClient.getHttpPost(fullUrl)).thenReturn(mockHttpPost);
        when(mockBandwidthClient.makeRequestMessageControllerPost(mockStringEntity, mockHttpClient, mockHttpPost)).thenReturn(mockHttpResponse);
        when(mockBandwidthClient.parseResponse(mockHttpResponse)).thenReturn(testResponse);
        when(mockRequestBody.toJSON()).thenReturn(testBody);

        //Create MessageController and call sendMessage()
        MessageController messageController = new MessageController(mockBandwidthClient);
        String response = messageController.sendMessage(mockRequestBody);

        //Check for proper response, and that the correct functions were called with the correct parameters
        assertTrue(response.equals(testResponse));
        //verify(mockRequestBody).toJSON();
        //verify(mockBandwidthClient).getUserId();
        //verify(mockBandwidthClient).makeRequestMessageControllerPost(testBody, mockHttpClient, mockHttpPost);
        //verify(mockBandwidthClient).
    }
}
