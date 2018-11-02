# Bandwidth Java V2 Messaging SDK

Java SDK for [Bandwidth's V2 Messaging Platform](https://dev.bandwidth.com/v2-messaging/)

## pom.xml entry

```xml
<dependency>
    <groupId>com.bandwidth.sdk</groupId>
    <artifactId>bandwidth-v2-messaging</artifactId>
    <version><<<current-version>>></version>
</dependency>
```

## Developer guide

### Important links
* [Bandwidth Dashboard](dashboard.bandwidth.com)
* [Bandwidth Application](app.bandwidth.com)
* [Bandwidth Developer Homepage](dev.bandwidth.com)


Documentation for the SDK can be found [here](http://www.javadoc.io/doc/com.bandwidth.sdk/bandwidth-v2-messaging/)
(Not yet live)

The Java Bandwidth V2 Messaging SDK works in 3 parts:
* BandwidthClient
* Model objects
* Controller objects

The BandwidthClient object holds your HTTP credentials. There are 6 values held by this object

| Variable    | Description                                            | example        |
|:------------|:-------------------------------------------------------|:---------------|
| `userId`    | Your userId (not your username) from app.bandwidth.com | `u-abc123`     |
| `apiToken`  | Your API token from app.bandwidth.com                  | `t-abc123`     |
| `apiSecret` | Your API secret from app.bandwidth.com                 | `asdf123`      |
| `username`  | Your username used to login to dashboard.bandwidth.com | `yourUserName` |
| `password`  | Your password used to login to dashboard.bandwidth.com | `yourP@ssw0rd` |
| `account`   | Your account number from dashboard.bandwidth.com       | `992299`       |

BandwidthClient objects are responsible for making HTTP requests on Bandwidth's API endpoints, and for setting up proper authentication headers.

<br>

Model objects are used to store request body parameters. Model objects contain functions that convert themselves to JSON or XML, depending on the API endpoint used with the model.

<br>

Controller objects are used to set up requests on Bandwidth's API, and use the BandwidthClient to execute these requests. If the request requires a request body, the corresponding controller function will require a model object as a parameter.

<br>

Below is a code sample showing how these objects interact

```java
import com.bandwidth.V2.BandwidthClient;
import com.bandwidth.V2.models.*;
import com.bandwidth.V2.controllers.*;

import java.util.ArrayList;

public class BandwidthV2Messaging() {

    public static void main(String[] args) {
        static final String userId = "userId";
        static final String apiToken = "apiToken";
        static final String apiSecret = "apiSecret";
        static final String username = "username";
        static final String password = "password";
        static final String account = "account";

        BandwidthClient client = new BandwidthClient(userId, apiToken, apiSecret,
                                                     username, password, account);
        MessageController messageController = new MessageController(client);
        ApplicationController applicationController = new ApplicationController(client);

        //Send a single text message
        ArrayList<String> to = new ArrayList<String>();
        to.add("+18887776666");
        String from = "+13334445555"; //Bandwidth phone number
        String text = "Message content";
        String applicationId = "applicationId";
        ArrayList<String> media = new ArrayList<String>();
        media.add("example.com/testurl.png");
        String tag = "{\"next-step\":\"await-response\"}";

        SendMessageRequestBody body = new SendMessageRequestBody(to, from, text,
                                                                 applicationId, media,
                                                                 tag);
        controller.sendMessage(body);

        //Send a group text message
        ArrayList<String> to = new ArrayList<String>();
        to.add("+18887776666");
        to.add("+18887776665");
        to.add("+18887776664");
        to.add("+18887776663");
        String from = "+13334445555"; //Bandwidth phone number
        String text = "Message content";
        String applicationId = "applicationId";
        ArrayList<String> media = new ArrayList<String>();
        media.add("example.com/testurl.png");
        String tag = "{\"next-step\":\"await-response\"}";

        SendMessageRequestBody body = new SendMessageRequestBody(to, from, text,
                                                                 applicationId, media,
                                                                 tag);
        messageController.sendMessage(body);

        //Create an application
        String serviceType = "Messaging-V2";
        String appName = "App Name";
        String callbackUrl = "yourUrl.com";
        String callbackUsername = "yourUrl username";
        String callbackPassword = "yourUrl password";

        CreateApplicationRequestBody body = new CreateApplicationRequestBody(serviceType,
                                                                             appName,
                                                                             callbackUrl,
                                                                             callbackUsername,
                                                                             callbackPassword);
        applicationController.createApplication(body);

        //Get an application
        String applicationId = "applicationId";

        applicationController.getApplication(applicationId);

        //Delete an application
        String applicationId = "applicationId";

        applicationController.deleteApplication(applicationId);

        //Get all applications
        applicationController.getApplications();

        //Partially update an application
        String applicationId = "applicationId";
        String newAppName = "New App Name";

        PartialUpdateApplicationRequestBody = new PartialUpdateApplicationRequestBody(null, 
                                                                                      newAppName,
                                                                                      null,
                                                                                      null,
                                                                                      null);
        applicationController.partialUpdateApplication(body, applicationId);

        //Completely update an application
        String newServiceType = "Messaging-V2";
        String newAppName = "New App Name";
        String newCallbackUrl = "newYourUrl.com";
        String newCallbackUsername = "newYourUrl username";
        String newCallbackPassword = "newYourUrl password";
        String applicationId = "applicationId";

        CompleteUpdateApplicationRequestBody = new CompleteUpdateApplicationRequestBody(newServiceType,
                                                                                        newAppName,
                                                                                        newCallbackUrl,
                                                                                        newCallbackUsername,
                                                                                        newCallbackPassword);
        applicationController.completeUpdateApplication(body, applicationId);

        //Get an application's SIP Peers
        String applicationId = "applicationId";

        applicationController.getApplicationSipPeers(applicationId);
    }
}
```
