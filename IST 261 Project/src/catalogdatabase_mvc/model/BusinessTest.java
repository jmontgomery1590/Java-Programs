package catalogdatabase_mvc.model;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class BusinessTest {
	Business b1 = new Business("Justin's Instruments", "Retail", "Houston, TX", 225);

	@Test
	void testGetName() {
		String expected = "Justin's Instruments";
		String actual = b1.getName();
		assertEquals(expected, actual);
	}

	@Test
	void testSetName() {
		Business b1 = new Business();
		b1.setName("Justin's Instruments");
		assertEquals("Justin's Instruments", b1.getName());
	}

	@Test
	void testGetIndustry() {
		String expected = "Retail";
		String actual = b1.getIndustry();
		assertEquals(expected, actual);
	}

	@Test
	void testSetIndustry() {
		Business b1 = new Business();
		b1.setIndustry("Retail");
		assertEquals("Retail", b1.getIndustry());
	}

	@Test
	void testGetLocation() {
		String expected = "Houston, TX";
		String actual = b1.getLocation();
		assertEquals(expected, actual);
	}

	@Test
	void testSetLocation() {
		Business b1 = new Business();
		b1.setLocation("Houston, TX");
		assertEquals("Houston, TX", b1.getLocation());;
	}

	@Test
	void testGetNumProducts() {
		int expected = 225;
		int actual = b1.getNumProducts();
		assertEquals(expected, actual);
	}

	@Test
	void testSetNumProducts() {
		Business b1 = new Business();
		b1.setNumProducts(225);
		assertEquals(225, b1.getNumProducts());
	}

	@Test
	void testToString() {
		System.out.println(b1.toString());
	}

}
