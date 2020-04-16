package study;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

import java.util.regex.Pattern;

import static java.lang.System.out;

public class SampleCrawler extends WebCrawler {
    private static final Pattern IMAGE_EXTENSIONS = Pattern.compile(".*\\.(bmp|gif|jpg|png)$");

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {    // 페이지 방문여
        String href = url.getURL().toLowerCase();
        if (IMAGE_EXTENSIONS.matcher(href).matches()) {     // 일치하는 이미지가 있으
            return false;
        }
        return href.startsWith("https://en.wikipedia.org/wiki/");   // 해당하는 URL으로 시작한다.
    }

    @Override
    public void visit(Page page) {      // 페이지 처리 방법,  방문한 페이지가 전달된다.
        int docid = page.getWebURL().getDocid();
        String url = page.getWebURL().getURL();

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String text = htmlParseData.getText();
            if (text.contains("shipping route")) {
                out.println("\nURL: " + url);
                out.println("Text: " + text);
                out.println("Text length: " + text.length());
            }
        }
    }
}
