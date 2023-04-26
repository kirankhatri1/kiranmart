package com.kiranmart.kiranmart.employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Employee findEmployeeById(Long id) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        query.where(builder.equal(root.get("id"), id));

        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (Exception ignored){
            return null;
        }
    }

  /*  @Override
    @Query("select * from tbl_employee where id = :id")
    public boolean deleteEmployeeById(Long id) {
        Session session = (Session) entityManager.getDelegate();
        SqlQuery  sqlQuery = (SqlQuery) session.createQuery("");

        sqlQuery.execute();

        return false;
    }*/







}
