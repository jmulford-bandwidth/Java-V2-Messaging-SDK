package com.bandwidth.V2.controllers;

//Bandwidth V2 packages
import com.bandwidth.V2.BandwidthClient;

public class ApplicationController {

    protected static String BASE_URL = "https://dashboard.bandwidth.com/api/accounts/{account}/applications";

    private BandwidthClient client;
    private String url;

    public ApplicationController(final BandwidthClient client) {
        this.client = client;
        this.url = BASE_URL.replace("{account}", client.getAccount());
    }

    /*
    public CreateApplicationResponse createApplication(CreateApplicationRequestBody requestBody) {
        
    }
    
    public GetApplicationsResponse getApplications() {
        
    }

    public GetApplicationResponse getApplication(String applicationId) {
        
    }

    public PartialUpdateApplicationResponse partialUpdateApplication(PartialUpdateApplicationRequestBody requestBody, String applicationId) {
        
    }

    public CompleteUpdateApplicationResponse completeUpdateApplication(CompleteUpdateApplicationRequestBody requestBody, String applicationId) {
        
    }

    public DeleteApplicationResponse deleteApplication(String applicationId) {
        
    }

    public GetApplicationSipPeersResponse getApplicationSipPeers(String applicationId) {

    }
    */
}
