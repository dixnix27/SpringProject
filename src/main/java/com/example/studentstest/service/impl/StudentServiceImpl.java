package com.example.studentstest.service.impl;

import com.example.studentstest.dtos.FacultateDto;
import com.example.studentstest.dtos.StudentDto;
import com.example.studentstest.entities.Facultate;
import com.example.studentstest.entities.Student;
import com.example.studentstest.repositories.StudentRepository;
import com.example.studentstest.service.FacultateService;
import com.example.studentstest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final FacultateService facultateService;

// METODA POST , VA ADAUGA INFO IN BD
    @Override
    public HttpStatus createStudent(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto,Student.class);
        studentRepository.save(student);
        return HttpStatus.OK;
    }


// METODA GET CE VA EXTRAGE UN STUDENT DIN BD DUPA ID
    @Override
    public StudentDto getById(Long id) throws Exception {
        Optional <Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return modelMapper.map(student.get(),StudentDto.class);
        }else throw new Exception(String.format("Student doesnt exist!"));
    }

// METODA GET  , VA EXTRAGE TOTI STUDENTII DIN BD
    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public HttpStatus deleteById(Long id) {
        studentRepository.deleteById(id);
        return HttpStatus.OK;
    }

    @Override
    public StudentDto getByName(String name) throws Exception {
         Optional <Student> student = studentRepository.findByNume(name);
        if(student.isPresent()){
            return modelMapper.map(student.get(),StudentDto.class);
        }else throw new Exception(String.format("Student doesnt exist!"));

    }

    @Override
    public HttpStatus setFacultateById(Long id, FacultateDto facultateDto) throws Exception {
        Optional <Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            Facultate savedFacultate = facultateService.saveFacultate(facultateDto);
            student.get().setFacultate(savedFacultate);
            studentRepository.save(student.get());
            return HttpStatus.OK;
        }else throw new Exception(String.format("User by id is not found!",id));
    }

    /// AM INCERCAT SA FAC O METODA CE VA RETURNA O LISTA DE STUDENTI DUPA NUME
//    @Override
//    public List<StudentDto> getByNameList(String name) throws Exception {
//         List<StudentDto> studenti = null;
//        Optional <Student> student = studentRepository.findByNume(name);
//        if(student.isPresent()){
//            StudentDto s1= modelMapper.map(student.get(), (Type) StudentDto.class);
//            studenti.add(s1);
//            return studenti;
//        }else throw new Exception(String.format("Student doesnt exist!"));


}
