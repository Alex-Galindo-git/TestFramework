package website;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequestStatus extends BasePage  {


  public HttpRequestStatus(WebDriver driver){
    super(driver);
  }

  private static HttpURLConnection connection;

  public static void HttpURLStatus(String link) {
    try {
      // method to check on server status , urls will be check for  OK status
      URL url = new URL(link);

      connection = (HttpURLConnection) url.openConnection();

      connection.setRequestMethod("GET");
      connection.setConnectTimeout(5000);
      connection.setReadTimeout(5000);

      int status = connection.getResponseCode();
      System.out.println("Status is = " + status + " for url " + url);

    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


