package com.bandwidth.V2.controllers;

//Bandwidth V2 packages
import com.bandwidth.V2.BandwidthClient;
import com.bandwidth.V2.models.CreateApplicationRequestBody;
import com.bandwidth.V2.models.PartialUpdateApplicationRequestBody;
import com.bandwidth.V2.models.CompleteUpdateApplicationRequestBody;

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
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.DefaultHttpClient;


/**
 * Class to handle requests on Bandwidth's Application URLs
 */
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
        String body = requestBody.toXML();
        StringEntity entity = this.client.getStringEntity(body);
        String fullUrl = this.url;
        HttpClient client = this.client.getClient();
        HttpPost post = this.client.getHttpPost(fullUrl);
        HttpResponse response = this.client.makeRequestApplicationControllerPost(entity, client, post);
        return this.client.parseResponse(response);
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
        String body = requestBody.toXML();
        StringEntity entity = this.client.getStringEntity(body);
        String fullUrl = this.url + "/" + applicationId;
        HttpClient client = this.client.getClient();
        HttpPatch patch = this.client.getHttpPatch(fullUrl);
        HttpResponse response = this.client.makeRequestApplicationControllerPatch(entity, client, patch);
        return this.client.parseResponse(response);
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
        String body = requestBody.toXML();
        StringEntity entity = this.client.getStringEntity(body);
        String fullUrl = this.url + "/" + applicationId;
        HttpClient client = this.client.getClient();
        HttpPut put = this.client.getHttpPut(fullUrl);
        HttpResponse response = this.client.makeRequestApplicationControllerPut(entity, client, put);
        return this.client.parseResponse(response);
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
