package vttp.ssfAssessment.ssfAssessment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import vttp.ssfAssessment.ssfAssessment.model.News;

//Task 3: Create a save method
@Service
public class NewsRedis implements NewsRepo {

    private static final Logger logger = LoggerFactory.getLogger(NewsRedis.class);

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public void saveArticles(News news) {
        logger.info("save your news!");
        redisTemplate.opsForValue().set(news.getId(), news);
        
    }

    @Override
    public News findById(String newsId) {
        logger.info("find news by Id" + newsId);
        News result = (News) redisTemplate.opsforValue().get(newsId);
        return result;
    }

}

    


    
    
}
