package com.example.logindemo;

import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int Count=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Info=(TextView)findViewById(R.id.tvInfo);
        Login=(Button)findViewById(R.id.buttonLogin);

        Info.setText("No Of Attempts remaining: 5");
        Login.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }


        });
    }
    private void validate(String username,String userPassword)
    {
        if((username.equals("SharmaManish")) && (userPassword.equals("12345")))
        {
            Intent intent=new Intent(this,SecondActivity.class);
            startActivity(intent);
            Count=5;
        }
        else
        {
            Count--;
            Info.setText("No Attempts Left:"+String.valueOf(Count));
            if(Count==0)
            {
              Login.setEnabled(false);
            }
        }
    }
}
