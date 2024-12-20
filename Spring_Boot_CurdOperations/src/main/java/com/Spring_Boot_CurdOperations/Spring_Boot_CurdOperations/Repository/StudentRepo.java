package com.Spring_Boot_CurdOperations.Spring_Boot_CurdOperations.Repository;

import com.Spring_Boot_CurdOperations.Spring_Boot_CurdOperations.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student,Integer> {



}
