package com.any.main_logic.services.Model_services;

import com.any.main_logic.repo.model_rep.CountryOffensive_repo;
import com.any.main_logic.repo.model_rep.DateOffensive_repo;
import com.any.main_logic.repo.model_rep.OffensiveSummary_repo;
import com.any.main_logic.repo.model_rep.TopicSummary_repo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.any.model.JWT_BL.models.*;

@Service
public class DataService {

    private final TopicSummary_repo topicSummaryRepo = new TopicSummary_repo();
    private final DateOffensive_repo dateOffensiveRepo = new DateOffensive_repo();
    private final CountryOffensive_repo countryOffensiveRepo = new CountryOffensive_repo();
    private final OffensiveSummary_repo offensiveSummaryRepo = new OffensiveSummary_repo();

    public int getNumberOfTweets(){
        return 1;
    }

    public TopicSummary getTopicSummary(){
        return topicSummaryRepo.listAll().get(0);
    }

    public List<DateOffensive> getDateOffensiveSummary(){
        return dateOffensiveRepo.listAll();
    }

    public List<CountryOffensive> getCountryOffensiveSummary(){
        return countryOffensiveRepo.listAll();
    }

    public OffensiveSummary getOffensiveSummary(){
        return offensiveSummaryRepo.listAll().get(0);
    }

    public List<CountryOffensive> getTopCountryOffensiveSummary(){
        List<CountryOffensive> countryOffensives = countryOffensiveRepo.listAll();
        List<CountryOffensive> topCountryOffensives = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            topCountryOffensives.add(countryOffensives.get(i));
        }
        return topCountryOffensives;
    }
}
