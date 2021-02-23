package com.mockaroo.domain;



import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.mockaroo.dto.RespuestaDto;
import com.mockaroo.exeptions.FailCommunicationException;

@Service
public class WsClientMockaroo {

	@Value("${ws.url}")
	private String url;


	public RespuestaDto obtenerTypes(String key) throws FailCommunicationException {

		ResponseEntity<String> response = null;
		RestTemplate template = new RestTemplate();
		RespuestaDto responseDto = new RespuestaDto();
		String urlCompleta = null;
		Gson gson = new Gson();
		urlCompleta = url.concat(key);

		try {
			disableSslVerification();
			response = template.exchange(urlCompleta, HttpMethod.GET, null, String.class);
			responseDto = gson.fromJson(response.getBody(), RespuestaDto.class);

		} catch (Exception e) {
			e.printStackTrace();
			throw new FailCommunicationException("Problemas de comunicación del servicio de types");

		}

		return responseDto;

	}
	private static void disableSslVerification() {

		try {
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

				@Override
				public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
					// TODO Auto-generated method stub

				}

				@Override
				public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
					// TODO Auto-generated method stub

				}

				@Override
				public X509Certificate[] getAcceptedIssuers() {
					// TODO Auto-generated method stub
					return null;
				}

			} };
			// Install the all-trusting trust manager
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			// Create all-trusting host name verifier
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				@Override
				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}
			};

			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		} catch (NoSuchAlgorithmException e) {
			// log.error(null, e.getMessage(), e);
		} catch (KeyManagementException e) {
			// log.error(null, e.getMessage(), e);
		}
	}


}
