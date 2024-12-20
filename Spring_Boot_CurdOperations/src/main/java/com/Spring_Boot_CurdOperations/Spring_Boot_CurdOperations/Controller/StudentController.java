package com.Spring_Boot_CurdOperations.Spring_Boot_CurdOperations.Controller;

import com.Spring_Boot_CurdOperations.Spring_Boot_CurdOperations.Model.Student;
import com.Spring_Boot_CurdOperations.Spring_Boot_CurdOperations.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentRepo studentRepo;

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student){
        studentRepo.save(student);
    }
    @GetMapping("/getStudent")
    public List<Student> getStudents(){
        return studentRepo.findAll();
    }
    //Fetch By id
    @GetMapping("/getStudentById/{id}")
    public Optional<Student> getStudent(@PathVariable Integer id){
        return studentRepo.findById(id);
    }
    @PutMapping("/updateStudent/{id}")
    public String  updateStudent(@PathVariable Integer id,@RequestBody Student updatedStudent){
        Optional<Student> optionalStudent =studentRepo.findById(id);
        if(optionalStudent.isPresent()){
            Student existingStudent = optionalStudent.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAddress(updatedStudent.getAddress());
            studentRepo.save(existingStudent);
            return  "Student updated";
        }
        else {
            return  "Student Not Found";
        }
    }
    @DeleteMapping("deleteStudent/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentRepo.deleteById(id);
        return "Deleted";

    }


}
