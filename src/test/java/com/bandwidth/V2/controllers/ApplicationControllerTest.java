package com.bandwidth.V2.controllers;
  
//Bandwidth V2 packages
import com.bandwidth.V2.controllers.ApplicationController;
import com.bandwidth.V2.models.CreateApplicationRequestBody;
import com.bandwidth.V2.models.PartialUpdateApplicationRequestBody;
import com.bandwidth.V2.models.CompleteUpdateApplicationRequestBody;
import com.bandwidth.V2.BandwidthClient;

//Unit test packages
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//Mocking framework
import static org.mockito.Mockito.*;

//Exceptions
import java.net.MalformedURLException;
import java.io.IOException;

//Packages for http requests
import org.apache.http.entity.StringEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Test cases for ApplicationController
 */
public class ApplicationControllerTest {

    /**
     * Test for createApplication
     */
    @Test
    public void testCreateApplication() throws MalformedURLException, IOException {
        //Test values
        String testBody = "test";
        String testAccount = "12345";
        String testResponse = "67890";
        String testUrl = ApplicationController.BASE_URL.replace("{account}", testAccount);

        //Mock classes
        BandwidthClient mockBandwidthClient = mock(BandwidthClient.class);
        CreateApplicationRequestBody mockRequestBody = mock(CreateApplicationRequestBody.class);
        HttpClient mockHttpClient = mock(DefaultHttpClient.class);
        HttpPost mockHttpPost = mock(HttpPost.class);
        HttpResponse mockHttpResponse = mock(HttpResponse.class);
        StringEntity mockStringEntity = mock(StringEntity.class);

        //Mock functions
        when(mockBandwidthClient.getStringEntity(testBody)).thenReturn(mockStringEntity);
        when(mockBandwidthClient.getAccount()).thenReturn(testAccount);
        when(mockBandwidthClient.getClient()).thenReturn(mockHttpClient);
        when(mockBandwidthClient.getHttpPost(testUrl)).thenReturn(mockHttpPost);
        when(mockBandwidthClient.makeRequestApplicationControllerPost(mockStringEntity, mockHttpClient, mockHttpPost)).thenReturn(mockHttpResponse);
        when(mockBandwidthClient.parseResponse(mockHttpResponse)).thenReturn(testResponse);
        when(mockRequestBody.toXML()).thenReturn(testBody);

        //Make response
        ApplicationController controller = new ApplicationController(mockBandwidthClient);
        String response = controller.createApplication(mockRequestBody);

        //Verify response
        assertTrue(response.equals(testResponse));
    }

    /**
     * Test for getApplications
     */
    @Test
    public void testGetApplications() throws MalformedURLException, IOException {
        //Test values
        String testAccount = "12345";
        String testResponse = "67890";
        String testUrl = ApplicationController.BASE_URL.replace("{account}", testAccount);

        //Mock classes
        BandwidthClient mockBandwidthClient = mock(BandwidthClient.class);
        HttpClient mockHttpClient = mock(DefaultHttpClient.class);
        HttpGet mockHttpGet = mock(HttpGet.class);
        HttpResponse mockHttpResponse = mock(HttpResponse.class);

        //Mock functions
        when(mockBandwidthClient.getAccount()).thenReturn(testAccount);
        when(mockBandwidthClient.getClient()).thenReturn(mockHttpClient);
        when(mockBandwidthClient.getHttpGet(testUrl)).thenReturn(mockHttpGet);
        when(mockBandwidthClient.makeRequestApplicationControllerGet(mockHttpClient, mockHttpGet)).thenReturn(mockHttpResponse);
        when(mockBandwidthClient.parseResponse(mockHttpResponse)).thenReturn(testResponse);

        //Make response
        ApplicationController controller = new ApplicationController(mockBandwidthClient);
        String response = controller.getApplications();

        //Verify response
        assertTrue(response.equals(testResponse));
    }

