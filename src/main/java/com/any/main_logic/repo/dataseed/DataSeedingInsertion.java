package com.any.main_logic.repo.dataseed;

import com.any.model.JWT_BL.models.*;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class DataSeedingInsertion {

    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;encrypt=false;trustServerCertificate=false;databaseName=Tweet_Scoop";
    private static final String JDBC_USER = "SA";
    private static final String JDBC_PASSWORD = "123456789Mm";

    @Transactional
    public void countryInsertion(Country country){
//        String sql = "INSERT INTO Country (name, language,currency,TimeZone) VALUES (?, ?,?,?)";
//        try{
//            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, country.getName());
//            preparedStatement.setString(2, country.getLanguage());
//            preparedStatement.setString(3, country.getCurrency());
//            preparedStatement.setString(4, country.getTimeZone());
//            preparedStatement.executeUpdate();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void countryOffensive(CountryOffensive countryOffensive){
//        String sql = "INSERT INTO Country_Offensive (CountryId, Offensive,Hate_Speech,Normal) VALUES (?, ?,?,?)";
//        try{
//            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, String.valueOf(countryOffensive.getCountryId()));
//            preparedStatement.setString(2, String.valueOf(countryOffensive.getOffensive()));
//            preparedStatement.setString(3, String.valueOf(countryOffensive.getHate_Speech()));
//            preparedStatement.setString(4, String.valueOf(countryOffensive.getNormal()));
//            preparedStatement.executeUpdate();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void Tweet(Tweet tweet){
//        String sql = "INSERT INTO Tweet (text,CountryId,publish_datetime) VALUES (?,?,?)";
//        try{
//            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, tweet.getText());
//            preparedStatement.setString(2, String.valueOf(tweet.getCountryId()));
//            preparedStatement.setTimestamp(3, Timestamp.valueOf(tweet.getPublishDate()));
//            preparedStatement.executeUpdate();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void summary(DateOffensive dateOffensive){
//        String sql = "INSERT INTO Date_Offensive (Date, HateSpeech,Offensive,Normal) VALUES (?, ?,?,?)";
//        try{
//            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, String.valueOf(dateOffensive.getDate()));
//            preparedStatement.setString(2, String.valueOf(dateOffensive.getHateSpeech()));
//            preparedStatement.setString(3, String.valueOf(dateOffensive.getOffensive()));
//            preparedStatement.setString(4, String.valueOf(dateOffensive.getNormal()));
//            preparedStatement.executeUpdate();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void offensiveSummary(OffensiveSummary offensiveSummary){
//        String sql = "INSERT INTO Offensive_Summary (Offensive, Hate_Speech,Normal) VALUES (?, ?,?)";
//        try{
//            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, String.valueOf(offensiveSummary.getOffensive()));
//            preparedStatement.setString(2, String.valueOf(offensiveSummary.getHateSpeech()));
//            preparedStatement.setString(3, String.valueOf(offensiveSummary.getNormal()));
//            preparedStatement.executeUpdate();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void topicSummary(TopicSummary topicSummary){
//        String sql = "INSERT INTO Topic_Summary (Health, Politics,Sport,Technology,Religion) VALUES (?, ?,?,?,?)";
//        try{
//            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, String.valueOf(topicSummary.getHealth()));
//            preparedStatement.setString(2, String.valueOf(topicSummary.getPolitics()));
//            preparedStatement.setString(3, String.valueOf(topicSummary.getSport()));
//            preparedStatement.setString(4, String.valueOf(topicSummary.getTechnology()));
//            preparedStatement.setString(5, String.valueOf(topicSummary.getReligion()));
//
//            preparedStatement.executeUpdate();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
    }


    public void tweetOffensive(TweetOffensive tweetOffensive){
//        String sql = "INSERT INTO Tweet_Offensive (TweetId, Class) VALUES (?, ?)";
//        try{
//            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            int offensiveClass = tweetOffensive.getOffensiveClass().getValue();
//            preparedStatement.setString(1, String.valueOf(tweetOffensive.getTweetId()));
//            preparedStatement.setString(2, String.valueOf(offensiveClass));
//            preparedStatement.executeUpdate();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void tweetTopicObj(TweetTopic tweetTopic){
//        String sql = "INSERT INTO Tweet_Topic (TweetId, topic) VALUES (?, ?)";
//        try{
//            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            int topicClass = tweetTopic.getTopic().getValue();
//            preparedStatement.setString(1, String.valueOf(tweetTopic.getTweetId()));
//            preparedStatement.setString(2, String.valueOf(topicClass));
//            preparedStatement.executeUpdate();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
