package ro.bydl.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import ro.bydl.domain.Student;

public class StudentServiceTest {

	@Test
	public void dateTest() {
		Student student = new Student();
		student.setCnp("1880511240011");
		StudentService studentService = new StudentService();
		DateFormat formatter;
		Date date = null;
		formatter = new SimpleDateFormat("dd.MM.yyyy");
		try {
			date = formatter.parse("11.05.1988");
		} catch (ParseException e) {

		}
		assertEquals(date, studentService.birthDay(student));
	}

	@Test
	public void CnpRightLenghtFalseTest() {
		Student student = new Student();
		student.setCnp("18845654");
		;
		StudentService studentService = new StudentService();
		assertFalse(studentService.isCnpRightLength(student));
	}

	@Test
	public void CnpRightLenghtTest() {
		Student student = new Student();
		student.setCnp("1880511240011");
		StudentService studentService = new StudentService();
		assertTrue(studentService.isCnpRightLength(student));
	}
	@Test
	public void cnpFormatTrueTest() {
		Student student = new Student();
		student.setCnp("1880511240011");
				
		assertTrue(new StudentService().isCnpCorectFormat(student));
	}
	@Test
	public void cnpFormatFalseTest() {
		Student student = new Student();
		student.setCnp("188123d1240011");
				
		assertFalse(new StudentService().isCnpCorectFormat(student));
	}
	@Test
	public void cnpFormatFalse2Test() {
		Student student = new Student();
		student.setCnp("188123 1240011");
				
		assertFalse(new StudentService().isCnpCorectFormat(student));
	}
	@Test
	public void cnpFormatFalse3Test() {
		Student student = new Student();
		student.setCnp("188123-1240011");
				
		assertFalse(new StudentService().isCnpCorectFormat(student));
	}
	@Test
	public void cnplengthTest() {
		Student student = new Student();
		student.setCnp("18812301240011");
				
		assertTrue(new StudentService().isCnpRightLength(student));
	}
	@Test
	public void cnplengthTwoTest() {
		Student student = new Student();
		student.setCnp("18011");
				
		assertFalse(new StudentService().isCnpRightLength(student));
	}
	
}
