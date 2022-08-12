package vttp.ssfAssessment.ssfAssessment.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import vttp.ssfAssessment.ssfAssessment.model.News;
import vttp.ssfAssessment.ssfAssessment.service.NewsService;

@Controller
public class NewsController {
    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);

    //autowire news service to use it
    @Autowired
    NewsService newsSvc;

    @GetMapping("/")
    public String showIndexPage(Model model) {
        News n = new News();
        newsList(model);
        model.addAttribute("news", n);
        return "index";
    }


    private void newsList(Model model) {
        ArrayList<News> lsOfNews = newsSvc.getArticles();
        model.addAttribute("newsList", lsOfNews);
        
    }

    @PostMapping("/news")
    public String saveArticles(@ModelAttribute News news, Model model) {
        logger.info("article id >>>>>> " + news.getId());
        model.addAttribute("news", news);
        return "news";
    }
    
}
