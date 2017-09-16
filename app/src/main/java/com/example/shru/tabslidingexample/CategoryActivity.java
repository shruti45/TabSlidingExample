package com.example.shru.tabslidingexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by user on 3/29/2016.
 */
public class CategoryActivity extends Activity implements View.OnClickListener{

    Button button;
    String value1,value2;
    EditText buttons,viewpagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);

       // Intent intent = new Intent(this, Tab1.class);
      //  Bundle bundle = new Bundle();
        buttons = (EditText)findViewById(R.id.etbtn);
        viewpagers=(EditText)findViewById(R.id.etpager);

        button=(Button)findViewById(R.id.buttonsubmit);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                value1 = buttons.getText().toString();
                value2 = viewpagers.getText().toString();

                if(value1.equals("") || value2.equals("")) {

                    Toast.makeText(getApplicationContext(),
                            "enter both values",
                            Toast.LENGTH_LONG).show();

                }
                else
                {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), MainActivity.class);


                    System.out.println(value1);
                    System.out.println(value2);
                    i.putExtra("value_1", Integer.parseInt(value1));
                    i.putExtra("value_2",Integer.parseInt(value2));
                    startActivity(i);
                }

            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}

