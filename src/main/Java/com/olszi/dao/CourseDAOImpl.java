package com.olszi.dao;

import com.olszi.model.Course;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MOlszi on 2016-09-08.
 */

@Repository
@Transactional
public class CourseDAOImpl implements CourseDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CourseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Course course) {
        sessionFactory.getCurrentSession().save(course);
    }

    @Override
    public void update(Course course) {
        sessionFactory.getCurrentSession().update(course);
    }

    @Override
    public void delete(Course course) {
        sessionFactory.getCurrentSession().delete(course);
    }

    @Override
    public Course getById(Long id) {
        return sessionFactory.getCurrentSession().get(Course.class, id);
    }

    @Override
    public List<Course> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM course", Course.class).getResultList();
    }

    @Override
    public int rowCount() {
        return ((Long)sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM course").uniqueResult()).intValue();
    }

    @Override
    public void clearTable() {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM course").executeUpdate();
    }
}
