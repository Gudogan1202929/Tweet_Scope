package com.any.main_logic.repo.model_rep;

import com.any.model.JWT_BL.models.TopicSummary;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class TopicSummary_repo implements PanacheRepository<TopicSummary> {

}
