public class Eagle extends Bird implements Fly {

	private boolean flying;
	private int altitude;

	public Eagle(String name) {
		super(name);
		this.flying = false;
		this.altitude = 0;
	}

	public int getAltitude() {
		return altitude;
	}

	public boolean isFlying() {
		return flying;
	}

	@Override
	public String sing() {
		return "Screech!";
	}

	@Override
	public void takeOff() {
		if (!this.flying) {
			this.flying = true;
			System.out.println("I'm taking off.");
		} else {
			System.out.println("I'm flying.");
		}
	}

	@Override
	public int ascend(int meters) {
		if (!this.flying)
			this.takeOff();
		this.altitude += meters;
		System.out.println("I have ascended and my new altitude is " + this.altitude);
		return this.altitude;
	}

	@Override
	public int descend(int meters) {
		if (!this.flying)
			takeOff();
		if (this.altitude > meters) {
			this.altitude -= meters;
		} else {
			this.altitude = 0;
			this.land();
		}
		System.out.println("I have descended and my new altitude is " + this.altitude);
		return this.altitude;
	}

	@Override
	public void land() {
		String landingPlace = " on the ground.";
		if (this.altitude > 1)
			landingPlace = " on a bush or tree.";
		if (this.flying) {
			this.flying = false;
			System.out.println("I'm landing" + landingPlace);
		} else {
			System.out.println("I'm already landed" + landingPlace);
		}
	}

//	@Override
//	public void glide() {
//		// TODO Auto-generated method stub
//		Fly.super.glide();
//	}

}
