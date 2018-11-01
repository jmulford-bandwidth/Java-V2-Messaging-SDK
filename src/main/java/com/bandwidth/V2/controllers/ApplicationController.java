package com.bandwidth.V2.controllers;

//Bandwidth V2 packages
import com.bandwidth.V2.BandwidthClient;
import com.bandwidth.V2.models.CreateApplicationRequestBody;
import com.bandwidth.V2.models.PartialUpdateApplicationRequestBody;
import com.bandwidth.V2.models.CompleteUpdateApplicationRequestBody;

//Exceptions
import java.net.MalformedURLException;
import java.io.IOException;

public class ApplicationController {

    protected static String BASE_URL = "https://dashboard.bandwidth.com/api/accounts/{account}/applications";

    private BandwidthClient client;
    private String url;

    /**
     * Constructor for ApplicationController
     *
     * @param client The BandwidthClient object to make requests
     */
    public ApplicationController(BandwidthClient client) {
        this.client = client;
        this.url = BASE_URL.replace("{account}", client.getAccount());
    }

    /**
     * Creates a new application
     *
     * @param requestBody The CreateApplicationRequestBody object representing the request body parameters
     *
     * @return String: The response of the request
     *
     * @throws IOException IOException
     * @throws MalformedURLException MalformedURLException
     */
    public String createApplication(CreateApplicationRequestBody requestBody) throws IOException, MalformedURLException {
        return this.client.makeRequestApplicationControllerPost(this.url, requestBody.toJSON());
    }
   
    /**
     * Gets all applications
     *
     * @return String: The response of the request
     *
     * @throws IOException IOException
     * @throws MalformedURLException MalformedURLException
     */
    public String getApplications() throws IOException, MalformedURLException {
        return this.client.makeRequestApplicationControllerGet(this.url);
    }

    /**
     * Gets 1 application
     *
     * @param applicationId The ID of the application to retrieve
     *
     * @return String: The response of the request
     *
     * @throws IOException IOException
     * @throws MalformedURLException MalformedURLException
     */
    public String getApplication(String applicationId) throws IOException, MalformedURLException {
        return this.client.makeRequestApplicationControllerGet(this.url + "/" + applicationId);
    }

    /**
     * Partially updates 1 application
     *
     * @param requestBody The requestBody of the request
     * @param applicationId The application to update
     *
     * @return String: The response of the request
     *
     * @throws IOException IOException
     * @throws MalformedURLException MalformedURLException
     */
    public String partialUpdateApplication(PartialUpdateApplicationRequestBody requestBody, String applicationId) throws IOException, MalformedURLException {
        return this.client.makeRequestApplicationControllerPatch(this.url + "/" + applicationId, requestBody.toJSON());
    }

    /**
     * Completely updates 1 application
     *
     * @param requestBody The requestBody of the request
     * @param applicationId The application to update
     *
     * @return String: The response of the request
     *
     * @throws IOException IOException
     * @throws MalformedURLException MalformedURLException
     */
    public String completeUpdateApplication(CompleteUpdateApplicationRequestBody requestBody, String applicationId) throws IOException, MalformedURLException {
        return this.client.makeRequestApplicationControllerPut(this.url + "/" + applicationId, requestBody.toJSON());
    }

    /**
     * Deletes 1 application
     *
     * @param applicationId The ID of the application to delete
     *
     * @return String: The response of the request
     *
     * @throws IOException IOException
     * @throws MalformedURLException MalformedURLException
     */
    public String deleteApplication(String applicationId) throws IOException, MalformedURLException {
        return this.client.makeRequestApplicationControllerDelete(this.url + "/" + applicationId);
    }

    /**
     * Get all associated SipPeers (locations) for an application
     *
     * @param applicationId The ID of the application to get SipPeers from
     *
     * @return String: The response of the request
     *
     * @throws IOException IOException
     * @throws MalformedURLException MalformedURLException
     */
    public String getApplicationSipPeers(String applicationId) throws IOException, MalformedURLException {
        return this.client.makeRequestApplicationControllerGet(this.url + "/" + applicationId + "/associatedsippeers");
    }
}
