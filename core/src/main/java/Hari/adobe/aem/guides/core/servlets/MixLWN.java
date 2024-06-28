package Hari.adobe.aem.guides.core.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class)
@SlingServletPaths(value = { "/bin/apps/mixed" })
public class MixLWN extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws IOException {
        String session = request.getParameter("session");
        String Type = request.getParameter("type");
        
        String generatedString=null;

        if (session != null && Type!= null) {
            if (Type.equalsIgnoreCase("Letters")) {
                generatedString = generateRandomWord(6, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            } else if (Type.equalsIgnoreCase("Numbers")) {
                generatedString = generateRandomWord(6, "0123456789");
            } else if (Type.equalsIgnoreCase("Mixed")) {
                generatedString = generateRandomMixedWord(3, 3);
            }
        } else {
            generatedString = "no parameters";
        }

        response.getWriter().write(generatedString);
    }

    private String generateRandomWord(int length, String allowedCharacters) {
        StringBuilder randomWord = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allowedCharacters.length());
            randomWord.append(allowedCharacters.charAt(index));
        }

        return randomWord.toString();
    }

    private String generateRandomMixedWord(int lettersCount, int numbersCount) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        StringBuilder mixedWord = new StringBuilder();

        for (int i = 0; i < lettersCount; i++) {
            mixedWord.append(generateRandomWord(1, letters));
        }

        for (int i = 0; i < numbersCount; i++) {
            mixedWord.append(generateRandomWord(1, numbers));
        }

        return mixedWord.toString();
    }
}
