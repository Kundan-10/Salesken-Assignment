package com.student.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import com.student.Model.Student;


@Repository
public interface StudentRepository extends ElasticsearchRepository<Student, String>{

}
