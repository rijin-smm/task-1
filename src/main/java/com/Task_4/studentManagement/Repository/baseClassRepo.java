package com.Task_4.studentManagement.Repository;

import com.Task_4.studentManagement.Model.BaseClass;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface baseClassRepo extends MongoRepository<BaseClass,Long> {
}
