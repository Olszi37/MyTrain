package com.olszi.service;

import com.olszi.model.Course;

/**
 * Created by MOlszi on 2016-09-10.
 */
public interface CourseService {

    public void create(Course course);

    public void update(Course course);

    public void delete(Course course);

    public Course getById(Long id);
}
