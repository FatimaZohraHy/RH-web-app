package com.IT.SpringBootAngular.Repo;

import com.IT.SpringBootAngular.Entitys.HRadmin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HRadminRepo extends MongoRepository<HRadmin,String> {
}
