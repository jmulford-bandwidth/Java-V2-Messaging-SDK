package com.bandwidth.V2.models;

/**
 * Wrapper class for holding request parameters for ApplicationController.partialUpdateApplication()
 */
public class PartialUpdateApplicationRequestBody {

    private String serviceType;
    private String appName;
    private String callbackUrl;
    private String callbackUsername;
    private String callbackPassword;

    /**
     * Constructor for PartialUpdateApplicationRequestBody
     *
     * @param serviceType The service type of the application
     * @param appName The name of the application
     * @param callbackUrl The callback url for the application
     * @param callbackUsername Basic auth username for the callback url
     * @param callbackPassword Basic auth password for the callback url
     */
    public PartialUpdateApplicationRequestBody(String serviceType, String appName, String callbackUrl, String callbackUsername, String callbackPassword) {
        this.serviceType = serviceType;
        this.appName = appName;
        this.callbackUrl = callbackUrl;
        this.callbackUsername = callbackUsername;
        this.callbackPassword = callbackPassword;
    }

    /**
     * Returns a XML representation of the class
     *
     * @return String: XML representation of the class
     */
    public String toXML() {
        String xml = "<Application>";
        if (this.serviceType != null && this.serviceType.length() > 0) {
            xml += "<ServiceType>" + this.serviceType + "</ServiceType>";
        }
        if (this.appName != null && this.appName.length() > 0) {
            xml += "<AppName>" + this.appName + "</AppName>";
        }
        if (this.callbackUrl != null && this.callbackUrl.length() > 0) {
            xml += "<CallbackUrl>" + this.callbackUrl + "</CallbackUrl>";
        }
        if (this.callbackUsername != null && this.callbackUsername.length() > 0 && this.callbackPassword != null && this.callbackPassword.length() > 0) {
            xml += "<CallbackCreds>";
            xml += "<UserId>" + this.callbackUsername + "</UserId>";
            xml += "<Password>" + this.callbackPassword + "</Password>";
            xml += "</CallbackCreds>";
        }

        xml += "</Application>";

        return xml;
    }
}
