package com.any.main_logic.controllers;

import com.any.model.JWT_BL.UserModel;
import com.any.main_logic.repo.Account_repo;
import com.any.utils.constant.SystemConstants;
import com.any.utils.enc.Encryption;
import com.any.utils.enc.Hash;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class Account_controller {
    private final Account_repo accountRepo = new Account_repo();
    @Transactional
    public boolean login(UserModel userModel) throws Exception {
        try {
            String password = Encryption.Decrypt(userModel.getPassword());
            UserModel userModel1ByFind = accountRepo.findByUsername(userModel.getUsername());
            if (Hash.hashing(password).equals(userModel1ByFind.getPassword())){
                return true;
            }
            throw new Exception(SystemConstants.CANNT_LOGIN);
        }catch (Exception e){
            throw new Exception(SystemConstants.CANNT_LOGIN);
        }
    }

    @Transactional
    public boolean signUp (UserModel userModel){
        try {
            String password = Encryption.Decrypt(userModel.getPassword());
            UserModel userModel1ByFind = accountRepo.findByUsername(userModel.getUsername());
            if (userModel1ByFind == null){
                userModel.setPassword(Hash.hashing(password));
                accountRepo.persist(userModel);
                return true;
            }
            return false;


        }catch (Exception e){
            try {
                System.out.println(e.getMessage());

                return true;
            }catch (Exception e1){
                System.out.println(e1.getMessage());
                return false;
            }
        }
    }
}
