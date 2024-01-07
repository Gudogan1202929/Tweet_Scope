package com.any.service.repo.model_rep;

import com.any.model.TweetModel;
import com.any.model.dto.TopicsDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class Tweet_repo implements PanacheRepository<TweetModel> {

    @Transactional
    public List<TopicsDTO> summaryOffensive() {
        Query query = this.getEntityManager().createNativeQuery(
                "SELECT offensive_type, COUNT(*) AS NumberTweets FROM tweet WHERE offensive_type <> 'none' GROUP BY offensive_type ORDER BY NumberTweets DESC ;"
        );
        List<TopicsDTO> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return resultList;
        } else {
            return null;
        }
    }

    @Transactional
    public List<TweetModel> OffensiveChart() {
        Query query = this.getEntityManager().createNativeQuery("SELECT * FROM tweet ORDER BY timestamp asc;");
        List<TweetModel> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return resultList;
        } else {
            return null;
        }
    }

    @Transactional
    public List<TopicsDTO> topicClassifications() {
        Query query = this.getEntityManager().createNativeQuery("SELECT topic, COUNT(*) AS NumberTweets FROM tweet GROUP BY topic ORDER BY NumberTweets asc LIMIT 8;");
        List<TopicsDTO> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return resultList;
        } else {
            return null;
        }
    }

    @Transactional
    public List<TopicsDTO> recentTopic() {
        Query query = this.getEntityManager().createNativeQuery("SELECT topic, COUNT(*) AS NumberTweets FROM tweet GROUP BY topic ORDER BY NumberTweets;");
        List<TopicsDTO> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return resultList;
        } else {
            return null;
        }
    }
}
