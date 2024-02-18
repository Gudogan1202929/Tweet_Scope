package com.any.main_logic.repo.model_rep;

import com.any.main_logic.services.Model_services.TwitterAPIService;

public class MockApi extends Thread{

    @Override
    public void run() {
        TwitterAPIService twitterAPIService = new TwitterAPIService();
        twitterAPIService.withdrawAndClassifyTweets();
    }
}
