package com.ccet.student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.*;
import org.apache.http.message.BasicNameValuePair;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class login extends Activity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        
        Button login = (Button)findViewById(R.id.main_login);
        login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		        StrictMode.setThreadPolicy(policy);
		        
		        try{
		        	EditText uname = (EditText)findViewById(R.id.main_user);
		            EditText pwd = (EditText)findViewById(R.id.main_password);
		            
		            InputMethodManager inputManager = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE); 

inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                               InputMethodManager.HIDE_NOT_ALWAYS);
		        	
			        HttpClient client = new DefaultHttpClient();
			        HttpPost request = new HttpPost();
			         request.setURI(new URI("http://hbdsupu.ml/App/Login.php"));
			         List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			         nameValuePairs.add(new BasicNameValuePair("email", uname.getText().toString()));
			         nameValuePairs.add(new BasicNameValuePair("pwd", pwd.getText().toString()));
			         request.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			         
			         HttpResponse response = client.execute(request);
			         BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			         
			           StringBuffer sb = new StringBuffer("");
			           String line="";
			           
				          while ((line = in.readLine()) != null) {
				             sb.append(line);
				             break;
				           }
			          if(sb.toString().contains("Ami"))
			          {
			        	  Toast.makeText(getApplicationContext(), "Login Sucessfull !!!",Toast.LENGTH_LONG).show();  
			          }
			          else
			          {
			        	  Toast.makeText(getApplicationContext(), sb.toString()+"error",Toast.LENGTH_LONG).show();
			          }
			          
			          /*while ((line = in.readLine()) != null) {
			             sb.append(line);
			             break;
			           }*/
			           in.close();
			           
			        }
			        catch(Exception e)
			        {
			        	Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_LONG).show();
			        }

			}
		});
                
	}
	@Override
	public void onBackPressed() {
		Toast.makeText(getApplicationContext(), "Back Pressed !!!",Toast.LENGTH_LONG).show();
		super.onBackPressed();
	}
	
}
