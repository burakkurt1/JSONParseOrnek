
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;

public class App {

    public static void main(String[] args) throws Exception {
        String adr = "http://ecivas.com/users.json";

        String jsonString = Jsoup.connect(adr)
                .timeout(30000)
                .ignoreContentType(true)
                .get().text();

        JSONParser parser = new JSONParser();

        JSONArray userarray = (JSONArray) parser.parse(jsonString);

        System.out.println("Kişi sayısı : " + userarray.size());

        for (int i = 0; i < userarray.size(); i++) {

            JSONObject user = (JSONObject) userarray.get(i);
            String un = user.get("un").toString();
            String fn = user.get("fn").toString();
            System.out.println(un + " - " + fn);

        }
    }
}
