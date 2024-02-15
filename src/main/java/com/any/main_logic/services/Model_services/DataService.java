package com.any.main_logic.services.Model_services;

import com.any.main_logic.repo.model_rep.CountryOffensive_repo;
import com.any.main_logic.repo.model_rep.DateOffensive_repo;
import com.any.main_logic.repo.model_rep.OffensiveSummary_repo;
import com.any.main_logic.repo.model_rep.TopicSummary_repo;
import com.any.model.JWT_BL.dto.TimeInstanat_dto;
import com.any.model.JWT_BL.dto.getTopicSummary_dto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.any.model.JWT_BL.models.*;

@Service
public class DataService {

    private final TopicSummary_repo topicSummaryRepo = new TopicSummary_repo();
    private final DateOffensive_repo dateOffensiveRepo = new DateOffensive_repo();
    private final CountryOffensive_repo countryOffensiveRepo = new CountryOffensive_repo();
    private final OffensiveSummary_repo offensiveSummaryRepo = new OffensiveSummary_repo();

    public int getNumberOfTweets(){
//        return (int) countryOffensiveRepo.getTotalCounts();
        return 0;
    }

    public List<getTopicSummary_dto> getTopicSummary(){
//    try {
//        List<getTopicSummary_dto> newList = new ArrayList<>();
//
//        TopicSummary topicSummary = topicSummaryRepo.listAll().get(0);
//            newList.add(new getTopicSummary_dto("Health", topicSummary.getHealth()));
//            newList.add(new getTopicSummary_dto("Politics", topicSummary.getPolitics()));
//            newList.add(new getTopicSummary_dto("Sport", topicSummary.getSport()));
//            newList.add(new getTopicSummary_dto("Technology", topicSummary.getTechnology()));
//            newList.add(new getTopicSummary_dto("Religion", topicSummary.getReligion()));
//            return newList;
//    }catch (Exception e){
//        System.out.println(e.getMessage());
//    }
        return null;
    }

    public List<TimeInstanat_dto> getDateOffensiveSummary(){
//        List<DateOffensive> dateOffensives = dateOffensiveRepo.listAll();
//        List<TimeInstanat_dto> newList = new ArrayList<>();
//
//        for (DateOffensive dateOffensive : dateOffensives) {
//            newList.add(new TimeInstanat_dto(DateOffensive.getDateAsTimestamp(dateOffensive.getDate()),
//                    dateOffensive.getOffensive(), dateOffensive.getHateSpeech(), dateOffensive.getNormal()));
//        }
//        return newList;
        return null;
    }
    public List<getTopicSummary_dto> getCountryOffensiveSummary(){
//        return countryOffensiveRepo.getCountryOffensiveStats();
        return null;
    }

    public List<getTopicSummary_dto> getOffensiveSummary(){
//        DateOffensive dateOffensive = dateOffensiveRepo.listAll().get(0);
//        List<getTopicSummary_dto> newList = new ArrayList<>();
//        newList.add(new getTopicSummary_dto("Offensive", dateOffensive.getOffensive()));
//        newList.add(new getTopicSummary_dto("Hate_Speech", dateOffensive.getHateSpeech()));
//        newList.add(new getTopicSummary_dto("Normal", dateOffensive.getNormal()));
//        return newList;
        return null;
    }

    public List<getTopicSummary_dto> getTopCountryOffensiveSummary(){
//        System.out.println("getTopCountryOffensiveSummary");
//        List<getTopicSummary_dto> countryOffensives = countryOffensiveRepo.getCountryOffensiveStats();
//        Collections.sort(countryOffensives, (dto1, dto2) -> dto2.getTotalTweets() - dto1.getTotalTweets());
//        return countryOffensives.subList(0, Math.min(countryOffensives.size(), 6));
        return null;
    }
}