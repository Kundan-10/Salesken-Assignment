package com.student.Model;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Semester {
	
	@Id
	private Integer semId; 
    private Integer English;
    private Integer Maths ;
    private Integer Science ;
	
    public Semester(int semId)
    {
        this.semId = semId;
    }

}
