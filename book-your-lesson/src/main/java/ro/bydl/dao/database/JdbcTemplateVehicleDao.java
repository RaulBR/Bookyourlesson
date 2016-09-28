package ro.bydl.dao.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ro.bydl.dao.VehicleDAO;
import ro.bydl.domain.Vehicle;

@Component
public class JdbcTemplateVehicleDao implements VehicleDAO {

	@Autowired
	JdbcTemplate jdbcTeamplate;

	public Collection<Vehicle> getAll() {
		
		return jdbcTeamplate.query("SELECT id, brand, model, fuel, chassis, engine, license_plate, vignettes,"
				+ "insurance, itp " + "FROM public.vehicle;", new VehicleMapper());
	}

	@Override
	public Collection<Vehicle> getByLicence() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicle findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicle update(Vehicle model) {
		System.out.println(model.getCarType());
	
		  jdbcTeamplate.update("INSERT INTO public.vehicle("
					+ " brand, model, fuel, chassis, engine, license_plate, vignettes, insurance, itp) " +

					"VALUES ( ?, ?, ?, ?, ?, ?, ?,?, ?) ;", model.getBrand(), model.getCarType(), model.getFuel(),
					model.getChassis(), model.getEngine(), model.getLicensePlate(), model.isVignettes(),
					model.isInsurance(), model.isITP());
		  return model;
		 }

	@Override
	public int delete(Vehicle model) {

		return jdbcTeamplate.update("DELETE FROM public.vehicle " + "WHERE id=?;", model.getId());
	}

	@Override
	public int edit(Vehicle model) {

		return jdbcTeamplate.update(
				"UPDATE public.vehicle " + "SET id=?, brand=?, model=?, fuel=?, chassis=?, engine=?, license_plate=?, "
						+ " vignettes=?, insurance=?, itp=?" + " WHERE id=?;",
				model.getId());
	}

	private static class VehicleMapper implements RowMapper<Vehicle> {

		@Override
		public Vehicle mapRow(ResultSet rs, int arg1) throws SQLException {
			Vehicle vehicle = new Vehicle();
			vehicle.setId(rs.getInt("id"));
			vehicle.setBrand(rs.getString("brand"));
			vehicle.setCarType(rs.getString("model"));
			vehicle.setFuel(rs.getString("fuel"));
			vehicle.setChassis(rs.getString("chassis"));
			vehicle.setEngine(rs.getInt("engine"));
			vehicle.setLicensePlate(rs.getString("license_plate"));
			vehicle.setVignettes(rs.getBoolean("vignettes"));
			vehicle.setITP(rs.getBoolean("itp"));
			vehicle.setInsurance(rs.getBoolean("insurance"));
			return vehicle;
		}
	}

}
