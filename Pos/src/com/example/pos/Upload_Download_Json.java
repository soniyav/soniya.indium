package com.example.pos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

public class Upload_Download_Json {

	private HttpResponse httpresponse;
	private StringEntity se;
	private HttpPost httppostreq;
	private DefaultHttpClient httpclient;
	private BufferedReader reader;
	private String stringresponse;
	public Upload_Download_Json(Context context) {
	}

	
	public String sendJsonPost(String jsonstring, String postpath) {

		try {
			httpclient = new DefaultHttpClient();
			httppostreq = new HttpPost(postpath);
			se = new StringEntity(jsonstring);
			se.setContentType("application/json;charset=UTF-8");
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
					"application/json;charset=UTF-8"));
			httppostreq.setEntity(se);
			httpresponse = httpclient.execute(httppostreq);

			reader = new BufferedReader(new InputStreamReader(httpresponse
					.getEntity().getContent(), "UTF-8"));
			stringresponse = reader.readLine();
			return stringresponse;

		} catch (IOException e) {
			Log.d("Exception", e.toString());
			return "IO_EXCEPTION";
		}

	}
	public String getJsonObject(String SourceID) 
	{
		JSONObject obj = new JSONObject();
		try {
		obj.put("SourceID",SourceID);
		
		} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

		return obj.toString();

	}
}
