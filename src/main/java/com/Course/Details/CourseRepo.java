package com.Course.Details;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;

/**
 * Created by midhun on 15/12/16.
 */
public interface CourseRepo extends JpaRepository<Courses,Long> {
    List<Courses> findAll();
    Courses  findById(Long id);
    List<Courses> findByDuration(String id);
}
