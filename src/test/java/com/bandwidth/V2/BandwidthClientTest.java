package com.bandwidth.V2;

//Bandwidth V2 packages
import com.bandwidth.V2.BandwidthClient;

//Packages for http requests
import org.apache.http.HttpResponse;
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
import org.powermock.api.mockito.PowerMockito;

//Java IO packages
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

//Exceptions
import java.io.IOException;

/**
 * Test cases for BandwidthClient
 */
public class BandwidthClientTest {

    /**
     * Test for proper functionality of makeRequestMessageControllerPost
     */
    @Test
    public void testMakeRequestMessageControllerPost() throws IOException, Exception {
        //Test data
        String url = "123";
        String body = "456";
        String apiToken = "789";
        String apiSecret = "987";
        String expectedResponse = "abc";

        //Create mock objects
        HttpClient mockHttpClient = mock(DefaultHttpClient.class);
        HttpPost mockHttpPost = mock(HttpPost.class);
        CloseableHttpResponse mockCloseableHttpResponse = mock(CloseableHttpResponse.class);
        HttpEntity mockHttpEntity = mock(HttpEntity.class);
        InputStream mockInputStream = mock(InputStream.class);
        InputStreamReader mockInputStreamReader = mock(InputStreamReader.class);
        BufferedReader mockBufferedReader = mock(BufferedReader.class);

        //Mock return values of mock objects
        when(mockHttpClient.execute(mockHttpPost)).thenReturn(mockCloseableHttpResponse);
        when(mockCloseableHttpResponse.getEntity()).thenReturn(mockHttpEntity);
        when(mockHttpEntity.getContent()).thenReturn(mockInputStream);

        PowerMockito.whenNew(InputStreamReader.class).withArguments(mockInputStream).thenReturn(mockInputStreamReader);
        PowerMockito.whenNew(BufferedReader.class).withArguments(mockInputStreamReader).thenReturn(mockBufferedReader);
        when(mockBufferedReader.readLine()).thenReturn(expectedResponse).thenReturn(null);


        //Create BandwidthClient object
        BandwidthClient client = new BandwidthClient(null, apiToken, apiSecret, null, null, null);

        //Get response
        String response = client.makeRequestMessageControllerPost(body, mockHttpClient, mockHttpPost);

        //Validate response and function calls
        verify(mockHttpPost).setHeader("header", "content-type: application/json");
        verify(mockHttpPost).setHeader("user", apiToken + ":" + apiSecret);
        verify(mockHttpPost).setHeader("data", body);
    }
}
