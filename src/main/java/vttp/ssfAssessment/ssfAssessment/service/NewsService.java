package vttp.ssfAssessment.ssfAssessment.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import vttp.ssfAssessment.ssfAssessment.model.News;

//service annotation
@Service
public class NewsService {

    @Value("${api_key}")
    private String apiKey;

    private static final Logger logger = LoggerFactory.getLogger(NewsService.class);
    
    //Task 1: write service that returns a list of news articles from the lates news articles endpoint
    //bsed on the Json data it looks like the key value pair is data: [{article}. {article}]. get teh article first

    //hard code the language first and return to param it later.
    public static final String NEWS_LS_URL = "https://min-api.cryptocompare.com/data/v2/news/?lang=EN";

    
    public ArrayList<Object> getArticles() {
        //Url adds the language and the api key.
        String newsListUrl = UriComponentsBuilder.fromUriString(NEWS_LS_URL)
                            .queryParam("api_key", apiKey)
                            .toUriString();
        //log the url
        logger.info("News List URL >>>>>> " + newsListUrl);
        //rest template takes the Json data
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.getForEntity(newsListUrl, String.class);
        ArrayList<Object> lsOfNews = News.lsOfNews(resp.getBody());
        return lsOfNews;


    }

    
    
}
