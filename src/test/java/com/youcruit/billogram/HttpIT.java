package com.youcruit.billogram;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.logging.Logger;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.youcruit.billogram.client.http.HttpClient;
import com.youcruit.billogram.client.http.HttpURLConnectionBillogramClient;
import com.youcruit.billogram.client.http.OkHttpBillogramClient;

@RunWith(Parameterized.class)
public abstract class HttpIT {

    public static final Logger LOGGER = Logger.getLogger("HttpTest");

    private final Class<? extends HttpClient> httpClientClass;

    @Parameters
    public static Collection<Object[]> data() {
	return asList(new Object[][] { { OkHttpBillogramClient.class }, { HttpURLConnectionBillogramClient.class } });
    }

    public HttpIT(Class<HttpClient> httpClientClass) {
	this.httpClientClass = httpClientClass;
    }

    public HttpClient createClient(String username, String password) {
	if (httpClientClass == OkHttpBillogramClient.class) {
	    return new OkHttpBillogramClient(username, password, HttpClient.API_SANDBOX_BASE_URL);
	} else if (httpClientClass == HttpURLConnectionBillogramClient.class) {
		return new HttpURLConnectionBillogramClient(username, password, HttpClient.API_SANDBOX_BASE_URL);
	} else {
	throw new RuntimeException("Unknown client" + httpClientClass.getName());
    }
    }

    public HttpClient createClient() {
	String username = getPropEnv("BILLOGRAM_USERNAME");
	if (username == null) {
	    username = "6323-AEkh1TKi";
	    LOGGER.info("Using default username for sandbox. Use environment or property 'BILLOGRAM_USERNAME' to set a better one.");
	}
	String password = getPropEnv("BILLOGRAM_PASSWORD");
	if (password == null) {
	    password = "1bf259158941ce399090ca9b5d0c224c";
	    LOGGER.info("Using default username for sandbox. Use environment or property 'BILLOGRAM_PASSWORD' to set a better one.");
	}
	return createClient(username, password);
    }

    public String getPropEnv(String key) {
	String value = System.getProperties().getProperty(key);
	if (value == null) {
	    value = System.getenv(key);
	}
	return value;
    }
}
