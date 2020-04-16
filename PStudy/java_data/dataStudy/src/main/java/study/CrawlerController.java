package study;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class CrawlerController {    // 크롤러 설정 클래
    public static void main(String[] args) throws Exception {
        int numberOfCrawlers = 2;
        CrawlConfig config = new CrawlConfig();
        String crawlStorageFolder = "data";

        config.setCrawlStorageFolder(crawlStorageFolder);   // 크롤링이 저장되는 폴더
        config.setPolitenessDelay(500);  // 요청사이에 지연시간 설정
        config.setMaxDepthOfCrawling(2); // 크롤링 깊이 설정
        config.setMaxPagesToFetch(20);   // 최대 검색 페이
        config.setIncludeBinaryContentInCrawling(false); //PDF 파일과 같은 이진 데이터를 크롤링할지 여부
        /**
         * RobotstxtConfig 및 RobotstxtServer robot.txt 파일을 처리하는 데 사용되는 클래스
         * 이 파일에는 웹 크롤러가 읽어야하는 지침이 포함되어 있습니다. 크롤러가 크롤링해서는 안되는 사이트 부분을 지정하는 등 크롤러가 더 나은 작업을 수행 할 수 있도록 지침을 제공합니다. 자동 생성 페이지에 유용합니다.
         * */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
        // 시작 페이지 추가, 필요한 만큼 추가 가능하다.
        controller.addSeed("https://en.wikipedia.org/wiki/Bishop_Rock,_Isles_of_Scilly");
        // start 함수는 크롤링 프로세스를 시작한다.
        controller.start(SampleCrawler.class, numberOfCrawlers);
    }
}
