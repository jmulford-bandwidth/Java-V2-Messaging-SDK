package com.bandwidth.V2.models;

//Package for converting class to JSON
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//Java packages
import java.util.ArrayList;

/**
 * Wrapper class for holding request parameters for MessageController.SendMessage()
 */
@JsonInclude(Include.NON_NULL)
public class SendMessageRequestBody {

    public ArrayList<String> to;
    public String from;
    public String text;
    public String applicationId;
    public ArrayList<String> media;
    public String tag;

    /**
     * Constructor for SendMessageRequestBody
     *
     * @param from The Bandwidth number sending the message
     * @param to Recipient(s) of the message
     * @param text The text contents of the message
     * @param applicationId The application in the Bandwidth Dashbard using this number
     * @param media Included media to send
     * @param tag Custom user tag to include in the callback
     */
    public SendMessageRequestBody(ArrayList<String> to, String from, String text, String applicationId, ArrayList<String> media, String tag) {
       this.to = to;
       this.from = from;
       this.text = text;
       this.applicationId = applicationId;
       this.media = media;
       this.tag = tag; 
    }

    /**
     * Returns a JSON representation of the class
     *
     * @return String: JSON representation of the class
     *
     * @throws JsonProcessingException JsonProcessingException
     */
    public String toJSON() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        /*String json = "{";

        if (this.from != null && this.from.length() > 0) {
            json += "
        }

        json += "}";
        return json;*/
        return om.writeValueAsString(this);
    }
}
