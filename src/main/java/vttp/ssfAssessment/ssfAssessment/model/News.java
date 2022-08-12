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
    private int id;
    private String publishDate;
    private String url;
    private String imageurl;
    private String body;
    private String tags;
    private String categories;


    
    public int getId() {
        return id;
    }
    public void setId(int id) {
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


    public static ArrayList<Object> lsOfNews(String json)  {
        //logger.info("news create Json " + json); -> receives json file correctly
        InputStream is = new ByteArrayInputStream(json.getBytes());
        try (JsonReader r = Json.createReader(is);) {
            JsonObject newsJO = r.readObject();
            // logger.info("KEYS >>>> keySet" + newsJO.keySet());
            // logger.info("VALUES >>>>>>>>> " + newsJO.values());
            //try json array instead
            
            //nice the below gets me the full json array instead of  the []
            JsonArray data = newsJO.getJsonArray("Data");
            logger.info("Json array >>>>>>> " + data);
            logger.info("");
            logger.info("@#$!!!!!");
            logger.info("first element !!!!!>> " +data.getJsonObject(0) );

            

             ArrayList<Object> newsList = new ArrayList();
             if(data!= null) {
                 for(int i=0; i<data.size(); i++) {
                     newsList.add(data.getJsonObject(i));
                 }
             }
            logger.info(newsList.get(0).toString());

            return newsList;
        }

        //

    }

    

    
}
