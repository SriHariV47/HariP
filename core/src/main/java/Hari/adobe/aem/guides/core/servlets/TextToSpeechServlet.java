package Hari.adobe.aem.guides.core.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

@Component(
    service = { Servlet.class },
    property = {
        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
        "sling.servlet.paths=" + "/bin/textToSpeech"
    }
)
public class TextToSpeechServlet extends SlingAllMethodsServlet {

    private static final String API_URL = "https://cloudlabs-text-to-speech.p.rapidapi.com/synthesize";
    private static final String API_KEY = "YOUR_RAPIDAPI_KEY";
    private static final String API_HOST = "cloudlabs-text-to-speech.p.rapidapi.com";

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        
        String requestBody = request.getReader().lines()
                                  .reduce("", (accumulator, actual) -> accumulator + actual);

        JSONObject json = null;
        try {
            json = new JSONObject(requestBody);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String text = null;
        try {
            text = json.getString("text");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String audioUrl = null;
        try {
            audioUrl = callTextToSpeechApi(text);
        } catch (JSONException e1) {
            e1.printStackTrace();
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JSONObject jsonResponse = new JSONObject();
        try {
            jsonResponse.put("audioUrl", audioUrl);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        PrintWriter out = response.getWriter();
        out.print(jsonResponse.toString());
        out.flush();
    }

    private String callTextToSpeechApi(String text) throws IOException, JSONException {
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("X-RapidAPI-Key", API_KEY);
        connection.setRequestProperty("X-RapidAPI-Host", API_HOST);
        connection.setDoOutput(true);

        String requestBody = new JSONObject()
            .put("text", text)
            .put("voice", "en-US-Standard-D")
            .put("speed", "1.00")
            .put("pitch", "1.00")
            .toString();

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = requestBody.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        try (InputStream is = connection.getInputStream(); Scanner scanner = new Scanner(is)) {
            String response = scanner.useDelimiter("\\A").next();
            JSONObject jsonResponse = new JSONObject(response);
            return jsonResponse.getString("audioUrl");
        }
    }
}
