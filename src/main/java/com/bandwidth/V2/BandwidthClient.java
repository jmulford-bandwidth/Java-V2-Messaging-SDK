package com.bandwidth.V2;

//Java IO packages
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

//Exceptions
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

//Java packages
import java.util.Base64;


/**
 * Wrapper class for making http requests and storing user credentials for Bandwidth's APIs
 */
public class BandwidthClient {

    private String userId;
    private String apiToken;
    private String apiSecret;
    private String username;
    private String password;
    private String account;

    /**
     * Constructor for BandwidthClient
     *
     * @param userId UserId fom app.bandwidth.com (not username)
     * @param apiToken API Token fom app.bandwidth.com
     * @param apiSecret API Secret fom app.bandwidth.com
     * @param username Username for dashboard.bandwidth.com
     * @param password Password for dashboard.bandwidth.com
     * @param account Sub account fom dashboard.bandwidth.com 
     */
    public BandwidthClient(String userId, String apiToken, String apiSecret, String username, String password, String account) {
        this.userId = userId;
        this.apiToken = apiToken;
        this.apiSecret = apiSecret;
        this.username = username;
        this.password = password;
        this.account = account;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getApiToken() {
        return this.apiToken;
    }

    public String getApiSecret() {
        return this.apiSecret;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getAccount() {
        return this.account;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public HttpClient getClient() {
        return new DefaultHttpClient();
    }

    public StringEntity getStringEntity(String body) throws UnsupportedEncodingException {
        return new StringEntity(body);
    }

    public HttpPost getHttpPost(String url) {
        return new HttpPost(url);
    }

    public HttpGet getHttpGet(String url) {
        return new HttpGet(url);
    }

    public HttpPatch getHttpPatch(String url) {
        return new HttpPatch(url);
    }

    public HttpPut getHttpPut(String url) {
        return new HttpPut(url);
    }

    public HttpDelete getHttpDelete(String url) {
        return new HttpDelete(url);
    }

    /**
     * Parses an http response
     *
     * @param response Http response
     *
     * @return String parsed response
     *
     * @throws IOException IOException
     */
    public String parseResponse(HttpResponse response) throws IOException {
		BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		return result.toString();
    }

    /**
     * Creates an HTTP POST request on a Bandwidth Messaging url
     *
     * @param entity StringEntity of the JSON request body
     * @param client HttpClient
     * @param post HttpPost
     *
     * @return HttpResponse response from the request
     *
     * @throws IOException IOException
     */
    public HttpResponse makeRequestMessageControllerPost(StringEntity entity, HttpClient client, HttpPost post) throws IOException {
        String encoding = Base64.getEncoder().encodeToString((this.apiToken + ":" + this.apiSecret).getBytes("UTF-8"));

        post.setHeader("Content-type", "application/json");
        post.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
        post.setEntity(entity);

        return client.execute(post);
    }

    /**
     * Creates an HTTP Get request on a Bandwidth Application url
     *
     * @param client HttpClient
     * @param get HttpGet
     *
     * @throws IOException IOException
     */
    public HttpResponse makeRequestApplicationControllerGet(HttpClient client, HttpGet get) throws IOException {
        String encoding = Base64.getEncoder().encodeToString((this.username + ":" + this.password).getBytes("UTF-8"));

        get.setHeader("Content-type", "application/xml");
        get.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);

        return client.execute(get);
    }

    /**
     * Creates an HTTP Delete request on a Bandwidth Application url
     *
     * @param client HttpClient
     * @param delete HttpDelete
     *
     * @throws IOException IOException
     */
    public HttpResponse makeRequestApplicationControllerDelete(HttpClient client, HttpDelete delete) throws IOException {
        String encoding = Base64.getEncoder().encodeToString((this.username + ":" + this.password).getBytes("UTF-8"));

        delete.setHeader("Content-type", "application/xml");
        delete.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);

        return client.execute(delete);
    }

    /**
     * Creates an HTTP Post request on a Bandwidth Application url
     *
     * @param entity StringEntity of the XML request body
     * @param client HttpClient
     * @param post HttpPost
     */
    public HttpResponse makeRequestApplicationControllerPost(StringEntity entity, HttpClient client, HttpPost post) throws IOException {
        String encoding = Base64.getEncoder().encodeToString((this.username + ":" + this.password).getBytes("UTF-8"));

        post.setHeader("Content-type", "application/xml");
        post.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
        post.setEntity(entity);

        return client.execute(post);
    }

    /**
     * Creates an HTTP Patch request on a Bandwidth Application url
     *
     * @param entity StringEntity of the XML request body
     * @param client HttpClient
     * @param patch HttpPatch
     */
    public HttpResponse makeRequestApplicationControllerPatch(StringEntity entity, HttpClient client, HttpPatch patch) throws IOException {
        String encoding = Base64.getEncoder().encodeToString((this.username + ":" + this.password).getBytes("UTF-8"));

        patch.setHeader("Content-type", "application/xml");
        patch.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
        patch.setEntity(entity);

        return client.execute(patch);
    }

    /**
     * Creates an HTTP Put request on a Bandwidth Application url
     *
     * @param entity StringEntity of the XML request body
     * @param client HttpClient
     * @param put HttpPut
     */
    public HttpResponse makeRequestApplicationControllerPut(StringEntity entity, HttpClient client, HttpPut put) throws IOException {
        String encoding = Base64.getEncoder().encodeToString((this.username + ":" + this.password).getBytes("UTF-8"));

        put.setHeader("Content-type", "application/xml");
        put.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
        put.setEntity(entity);

        return client.execute(put);
    }
}
