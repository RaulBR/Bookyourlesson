package ro.bydl;

import java.util.Collection;

import ro.bydl.domain.Student;



public class IMStudentDAO implements StudentDAO {

	

	

	@Override
	public Collection<Student> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public int delete(Student model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long update(Student model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Collection<Student> getByTeacher(long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public long insert(Student model) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public Student getByCnp(long cnp) {
		// TODO Auto-generated method stub
		return null;
	}

}
