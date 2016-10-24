package ro.bydl.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.database.JdbcTemplateVehicleDAO;
import ro.bydl.domain.Vehicle;

@Service
public class VehicleService {

	@Autowired
	private JdbcTemplateVehicleDAO dao;

	public void save(Vehicle vehicle) {
		vehicle.setVignettes(vehicle.getVignettes().replace("-", "."));

		vehicle.setITP(vehicle.getITP().replace("-", "."));
		vehicle.setInsurance(vehicle.getInsurance().replace("-", "."));
		dao.update(vehicle);

	}

	public Collection<Vehicle> getAll() {
		return dao.getAll();

	}

	public void delete(Vehicle vehicle) {
		dao.delete(vehicle);

	}

	public void edit(Vehicle vehicle) {
		dao.edit(vehicle);

	}

	public boolean isVehicleOk(Vehicle vehicle) {
		for (Vehicle v : getAll()) {
			if (vehicle.equals(v)) {
				return false;
			}
		}

		return true;

	}

	public Collection<Vehicle> findByTeacherId(long id) {

		return dao.findByTeacherId(id);
	}

	public Vehicle findById(long id) {
		return dao.findById(id);

	}

}
