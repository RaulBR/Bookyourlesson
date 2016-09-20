package ro.bydl.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.VehicleDAO;
import ro.bydl.domain.Vehicle;

@Service
public class VehicleService {

	@Autowired
	private VehicleDAO dao;

	public void save(Vehicle vehicle) {

		dao.update(vehicle);

	}

	public Collection<Vehicle> getAll() {
		return dao.getAll();

	}
	public void delete(Vehicle vehicle) {
		dao.delete(vehicle);
		

	}

	public void edit(Vehicle vehicle) {
		dao.update(vehicle);
		
	}
}
