package com.kiranmart.kiranmart.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public List<Admin> finAllByStatus(){
        return adminRepository.findAllByStatus();
    }
}
