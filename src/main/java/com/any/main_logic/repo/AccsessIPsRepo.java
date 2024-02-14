package com.any.main_logic.repo;

import com.any.model.JWT_BL.IPsModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccsessIPsRepo implements PanacheRepository<IPsModel> {
}
