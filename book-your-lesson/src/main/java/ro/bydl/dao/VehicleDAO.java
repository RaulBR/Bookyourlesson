package ro.bydl.dao;

import ro.bydl.domain.Vehicle;

public interface VehicleDAO extends BaseDao<Vehicle> {

	public Vehicle getByLicence(Vehicle vehicle);

	Vehicle findByTeacherId(Long id);
}
