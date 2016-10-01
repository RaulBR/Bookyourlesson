package ro.bydl.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ro.bydl.domain.Student;



public class StudentServiceTest {

		
	@Test
	public void dateTest(){
		Student student =new Student();
		student.setCnp(1880511240011l);
		StudentService studentService=new StudentService();
		assertEquals("11.05.1988", studentService.byrthDay(1880511240011l));
	}
	@Test
	public void isAllowedTest(){
		Student student =new Student();
		student.setBirthDay("11.05.1988");
		StudentService studentService=new StudentService();
		assertTrue( studentService.isAllawed(student));
	}
	@Test
	public void isAllowedTestFalse(){
		Student student =new Student();
		student.setBirthDay("11.05.2015");
		StudentService studentService=new StudentService();
		assertFalse( studentService.isAllawed(student));
	}
	@Test
	public void CnpRightLenghtFalseTest(){
		Student student =new Student();
		student.setCnp(18845654);;
		StudentService studentService=new StudentService();
		assertFalse( studentService.isCnpRightLength(student));
	}
	@Test
	public void CnpRightLenghtTest(){
		Student student =new Student();
		student.setCnp(1880511240011l);
		StudentService studentService=new StudentService();
		assertTrue( studentService.isCnpRightLength(student));
	}
	
}
