import java.util.ArrayList;
import java.util.List;


/**
 * The class Exchange allows to convert an amount in euro.
 * 
 * Version 4.
 */

public class Exchange {

	/*
	 * This version allows to add dynamicaly new currencies.
	 * 
	 * Other problems from the previous version are still present :
	 * - using Error() instead an exception ;
	 * - problem on the effenciency of the method searchCurrency(String) ;
	 * - it is always possible to modify the rate of a currency, when it would be
	 * some time impossible.
	 */

	private static final List<Currency> CURRENCIES = new ArrayList<Currency>();

	static {
		String[] names = { "Franc", "Mark", "Dollard", "Euro" };
		double[] rates = { 6.55957, 1.95583, 1.2713, 1. };

		for (int i = 0; i < names.length; ++i) {
			addCurrency(new Currency(names[i], rates[i]));
		}
	}

	/*
	 * Please note the use of a loop for on an Iterable. This notation exists
	 * only since version 1.5.
	 */
	private static Currency searchCurrency(String name) {
		for (Currency c : CURRENCIES) {
			if (c.name().equals(name)) {
				return c;
			}
		}
		return null;
	}

	public static Currency currency(String name) {
		Currency c = searchCurrency(name);
		if (c == null) {
			throw new Error("Currency " + name + " unknown");
		}
		return c;
	}

	public static void addCurrency(Currency d) {
		if (searchCurrency(d.name()) == null) {
			CURRENCIES.add(d);
		} else {
			throw new Error("Currency " + d.name() + " yet present");
		}
	}

	public static boolean processedCurrency(String name) {
		return (searchCurrency(name) != null);
	}

	public static Currency[] processedCurrencies() {
		return CURRENCIES.toArray(new Currency[CURRENCIES.size()]);
	}

	public static void main(String[] args) {
		double amountToConvert = Double.valueOf(args[0]).doubleValue();
		String currencyName = args[1];

		if (processedCurrency(currencyName)) {
			System.out.println(currency(currencyName).convertInEuro(
					amountToConvert)
					+ " Euros");
		} else {
			Currency[] currencies = processedCurrencies();
			System.out.print("Currency unknown (processed currencies =");
			for (int i = 0; i < currencies.length; ++i) {
				System.out.print(" " + currencies[i].name());
			}
			System.out.println(")");
		}
	}
}
