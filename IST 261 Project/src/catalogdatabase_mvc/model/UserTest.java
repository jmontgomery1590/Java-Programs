package catalogdatabase_mvc.model;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class UserTest {
	User ceo = new User("Justin Montgomery", "Houston, TX", "(412)737-0996");

	@Test
	void testGetName() {
		String expected = "Justin Montgomery";
		String actual = ceo.getName();
		assertEquals(expected, actual);
	}

	@Test
	void testSetName() {
		User ceo = new User();
		ceo.setName("Justin Montgomery");
		assertEquals("Justin Montgomery", ceo.getName());
	}

	@Test
	void testGetLocation() {
		String expected = "Houston, TX";
		String actual = ceo.getLocation();
		assertEquals(expected, actual);
	}

	@Test
	void testSetLocation() {
		User ceo = new User();
		ceo.setLocation("Houston, TX");
		assertEquals("Houston, TX", ceo.getLocation());
	}

	@Test
	void testGetContactInfo() {
		String expected = "(412)737-0996";
		String actual = ceo.getContactInfo();
		assertEquals(expected, actual);
	}

	@Test
	void testSetContactInfo() {
		User ceo = new User();
		ceo.setContactInfo("(412)737-0996");
		assertEquals("(412)737-0996", ceo.getContactInfo());
	}

	@Test
	void testToString() {
		System.out.println(ceo.toString());
	}

}
