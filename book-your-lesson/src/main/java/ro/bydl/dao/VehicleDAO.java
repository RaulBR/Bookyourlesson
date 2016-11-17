package ro.bydl.dao;

import java.util.Collection;

import ro.bydl.domain.Vehicle;

public interface VehicleDAO extends BaseDao<Vehicle> {

	public Vehicle getByLicence(Vehicle vehicle);

	Collection<Vehicle> findByTeacherId(Long id);


	Vehicle findByChassis(String chassis);

	Vehicle findbyLicencePlate(String licensePlate);

	long countByteacherId(long teahcerId);

}
