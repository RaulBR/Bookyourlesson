package ro.bydl.service;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.VehicleDAO;
import ro.bydl.domain.Vehicle;
import ro.bydl.exceptions.ValidationException;

/**
 * Service class for vehicles
 * 
 * @author Raul
 *
 */
@Service
public class VehicleService {

	@Autowired
	private VehicleDAO dao;

	/**
	 * this method saves a vehicle to the DB via validation
	 * <p>
	 * Validates:
	 * <p>
	 * <ul>
	 * <li>if chases is already in db</li>
	 * <li>if chases has unneeded symbols</li>
	 * <li>if license plate is of correct length and format</li>
	 * <li>if license plate already exists</li>
	 * <li>if ITP is valid</li>
	 * <li>if insurance is valid</li>
	 * <li>if viniet is valid</li>
	 * </ul>
	 * 
	 * @param vehicle
	 * @throws ValidationException
	 */
	public void save(Vehicle vehicle) throws ValidationException {

		refineVehicleContent(vehicle);
		if (vehicle.getId() == 0) {
			validate(vehicle);
			dao.insert(vehicle);

		} else {

			update(vehicle);
		}

	}

	private void refineVehicleContent(Vehicle vehicle) {
		StringHelper stringHelper = new StringHelper();
		vehicle.setCarType(stringHelper.formatFirstToUpeerOtherToLowerCase(vehicle.getCarType()));
		vehicle.setBrand(stringHelper.formatFirstToUpeerOtherToLowerCase(vehicle.getBrand()));

		vehicle.setLicensePlate(removeSpace(vehicle.getLicensePlate()));
	}

	private void validate(Vehicle vehicle) throws ValidationException {

		List<String> errors = new LinkedList<>();
		vehicle.getChassis();

		if (chassisExists(vehicle)) {
			errors.add("Vehivle already enterd, ");

		}
		if (new StringHelper().containsSimbols(vehicle.getChassis())) {
			errors.add("chassis must contain only numbers or letter");
		}
		if (licencePlateIncorectLength(vehicle)) {
			errors.add("licence is incorect lenght format is BM12MMM");
		}
		if (isLicenceIncrectFormat(vehicle)) {
			errors.add("licence is incorect format is BM12MMM");

		}
		if (licencePlateExists(vehicle)) {
			errors.add("Vehivle already enterd, licence plate exists ");
		}
		if (ItpInThePast(vehicle.getITP())) {
			errors.add("Itp is not valid ");
		}
		if (ItpInThePast(vehicle.getVignettes())) {
			errors.add("You need a valid viniet");
		}
		if (ItpInThePast(vehicle.getInsurance())) {
			errors.add("you need a valid insurance");
		}
		if (!errors.isEmpty()) {
			throw new ValidationException(errors.toArray(new String[] {}));
		}

	}

	private boolean licencePlateIncorectLength(Vehicle vehicle) {
		if (vehicle.getLicensePlate().length() > 8 || vehicle.getLicensePlate().length() < 6) {
			return true;
		}
		return false;
	}

	private boolean isLicenceIncrectFormat(Vehicle vehicle) {
		String[] e = vehicle.getLicensePlate().split("");
		String[] countys = { "AB", "AR", "AG", "BC", "BH", "BN", "BT", "BV", "BR", "BZ", "CS", "CL", "CJ", "CT", "CV",
				"DB", "DJ", "GL", "GR", "GJ", "HR", "HD", "IL", "IS", "IF", "MM", "MH", "MS", "NT", "OT", "PH", "SM",
				"SJ", "SB", "SV", "TR", "TM", "TL", "VS", "VL", "VN" };

		if (e[0].toUpperCase().equals("B")) {

			if (isNumeric(e[1] + e[2] + e[3])) {

				if ((e[4].matches("[a-zA-z]{1}") && e[5].matches("[a-zA-z]{1}") && e[6].matches("[a-zA-z]{1}"))) {

					return false;
				}
			}
		}
		if (e[0].toUpperCase().equals("B")) {

			if (isNumeric(e[1] + e[2])) {

				if ((e[4].matches("[a-zA-z]{1}") && e[5].matches("[a-zA-z]{1}") && e[6].matches("[a-zA-z]{1}"))) {

					return false;
				}
			}
		}

		for (String county : countys) {

			if ((e[0].toUpperCase() + e[1].toUpperCase()).equals(county)) {

				if (isNumeric(e[2] + e[3])) {

					if (e[4].matches("[a-zA-z]{1}") && e[5].matches("[a-zA-z]{1}") && e[6].matches("[a-zA-z]{1}")) {

						return false;
					}
				}
			}
		}

		return true;
	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	private boolean ItpInThePast(Date date) {
		Date vehilceDate = null;

		Date todat = new Date();

		vehilceDate = (date);

		if (vehilceDate.compareTo(todat) < 0) {
			return true;
		} else {

			return false;
		}
	}

	private boolean licencePlateExists(Vehicle vehicle) {
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

	private String removeSpace(String done) {

		done = done.replaceAll(" ", "");
		done = done.toLowerCase();

		return done;
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
