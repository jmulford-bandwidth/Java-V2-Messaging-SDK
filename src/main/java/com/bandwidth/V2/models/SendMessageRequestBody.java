package com.bandwidth.V2.models;

//Package for converting class to JSON
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

//Java packages
import java.util.ArrayList;

/**
 * Wrapper class for holding request parameters for MessageController.SendMessage()
 */
public class SendMessageRequestBody {

    public String from;
    public ArrayList<String> to;
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
    public SendMessageRequestBody(String from, ArrayList<String> to, String text, String applicationId, ArrayList<String> media, String tag) {
       this.from = from;
       this.to = to;
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
        return om.writeValueAsString(this);
    }
}
