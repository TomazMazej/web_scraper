import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        String name, jockey, odds, number;
        Horse horse = new Horse();
        List<Horse> horses = new ArrayList<>();

        try {
            Document doc = Jsoup.connect("https://www.sportinglife.com/racing/racecards/2020-04-10/gulfstream/racecard/570036/race-1-maiden-claiming").timeout(6000).get();
            Elements element = doc.select("div.hr-racing-racecard-wrapper");

            for(Element e : element.select("div").select("section.hr-racing-runner-wrapper")){
                number = e.select("span.hr-racing-runner-saddle-cloth-no").text();
                name = e.select("span.hr-racing-runner-horse-name").select("a").text();
                jockey = e.select("span.hr-racing-runner-form-jockey-name").text();
                odds = e.select("div.hr-racing-runner-betting-odds").select("a").text();

                horse = new Horse(Integer.parseInt(number), name, jockey, odds);
                horses.add(horse);
                System.out.println(number + " " + name + " " + jockey + " " + odds);
            }

            FileWriter myWriter = new FileWriter("horses.json");
            String json = new Gson().toJson(horses);
            myWriter.write(json);
            myWriter.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
