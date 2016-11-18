package ro.bydl.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import ro.bydl.domain.Teacher;

public class TeacherServiceTest {

	@Test
	public void dateTest() {
		Teacher student = new Teacher();
		student.setCnp("1880511240011");
		TeacherService studentService = new TeacherService();
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
		Teacher student = new Teacher();
		student.setCnp("18845654");
		;
		TeacherService studentService = new TeacherService();
		assertFalse(studentService.isCnpRightLength(student));
	}

	@Test
	public void CnpRightLenghtTest() {
		Teacher student = new Teacher();
		student.setCnp("1880511240011");
		TeacherService studentService = new TeacherService();
		assertTrue(studentService.isCnpRightLength(student));
	}
	@Test
	public void cnpFormatTrueTest() {
		Teacher student = new Teacher();
		student.setCnp("1880511240011");
				
		assertTrue(new TeacherService().isCnpCorectFormat(student));
	}
	@Test
	public void cnpFormatFalseTest() {
		Teacher student = new Teacher();
		student.setCnp("188123d1240011");
				
		assertFalse(new TeacherService().isCnpCorectFormat(student));
	}
	@Test
	public void cnpFormatFalse2Test() {
		Teacher student = new Teacher();
		student.setCnp("188123 1240011");
				
		assertFalse(new TeacherService().isCnpCorectFormat(student));
	}
	@Test
	public void cnpFormatFalse3Test() {
		Teacher student = new Teacher();
		student.setCnp("188123-1240011");
				
		assertFalse(new TeacherService().isCnpCorectFormat(student));
	}
	@Test
	public void cnplengthTest() {
		Teacher student = new Teacher();
		student.setCnp("18812301240011");
				
		assertTrue(new TeacherService().isCnpRightLength(student));
	}
	@Test
	public void cnplengthTwoTest() {
		Teacher student = new Teacher();
		student.setCnp("18011");
				
		assertFalse(new TeacherService().isCnpRightLength(student));
	}
	
}
