package framep;

import org.testng.annotations.Test;

public class Prior {
	@Test
	public void b() {
		System.out.println("f Without Priority");
		System.out.println("Checking Git");
	}
	@Test(priority = 0)
	public void d() {
		System.out.println("Name 0");
	}
	@Test(priority = 1)
	public void c() {
		System.out.println("Name 1");
	}
	@Test(priority = 1)
	public void a() {
		System.out.println("Name 2");
	}
}
