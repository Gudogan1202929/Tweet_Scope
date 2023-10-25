package com.any.service.repo;

import com.any.model.JWT_BL.IPsModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AccsessIPsRepo implements PanacheRepository<IPsModel> {
}
