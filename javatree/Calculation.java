package my.javatree;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This class is for all calculation.
 *
 * @author Tan Jia Earn
 * @author Ng Shen Meng
 * @author Wong Fang Man
 */
public class Calculation extends CoronaVirus {

    /**
     * This is constructor for class Calculation.
     *
     * @param countryName     The type of country.
     * @param totalCases      The number of total cases.
     * @param newCases        The number of new cases.
     * @param totalDeaths     The number of total deaths.
     * @param newDeaths       The number of new deaths.
     * @param totalRecovered  The number of total recovered.
     * @param activeCases     The number of active cases.
     * @param seriousCritical The number of serious critical.
     * @param totCases        The total cases per 1 million of population for the country.
     * @param deaths          The total deaths per 1 million of population for the country.
     * @param totalTest       The number of total test.
     * @param test            The total test per 1 million of population for the country.
     * @param population      The number of population.
     */
    public Calculation(String countryName, int totalCases, int newCases, int totalDeaths, int newDeaths, int totalRecovered, int activeCases, int seriousCritical, long totCases, long deaths, int totalTest, long test, int population) {
        super(countryName, totalCases, newCases, totalDeaths, newDeaths, totalRecovered, activeCases, seriousCritical, totCases, deaths, totalTest, test, population);
    }

    /**
     * Gets the number of total cases.
     *
     * @return The number of total cases.
     */
    public int getTotalCases() {
        return totalCases;
    }

    /**
     * Gets the number of total deaths.
     *
     * @return The number of total deaths.
     */
    public int getTotalDeaths() {
        return totalDeaths;
    }

    /**
     * Gets the number of new cases.
     *
     * @return The number of new cases.
     */
    public int getNewCases() {
        return newCases;
    }

    /**
     * Gets the number of new deaths.
     *
     * @return The number of new deaths.
     */
    public int getNewDeaths() {
        return newDeaths;
    }

    /**
     * Gets the total cases per 1 million of population for the country.
     *
     * @return The total cases per 1 million of population for the country.
     */
    public long getTotCases() {
        return totCases;
    }

    /**
     * Gets the total deaths per 1 million of population for the country.
     *
     * @return The total deaths per 1 million of population for the country.
     */
    public long getDeaths() {
        return deaths;
    }

    /**
     * Gets the total test per 1 million of population for the country.
     *
     * @return The total test per 1 million of population for the country.
     */
    public long getTest() {
        return test;
    }

    /**
     * This method is for calculating totalCases, newCases, newDeaths, deaths, totCases and test.
     */
    public void calculate() {
        for (DataOfSystem dOS : AddData.dOS) {
            totalCases = dOS.totalDeaths + dOS.totalRecovered + dOS.activeCases;
            newCases = totalCases;
            newDeaths = dOS.totalDeaths;
            String a = Long.toString(dOS.totalDeaths);
            String b = Long.toString(totalCases);
            String c = Long.toString(dOS.totalTest);
            String pP = Long.toString(dOS.population);

            BigDecimal obj1 = new BigDecimal(a);
            BigDecimal obj2 = new BigDecimal(b);
            BigDecimal obj3 = new BigDecimal(c);
            BigDecimal obj4 = new BigDecimal(pP);
            BigDecimal oneM = new BigDecimal("1000000");

            obj1 = obj1.divide(obj4, 10, RoundingMode.CEILING).multiply(oneM);
            obj2 = obj2.divide(obj4, 10, RoundingMode.CEILING).multiply(oneM);
            obj3 = obj3.divide(obj4, 10, RoundingMode.CEILING).multiply(oneM);

            deaths = (long) Math.ceil(Double.parseDouble(String.valueOf(obj1)));
            totCases = (long) Math.ceil(Double.parseDouble(String.valueOf(obj2)));
            test = Math.round(Double.parseDouble(String.valueOf(obj3)));
        }
    }

    /**
     * This method is for calculating totalCases, newCases, newDeaths, deaths, totCases and test after editing.
     */
    public void calculate2() {
        for (DataOfSystem dOS : EditData.dOS) {
            totalCases = dOS.totalDeaths + dOS.totalRecovered + dOS.activeCases;
            String a = Long.toString(dOS.totalDeaths);
            String b = Long.toString(totalCases);
            String c = Long.toString(dOS.totalTest);
            String pP = Long.toString(dOS.population);

            BigDecimal obj1 = new BigDecimal(a);
            BigDecimal obj2 = new BigDecimal(b);
            BigDecimal obj3 = new BigDecimal(c);
            BigDecimal obj4 = new BigDecimal(pP);
            BigDecimal oneM = new BigDecimal("1000000");

            obj1 = obj1.divide(obj4, 10, RoundingMode.CEILING).multiply(oneM);
            obj2 = obj2.divide(obj4, 10, RoundingMode.CEILING).multiply(oneM);
            obj3 = obj3.divide(obj4, 10, RoundingMode.CEILING).multiply(oneM);

            deaths = (long) Math.ceil(Double.parseDouble(String.valueOf(obj1)));
            totCases = (long) Math.ceil(Double.parseDouble(String.valueOf(obj2)));
            test = Math.round(Double.parseDouble(String.valueOf(obj3)));
        }
        newDeaths = totalDeaths - newDeaths;
        newCases = totalCases - newCases;
    }

}
