package com.student.Model;

import org.springframework.stereotype.Component;
import org.springframework.data.elasticsearch.annotations.FieldType;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "Student")
public class Student {
	
	
	@Id
	private String Id;
	
	@Field(type = FieldType.Text, name = "Name")	
	private String Name;
	
	 @Field(type = FieldType.Auto, name = "semesters")
	 private List<Semester> semesters;
	
	
}
