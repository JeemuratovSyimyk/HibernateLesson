package org.example.Service.ServiceImpl;

import org.example.Service.StudentService;
import org.example.dao.StudentDao;
import org.example.dao.daoImpl.StudentDaoImpl;
import org.example.entity.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {
 StudentDao studentDao = new StudentDaoImpl();
    @Override
    public String saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }
    @Override
    public Student getStudentById(Long id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }

    @Override
    public Student updateStudent(Long oldStudentId, Student newStudent) {
        return studentDao.updateStudent(oldStudentId,newStudent);
    }

    @Override
    public String deleteStudentById(Long id) {
        return studentDao.deleteStudentById(id);
    }
}
