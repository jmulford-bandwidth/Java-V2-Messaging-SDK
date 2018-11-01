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

        //Mock functions
        when(mockBandwidthClient.getAccount()).thenReturn(testAccount);
        when(mockBandwidthClient.makeRequestApplicationControllerPost(testUrl, testBody)).thenReturn(testResponse);
        when(mockRequestBody.toJSON()).thenReturn(testBody);

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

        //Mock functions
        when(mockBandwidthClient.getAccount()).thenReturn(testAccount);
        when(mockBandwidthClient.makeRequestApplicationControllerGet(testUrl)).thenReturn(testResponse);

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
        String testUrl = ApplicationController.BASE_URL.replace("{account}", testAccount);

        //Mock classes
        BandwidthClient mockBandwidthClient = mock(BandwidthClient.class);

        //Mock functions
        when(mockBandwidthClient.getAccount()).thenReturn(testAccount);
        when(mockBandwidthClient.makeRequestApplicationControllerGet(testUrl + "/" + testApplicationId)).thenReturn(testResponse);

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
        String testUrl = ApplicationController.BASE_URL.replace("{account}", testAccount);

        //Mock classes
        BandwidthClient mockBandwidthClient = mock(BandwidthClient.class);
        PartialUpdateApplicationRequestBody mockRequestBody = mock(PartialUpdateApplicationRequestBody.class);

        //Mock functions
        when(mockBandwidthClient.getAccount()).thenReturn(testAccount);
        when(mockBandwidthClient.makeRequestApplicationControllerPatch(testUrl + "/" + testApplicationId, testBody)).thenReturn(testResponse);
        when(mockRequestBody.toJSON()).thenReturn(testBody);

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
        String testUrl = ApplicationController.BASE_URL.replace("{account}", testAccount);

        //Mock classes
        BandwidthClient mockBandwidthClient = mock(BandwidthClient.class);
        CompleteUpdateApplicationRequestBody mockRequestBody = mock(CompleteUpdateApplicationRequestBody.class);

        //Mock functions
        when(mockBandwidthClient.getAccount()).thenReturn(testAccount);
        when(mockBandwidthClient.makeRequestApplicationControllerPut(testUrl + "/" + testApplicationId, testBody)).thenReturn(testResponse);
        when(mockRequestBody.toJSON()).thenReturn(testBody);

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
        String testUrl = ApplicationController.BASE_URL.replace("{account}", testAccount);

        //Mock classes
        BandwidthClient mockBandwidthClient = mock(BandwidthClient.class);

        //Mock functions
        when(mockBandwidthClient.getAccount()).thenReturn(testAccount);
        when(mockBandwidthClient.makeRequestApplicationControllerDelete(testUrl + "/" + testApplicationId)).thenReturn(testResponse);

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
        String testUrl = ApplicationController.BASE_URL.replace("{account}", testAccount);

        //Mock classes
        BandwidthClient mockBandwidthClient = mock(BandwidthClient.class);

        //Mock functions
        when(mockBandwidthClient.getAccount()).thenReturn(testAccount);
        when(mockBandwidthClient.makeRequestApplicationControllerGet(testUrl + "/" + testApplicationId + "/associatedsippeers")).thenReturn(testResponse);

        //Make response
        ApplicationController controller = new ApplicationController(mockBandwidthClient);
        String response = controller.getApplicationSipPeers(testApplicationId);

        //Verify response
        assertTrue(response.equals(testResponse));
    }
}
