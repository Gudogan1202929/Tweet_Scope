package com.any.main_logic.repo.model_rep;

import com.any.model.JWT_BL.dto.getTopicSummary_dto;
import com.any.model.JWT_BL.models.CountryOffensive;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CountryOffensive_repo {

    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;encrypt=false;trustServerCertificate=false;databaseName=Tweet_Scoop";
    private static final String JDBC_USER = "SA";
    private static final String JDBC_PASSWORD = "123456789Mm";

    public List<getTopicSummary_dto> getCountryOffensiveStats() {
        List<getTopicSummary_dto> getTopicSummaryDtos = new ArrayList<>();

        String sql = "SELECT c.Name, SUM(co.Offensive + co.Hate_Speech)" +
                " FROM Country_Offensive co" +
                " JOIN Country c ON c.id = co.CountryId" +
                " GROUP BY c.Name" +
                " HAVING SUM(co.Offensive + co.Hate_Speech) > 0;";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String topic = resultSet.getString(1); // Assuming the first column is the topic name
                int totalTweets = resultSet.getInt(2); // Assuming the second column is the total count
                getTopicSummaryDtos.add(new getTopicSummary_dto(topic, totalTweets));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return getTopicSummaryDtos;
    }
}