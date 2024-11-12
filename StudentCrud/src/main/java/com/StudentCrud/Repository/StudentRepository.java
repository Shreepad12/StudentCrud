package com.StudentCrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentCrud.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
