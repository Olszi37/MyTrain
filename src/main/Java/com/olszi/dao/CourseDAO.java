package com.olszi.dao;

import com.olszi.model.Course;

import java.util.List;

/**
 * Created by MOlszi on 2016-09-08.
 */
public interface CourseDAO {

    public void create(Course course);

    public void update(Course course);

    public void delete(Course course);

    public Course getById(Long id);

    public List<Course> getAll();

    public int rowCount();

    public void clearTable();
}
