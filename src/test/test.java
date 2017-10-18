package test;

import dao.CarDao;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//²âÊÔÊý¾Ý¿â²Ù×÷
		CarDao cd = new CarDao();
//		cd.getCarInfo();
//		cd.saveCarInfo();
//		cd.deleteCarInfo();
		cd.updateCarInfo();
//		cd.testOrcl();

	}

}
