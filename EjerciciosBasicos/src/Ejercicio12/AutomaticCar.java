package Ejercicio12;

public class AutomaticCar { // Hay que poner los atributos privados para que no tenga acceso el usuario
	String brand;
	String model;
	int maxSpeed;
	String fuel;
	int speedometer = 0;
	int tachometer = 0;
	String gear = "N";
	boolean reverse = false;
	int steeringWheelAngle = 0;

	public AutomaticCar(String brand, String model, int maxSpeed, String fuel) {
		this.brand = brand;
		this.model = model;
		this.maxSpeed = maxSpeed;
		this.fuel = fuel;
	}

	public AutomaticCar() {
		this.brand = "Opel";
		this.model = "Corsa";
		this.maxSpeed = 120;
		this.fuel = "Gasolina";
	}

	public void start() {
		if (this.tachometer == 0) {
			this.tachometer = 1000;
			this.gear = "N";
			this.reverse=false;
			this.speedometer = 0;
			System.out.println("Vehiculo acendido");
		} else {
			System.out.println("O vehiculo xa esta acendido");
		}
	}

	public void stop() {
		if (this.speedometer == 0) {
			this.tachometer = 0;
			this.gear = "P";
			this.reverse=false;
			System.out.println("Vehiculo apagado");
		} else {
			System.out.println("Non se pode apagar o vehiculo, primero ten que estar detido");
		}
	}

	private void tachometerControlAceleration(int minSpeed, int maxSpeed, int interval) {
		if (this.speedometer >= minSpeed && this.speedometer < maxSpeed) {
			this.speedometer += 10;
			this.tachometer += interval;
			if (this.speedometer == maxSpeed) {
				this.tachometer = 1000;
			}

		}
	}

	public void accelerate() {

		if (this.tachometer >= 1000) {

			if (this.maxSpeed > this.speedometer) {

				if (this.gear.equals("R")) {
					if (this.speedometer >= 10) {
						System.out.println("Non é psoible acelerar máis marcha atrás.\n");
					} else {
						this.speedometer += 10;
						this.tachometer += 1000;
					}
				} else {

					this.gear = "D";
					switch (this.speedometer) {
					case 0:
						tachometerControlAceleration(0, 10, 1000);
						break;
					case 10, 20:
						tachometerControlAceleration(10, 30, 500);
						break;
					case 30, 40:
						tachometerControlAceleration(30, 50, 500);
						break;
					case 50, 60:
						tachometerControlAceleration(50, 70, 500);
						break;
					default:
						if (this.speedometer >= 70 && this.speedometer < this.maxSpeed) {
							this.speedometer += 10;
							this.tachometer += 500;
						}
						break;
					}
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

	private void tachometerControlDeceleration(int minSpeed, int maxSpeed, int interval) {
		if (this.speedometer > minSpeed && this.speedometer <= maxSpeed) {
			if (this.speedometer == maxSpeed) {
				this.tachometer = 2000;
			}
			this.speedometer -= 10;
			this.tachometer -= interval;

		}
	}

	public void decelerate() {

		if (this.speedometer > 0) {

			if (this.gear.equals("R")) {
				if (this.speedometer == 10) {
					this.speedometer -= 10;
					this.tachometer -= 1000;
				} else {
					System.out.println("Non se pode frenar máis.O vehículo xa está detido.");
				}
			} else {
				this.gear = "D";

				switch (this.speedometer) {
				case 10:
					tachometerControlDeceleration(0, 10, 1000);
					break;
				case 20, 30:
					tachometerControlDeceleration(10, 30, 500);
					break;
				case 40, 50:
					tachometerControlDeceleration(30, 50, 500);
					break;
				case 60, 70:
					tachometerControlDeceleration(50, 70, 500);
					break;
				default:
					if (this.speedometer > 70 && this.speedometer <= this.maxSpeed) {
						this.speedometer -= 10;
						this.tachometer -= 500;
					}
					break;
				}

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
			if (this.speedometer <= 10) {
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

		AutomaticCar myCar = new AutomaticCar();
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
		myCar.stop();

		System.out.println();
		myCar.accelerate();

		System.out.println();
		myCar.accelerate();

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
