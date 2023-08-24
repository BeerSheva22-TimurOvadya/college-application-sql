package telran.spring.college.entity;

import java.time.LocalDate;

import jakarta.persistence.*;


@Entity
//@Table(name = "students")


public class Student extends Person {

	public Student() {
		
	}

	public Student(long id, String name, LocalDate birthDate, String city, String phone) {
		super(id, name, birthDate, city, phone);
		
	}

}
