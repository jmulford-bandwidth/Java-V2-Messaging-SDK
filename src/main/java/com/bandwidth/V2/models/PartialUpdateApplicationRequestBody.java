package com.bandwidth.V2.models;

import org.immutables.value.Value;

import java.util.Optional;

/**
 * Wrapper class for holding request parameters for ApplicationController.partialUpdateApplication()
 */
@Value.Immutable
public abstract class PartialUpdateApplicationRequestBody {

    public abstract Optional<String> serviceType();
    public abstract Optional<String> appName();
    public abstract Optional<String> callbackUrl();
    public abstract Optional<String> callbackUsername();
    public abstract Optional<String> callbackPassword();

    /**
     * Returns a XML representation of the class
     *
     * @return String: XML representation of the class
     */
    public String toXML() {
        String xml = "<Application>";
        if (this.serviceType().isPresent()) {
            xml += "<ServiceType>" + this.serviceType().get() + "</ServiceType>";
        }
        if (this.appName().isPresent()) {
            xml += "<AppName>" + this.appName().get() + "</AppName>";
        }
        if (this.callbackUrl().isPresent()) {
            xml += "<CallbackUrl>" + this.callbackUrl().get() + "</CallbackUrl>";
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
