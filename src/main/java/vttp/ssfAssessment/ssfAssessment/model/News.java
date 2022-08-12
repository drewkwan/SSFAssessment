package vttp.ssfAssessment.ssfAssessment.model;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;

public class News {
    //needs a save method later
    private static final Logger logger = LoggerFactory.getLogger(News.class);
    //private String lang = "EN";
    private String id;
    private String publishDate;
    private String url;
    private String imageurl;
    private String body;
    private String tags;
    private String categories;
    private String title;


    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImageurl() {
        return imageurl;
    }
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    public String getCategories() {
        return categories;
    }
    public void setCategories(String categories) {
        this.categories = categories;
    }


    public static ArrayList<News> lsOfNews(String json)  {
        //logger.info("news create Json " + json); -> receives json file correctly
        InputStream is = new ByteArrayInputStream(json.getBytes());
        try (JsonReader r = Json.createReader(is);) {
            JsonObject newsJO = r.readObject();
            // logger.info("KEYS >>>> keySet" + newsJO.keySet());
            // logger.info("VALUES >>>>>>>>> " + newsJO.values());
            //try json array instead
            
            //the below gets me the full json array instead of  the []
            JsonArray data = newsJO.getJsonArray("Data");
            logger.info("Json array >>>>>>> " + data);
            logger.info("");
            logger.info("@#$!!!!!");
            logger.info("first element !!!!!>> " +data.getJsonObject(0) );

            

            ArrayList<News> newsListFromArray = new ArrayList<>();
            for (JsonValue value:data) {
                JsonObject newsList = value.asJsonObject();
                News news = News.createNews(newsList);
                newsListFromArray.add(news);
                logger.info("the new list!!! >>>>>> " + newsListFromArray.get(0).toString());
                logger.info(news.getId().toString());
            }

            return newsListFromArray;
        }

        //the logger is showing me like a full class                            

    }

    private static News createNews(JsonObject o) {
        News news = new News();
        news.setBody(o.get("body").toString());
        news.setId(o.get("id").toString());
        news.setTitle(o.get("title").toString());
        news.setPublishDate(o.get("published_on").toString());
        news.setImageurl(o.get("imageurl").toString());
        news.setCategories(o.get("categories").toString());
        news.setTags(o.get("tags").toString());
        news.setUrl(o.get("url").toString());

        return news;
    }

    

    
}
