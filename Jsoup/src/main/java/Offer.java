import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class Offer {
    private String name;
    private String http;
    private String price;
    private String description;

    Offer(String name, String http, String descr) {
        this.name = name;
        this.http = http;
        this.description = descr;
    }


    @Override
    public String toString() {
        return "Offer{" +
                "name='" + name + '\'' +
                ", http='" + http + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    String givePrice() throws IOException {

        try {
            Document document = Jsoup.connect(http).get();
            return "Cena z klasy: " + document.getElementsByClass("pricelabel__value").text();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Brak ceny";
    }

    public String getName() {
        return name;
    }

    public String getHttp() {
        return http;
    }
}
