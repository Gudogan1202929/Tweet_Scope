package com.any.main_logic.repo.model_rep;

import com.any.model.JWT_BL.models.TopicSummary;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TopicSummary_repo implements PanacheRepository<TopicSummary> {

}
