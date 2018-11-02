package com.bandwidth.V2.models;

import org.immutables.value.Value;

import java.util.Optional;

/**
 * Wrapper class for holding request parameters for ApplicationController.completeUpdateApplication()
 */
@Value.Immutable
public abstract class CompleteUpdateApplicationRequestBody {

    public abstract String serviceType();
    public abstract String appName();
    public abstract String callbackUrl();
    public abstract Optional<String> callbackUsername();
    public abstract Optional<String> callbackPassword();

    /**
     * Returns a XML representation of the class
     *
     * @return String: XML representation of the class
     */
    public String toXML() {
        String xml = "<Application>";
        if (this.serviceType() != null && this.serviceType().length() > 0) {
            xml += "<ServiceType>" + this.serviceType() + "</ServiceType>";
        }
        if (this.appName() != null && this.appName().length() > 0) {
            xml += "<AppName>" + this.appName() + "</AppName>";
        }
        if (this.callbackUrl() != null && this.callbackUrl().length() > 0) {
            xml += "<CallbackUrl>" + this.callbackUrl() + "</CallbackUrl>";
        }
        if (this.callbackUsername().isPresent() && this.callbackPassword().isPresent()) {
            xml += "<CallbackCreds>";
            xml += "<UserId>" + this.callbackUsername().get() + "</UserId>";
            xml += "<Password>" + this.callbackPassword().get() + "</Password>";
            xml += "</CallbackCreds>";
        }

        xml += "</Application>";

        return xml;
    }
}

