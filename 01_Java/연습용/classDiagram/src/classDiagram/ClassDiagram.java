package classDiagram;

public class ClassDiagram {

	// BuyCar
	public class BuyCar{
		private Driver bestDriver;
		private Car carType;
		public BuyCar(Driver d) {
			this.bestDriver = new Driver(); 
		}
	}
	
	
	// Driver
	public class Driver{
		private String name;
		private int age;
	}

	
	// Benz
	public abstract class Benz extends Car{
		private int price;
		public Status autoDrive() {
			return new Status();
		}
	}
	
	
	// Status
	public class Status{
		private int speed;
		private String engineStatus;
		private String oilStatus;
	}
	
	
	// Audi
	public class Audi extends Car{
		private int price;
		public void saveMode() {}
		protected void specialFunction() {}
	}
	
	
	// Car
	public abstract class Car{
		public void defaultFunction() {}
		protected abstract void specialFunction();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}







































