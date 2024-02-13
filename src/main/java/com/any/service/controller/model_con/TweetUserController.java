package com.any.service.controller.model_con;

import com.any.model.TweetModel;
import com.any.model.TweetUserModel;
import com.any.model.dto.TopRegionsDTO;
import com.any.service.repo.model_rep.TweeterUser_repo;
import com.any.utils.constant.SystemConstants;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TweetUserController {

    private final TweeterUser_repo tweetUserRepo = new TweeterUser_repo();

    public List<TweetUserModel> retrieveAllUsers() throws Exception {
        try {
            return tweetUserRepo.listAll();
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }


    public boolean insertTweeterUsers (List<TweetUserModel> tweetUserModels) throws Exception {
        try {
            tweetUserRepo.persist(tweetUserModels);
            return true;
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }

    public List<TopRegionsDTO> TopRegions() throws Exception {
        try {
            return tweetUserRepo.TopRegions();
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }


    public List<TopRegionsDTO> globalDistribution() throws Exception {
        try {
            return (tweetUserRepo.globalDistribution());
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }

}
