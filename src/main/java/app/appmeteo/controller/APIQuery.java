package app.appmeteo.controller;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Controller to query API
 *
 * @version 1.2
 */
public class APIQuery {
    private static final String key = "e2e1ec571e2e637490c73b7e051f2556"; // API Key

    /**
     * Creates a query for the API asking for current weather in the city passed in parameter
     *
     * @param city the String corresponding to city's name
     * @return a string containing all .json infos from the API answer
     * @throws IOException if the URL sent is not valid
     * @since 1.0
     */
    public static String QueryWithCity(String city) throws IOException {
        // API Query
        String StrUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=" + key;


        URL url = new URL(StrUrl);
        // URL connection


        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();


        // Buffer creation
        InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
        BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));

        // return string
        return r.readLine();
    }

    /**
     * Creates a query for the API asking for current weather in the city passed in parameter
     *
     * @param city        the String corresponding to city's name
     * @param countryCode the String corresponding to city's country code
     * @return a string containing all .json infos from the API answer
     * @throws IOException if the URL sent is not valid
     * @since 1.2
     */
    public static String QueryWithCountryCode(String city, String countryCode) throws IOException {
        // API Query
        String StrUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + countryCode +
                "&units=metric&appid=" + key;

        URL url = new URL(StrUrl);
        // URL connection
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        // Buffer creation
        InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
        BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));

        // return string
        return r.readLine();
    }

    /**
     * Creates a query for the API asking for current weather in the city passed in parameter
     *
     * @param id the String corresponding to city's ID
     * @return a string containing all .json infos from the API answer
     * @throws IOException if the URL sent is not valid
     * @since 1.2
     */
    public static String QueryWithID(String id) throws IOException {
        // API Query
        String StrUrl = "http://api.openweathermap.org/data/2.5/weather?id=" + id + "&units=metric&appid=" + key;

        URL url = new URL(StrUrl);
        // URL connection
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        // Buffer creation
        InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
        BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));

        // return string
        return r.readLine();
    }

    /**
     * Creates a query for the API asking for current weather in the city passed in parameter
     *
     * @param zip         the String corresponding to city's ZIP Code
     * @param countryCode the String corresponding to city's country code
     * @return a string containing all .json infos from the API answer
     * @throws IOException if the URL sent is not valid
     * @since 1.2
     */
    public static String QueryWithZip(String zip, String countryCode) throws IOException {
        // API Query
        String StrUrl = "http://api.openweathermap.org/data/2.5/weather?zip=" + zip + "," + countryCode + "&units=metric&appid=" + key;

        URL url = new URL(StrUrl);
        // URL connection
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        // Buffer creation
        InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
        BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));

        // return string
        return r.readLine();
    }


    /**
     * Creates a query for the API asking for weather in coordinates passed in parameter
     * Creates and returns a string containing all .json infos from the API answer about 7 days forecast
     *
     * @param longitude longitude of the city
     * @param latitude  latitude of the city
     * @return a string containing all .json infos from the API answer
     * @throws IOException if the URL sent is not valid
     * @since 1.1
     */
    public static String QueryOneCallWithPos(double longitude, double latitude) throws IOException {
        // API Query
        String StrUrl = "https://api.openweathermap.org/data/2.5/onecall?lat=" + latitude +
                "&lon=" + longitude + "&exclude=minutely,alerts&units=metric&appid=" + key;

        URL url = new URL(StrUrl);
        // URL connection
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        // Buffer creation
        InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
        BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));

        // return string
        return r.readLine();
    }

    /**
     * Creates a query for the API asking for weather in coordinates passed in parameter
     * Creates and returns a string containing all .json infos from the API answer about current weather
     *
     * @param longitude longitude of the city
     * @param latitude  latitude of the city
     * @return a string containing all .json infos from the API answer
     * @throws IOException if the URL sent is not valid
     * @since 1.1
     */
    public static String QueryWeatherWithPos(double longitude, double latitude) throws IOException {
        // API Query
        String StrUrl = "http://api.openweathermap.org/data/2.5/weather?lat=" + latitude +
                "&lon=" + longitude + "&units=metric&appid=" + key;

        URL url = new URL(StrUrl);
        // URL connection
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        // Buffer creation
        InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
        BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));

        // return string
        return r.readLine();
    }
}
