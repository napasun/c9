package study;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import static java.lang.System.out;
import java.util.ArrayList;

public class SimpleWebCrawler {

    private final String topic;             // 페이지에 포함될 문자열
    private final String startingURL;       // 시작 URL
    private final String urlLimiter;        // 링크에 포함될 문자열
    private final int pageLimit = 20;       // 최대 검색 페이
    private final ArrayList<String> visitedList = new ArrayList();
    private final ArrayList<String> pageList = new ArrayList();

    public SimpleWebCrawler() {
        startingURL = "https://en.wikipedia.org/wiki/Bishop_Rock,_Isles_of_Scilly";
        urlLimiter = "Bishop_Rock";
        topic = "shipping route";
        visitPage(startingURL);
    }

    public void visitPage(String url) {
        if (pageList.size() >= pageLimit) {
            return;
        }
        if (visitedList.contains(url)) {
            // URL 이미 방문한 페이
        } else {
            visitedList.add(url);
            try {
                Document doc = Jsoup.connect(url).get();    // Jsoup 페이지를 구문 분석하고 Document 객체를 반환하는 데 사용됩니다.
                if (doc.text().contains(topic)) {       // 토픽 문자열이 포함된 페이지
                    out.println((pageList.size() + 1) + ": [" + url + "]");
                    pageList.add(url);

                    // Process page links
                    Elements questions = doc.select("a[href]");
                    for (Element link : questions) {
                        if (link.attr("href").contains(urlLimiter)) {       // 제한된 URL이 포함된 링크
                            visitPage(link.attr("abs:href"));
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SimpleWebCrawler();
    }

}

