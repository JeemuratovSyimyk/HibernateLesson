package org.example.dao.daoImpl;

import org.example.Config.HibernateConfig;
import org.example.dao.StudentDao;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public String saveStudent(Student student) {
   Session session = HibernateConfig.getSession().openSession();
   session.beginTransaction();
       session.persist(student);
       session.getTransaction().commit();
       session.close();
        return student.getFirstName()+ " is successfully saved";
    }
    @Override
    public Student getStudentById(Long id) {
       Session session = HibernateConfig.getSession().openSession();
       session.beginTransaction();
       Student student = session.get(Student.class,id);
       session.getTransaction().commit();
       session.close();
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        Session session = HibernateConfig.getSession().openSession();
        session.beginTransaction();
        List<Student> students = session.createQuery("select s from Student s ").getResultList();
        session.getTransaction().commit();
        session.close();
        return students;
    }

    @Override
    public Student updateStudent(Long oldStudentId, Student newStudent) {
        Session session = HibernateConfig.getSession().openSession();
        session.beginTransaction();
        Student oldstudent = getStudentById(oldStudentId);
        oldstudent.setFirstName(newStudent.getFirstName());
        oldstudent.setLastName(newStudent.getLastName());
        oldstudent.setAge(newStudent.getAge());
        oldstudent.setEmail(newStudent.getEmail());
        session.merge(oldstudent);
        session.getTransaction().commit();
        session.close();
        return oldstudent;
    }

    @Override
    public String deleteStudentById(Long id) {
       Session session = HibernateConfig.getSession().openSession();
       session.beginTransaction();
       Student student = getStudentById(id);
       session.remove(student);
        session.getTransaction().commit();
        session.close();
        return student.getFirstName()+ " is successfully deleted";
    }
}

