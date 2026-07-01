package com.trivikram.springbootdemo.repository;

import com.trivikram.springbootdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository; // JpaRepository : Used to make the connection to the database,

// why <Student , Long >, means Student-> Database or entity class name and Long-> we declared id as long in entity so here also should be long. AND WE SHOULD GIVE : JpaRepository<TableName, Id Type>
public interface StudentRepository extends JpaRepository<Student, Long> {

}
