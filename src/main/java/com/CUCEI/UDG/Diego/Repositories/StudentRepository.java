package com.CUCEI.UDG.Diego.Repositories;

import com.CUCEI.UDG.Diego.Models.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel,Long> {
    public Optional<StudentModel> findStudentByCode(String code);
    public Optional<List<StudentModel>> findStudentByName(String Name);

}
