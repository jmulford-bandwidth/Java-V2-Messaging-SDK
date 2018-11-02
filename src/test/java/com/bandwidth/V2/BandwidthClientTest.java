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
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPut;
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

    /**
     * Test for makeRequestApplicationControllerGet()
     */
    @Test
    public void testMakeRequestApplicationControllerGet() throws IOException, Exception {
        //Test data
        String testUsername = "123";
        String testPassword = "456";

        //Create mock objects
        HttpClient mockHttpClient = mock(DefaultHttpClient.class);
        HttpGet mockHttpGet = mock(HttpGet.class);
        CloseableHttpResponse mockCloseableHttpResponse = mock(CloseableHttpResponse.class);
        StringEntity mockStringEntity = mock(StringEntity.class);

        //Mock return values of mock objects
        when(mockHttpClient.execute(mockHttpGet)).thenReturn(mockCloseableHttpResponse);

        //Create BandwidthClient object
        BandwidthClient client = new BandwidthClient(null, null, null, testUsername, testPassword, null);

        //Get response
        HttpResponse response = client.makeRequestApplicationControllerGet(mockHttpClient, mockHttpGet);

        //Validate function calls
        verify(mockHttpGet).setHeader("Content-type", "application/xml");
        String encoding = Base64.getEncoder().encodeToString((testUsername + ":" + testPassword).getBytes("UTF-8"));
        verify(mockHttpGet).setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
        verify(mockHttpClient).execute(mockHttpGet);
    }

    /**
     * Test for makeRequestApplicationControllerDelete()
     */
    @Test
    public void testMakeRequestApplicationControllerDelete() throws IOException, Exception {
        //Test data
        String testUsername = "123";
        String testPassword = "456";

        //Create mock objects
        HttpClient mockHttpClient = mock(DefaultHttpClient.class);
        HttpDelete mockHttpDelete = mock(HttpDelete.class);
        CloseableHttpResponse mockCloseableHttpResponse = mock(CloseableHttpResponse.class);
        StringEntity mockStringEntity = mock(StringEntity.class);

        //Mock return values of mock objects
        when(mockHttpClient.execute(mockHttpDelete)).thenReturn(mockCloseableHttpResponse);

        //Create BandwidthClient object
        BandwidthClient client = new BandwidthClient(null, null, null, testUsername, testPassword, null);

        //Delete response
        HttpResponse response = client.makeRequestApplicationControllerDelete(mockHttpClient, mockHttpDelete);

        //Validate function calls
        verify(mockHttpDelete).setHeader("Content-type", "application/xml");
        String encoding = Base64.getEncoder().encodeToString((testUsername + ":" + testPassword).getBytes("UTF-8"));
        verify(mockHttpDelete).setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
        verify(mockHttpClient).execute(mockHttpDelete);
    }

    /**
     * Test for proper functionality of makeRequestApplicationeControllerPost()
     */
    @Test
    public void testMakeRequestApplicationControllerPost() throws IOException, Exception {
        //Test data
        String testUsername = "123";
        String testPassword = "456";

        //Create mock objects
        HttpClient mockHttpClient = mock(DefaultHttpClient.class);
        HttpPost mockHttpPost = mock(HttpPost.class);
        CloseableHttpResponse mockCloseableHttpResponse = mock(CloseableHttpResponse.class);
        StringEntity mockStringEntity = mock(StringEntity.class);

        //Mock return values of mock objects
        when(mockHttpClient.execute(mockHttpPost)).thenReturn(mockCloseableHttpResponse);

        //Create BandwidthClient object
        BandwidthClient client = new BandwidthClient(null, null, null, testUsername, testPassword, null);

        //Get response
        HttpResponse response = client.makeRequestApplicationControllerPost(mockStringEntity, mockHttpClient, mockHttpPost);

        //Validate function calls
        verify(mockHttpPost).setHeader("Content-type", "application/xml");
        String encoding = Base64.getEncoder().encodeToString((testUsername + ":" + testPassword).getBytes("UTF-8"));
        verify(mockHttpPost).setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
        verify(mockHttpPost).setEntity(mockStringEntity);
        verify(mockHttpClient).execute(mockHttpPost);
    }

    /**
     * Test for proper functionality of makeRequestApplicationeControllerPut()
     */
    @Test
    public void testMakeRequestApplicationControllerPut() throws IOException, Exception {
        //Test data
        String testUsername = "123";
        String testPassword = "456";

        //Create mock objects
        HttpClient mockHttpClient = mock(DefaultHttpClient.class);
        HttpPut mockHttpPut = mock(HttpPut.class);
        CloseableHttpResponse mockCloseableHttpResponse = mock(CloseableHttpResponse.class);
        StringEntity mockStringEntity = mock(StringEntity.class);

        //Mock return values of mock objects
        when(mockHttpClient.execute(mockHttpPut)).thenReturn(mockCloseableHttpResponse);

        //Create BandwidthClient object
        BandwidthClient client = new BandwidthClient(null, null, null, testUsername, testPassword, null);

        //Get response
        HttpResponse response = client.makeRequestApplicationControllerPut(mockStringEntity, mockHttpClient, mockHttpPut);

        //Validate function calls
        verify(mockHttpPut).setHeader("Content-type", "application/xml");
        String encoding = Base64.getEncoder().encodeToString((testUsername + ":" + testPassword).getBytes("UTF-8"));
        verify(mockHttpPut).setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
        verify(mockHttpPut).setEntity(mockStringEntity);
        verify(mockHttpClient).execute(mockHttpPut);
    }

    /**
     * Test for proper functionality of makeRequestApplicationeControllerPatch()
     */
    @Test
    public void testMakeRequestApplicationControllerPatch() throws IOException, Exception {
        //Test data
        String testUsername = "123";
        String testPassword = "456";

        //Create mock objects
        HttpClient mockHttpClient = mock(DefaultHttpClient.class);
        HttpPatch mockHttpPatch = mock(HttpPatch.class);
        CloseableHttpResponse mockCloseableHttpResponse = mock(CloseableHttpResponse.class);
        StringEntity mockStringEntity = mock(StringEntity.class);

        //Mock return values of mock objects
        when(mockHttpClient.execute(mockHttpPatch)).thenReturn(mockCloseableHttpResponse);

        //Create BandwidthClient object
        BandwidthClient client = new BandwidthClient(null, null, null, testUsername, testPassword, null);

        //Get response
        HttpResponse response = client.makeRequestApplicationControllerPatch(mockStringEntity, mockHttpClient, mockHttpPatch);

        //Validate function calls
        verify(mockHttpPatch).setHeader("Content-type", "application/xml");
        String encoding = Base64.getEncoder().encodeToString((testUsername + ":" + testPassword).getBytes("UTF-8"));
        verify(mockHttpPatch).setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
        verify(mockHttpPatch).setEntity(mockStringEntity);
        verify(mockHttpClient).execute(mockHttpPatch);
    }
}
