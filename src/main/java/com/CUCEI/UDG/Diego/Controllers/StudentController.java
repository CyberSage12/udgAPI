package com.CUCEI.UDG.Diego.Controllers;

import com.CUCEI.UDG.Diego.Models.StudentModel;
import com.CUCEI.UDG.Diego.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import  java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService ;

    @PostMapping("")
    public StudentModel saveStudent(@RequestBody StudentModel studentModel){
        return studentService.saveStudent(studentModel);
    }
    @GetMapping("")
    public List<StudentModel>getAllStudents(){
        return studentService.getAllStudents();
    }
    //codigo
    @GetMapping("/findByCode={code}")
    public Optional<StudentModel> getStudentByCode(@PathVariable String code){
        return StudentService.findStudentByCode(code);
    }
    //Nombre
    @GetMapping("/findByName={name}")
    public Optional<List<StudentModel>> getStudentByName(@PathVariable String name) {
        return StudentService.findStudentByName(name);
    }
    @DeleteMapping("/deleteStudentByCode={code}")
    public String deleteStudentByCode(@PathVariable String code){
        return studentService.deleteStudentByCode(code);
    }

    @PutMapping("")
    public StudentModel updateStudent(@RequestBody StudentModel studentModel){
        return studentService.saveStudent(studentModel);
    }

    @PutMapping("/updateStudentByCode={code}")
    public StudentModel updateStudent(@PathVariable String code,@RequestBody StudentModel studentModel){
        return studentService.updateStudentByCode(code,studentModel);
    }
}
