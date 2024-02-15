package com.any.main_logic.repo.model_rep;

import com.any.model.JWT_BL.dto.getTopicSummary_dto;
import com.any.model.JWT_BL.models.CountryOffensive;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CountryOffensive_repo implements PanacheRepository<CountryOffensive>{

    @Inject
    EntityManager em;

    public int getTotalCounts() {
//        Object result = em.createNativeQuery("SELECT SUM(Normal + Offensive + Hate_Speech) FROM Country_Offensive").getSingleResult();
//        return result != null ? (int) ((Number) result).longValue() : 0;
        return 0;
    }


    public List<getTopicSummary_dto> getCountryOffensiveStats() {
//        List<Object[]> results = em.createNativeQuery(
//                        "SELECT c.Name, SUM(co.Offensive + co.Hate_Speech) " +
//                                "FROM Country_Offensive co " +
//                                "JOIN Country c ON c.id = co.CountryId " +
//                                "GROUP BY c.Name")
//                .getResultList();
//
//        List<getTopicSummary_dto> summaryList = new ArrayList<>();
//        for (Object[] result : results) {
//            String name = (String) result[0];
//            long sum = ((Number) result[1]).longValue();
//            summaryList.add(new getTopicSummary_dto(name, (int) sum));
//        }
//        return summaryList;
        return null;
    }



}