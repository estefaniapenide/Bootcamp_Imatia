package Ejercicio12;

public class Car {
	String brand;
	String model;
	int maxSpeed;
	String fuel;
	int speedometer = 0;
	int tachometer = 0;
	String gear = "N";
	boolean reverse = false;
	int steeringWheelAngle = 0;


	public Car(String brand, String model, int maxSpeed, String fuel) {
		this.brand = brand;
		this.model = model;
		this.maxSpeed = maxSpeed;
		this.fuel = fuel;
	}

	public Car() {
		this.brand = "Opel";
		this.model = "Corsa";
		this.maxSpeed = 120;
		this.fuel = "Gasolina";
	}

	public void start() {
		if (this.tachometer == 0) {
			this.tachometer = 1000;
			this.speedometer = 0;
			System.out.println("Vehiculo acendido");
		} else {
			System.out.println("O vehiculo xa esta acendido");
		}
	}

	public void stop() {
		if (this.speedometer == 0) {
			this.tachometer = 0;
			System.out.println("Vehiculo apagado");
		} else {
			System.out.println("Non se pode apagar o vehiculo, primero ten que estar detido");
		}
	}

	private void switchGear(int minSpeed, int maxSpeed, String nextGear, int interval) {
		if (this.speedometer >= minSpeed && this.speedometer < maxSpeed) {
			this.speedometer += 10;
			this.tachometer += interval;
			if (this.speedometer == maxSpeed) {
				this.gear=nextGear;
				this.tachometer = 1000;
			}

		} else {
			System.out.println("O coche non cambia a súa aceleración porque non está na marcha correcta.");
		}
	}

	public void switchFromN(String gear, int speed1, int speed2, int speed3) {
		this.gear = gear;
		if(this.speedometer==speed1) {
			this.tachometer = 1000;
		}
		if(this.speedometer==speed2) {
			this.tachometer = 1500;
		}
		if(this.speedometer==speed3) {
			this.tachometer = 2000;
		}
	}
	


	public void accelerate() {

		if (this.tachometer >= 1000) {

			if (this.maxSpeed > this.speedometer) {

				switch (this.gear) {
				case "1", "R":
					if (this.speedometer >= 0 && this.speedometer < 10) {
						this.speedometer += 10;
						this.tachometer += 1500;
						if (this.speedometer == 10 && this.gear.equals("R")) {
							this.reverse = false;
							this.gear = "2";
							this.tachometer = 1000;
						}
						if (this.speedometer == 10) {
							this.gear = "2";
							this.tachometer = 1000;
						}

					} else {
						System.out.println("O coche non cambia a súa aceleración porque non está na marcha correcta");
					}
					break;
				case "2":
					switchGear(10, 30, "3",500);
					break;
				case "3":
					switchGear(30, 50, "4",500);
					break;
				case "4":
					switchGear(50, 70, "5",500);
					break;
				case "5":
					if (this.speedometer >= 70 && this.speedometer < this.maxSpeed) {
						this.speedometer += 10;
						this.tachometer += 500;
					}
					break;
				case "N":
					this.speedometer += 10;
					if (this.speedometer >= 0 && this.speedometer < 10) {
						this.gear = "1";
						switch (this.speedometer) {
						case 0:
							this.tachometer = 1000;
							break;
						case 10:
							this.tachometer = 2000;
							break;
						}
					}
					if (this.speedometer >= 10 && this.speedometer < 30) {
						switchFromN("2",10,20,30);
					}
					if (this.speedometer >= 30 && this.speedometer < 50) {
						switchFromN("3",30,40,50);
					}
					if (this.speedometer >= 50 && this.speedometer < 70) {
						switchFromN("4",50,60,70);
					}
					if (this.speedometer >= 70) {
						this.gear = "5";
						switch (this.speedometer) {
						case 70:
							this.tachometer = 1000;
							break;
						case 80:
							this.tachometer = 1500;
							break;
						case 90:
							this.tachometer = 2000;
							break;
						case 100:
							this.tachometer = 2500;
							break;
						case 110:
							this.tachometer = 3000;
							break;
						case 120:
							this.tachometer = 3500;
							break;
						}
					}

					break;

				}

				System.out.println("Velocidade: " + this.speedometer);
				System.out.println("Revolucións: " + this.tachometer);
				System.out.println("Marcha: " + this.gear);

			} else {
				System.out.println("Non se pode acelerar. O vehículo está á máxima velocidade");
			}

		} else {
			System.out.println("Non se pode acelerar. O vehículo está apagado");
		}

	}

	private void switchGearBreak(int minSpeed, int maxSpeed, String prevoius,int interval) {
		if (this.speedometer > minSpeed && this.speedometer <= maxSpeed) {
			this.speedometer -= 10;
			this.tachometer -= interval;
			if (this.speedometer == minSpeed) {
				this.gear=prevoius;
				this.tachometer = 2000;
			}

		} else {
			System.out.println("O coche non cambia a súa aceleración porque non está na marcha correcta.");
		}
	}
	

