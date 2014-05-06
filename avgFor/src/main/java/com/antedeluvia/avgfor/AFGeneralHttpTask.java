package com.antedeluvia.avgfor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class AFGeneralHttpTask {

	public static InputStream getInputStream(String url){
		try {
            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
 
            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
 
            // receive response as inputStream
            InputStream inputStream = httpResponse.getEntity().getContent();
 
            // convert input stream to string
            if(inputStream != null){
                System.err.println("inputstream works");
                return inputStream;
            }
            else{
                System.err.println("inputstream does not work");
                return null;
            }
 
        } catch (Exception e) {
            System.err.println("doInBackground not work");
            Log.e("MYAPP","exception",e);
            return null;
        }
	}
	
	public static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        char[] buffer = new char[500];
        int num = 0;
        StringBuffer result = new StringBuffer();
        while( (num = bufferedReader.read(buffer, 0, buffer.length)) > 0 ){
            result.append(buffer, 0, num);
        } 
        inputStream.close();
        return result.toString();
 
    }
}
