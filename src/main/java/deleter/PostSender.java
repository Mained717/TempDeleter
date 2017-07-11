package deleter;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created on 10-Jul-17.
 * <p>
 * Class for sending POST request to Notifier
 * <p>
 * IMPORTANT NOTE!!!! DO NOT CHANGE THIS CLASS!
 * Any changes will change POST request structure or POST url and request will be not processed by Notifier
 */
public class PostSender {

    public void sendPost(FileDeleterStatistic newReport) {
        String postUrl = "http://localhost:4567/send-temp-deleter-report";

        Gson gson = new Gson();
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(postUrl);
        StringEntity postingString = null;
        try {
            postingString = new StringEntity(gson.toJson(newReport));
        } catch (UnsupportedEncodingException e) {
            System.out.println("Can't parse to json((\n\n" + e.getMessage());
        }
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");
        try {
            HttpResponse response = httpClient.execute(post);
            System.out.println("RESPONSE " + response);
        } catch (IOException e) {
            System.out.println("Can't send post \n\n" + e.getMessage());
            e.printStackTrace();
        }
    }
}
