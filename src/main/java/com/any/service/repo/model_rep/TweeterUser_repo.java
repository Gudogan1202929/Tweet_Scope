package com.any.service.repo.model_rep;

import com.any.model.TweetUserModel;
import com.any.model.dto.TopRegionsDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

public class TweeterUser_repo implements PanacheRepository<TweetUserModel> {

    @Transactional
    public List<TopRegionsDTO> TopRegions() {
        String sql = "SELECT region, COUNT(DISTINCT tweetuser.id) AS user_count\n" +
                "FROM tweetuser\n" +
                "WHERE tweetuser.id IN (\n" +
                "    SELECT DISTINCT tweet.usermodel_id\n" +
                "    FROM tweet\n" +
                "    WHERE tweet.offensive_type != 'none'\n" +
                ")\n" +
                "GROUP BY region\n" +
                "ORDER BY user_count DESC;\n";

        Query query = this.getEntityManager().createNativeQuery(sql);
        List<TopRegionsDTO> resultList = query.getResultList();

        if (!resultList.isEmpty()) {
            return resultList;
        } else {
            return null;
        }
    }

@Transactional
    public List<TopRegionsDTO> globalDistribution() {
    String sql = "SELECT region, user_count\n" +
            "FROM (\n" +
            "    SELECT region, COUNT(DISTINCT tweetuser.id) AS user_count\n" +
            "    FROM tweetuser\n" +
            "    WHERE tweetuser.id IN (\n" +
            "        SELECT DISTINCT tweet.usermodel_id\n" +
            "        FROM tweet\n" +
            "        WHERE tweet.offensive_type != 'none'\n" +
            "    )\n" +
            "    GROUP BY region\n" +
            "    ORDER BY user_count DESC\n" +
            "    LIMIT 8\n" +
            ") AS top_regions\n" +
            "ORDER BY user_count ASC;\n";

    Query query = this.getEntityManager().createNativeQuery(sql);
        List<TopRegionsDTO> resultList = query.getResultList();

        if (!resultList.isEmpty()) {
            return resultList;
        } else {
            return null;
        }
    }
}
