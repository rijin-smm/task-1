package com.Task_4.studentManagement.Repository;

import com.Task_4.studentManagement.Model.studentClass;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface studentClassRepo extends MongoRepository<studentClass,Long> {
}
