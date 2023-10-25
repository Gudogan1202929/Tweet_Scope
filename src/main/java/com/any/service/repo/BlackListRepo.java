package com.any.service.repo;

import com.any.model.JWT_BL.BlackListModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class BlackListRepo implements PanacheRepository<BlackListModel> {

    public boolean findByToken(String token) {
        Query query = this.getEntityManager().createNativeQuery("SELECT * FROM black_tokens WHERE black_token = ?", BlackListModel.class);
        query.setParameter(1, token);
        List<BlackListModel> resultList = query.getResultList();
        if (resultList.size() == 0){
            return true;
        }
        return false;
    }
}