    /**
     * Test for getApplication
     */
    @Test
    public void testGetApplication() throws MalformedURLException, IOException {
        //Test values
        String testAccount = "12345";
        String testResponse = "67890";
        String testApplicationId = "321";
        String testUrl = ApplicationController.BASE_URL.replace("{account}", testAccount) + "/" + testApplicationId;

        //Mock classes
        BandwidthClient mockBandwidthClient = mock(BandwidthClient.class);
        HttpClient mockHttpClient = mock(DefaultHttpClient.class);
        HttpGet mockHttpGet = mock(HttpGet.class);
        HttpResponse mockHttpResponse = mock(HttpResponse.class);

        //Mock functions
        when(mockBandwidthClient.getAccount()).thenReturn(testAccount);
        when(mockBandwidthClient.getClient()).thenReturn(mockHttpClient);
        when(mockBandwidthClient.getHttpGet(testUrl)).thenReturn(mockHttpGet);
        when(mockBandwidthClient.makeRequestApplicationControllerGet(mockHttpClient, mockHttpGet)).thenReturn(mockHttpResponse);
        when(mockBandwidthClient.parseResponse(mockHttpResponse)).thenReturn(testResponse);

        //Make response
        ApplicationController controller = new ApplicationController(mockBandwidthClient);
        String response = controller.getApplication(testApplicationId);

        //Verify response
        assertTrue(response.equals(testResponse));
    }

    /**
     * Test for partialUpdateApplication
     */
    @Test
    public void testPartialUpdateApplication() throws MalformedURLException, IOException {
        //Test values
        String testBody = "test";
        String testAccount = "12345";
        String testResponse = "67890";
        String testApplicationId = "321";
        String testUrl = ApplicationController.BASE_URL.replace("{account}", testAccount) + "/" + testApplicationId;

        //Mock classes
        BandwidthClient mockBandwidthClient = mock(BandwidthClient.class);
        PartialUpdateApplicationRequestBody mockRequestBody = mock(PartialUpdateApplicationRequestBody.class);
        HttpClient mockHttpClient = mock(DefaultHttpClient.class);
        HttpPatch mockHttpPatch = mock(HttpPatch.class);
        HttpResponse mockHttpResponse = mock(HttpResponse.class);
        StringEntity mockStringEntity = mock(StringEntity.class);

        //Mock functions
        when(mockBandwidthClient.getStringEntity(testBody)).thenReturn(mockStringEntity);
        when(mockBandwidthClient.getAccount()).thenReturn(testAccount);
        when(mockBandwidthClient.getClient()).thenReturn(mockHttpClient);
        when(mockBandwidthClient.getHttpPatch(testUrl)).thenReturn(mockHttpPatch);
        when(mockBandwidthClient.makeRequestApplicationControllerPatch(mockStringEntity, mockHttpClient, mockHttpPatch)).thenReturn(mockHttpResponse);
        when(mockBandwidthClient.parseResponse(mockHttpResponse)).thenReturn(testResponse);
        when(mockRequestBody.toXML()).thenReturn(testBody);

        //Make response
        ApplicationController controller = new ApplicationController(mockBandwidthClient);
        String response = controller.partialUpdateApplication(mockRequestBody, testApplicationId);

        //Verify response
        assertTrue(response.equals(testResponse));
    }

