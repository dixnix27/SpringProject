package com.example.studentstest.service;

import com.example.studentstest.dtos.FacultateDto;
import com.example.studentstest.dtos.StudentDto;
import com.example.studentstest.entities.Facultate;
import com.example.studentstest.entities.Student;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface StudentService {



    HttpStatus createStudent(StudentDto studentDto);

    StudentDto getById(Long id) throws Exception;

    List<Student> getAll();

    HttpStatus deleteById(Long id);

    StudentDto getByName(String name) throws Exception;

//    List<StudentDto> getByNameList(String name) throws Exception;

    HttpStatus setFacultateById(Long id,FacultateDto facultateDto) throws Exception;


}


