package com.bandwidth.V2.controllers;

//Bandwidth V2 packages
import com.bandwidth.V2.models.SendMessageRequestBody;
import com.bandwidth.V2.BandwidthClient;

//Exceptions
import java.net.MalformedURLException;
import java.io.IOException;

/**
 * Class to handle requests on Bandwidth's Messaging URLs
 */
public class MessageController {

    protected static String BASE_URL = "https://api.catapult.inetwork.com/v2/users/{userId}/messages";
    protected static String SEND_MESSAGE_URL = "";

    private BandwidthClient client;
    private String url;

    /**
     * Constructor for MessageController
     *
     * @param client The BandwidthClient object to make requests
     */
    public MessageController(BandwidthClient client) {
        this.client = client;
        this.url = BASE_URL.replace("{userId}", client.getUserId());
    }

    /**
     * Takes a SendMessageRequestBody object and calls the client function makeRequestMessageControllerPost()
     *
     * @param requestBody The SendMessageRequestBody object representing the request body parameters
     *
     * @return String: The response of the request
     *
     * @throws IOException IOException
     * @throws MalformedURLException MalformedURLException
     */
    public String sendMessage(SendMessageRequestBody requestBody) throws MalformedURLException, IOException {
        String body = requestBody.toJSON();
        String fullUrl = this.url + SEND_MESSAGE_URL;
        return this.client.makeRequestMessageControllerPost(fullUrl, body);
    }
}
