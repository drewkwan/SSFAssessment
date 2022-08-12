package vttp.ssfAssessment.ssfAssessment.service;

import vttp.ssfAssessment.ssfAssessment.model.News;

public interface NewsRepo {

    public void saveArticles(final News news);

    public News findById(final Integer newsId);

    
}
