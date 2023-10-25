package com.any.service.repo.model_rep;

import com.any.model.TweetModel;
import com.any.model.dto.RecentOffensiveDTO;
import com.any.model.dto.TopicsDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class Tweet_repo implements PanacheRepository<TweetModel> {
    @Transactional
    public RecentOffensiveDTO resentHateSpeech() {
        Query query = this.getEntityManager().createNativeQuery(
                "SELECT offensive_type, tweet_content " +
                        "FROM tweet " +
                        "WHERE offensive_type = 'HateSpeech' " +
                        "ORDER BY timestamp DESC " +
                        "LIMIT 1"
        );

        List<Object[]> resultList = query.getResultList();

        if (!resultList.isEmpty()) {
            Object[] row = resultList.get(0);
            RecentOffensiveDTO recentOffensiveDTO = new RecentOffensiveDTO(
                    (String) row[0],
                    (String) row[1]
            );
            return recentOffensiveDTO;
        } else {
            return null;
        }
    }

    @Transactional
    public RecentOffensiveDTO resentPornography() {
        Query query = this.getEntityManager().createNativeQuery(
                "SELECT offensive_type, tweet_content " +
                        "FROM tweet " +
                        "WHERE offensive_type = 'Pornograph' " +
                        "ORDER BY timestamp DESC " +
                        "LIMIT 1"
        );

        List<Object[]> resultList = query.getResultList();

        if (!resultList.isEmpty()) {
            Object[] row = resultList.get(0);
            RecentOffensiveDTO recentOffensiveDTO = new RecentOffensiveDTO(
                    (String) row[0],
                    (String) row[1]
            );
            return recentOffensiveDTO;
        } else {
            return null;
        }
    }


    @Transactional
    public RecentOffensiveDTO resentAbusive() {
        Query query = this.getEntityManager().createNativeQuery(
                "SELECT offensive_type, tweet_content " +
                        "FROM tweet " +
                        "WHERE offensive_type = 'Abusive' " +
                        "ORDER BY timestamp DESC " +
                        "LIMIT 1"
        );

        List<Object[]> resultList = query.getResultList();

        if (!resultList.isEmpty()) {
            Object[] row = resultList.get(0);
            RecentOffensiveDTO recentOffensiveDTO = new RecentOffensiveDTO(
                    (String) row[0],
                    (String) row[1]
            );
            return recentOffensiveDTO;
        } else {
            return null;
        }
    }


    public List<TweetModel> OffensiveChart() {
        Query query = this.getEntityManager().createNativeQuery("SELECT * FROM tweet");
        List<TweetModel> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return resultList;
        } else {
            return null;
        }
    }

    public List<TopicsDTO> topicClassifications() {
        Query query = this.getEntityManager().createNativeQuery("SELECT topic, COUNT(*) AS NumberTweets FROM tweet GROUP BY topic ORDER BY NumberTweets DESC LIMIT 6;");
        List<TopicsDTO> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return resultList;
        } else {
            return null;
        }
    }


    public List<TopicsDTO> recentTopic() {
        Query query = this.getEntityManager().createNativeQuery("SELECT topic, COUNT(*) AS NumberTweets FROM tweet GROUP BY topic ORDER BY NumberTweets DESC LIMIT 6;");
        List<TopicsDTO> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return resultList;
        } else {
            return null;
        }
    }
}
