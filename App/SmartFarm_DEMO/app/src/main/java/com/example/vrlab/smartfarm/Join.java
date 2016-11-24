package com.example.vrlab.smartfarm;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// http://222.104.31.75
// http://155.230.86.192/smartfarm/join.php
// http://155.230.86.192/smartfarm/validCheck.php
public class Join extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextCheckPassword;

    String email;
    String password;
    String checkpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        editTextEmail = (EditText) findViewById(R.id.Join_editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.Join_editTextPassword);
        editTextCheckPassword = (EditText) findViewById(R.id.Join_editTextCheckPassword);
        Button Join = (Button)findViewById(R.id.Join);
    }

    public void invokeJoin(View view){
        email = editTextEmail.getText().toString();
        password = editTextPassword.getText().toString();
        checkpassword = editTextCheckPassword.getText().toString();

        String EmailType = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(EmailType, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        // email 타입 체크
        if (matcher.matches())
        {
            // password 길이 체크
            if(password.length()<6 || password.length()>16)
                Toast.makeText(getApplicationContext(),"올바른 Password를 입력하세요.\n6~16자의 문자를 사용하세요.", Toast.LENGTH_LONG).show();
            else
            {
                // password 일치 체크
                if(password.equals(checkpassword))
                {
                    join(email, password);
                }
                else
                    Toast.makeText(getApplicationContext(), "Password를 확인하세요.", Toast.LENGTH_LONG).show();
            }
        }
        else
            Toast.makeText(getApplicationContext(),"올바른 E-mail 주소를 입력하세요.", Toast.LENGTH_LONG).show();
    }

    // DB에 추가
    private void join(final String email, String password) {

        class JoinAsync extends AsyncTask<String, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            @Override
            protected String doInBackground(String... params) {
                String email = params[0];
                String pass = params[1];

                InputStream is = null;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("email", email));
                nameValuePairs.add(new BasicNameValuePair("password", pass));
                String result = null;

                try{
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://155.230.86.83/smartfarm/join.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();

                    is = entity.getContent();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result){
                String s = result.trim();
                if(s.equalsIgnoreCase("success")){
                    Toast.makeText(getApplicationContext(), "축하합니다! 가입되었습니다.", Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(), "이미 존재하는 사용자입니다.", Toast.LENGTH_LONG).show();
                }
            }
        }
        JoinAsync la = new JoinAsync();
        la.execute(email, password);
    }
}
