import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public class Run {
    public static void main(String[] args) throws IOException {



        String link = "https://www.olx.pl/motoryzacja/samochody/";
        int pages = 0;
        List<Offer> offersList = new LinkedList<>();

        try {
            Document documentPage = Jsoup.connect(link).get();
            Elements elements1 = documentPage
                    .getElementsByAttributeValueContaining("data-cy", "page-link-last");
//                    .getElementsByAttributeValueContaining("summary", "Ogłoszenie");

            pages = Integer.parseInt(elements1.text());
            pages = Integer.parseInt(elements1.text());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Elements elements2;

        for (int i = 1; i <= 5; i++) {
            Document document =
                    Jsoup.connect(link + "?page=" + i).get();

            elements2 = document.getElementsByClass("marginright5 link linkWithHash detailsLinkPromoted linkWithHashPromoted");

            System.out.println("Elementy = page: " + i + " " + elements2.size());
            for (Element elementsIn : elements2) {


//                System.out.println(elementsIn.getElementsByTag("strong").eachText());
                Offer offerToAdd = new Offer(elementsIn.attr("title"), elementsIn.attr("href"),elementsIn.getElementsByTag("strong").text() );
                offersList.add(offerToAdd);
            }
        }
        AtomicInteger offerCounter = new AtomicInteger();
        AtomicLong offerPrice = new AtomicLong();
        String regex = "[0-9]*";
        Pattern pattern = Pattern.compile(regex);
        offersList.forEach(s -> {

            try {
                System.out.println(s + " cena: " + s.givePrice());
                System.out.println("regex " + s.givePrice().trim().replaceAll("[^0-9,]", "")
                        .replaceAll(",", "."));
                offerCounter.addAndGet(1);
                //Matcher matcher = pattern.matcher(s.givePrice().replaceAll("^[0-9]",""));
//                wh

                offerPrice.addAndGet(1);
                // offerCounter.updateAndGet(a -> (a)*10);
                //System.out.println(Integer.parseInt(offerCounter.toString(),2));
                System.out.println(offerCounter.longValue());
                System.out.println(offerPrice.longValue());
                System.out.println(offerPrice.longValue() / offerCounter.longValue());

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Ilość stron: " + pages);
    }
}