	public void decelerate() {

		if (this.speedometer > 0) {

			switch (this.gear) {
			case "1", "R":
				if (this.speedometer >= 0 && this.speedometer <= 10) {
					this.speedometer -= 10;
					this.tachometer -= 1000;
				} else {
					System.out.println("O coche non cambia a súa aceleración porque non está na marcha correcta");
				}
				break;
			case "2":
				switchGearBreak(10, 30, "1",500);
				break;
			case "3":
				switchGearBreak(30, 50, "2",500);
				break;
			case "4":
				switchGearBreak(50, 70, "3",500);
				break;
			case "5":
				switchGearBreak(70, this.maxSpeed, "4",500);
				break;
			case "N":
				this.speedometer -= 10;
				if (this.speedometer >= 0 && this.speedometer < 10) {
					this.gear = "1";
					switch (this.speedometer) {
					case 0:
						this.tachometer = 1000;
						break;
					case 10:
						this.tachometer = 2000;
						break;
					}
				}
				if (this.speedometer >= 10 && this.speedometer < 30) {
					switchFromN("2",10,20,30);

				}
				if (this.speedometer >= 30 && this.speedometer < 50) {
					switchFromN("3",30,40,50);
				}
				if (this.speedometer >= 50 && this.speedometer < 70) {
					switchFromN("4",50,60,70);
				}
				if (this.speedometer >= 70) {
					this.gear = "5";
					switch (this.speedometer) {
					case 70:
						this.tachometer = 1000;
						break;
					case 80:
						this.tachometer = 1500;
						break;
					case 90:
						this.tachometer = 2000;
						break;
					case 100:
						this.tachometer = 2500;
						break;
					case 110:
						this.tachometer = 3000;
						break;
					case 120:
						this.tachometer = 3500;
						break;
					}
				}

				break;

			}

			System.out.println("Velocidade: " + this.speedometer);
			System.out.println("Revolucións: " + this.tachometer);
			System.out.println("Marcha: " + this.gear);

		} else {
			System.out.println("Non se pode frear. O vehículo xa está detido.");
		}

	}

	public void turnSteeringWheel(int angle) {
		
		if ((this.steeringWheelAngle + angle) >= 545) {

			this.steeringWheelAngle = 545;
			System.out.println("Chegou ó tope. Non pode xirar máis o volante á dereita");

		} else if ((this.steeringWheelAngle + angle) <= -545) {

			this.steeringWheelAngle = -545;
			System.out.println("Chegou ó tope. Non pode xirar máis o volante á esquerda");

		} else {

			this.steeringWheelAngle += angle;

		}

		System.out.println("Ángulo do volante: " + this.steeringWheelAngle);
	}

	public String showSteeringWheelDetail() {
		String steeringWheel = "Ángulo del volante: " + this.steeringWheelAngle;
		return steeringWheel;// mostrar el angulo de las ruedas

	}

	public boolean isReverse() {
		return this.reverse;
	}

	public void setReverse(boolean reverse) {
		if (reverse) {
			if (this.speedometer <=10) {
				this.gear = "R";
				this.reverse = reverse;
			} else {
				System.out.println("Non é psoible meter a marcha atrás, vai demasiado rápido. Frene primeiro.");
			}
		} else {
			this.reverse = reverse;
			this.gear = "N";
		}
		
		System.out.println("Velocidade: " + this.speedometer);
		System.out.println("Revolucións: " + this.tachometer);
		System.out.println("Marcha: " + this.gear);
	}

	public void showDetails() {
		System.out.println("\nMARCA: " + this.brand + "\nMODELO: " + this.model + "\nVELOCIDADE MÁXIMA: "
				+ this.maxSpeed + "\nCOMBUSTIBLE: " + this.fuel + "\nVELOCÍMETRO: " + this.speedometer + "\nTACÓMETRO: "
				+ this.tachometer + "\nMARCHA: " + this.gear + "\nMARCHA ATRÁS: " + this.reverse
				+ "\nÁNGULO DO VOLANTE: " + this.steeringWheelAngle);

	}


	public static void main(String[] args) {

		Car myCar = new Car();
		String option = "";
		System.out.println();
		myCar.showDetails();

		System.out.println();
		myCar.stop();

		System.out.println();
		myCar.accelerate();

		System.out.println();
		myCar.start();

		System.out.println();
		myCar.accelerate();

		System.out.println();
		myCar.accelerate();

		System.out.println();
		myCar.accelerate();

		
		System.out.println();
		myCar.turnSteeringWheel(-300);

		System.out.println();
		myCar.accelerate();

		System.out.println();
		myCar.accelerate();
		
		System.out.println();
		myCar.turnSteeringWheel(-276);

		System.out.println();
		myCar.accelerate();

		System.out.println();
		myCar.accelerate();

		System.out.println();
		myCar.accelerate();

		System.out.println();
		myCar.accelerate();

		System.out.println();
		myCar.accelerate();

		System.out.println();
		myCar.accelerate();
		
		System.out.println();
		myCar.stop();

		System.out.println();
		myCar.accelerate();
		
		System.out.println();
		myCar.turnSteeringWheel(533);

		System.out.println();
		myCar.accelerate();

		System.out.println();
		myCar.accelerate();

		System.out.println();
		myCar.setReverse(true);

		System.out.println();
		myCar.decelerate();

		System.out.println();
		myCar.decelerate();

		System.out.println();
		myCar.decelerate();

		System.out.println();
		myCar.setReverse(true);

		System.out.println();
		myCar.turnSteeringWheel(12);

		System.out.println();
		myCar.decelerate();

		System.out.println();
		myCar.accelerate();

		System.out.println();
		myCar.decelerate();

		System.out.println();
		myCar.decelerate();

		System.out.println();
		myCar.decelerate();

		System.out.println();
		myCar.decelerate();

		System.out.println();
		myCar.setReverse(true);

		System.out.println();
		myCar.decelerate();

		System.out.println();
		myCar.decelerate();

		System.out.println();
		myCar.decelerate();

		System.out.println();
		myCar.setReverse(true);

		System.out.println();
		myCar.decelerate();

		System.out.println();
		myCar.setReverse(true);

		System.out.println();
		myCar.decelerate();

		System.out.println();
		myCar.decelerate();
		

		System.out.println();
		myCar.stop();

		System.out.println();
		myCar.showDetails();

	}

}
