package com.deepak.pythontest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {
    EditText input,output;
    Button Calculate,Instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input=(EditText) findViewById(R.id.etInput);
        output=(EditText) findViewById(R.id.etOutput);
        Calculate=(Button) findViewById(R.id.btnCalculate);
        Instructions=(Button)findViewById(R.id.btnInstructions);

        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Python py = Python.getInstance();

                PyObject pyobj=py.getModule("myscript");

                // Input String from EditText
                String st = input.getText().toString().trim();

                PyObject obj = pyobj.callAttr("main",st);

                output.setText(obj.toString());

            }
        });

        Instructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Instruction.class);
                startActivity(intent);

            }
        });




    }
}