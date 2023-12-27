package org.example;

import org.example.Service.ServiceImpl.StudentServiceImpl;
import org.example.Service.StudentService;
import org.example.entity.Student;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {

                case 1 -> System.out.println(studentService.saveStudent(new Student("Syimyk", "Ulukbek Uulu", 21, "ulukbekuulusyimyk50@gmail.com")));
                case 2 -> System.out.println(studentService.getStudentById(2L));
                case 3 -> System.out.println(studentService.getAllStudent());
                case 4 -> System.out.println(studentService.updateStudent(2L, new Student("Aizat", "Asanova", 20, "aizat@gmail.com")));
                case 5 -> System.out.println(studentService.deleteStudentById(2L));
            }
        }
    }
}