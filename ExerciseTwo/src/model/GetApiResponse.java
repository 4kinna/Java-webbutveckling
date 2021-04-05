package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class GetApiResponse {

	public static void getWeather(WeatherBean wBean) throws IOException {

		// Build the API call URL by adding city+country into a URL
		String URLtoSend = "http://api.openweathermap.org/data/2.5/weather?q=" + wBean.getCityStr() + ","
				+ wBean.getCountryStr() + "&APPID=75266191928921c5cabd5749e6368356&mode=xml";


		// Set the URL that will be sent
		URL line_api_url = new URL(URLtoSend);

		// Create a HTTP connection to sent the GET request over
		HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();
		linec.setDoInput(true);
		linec.setDoOutput(true);
		linec.setRequestMethod("GET");

		// Make a Buffer to read the response from the API
		BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));

		// a String to temp save each line in the response
		String inputLine;

		// a String to save the full response to use later
		String ApiResponse = "";

		// loop through the whole response
		while ((inputLine = in.readLine()) != null) {

			// System.out.println(inputLine);
			// Save the temp line into the full response
			ApiResponse += inputLine;
		}
		in.close();

		// print the response
		System.out.println(ApiResponse);

		// Call a method to make a XMLdoc out of the full response
		Document doc = convertStringToXMLDocument(ApiResponse);

		// normalize the XML response
		doc.getDocumentElement().normalize();
		
		// check that the XML response is OK by getting the Root element
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		// Create a Node list that gets everything in and under the "clouds" tag
		NodeList cloudNodeList = doc.getElementsByTagName("clouds");

		// loop through the content of the tag
		for (int i = 0; i < cloudNodeList.getLength(); i++) {
			// Save a node of the current list id
			Node nodeCloud = cloudNodeList.item(i);
			if (nodeCloud.getNodeType() == Node.ELEMENT_NODE) {

				// set the current node as an Element
				Element cElement = (Element) nodeCloud;
				// get the content of an attribute in element
				String XMLclouds = cElement.getAttribute("name");
				// and print it
				System.out.println(wBean.getCityStr() + " is now a " + XMLclouds);
				// save it
				wBean.setCloudsStr(XMLclouds);

			}
		}
		
		// Create a Node list that gets everything in and under the "last update" tag
		NodeList lastupdateNodeList = doc.getElementsByTagName("lastupdate");

		// loop through the content of the tag
		for (int j = 0; j < lastupdateNodeList.getLength(); j++) {
			// Save a node of the current list id
			Node nodeLastupdate = lastupdateNodeList.item(j);
			if (nodeLastupdate.getNodeType() == Node.ELEMENT_NODE) {

				// set the current node as an Element
				Element lElement = (Element) nodeLastupdate;
				// get the content of an attribute in element
				String XMLlastupdate = lElement.getAttribute("value");
				XMLlastupdate = XMLlastupdate.replace("T", " at ");
				XMLlastupdate = XMLlastupdate.substring(0, XMLlastupdate.length() - 3) + " ";
				
				
				// and print it
				System.out.println(XMLlastupdate);
				// save it
				wBean.setLastupdateStr(XMLlastupdate);

			}
		}
		
		// Create a Node list that gets everything in and under the "clouds" tag
				NodeList tempNodeList = doc.getElementsByTagName("temperature");

				// loop through the content of the tag
				for (int k = 0; k < tempNodeList.getLength(); k++) {
					// Save a node of the current list id
					Node nodeTemp = tempNodeList.item(k);
					if (nodeTemp.getNodeType() == Node.ELEMENT_NODE) {

						// set the current node as an Element
						Element tElement = (Element) nodeTemp;
						// get the content of an attribute in element
						String XMLtemp = tElement.getAttribute("value");
						
						
						double celsius = Double.parseDouble(XMLtemp) -273.15;
						DecimalFormat df = new DecimalFormat("0");
						// and print it
						System.out.println("the temprature is " + df.format(celsius));
						// save it
						wBean.setTemp(df.format(celsius));

					}
				}
	}

	// Method the makes a XML doc out of a string, if it is in a XML format.
	private static Document convertStringToXMLDocument(String xmlString) {
		// Parser that produces DOM object trees from XML content
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// API to obtain DOM Document instance
		DocumentBuilder builder = null;
		try {
			// Create DocumentBuilder with default configuration
			builder = factory.newDocumentBuilder();

			// Parse the content to Document object
			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}