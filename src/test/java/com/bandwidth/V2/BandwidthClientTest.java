package com.bandwidth.V2;

//Bandwidth V2 packages
import com.bandwidth.V2.BandwidthClient;

//Packages for http requests
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;

//Unit test packages
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//Mocking framework
import static org.mockito.Mockito.*;

//Java IO packages
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

//Exceptions
import java.io.IOException;

//Java packages
import java.util.Base64;

/**
 * Test cases for BandwidthClient
 */
public class BandwidthClientTest {

    /**
     * Test for proper functionality of makeRequestMessageControllerPost()
     */
    @Test
    public void testMakeRequestMessageControllerPost() throws IOException, Exception {
        //Test data
        String testApiToken = "789";
        String testApiSecret = "987";

        //Create mock objects
        HttpClient mockHttpClient = mock(DefaultHttpClient.class);
        HttpPost mockHttpPost = mock(HttpPost.class);
        CloseableHttpResponse mockCloseableHttpResponse = mock(CloseableHttpResponse.class);
        StringEntity mockStringEntity = mock(StringEntity.class);

        //Mock return values of mock objects
        when(mockHttpClient.execute(mockHttpPost)).thenReturn(mockCloseableHttpResponse);

        //Create BandwidthClient object
        BandwidthClient client = new BandwidthClient(null, testApiToken, testApiSecret, null, null, null);

        //Get response
        HttpResponse response = client.makeRequestMessageControllerPost(mockStringEntity, mockHttpClient, mockHttpPost);

        //Validate function calls
        verify(mockHttpPost).setHeader("Content-type", "application/json");
        String encoding = Base64.getEncoder().encodeToString((testApiToken + ":" + testApiSecret).getBytes("UTF-8"));
        verify(mockHttpPost).setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
        verify(mockHttpPost).setEntity(mockStringEntity);
        verify(mockHttpClient).execute(mockHttpPost);
    }
}
