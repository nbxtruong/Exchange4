/**
 * The class Currency allows to create objects representing the curreny of a
 * country.
 * Each currency is characterized by its name and contains as data its exchange
 * rate in euro.
 * This class gives also methods allowing to convert an amount from the currency
 * to euro and reverse.
 * The exchange rate in euro may be changed.
 */

public class Currency {
	private final String name;

	private double exchangeRateInEuro;

	public Currency(String name, double exchangeRateInEuro) {
		this.name = name;
		this.exchangeRateInEuro = exchangeRateInEuro;
	}

	/*
	 * This method is final to forbid name changing by redefinition.
	 */
	public final String name() {
		return name;
	}

	public double exchangeRateInEuro() {
		return exchangeRateInEuro;
	}

	public void modifyExchangeRateInEuro(double newRate) {
		exchangeRateInEuro = newRate;
	}

	public double convertInEuro(double amount) {
		return amount / exchangeRateInEuro;
	}

	public double convertFromEuro(double amount) {
		return amount * exchangeRateInEuro;
	}

	public boolean equals(Object o) {
		return o instanceof Currency && name.equals(((Currency) o).name);
	}

	public String toString() {
		return name;
	}

	public int hashCode() {
		return name.hashCode();
	}
}
