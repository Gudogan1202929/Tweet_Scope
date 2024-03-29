package com.any.main_logic.repo;

import com.any.model.JWT_BL.UserModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class Account_repo implements PanacheRepository<UserModel> {

    public UserModel findByUsername(String username) {
        Query query = this.getEntityManager().createNativeQuery("SELECT * FROM user_table WHERE username LIKE ?", UserModel.class);
        query.setParameter(1, username);
        List<UserModel> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        } else {
            return null;
        }
    }


    @Transactional
    public String AddToken(UserModel userModel ,String token) {
        try {
            String sql = "UPDATE user_table SET token = ? WHERE CAST(username AS NVARCHAR(MAX)) = ? AND CAST(password AS NVARCHAR(MAX)) = ?";
            Query q = this.getEntityManager().createNativeQuery(sql);
            q.setParameter(1, token);
            q.setParameter(2, userModel.getUsername());
            q.setParameter(3, userModel.getPassword());
            int isDone = q.executeUpdate();

            if (isDone > 0){
                System.out.println(token);
                return token;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        throw new RuntimeException("Token not added");
    }
}
