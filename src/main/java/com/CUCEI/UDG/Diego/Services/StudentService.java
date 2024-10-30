package com.CUCEI.UDG.Diego.Services;

import com.CUCEI.UDG.Diego.Repositories.StudentRepository;
import com.CUCEI.UDG.Diego.Models.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService{
    @Autowired
    static StudentRepository studentRepository;

    //cread
    public List<StudentModel>getAllStudents(){
        return (List<StudentModel>) studentRepository.findAll();
    }
    //Read
    public List<StudentModel> finAllStudent(){
        return (List<StudentModel>) studentRepository.findAll();
    }
    //Guardar
    public StudentModel saveStudent(StudentModel student){
        return studentRepository.save(student);
    }
    //Encontrar por codigo
    public static Optional<StudentModel> findStudentByCode(String code){
        return studentRepository.findStudentByCode(code);
    }
    //Encontrar por nombre
    public static Optional<List<StudentModel>> findStudentByName(String name){
        return studentRepository.findStudentByName(name);
    }

    //Delete
    public String deleteStudentByCode(String code){
        String response = "";
        Optional<StudentModel> foundStudent = findStudentByCode(code);
        if(foundStudent.isPresent()){
            studentRepository.delete(foundStudent.get());
            response = "Student deleted succesfully";
        }else{
            response = "Student not found";
        }

        return  response;
    }

    public StudentModel updateStudentByCode(String code,StudentModel studentModel) {
        return findStudentByCode(code).isPresent()?studentRepository.save(studentModel):new StudentModel(0L,"0","Student not Found","","",00d);
    }
}
