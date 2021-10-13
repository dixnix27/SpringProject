package com.example.studentstest.controllers;

import com.example.studentstest.dtos.FacultateDto;
import com.example.studentstest.dtos.StudentDto;
import com.example.studentstest.entities.Student;
import com.example.studentstest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/home")
public class StudentController {

private final StudentService studentService; // CHEMAM SERVICIUL!

@PostMapping("/save")  // CREAM UN REQUEST DE TIP POST
public ResponseEntity<HttpStatus> createStudent(@RequestBody StudentDto studentDto){ // CREAM METODA ,VOM TRANSMITE UN BODY IN POSTMAN
    return ResponseEntity.ok(studentService.createStudent(studentDto)); // APELAM METODA CREATESERVICE DIN SERVICIU! SI RETURNAM STATUS
}

@GetMapping("/getById/{id}")  // CREAM UN REQUEST DE TIP GET DUPA ID
public ResponseEntity<StudentDto> getStudent(@PathVariable Long id) throws Exception { // CREAM METODA ,VOM TRANSMITE UN BODY IN POSTMAN
        return ResponseEntity.ok(studentService.getById(id)); // APELAM METODA CREATESERVICE DIN SERVICIU! SI RETURNAM STATUS
    }

@GetMapping("/getAll")  // CREAM UN REQUEST DE GET ,VOM AFISA TOTI STUDENTII
public List<Student> getAll (){
    return studentService.getAll();
}

@GetMapping("/getByName/{name}")  // CREAM UN REQUEST DE TIP GET DUPA ID
public ResponseEntity<StudentDto> getByName(@PathVariable String name) throws Exception { // CREAM METODA ,VOM TRANSMITE UN BODY IN POSTMAN
    return ResponseEntity.ok(studentService.getByName(name)); // APELAM METODA CREATESERVICE DIN SERVICIU! SI RETURNAM STATUS
}

// GET BY NAME LIST
//@GetMapping("/getByNameList/{name}")  // CREAM UN REQUEST DE TIP GET DUPA ID
//    public List<StudentDto> getByNameList(@PathVariable String name) throws Exception { // CREAM METODA ,VOM TRANSMITE UN BODY IN POSTMAN
//        return studentService.getByNameList(name); // APELAM METODA CREATESERVICE DIN SERVICIU! SI RETURNAM STATUS
//    }

@DeleteMapping("/deleteById/{id}")  // CREAM UN REQUEST DE TIP DELETE
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id){
    return ResponseEntity.ok(studentService.deleteById(id));
    }


@PostMapping("/setFacultateById/{id}")
public ResponseEntity<HttpStatus> setFacultate (@PathVariable Long id , @RequestBody FacultateDto facultateDto) throws Exception {
    return ResponseEntity.ok(studentService.setFacultateById(id,facultateDto));
}

}
