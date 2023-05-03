package com.kiranmart.kiranmart.admin;

import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository <Admin, Long>, AdminRepositoryCustom{
}
