package com.ccet.student;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	SharedPreferences sharedPreferences ;

    @SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.register);
       
        // Server data insertion
        
        /*if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            
            try{
            	
		        HttpClient client = new DefaultHttpClient();
		        HttpPost request = new HttpPost();
		         request.setURI(new URI("http://hbdsupu.ml/App/insertData.php"));
		         List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		         nameValuePairs.add(new BasicNameValuePair("l_name", "Ghanshyam"));
		         nameValuePairs.add(new BasicNameValuePair("f_name", "Upadhyay"));
		         nameValuePairs.add(new BasicNameValuePair("age", "19"));
		         request.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		         TextView tv= (TextView)findViewById(R.id.reg_textView8);
		         tv.setText(request.getURI()+"\n");
		         HttpResponse response = client.execute(request);
		         BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		           StringBuffer sb = new StringBuffer("");
		           String line="";
		          
		          while ((line = in.readLine()) != null) {
		             sb.append(line);
		             break;
		           }
		           in.close();
		           Toast.makeText(getApplicationContext(), sb.toString(),Toast.LENGTH_LONG).show();
		        }
		        catch(Exception e)
		        {
		        	Toast.makeText(getApplicationContext(), e.toString(),Toast.LENGTH_LONG).show();
		        }
        }     */
        
        //SQLite Database insertion & retrival .....
        
        /*try{
        SQLiteDatabase sq = openOrCreateDatabase("data.db", SQLiteDatabase.CREATE_IF_NECESSARY,null );
        sq.setVersion(1);
        sq.setLockingEnabled(true);
        //Toast.makeText(getApplicationContext(), "db created...",Toast.LENGTH_LONG).show();
        //sq.execSQL("create table info(f_name text ,l_name text ); ");
        sq.execSQL("insert into info values (\"Bhavya\",\"Doshiiii\");");
        Cursor c = sq.rawQuery("select * from info ;",null);
        while(c.moveToNext())
        {
        	Toast.makeText(getApplicationContext(), c.getString(0)+" "+c.getString(1),Toast.LENGTH_SHORT).show();
        }
         
        sq.setLocale(Locale.getDefault());
        c.close();
        sq.close();
        }
        catch(Exception e)
        {
        	Toast.makeText(getApplicationContext(), e.toString(),Toast.LENGTH_LONG).show();
        }*/
        
        //  sharedPrefrences
        
        sharedPreferences = getSharedPreferences("LocalData", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed;
        if(!sharedPreferences.contains("initialized")){
        		
        		Intent mytt = new Intent(MainActivity.this,login.class);  
        		startActivity(mytt);
        	}
        else
        {
        	Toast.makeText(MainActivity.this,"already exist ...",Toast.LENGTH_LONG).show();
        	Intent mytt = new Intent(MainActivity.this,main_page.class);  
    		startActivity(mytt);
        }
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
