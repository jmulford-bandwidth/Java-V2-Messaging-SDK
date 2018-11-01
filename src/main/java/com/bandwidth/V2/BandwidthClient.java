package com.bandwidth.V2;

//Java IO packages
import java.io.BufferedReader;
import java.io.InputStreamReader;

//Exceptions
import java.io.IOException;

//Packages for http requests
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;


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

    public HttpPost getHttpPost(String url) {
        return new HttpPost(url);
    }

    /**
     * Creates an HTTP POST request on a Bandwidth Messaging url
     *
     * @param body The JSON request body
     * @param client HttpClient
     * @param post HttpPost
     *
     * @return String response from the request
     *
     * @throws IOException IOException
     */
    public String makeRequestMessageControllerPost(String body, HttpClient client, HttpPost post) throws IOException {
        String header = "content-type: application/json";
        String user = this.apiToken + ":" + this.apiSecret;

        post.setHeader("header", header);
        post.setHeader("user", user);
        post.setHeader("data", body);

        HttpResponse response = client.execute(post);

		BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		return result.toString();
    }

    public String makeRequestApplicationControllerGet(String url) {
        return "";
    }
    public String makeRequestApplicationControllerPost(String url, String body) {
        return "";
    }
    public String makeRequestApplicationControllerPatch(String url, String body) {
        return "";
    }
    public String makeRequestApplicationControllerPut(String url, String body) {
        return "";
    }
    public String makeRequestApplicationControllerDelete(String url) {
        return "";
    }
}
