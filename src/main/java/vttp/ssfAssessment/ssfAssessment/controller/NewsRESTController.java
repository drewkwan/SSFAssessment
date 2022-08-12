package vttp.ssfAssessment.ssfAssessment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp.ssfAssessment.ssfAssessment.model.News;
import vttp.ssfAssessment.ssfAssessment.service.NewsRedis;
import vttp.ssfAssessment.ssfAssessment.service.NewsService;

@RestController
@RequestMapping(path= "/news")
public class NewsRESTController {
    private static final Logger logger = LoggerFactory.getLogger(NewsRESTController.class);

    @Autowired
    NewsRedis service;

    @GetMapping(path ="/{newsId}")
    public ResponseEntity<News> getNewsById(@PathVariable String newsId) {
        News n = service.findById(newsId);
        return ResponseEntity.ok(n);
    }

    

    
}
