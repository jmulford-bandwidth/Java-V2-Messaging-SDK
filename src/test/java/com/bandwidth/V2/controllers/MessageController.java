public class MessageController {

    protected static String BASE_URL = "https://api.catapult.inetwork.com/v2/users/{userId}/messages";

    private BandwidthClient client;
    private String url;

    public MessageController(final BandwidthClient client) {
        this.client = client;
        this.url = BASE_URL.replace("{userId}", client.userId);
    }

    public SendMessageResponse sendMessage(SendMessageRequestBody requestBody) {
        
    }

}
