package devises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyTest {
	private Money m12CHF;
	private Money m14CHF;

	@BeforeEach
	void setUp() {
		m12CHF = new Money(12, "CHF");
		m14CHF = new Money(14, "CHF");
	}

	@Test
	void testSimpleAdd() {

		// Money m12CHF = new Money(12, "CHF");
		// Money m14CHF = new Money(14, "CHF");
		Money expected = new Money(26, "CHF");
		Money result = (Money) m12CHF.add(m14CHF);
		assertTrue(expected.equals(result));
	}

	@Test
	void testEquals() {
		// Money m12CHF = new Money(12, "CHF");
		// Money m14CHF = new Money(14, "CHF");

		assertTrue(!m12CHF.equals(null));
		assertEquals(m12CHF, m12CHF);
		assertEquals(m12CHF, new Money(12, "CHF"));
		assertTrue(!m12CHF.equals(m14CHF));
	}
}
