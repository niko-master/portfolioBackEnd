/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioweb.PortfolioNicoFrances.security.Controller;

import com.portfolioweb.PortfolioNicoFrances.security.Dto.JwtDto;
import com.portfolioweb.PortfolioNicoFrances.security.Dto.LoginUser;
import com.portfolioweb.PortfolioNicoFrances.security.Dto.NewUser;
import com.portfolioweb.PortfolioNicoFrances.security.Entity.Rol;
import com.portfolioweb.PortfolioNicoFrances.security.Entity.User;
import com.portfolioweb.PortfolioNicoFrances.security.Service.RolService;
import com.portfolioweb.PortfolioNicoFrances.security.Service.UserService;
import com.portfolioweb.PortfolioNicoFrances.security.enums.RolNombre;
import com.portfolioweb.PortfolioNicoFrances.security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nico
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    
    @PostMapping("/new")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Datos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        
        if(userService.existByUserName(newUser.getUserName()))
        return new ResponseEntity(new Mensaje("El Usuario ya existe"), HttpStatus.BAD_REQUEST);
        
        if(userService.existByEmail(newUser.getEmail()))
        return new ResponseEntity(new Mensaje("Email en uso"), HttpStatus.BAD_REQUEST);
        
        User user = new User(newUser.getName(), newUser.getUserName(),
        newUser.getEmail(), passwordEncoder.encode(newUser.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        
        if(newUser.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());  
        user.setRoles(roles);
        userService.save(user);
        
        return new ResponseEntity(new Mensaje("Usuario creado"), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUserName(), loginUser.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generatedToken(authentication);
        
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