    /**
     * Test for completeUpdateApplication
     */
    @Test
    public void testCompleteUpdateApplication() throws MalformedURLException, IOException {
        //Test values
        String testBody = "test";
        String testAccount = "12345";
        String testResponse = "67890";
        String testApplicationId = "321";
        String testUrl = ApplicationController.BASE_URL.replace("{account}", testAccount) + "/" + testApplicationId;

        //Mock classes
        BandwidthClient mockBandwidthClient = mock(BandwidthClient.class);
        CompleteUpdateApplicationRequestBody mockRequestBody = mock(CompleteUpdateApplicationRequestBody.class);
        HttpClient mockHttpClient = mock(DefaultHttpClient.class);
        HttpPut mockHttpPut = mock(HttpPut.class);
        HttpResponse mockHttpResponse = mock(HttpResponse.class);
        StringEntity mockStringEntity = mock(StringEntity.class);

        //Mock functions
        when(mockBandwidthClient.getStringEntity(testBody)).thenReturn(mockStringEntity);
        when(mockBandwidthClient.getAccount()).thenReturn(testAccount);
        when(mockBandwidthClient.getClient()).thenReturn(mockHttpClient);
        when(mockBandwidthClient.getHttpPut(testUrl)).thenReturn(mockHttpPut);
        when(mockBandwidthClient.makeRequestApplicationControllerPut(mockStringEntity, mockHttpClient, mockHttpPut)).thenReturn(mockHttpResponse);
        when(mockBandwidthClient.parseResponse(mockHttpResponse)).thenReturn(testResponse);
        when(mockRequestBody.toXML()).thenReturn(testBody);

        //Make response
        ApplicationController controller = new ApplicationController(mockBandwidthClient);
        String response = controller.completeUpdateApplication(mockRequestBody, testApplicationId);

        //Verify response
        assertTrue(response.equals(testResponse));
    }

    /**
     * Test for deleteApplication
     */
    @Test
    public void testDeleteApplication() throws MalformedURLException, IOException {
        //Test values
        String testAccount = "12345";
        String testResponse = "67890";
        String testApplicationId = "321";
        String testUrl = ApplicationController.BASE_URL.replace("{account}", testAccount) + "/" + testApplicationId;

        //Mock classes
        BandwidthClient mockBandwidthClient = mock(BandwidthClient.class);
        HttpClient mockHttpClient = mock(DefaultHttpClient.class);
        HttpDelete mockHttpDelete = mock(HttpDelete.class);
        HttpResponse mockHttpResponse = mock(HttpResponse.class);

        //Mock functions
        when(mockBandwidthClient.getAccount()).thenReturn(testAccount);
        when(mockBandwidthClient.getClient()).thenReturn(mockHttpClient);
        when(mockBandwidthClient.getHttpDelete(testUrl)).thenReturn(mockHttpDelete);
        when(mockBandwidthClient.makeRequestApplicationControllerDelete(mockHttpClient, mockHttpDelete)).thenReturn(mockHttpResponse);
        when(mockBandwidthClient.parseResponse(mockHttpResponse)).thenReturn(testResponse);

        //Make response
        ApplicationController controller = new ApplicationController(mockBandwidthClient);
        String response = controller.deleteApplication(testApplicationId);

        //Verify response
        assertTrue(response.equals(testResponse));
    }

    /**
     * Test for getApplicationSipPeers
     */
    @Test
    public void testGetApplicationSipPeers() throws MalformedURLException, IOException {
        //Test values
        String testAccount = "12345";
        String testResponse = "67890";
        String testApplicationId = "321";
        String testUrl = ApplicationController.BASE_URL.replace("{account}", testAccount) + "/" + testApplicationId + "/associatedsippers";

        //Mock classes
        BandwidthClient mockBandwidthClient = mock(BandwidthClient.class);
        HttpClient mockHttpClient = mock(DefaultHttpClient.class);
        HttpGet mockHttpGet = mock(HttpGet.class);
        HttpResponse mockHttpResponse = mock(HttpResponse.class);

        //Mock functions
        when(mockBandwidthClient.getAccount()).thenReturn(testAccount);
        when(mockBandwidthClient.getClient()).thenReturn(mockHttpClient);
        when(mockBandwidthClient.getHttpGet(testUrl)).thenReturn(mockHttpGet);
        when(mockBandwidthClient.makeRequestApplicationControllerGet(mockHttpClient, mockHttpGet)).thenReturn(mockHttpResponse);
        when(mockBandwidthClient.parseResponse(mockHttpResponse)).thenReturn(testResponse);

        //Make response
        ApplicationController controller = new ApplicationController(mockBandwidthClient);
        String response = controller.getApplicationSipPeers(testApplicationId);

        //Verify response
        assertTrue(response.equals(testResponse));
    }
}
