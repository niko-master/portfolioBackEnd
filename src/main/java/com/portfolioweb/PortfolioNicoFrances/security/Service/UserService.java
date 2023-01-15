/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioweb.PortfolioNicoFrances.security.Service;

import com.portfolioweb.PortfolioNicoFrances.security.Entity.User;
import com.portfolioweb.PortfolioNicoFrances.security.Repository.iUserRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nico
 */
@Service
@Transactional
public class UserService {
    @Autowired
    iUserRepository iuserRepository;
    
    public  Optional<User> getByUserName(String userName){
        return iuserRepository.findByUserName(userName);
    }        
    public boolean existByUserName(String userName){
        return iuserRepository.existsByUserName(userName);
    }
    public   boolean existByEmail(String email){
        return iuserRepository.existsByEmail(email);      
    }
    public void save(User user){
        iuserRepository.save(user);
    }
}
