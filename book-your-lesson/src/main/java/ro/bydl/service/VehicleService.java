package ro.bydl.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.VehicleDAO;
import ro.bydl.domain.Vehicle;
import ro.bydl.service.errors.ValidationException;

@Service
public class VehicleService {

	@Autowired
	private VehicleDAO dao;

	public void save(Vehicle vehicle) throws ValidationException {
		validate(vehicle);
		
		
		
		if (vehicle.getId() == 0) {

			dao.insert(vehicle);

		} else {
			// edit
			update(vehicle);
		}

	}

	private void validate(Vehicle vehicle) throws ValidationException {

		List<String> errors = new LinkedList<>();
		vehicle.getChassis();

		if (chassisExists(vehicle)) {
			errors.add("Vehivle already enterd, ");

		}
		if (licencePlateexists(vehicle)) {
			errors.add("Vehivle already enterd, licence plate exists ");
		}
//		if (ItpInTheFuture(vehicle.getITP())) {
//			errors.add("Vehivle already enterd, licence plate exists ");
//		}
//		if (ItpInTheFuture(vehicle.getVignettes())) {
//			errors.add("You need a valid viniet");
//		}
//		if (ItpInTheFuture(vehicle.getInsurance())) {
//			errors.add("you need a valid insurance");
//		}
		if (!errors.isEmpty()) {
			throw new ValidationException(errors.toArray(new String[] {}));
		}

	}

	private boolean ItpInTheFuture(String inputDate) {
		Date vehilceDate = null;

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date todat = new Date();
		try {
			vehilceDate = df.parse(inputDate);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		if (vehilceDate.compareTo(todat) < 0) {
			return true;
		} else {

			return false;
		}
	}

	private boolean licencePlateexists(Vehicle vehicle) {
		try {
			dao.findbyLicencePlate(vehicle.getLicensePlate());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean chassisExists(Vehicle vehicle) {
		try {
			dao.findByChassis(vehicle.getChassis());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Collection<Vehicle> getAll() {
		return dao.getAll();

	}

	public void delete(Vehicle vehicle) {
		dao.delete(vehicle);

	}

	public void update(Vehicle vehicle) {
		dao.update(vehicle);

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
