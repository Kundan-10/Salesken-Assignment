package com.student.Repository;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

//import org.elasticsearch.common.UUIDs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.Model.Semester;
import com.student.Model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	private final String indexName="Student";
	
	
	public String StudentAdd(String name) {
		
		int idN=(int) (studentRepo.count()+1);
		
		String id=Integer.toString(idN);
		
		System.out.println("count: " + id);
		
		Semester first=new Semester(1);
		Semester Second=new Semester(2);
		
		List<Semester> semL=new ArrayList<>();
		semL.add(first);
		semL.add(Second);
		
		 Student student = new Student(id, name, semL);
		 
		 System.out.println("Student Count : "+ id);
		 System.out.println("Student semesters : " + student.getSemesters());
		 
		   try {
	            studentRepo.save(student);
	        } catch (Exception e) {
	            return e.toString();
	        }
		   
		   
		   return "student added Successfully!";
	}
	
    public String addMarks(String studentId, int semId, String subject, int marks) {

        try {

            Optional<Student> students = studentRepo.findById(studentId);

            if (students.isEmpty()) {
                return "Marks add unsuccessfull, no student with StudentId : " + semId;
            }


            Student student = students.get();
            List<Semester> semestersList = student.getSemesters();

            for (Semester sem : semestersList) {

                System.out.println(sem.getSemId());
                System.out.println(semId);
                System.out.println(sem.getSemId() == semId);
                System.out.println((subject.equals("Maths")));

                if (sem.getSemId() == semId) {
                    if (subject.equals("English")) {
                        sem.setEnglish(marks);
                    } else if (subject.equals("Maths")) {
                        sem.setMaths(marks);
                    } else if (subject.equals("Science")) {
                        sem.setScience(marks);
                    } else {
                        return "error in subject name";
                    }

                    break;
                }
            }

            student.setSemesters(semestersList);
            studentRepo.save(student);

        }catch (Exception e){
            System.out.println(e.toString());
        }

        return "marks add success!";
    }
    
    
    public String averagePercentage(int sem)
    {
        Double average = 0.0;

        try {
            List<Double> percentageList = new ArrayList<>();
            Iterable<Student> studentList = studentRepo.findAll();
            for(Student s : studentList)
            {
                Semester semester = s.getSemesters().get(sem-1);
                Double sum = Double.valueOf((semester.getEnglish() + semester.getMaths() + semester.getScience()));
                Double percentage = sum/3;
                percentageList.add(percentage);
            }

            for(Double d : percentageList)
            {
                average += d;
            }

            average = average/percentageList.size();
            System.out.println("average : " + average);

        }catch (Exception e)
        {
            System.out.println(e.toString());
        }

        DecimalFormat df = new DecimalFormat("####0.00");

        return df.format(average);
    }
    
    
    public HashMap<String, Double> top2(){

      HashMap<String, Double> map = new HashMap<String, Double>();

      try {
          Iterable<Student> studentList = studentRepo.findAll();
          for(Student s : studentList)
          {
              Semester semester1 = s.getSemesters().get(0);
              Semester semester2 = s.getSemesters().get(1);
              Double sum = Double.valueOf((semester1.getEnglish() + semester1.getMaths() + semester1.getScience()+
                      semester2.getEnglish() + semester2.getMaths() + semester2.getScience()));
              Double max = sum/2;
              map.put(s.getId(), max);
          }

      }catch (Exception e)
      {
          System.out.println(e.toString());
      }
      return map;
  }
	

}
