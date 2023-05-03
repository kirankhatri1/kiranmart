package com.kiranmart.kiranmart.admin;

import java.util.List;

public interface AdminRepositoryCustom {
    Admin findAdminById(Long id);

    List<Admin> findAllByStatus();
}
