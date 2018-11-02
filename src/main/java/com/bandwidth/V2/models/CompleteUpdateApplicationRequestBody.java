package com.bandwidth.V2.models;

import org.immutables.value.Value;

/**
 * Wrapper class for holding request parameters for ApplicationController.completeUpdateApplication()
 */
@Value.Immutable
public abstract class CompleteUpdateApplicationRequestBody {

    public abstract String serviceType();
    public abstract String appName();
    public abstract String callbackUrl();
    public abstract String callbackUsername();
    public abstract String callbackPassword();

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
