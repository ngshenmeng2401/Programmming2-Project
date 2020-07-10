package my.javatree;

/**
 * This class is for creating an array list.
 *
 * @author Tan Jia Earn
 * @author Ng Shen Meng
 * @author Wong Fang Man
 */
public class DataOfSystem {

    String countryName;
    int totalCases, newCases, totalDeaths, newDeaths;
    int totalRecovered, activeCases, seriousCritical;
    long totCases;
    long deaths;
    int totalTest;
    long test;
    int population;
    int row;

    /**
     * This constructor is for adding data.
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
    public DataOfSystem(String countryName, int totalCases, int newCases, int totalDeaths, int newDeaths, int totalRecovered, int activeCases, int seriousCritical, long totCases, long deaths, int totalTest, long test, int population) {
        this.countryName = countryName;
        this.totalCases = totalCases;
        this.newCases = newCases;
        this.totalDeaths = totalDeaths;
        this.newDeaths = newDeaths;
        this.totalRecovered = totalRecovered;
        this.activeCases = activeCases;
        this.seriousCritical = seriousCritical;
        this.totCases = totCases;
        this.deaths = deaths;
        this.totalTest = totalTest;
        this.test = test;
        this.population = population;
    }

    /**
     * This constructor is for editing previous data.
     *
     * @param countryName    The type of country.
     * @param newDeaths      The number of new deaths.
     * @param newCases       The number of new cases.
     * @param row            The row of table.
     * @param totalRecovered The number of total recovered.
     */
    public DataOfSystem(String countryName, int newDeaths, int newCases, int row, int totalRecovered) {
        this.countryName = countryName;
        this.newDeaths = newDeaths;
        this.newCases = newCases;
        this.row = row;
        this.totalRecovered = totalRecovered;
    }

}

