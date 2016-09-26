package com.olszi.service;

import com.olszi.dao.CourseDAO;
import com.olszi.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MOlszi on 2016-09-10.
 */

@Service
public class CourseServiceImpl implements CourseService {

    private CourseDAO courseDAO;

    @Autowired
    public CourseServiceImpl(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public void create(Course course) {
        courseDAO.create(course);
    }

    @Override
    public void update(Course course) {
        courseDAO.update(course);
    }

    @Override
    public void delete(Course course) {
        courseDAO.delete(course);
    }

    @Override
    public Course getById(Long id) {
        return courseDAO.getById(id);
    }

    @Override
    public List<Course> getAll() {
        return courseDAO.getAll();
    }
}
