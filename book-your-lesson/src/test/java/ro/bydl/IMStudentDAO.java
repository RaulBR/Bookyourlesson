package ro.bydl;

import java.util.Collection;

import ro.bydl.dao.StudentDAO;
import ro.bydl.domain.Student;



public class IMStudentDAO implements StudentDAO {

	@Override
	public Collection<Student> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long insert(Student model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Student model) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void update(Student model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Student> getByTeacher(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getByCnp(String cnp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long find(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countByteacherId(long teahcerId) {
		// TODO Auto-generated method stub
		return 0;
	}


}
