package my.javatree;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is for add data into list and write data into file.
 *
 * @author Tan Jia Earn
 * @author Ng Shen Meng
 * @author Wong Fang Man
 */
public class CoronaVirus {
    String countryName;
    int totalCases, newCases, totalDeaths, newDeaths;
    int totalRecovered, activeCases, seriousCritical;
    long totCases, deaths, test;
    int totalTest, population;
    static List<DataOfSystem> dOS = new ArrayList<>();

    /**
     * This is constructor for class CoronaVirus.
     */
    public CoronaVirus() {
    }

    /**
     * This is constructor for class CoronaVirus.
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
    public CoronaVirus(String countryName, int totalCases, int newCases, int totalDeaths, int newDeaths, int totalRecovered, int activeCases, int seriousCritical, long totCases, long deaths, int totalTest, long test, int population) {
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
     * This method is for adding the data into list.
     *
     * @return The string.
     */
    public String toString() {
        String data;
        data = "\nCountry Name       : " + countryName
                + "\n" + "Total Cases           : " + totalCases
                + "\n" + "Total Deaths          : " + totalDeaths
                + "\n" + "Total Recovered    : " + totalRecovered
                + "\n" + "Active Cases          : " + activeCases
                + "\n" + "Serious Critical       : " + seriousCritical
                + "\n" + "Total Test               : " + totalTest
                + "\n" + "Population              : " + population;

        dOS.add(new DataOfSystem(countryName, totalCases, newCases, totalDeaths, newDeaths, totalRecovered, activeCases, seriousCritical, totCases, deaths, totalTest, test, population));

        return data;
    }

    /**
     * This method is for writing the data into file.
     */
    public void fileWriter() {
        try (FileWriter cV = new FileWriter("Covid19.txt")) {
            StringBuilder sb = new StringBuilder();
            for (DataOfSystem dOS : CoronaVirus.dOS) {
                sb
                        .append(dOS.countryName).append(",")
                        .append(dOS.totalCases).append(",")
                        .append(dOS.newCases).append(",")
                        .append(dOS.totalDeaths).append(",")
                        .append(dOS.newDeaths).append(",")
                        .append(dOS.totalRecovered).append(",")
                        .append(dOS.activeCases).append(",")
                        .append(dOS.seriousCritical).append(",")
                        .append(dOS.totCases).append(",")
                        .append(dOS.deaths).append(",")
                        .append(dOS.totalTest).append(",")
                        .append(dOS.test).append(",")
                        .append(dOS.population).append(",")
                        .append("\r\n");
            }
            cV.write(sb.toString());
            cV.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
