package code.explore.grammar;

public class Car {
	public String brand = "Audi";
	private String oil;
	public void run(String oil) {
		this.oil = oil;
		System.out.println("Have a wonderful travel <Audi>");
		Engine engine = new Engine(5);
		engine.run();
	}
	public class Engine{
		public int temperature;
		public Engine(int temperature) {
			this.temperature = temperature;
		}
		public void run() {
			System.out.println("current temperature:"+temperature+"℃,oil type:"+oil);
		}
	}
}
