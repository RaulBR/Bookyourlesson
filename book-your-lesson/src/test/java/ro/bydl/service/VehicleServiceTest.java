package ro.bydl.service;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import ro.bydl.domain.Vehicle;

public class VehicleServiceTest {
	@Test
	public void licencePlateFormatTest() {
		Vehicle vehicle = new Vehicle();
		vehicle.setLicensePlate("sdfsdfsdf");

		assertTrue(new VehicleService().isLicenceCrectFormat(vehicle));
	}

	@Test
	public void licencePlateFalseTest() {
		Vehicle vehicle = new Vehicle();
		vehicle.setLicensePlate("Cj22bbb");

		assertFalse(new VehicleService().isLicenceCrectFormat(vehicle));
	}

	@Test
	public void licencePlateFalse2Test() {
		Vehicle vehicle = new Vehicle();
		vehicle.setLicensePlate("B202bbb");

		assertFalse(new VehicleService().isLicenceCrectFormat(vehicle));
	}

	@Test
	public void itpInThePsatTest() {
		Vehicle vehicle = new Vehicle();
		DateFormat formatter;
		Date date = null;
		formatter = new SimpleDateFormat("dd.MM.yyyy");
		try {
			date = formatter.parse("11.05.1988");
		} catch (ParseException e) {

		}
		vehicle.setITP(date);

		assertTrue(new VehicleService().DareInThePast(date));
	}

	@Test
	public void itpIsOkTest() {
		Vehicle vehicle = new Vehicle();
		DateFormat formatter;
		Date date = null;
		formatter = new SimpleDateFormat("dd.MM.yyyy");
		try {
			date = formatter.parse("11.05.2017");
		} catch (ParseException e) {

		}
		vehicle.setITP(date);

		assertFalse(new VehicleService().DareInThePast(date));
	}

	@Test
	public void vinietIsOkTest() {

		assertEquals("aaaa", new VehicleService().removeSpace("aa aa"));

	}

	@Test
	public void refineVihecleTest() {
		VehicleService s = new VehicleService();
		Vehicle vehicle = new Vehicle();
		vehicle.setBrand("dacia");
		s.refineVehicleContent(vehicle);

		assertEquals("Dacia", vehicle.getBrand());
	}

	@Test
	public void refineCarTypeVihecleTest() {
		VehicleService s = new VehicleService();
		Vehicle vehicle = new Vehicle();
		vehicle.setCarType("dacia");
		s.refineVehicleContent(vehicle);

		assertEquals("Dacia", vehicle.getCarType());
	}

}
