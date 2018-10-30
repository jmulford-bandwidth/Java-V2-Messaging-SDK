public class BandwidthClient {

    protected String userId;
    protected String apiToken;
    protected String apiSecret;
    protected String username;
    protected String password;

    protected static BandwidthClient INSTANCE;

    public synchronized static BandwidthClient getInstance() {
        if (INSTANCE == null) {
            String userId = "";//TODO: Replace with env variables
            String apiToken = "";
            String apiSecret = "";
            String username = "";
            String password = "";
            String account = "";

            INSTANCE = new BandwidthClient(userId, apiToken, apiSecret, username, password, account);
        }

        return INSTANCE;
    }

    protected BandwidthClient(final String userId, final String apiToken, final String apiSecret, final String username, final String password, final String account) {
        this.userId = userId;
        this.apiToken = apiToken;
        this.apiSecret = apiSecret;
        this.username = username;
        this.password = password;
        this.account = account;
    }

}
