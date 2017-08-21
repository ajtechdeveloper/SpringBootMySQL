package com.aj.springbootmysql.repository;

import com.aj.springbootmysql.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findByName(String name);

    @Modifying(clearAutomatically = true)
    @Query("Update Employee emp set emp.name =:name, emp.department =:department,emp.salary =:salary where emp.id =:id")
    int updateEmployee(@Param("name") String name, @Param("department") String department,
                         @Param("salary") Integer salary, @Param("id") Integer id);
}
