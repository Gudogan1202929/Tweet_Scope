package com.any.service.controller.model_con;

import com.any.model.TweetModel;
import com.any.model.dto.RecentOffensiveDTO;
import com.any.model.dto.TopicsDTO;
import com.any.service.repo.model_rep.Tweet_repo;
import com.any.utils.constant.SystemConstants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetModelController {

    private final Tweet_repo tweetRepo = new Tweet_repo();

    public List<TweetModel> retrieveAllTweets() throws Exception {
        try {
            return tweetRepo.listAll();
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }

    public boolean insertTweets (List<TweetModel> tweetModel) throws Exception {
        try {
            tweetRepo.persist(tweetModel);
            return true;
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }

    public RecentOffensiveDTO resentHateSpeech() throws Exception {
        try {
            return tweetRepo.resentHateSpeech();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }

    public RecentOffensiveDTO resentPornography() throws Exception {
        try {
            return tweetRepo.resentPornography();
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }


    public RecentOffensiveDTO resentAbusive() throws Exception {
        try {
            return tweetRepo.resentAbusive();
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }

    public List<TweetModel> OffensiveChart() throws Exception {
        try {
           return tweetRepo.OffensiveChart();
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }

    public List<TopicsDTO> topicClassifications() throws Exception {
        try {
            return tweetRepo.topicClassifications();
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }

    public List<TopicsDTO> recentTopic () throws Exception {
        try {
            return tweetRepo.recentTopic();
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }
}
