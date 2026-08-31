package devises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyBagTest {

	private Money f12CHF;
	private Money f14CHF;
	private Money f7USD;
	private Money f21USD;
	private MoneyBag fMB1;

	@BeforeEach
	public void setUp() {
		f12CHF = new Money(12, "CHF");
		f14CHF = new Money(14, "CHF");
		f7USD = new Money(7, "USD");
		f21USD = new Money(21, "USD");
		fMB1 = new MoneyBag(f12CHF, f7USD);
		new MoneyBag(f14CHF, f21USD);
	}

	@Test
	public void testBagEquals() {
		assertTrue(!fMB1.equals(null));
		assertEquals(fMB1, fMB1);
		assertTrue(!fMB1.equals(f12CHF));
		assertTrue(!f12CHF.equals(fMB1));
	}

	@Test
	public void testBagSimpleAdd() {
		// [12 CHF] + [14 CHF, 21 USD] = [26 CHF, 21 USD]
		Money bagData[] = { f14CHF, f21USD };
		MoneyBag bag = new MoneyBag(bagData);

		Money expectedData[] = { new Money(26, "CHF"), f21USD };
		MoneyBag expected = new MoneyBag(expectedData);

		// Ajout d'un MoneyBag à un simple Money (f12CHF)
		assertEquals(expected, f12CHF.add(bag));
	}

	@Test
	public void testSimpleBagAdd() {
		// [14 CHF, 21 USD] + [12 CHF] = [26 CHF, 21 USD]
		Money bagData[] = { f14CHF, f21USD };
		MoneyBag bag = new MoneyBag(bagData);

		Money expectedData[] = { new Money(26, "CHF"), f21USD };
		MoneyBag expected = new MoneyBag(expectedData);

		// Ajout d'un simple Money (f12CHF) à un MoneyBag (bag)
		assertEquals(expected, bag.add(f12CHF));
	}

	@Test
	public void testBagBagAdd() {
		// [12 CHF, 7 USD] + [14 CHF, 21 USD] = [26 CHF, 28 USD]
		MoneyBag bag1 = new MoneyBag(f12CHF, f7USD);
		MoneyBag bag2 = new MoneyBag(f14CHF, f21USD);

		Money expectedData[] = { new Money(26, "CHF"), new Money(28, "USD") };
		MoneyBag expected = new MoneyBag(expectedData);

		// Ajout de deux MoneyBags (bag1 + bag2)
		assertEquals(expected, bag1.add(bag2));
	}

}
