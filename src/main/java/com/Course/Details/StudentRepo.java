package com.Course.Details;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by midhun on 15/12/16.
 */
public interface StudentRepo extends JpaRepository<Student,Long> {
    List<Student> findAll();
//    List<Student> findByDuration(String id);
}
