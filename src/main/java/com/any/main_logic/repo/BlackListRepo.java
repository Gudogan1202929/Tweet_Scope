package com.any.main_logic.repo;

import com.any.model.JWT_BL.BlackListModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class BlackListRepo implements PanacheRepository<BlackListModel> {

}
