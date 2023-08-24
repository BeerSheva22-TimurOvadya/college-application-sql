package telran.spring.college;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import telran.spring.college.entity.Lecturer;
import telran.spring.college.entity.Student;
import telran.spring.college.repo.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CollegeApplicationTests {
	private static final long ID_LECTURER = 123;
	private static final long ID_STUDENT = 124;
	@Autowired
	LecturerRepository lecturerRepository;
	@Autowired
	StudentRepository studentRepository;
	
	Lecturer lecturer = new Lecturer(ID_LECTURER, "Vasya", LocalDate.now(), null, null);
	Student student = new Student(ID_STUDENT, "Pety", LocalDate.now(), null, null);

	@Test
	void contextLoads() {
	}

	@Test
	@Order(1)
	void saveLecturerStudentTest() {
		lecturerRepository.save(lecturer);
		studentRepository.save(student);
	}

	@Test
	@Order(2)
	void findLecturerStudentTest() {
		Lecturer lecturerRes = lecturerRepository.findById(ID_LECTURER).orElse(null);
		assertEquals(ID_LECTURER, lecturerRes.getId());
		
		Student studentRes = studentRepository.findById(ID_STUDENT).orElse(null);
		assertEquals(ID_STUDENT, studentRes.getId());
	}
	
	@Test
	@Order(3)
	void getAllStudents() {
		List objects = lecturerRepository.findAll();
		assertEquals(1, objects.size());
		
		
	}
	

}
