package com.freeapkstudios.qes;

import android.content.Intent;
import android.net.Uri;
//import android.support.v7.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;


import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    DecimalFormat number = new DecimalFormat("#.00");//for converting number to two decimals
    EditText et_a,et_b,et_c;
    Button b_go;

    TextView tv_result;

    double a,b,c,d,x1,x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        et_a = (EditText) findViewById(R.id.et_a);
        et_b = (EditText) findViewById(R.id.et_b);
        et_c = (EditText) findViewById(R.id.et_c);

        b_go = (Button) findViewById(R.id.b_go);
        tv_result = (TextView) findViewById(R.id.tv_result);


        b_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_a.getText().toString().equals("")  && !et_b.getText().toString().equals("")
                        && !et_c.getText().toString().equals("")){
                    a =Double.parseDouble(et_a.getText().toString());
                    b =Double.parseDouble(et_b.getText().toString());
                    c =Double.parseDouble(et_c.getText().toString());

                    d =Math.pow(b, 2) - 4*a*c;

                    if(d==0) {
                        x1 = -b/(2 * a);
                        tv_result.setText(" Discriminant = " + d +"\n Nature : Same Roots\n Both Root = " + x1);
                    }  else if(d<0) {
                        x1 = -b / (2 * a);
                        x2= Math.sqrt(-d) / (2 * a);
                        x2 = Double.parseDouble(number.format(x2));     //convert number to two decimal points
                        tv_result.setText(" Discriminant = " + d + "\n Nature : Complex Roots\n First Root = " + x1 + " + i"  + x2 +" \n Second Root = " + x1 +" - i" + x2);



                    }  else if(d>0) {
                        x1 = (-b + Math.sqrt(d))/(2*a);
                        x2 = (-b - Math.sqrt(d))/(2*a);
                        tv_result.setText(" Discriminant = " + d + "\n Nature : Real Roots \n First Root = " + x1 + "\n Second Root = " + x2);



                    }
                }
            }
        });

    } // Till here Quadratic Equation logic are written.

    // This code use to show the menu button on screen only.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // This code is make an action on clicking on item and Use To START Contact_Developer....
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.about ) {

            Intent intentPolicy =  new Intent(MainActivity.this, Contact_Developer.class);
            startActivity(intentPolicy);

            //Toast.makeText(this,"You have selected Privacy Policy Option",Toast.LENGTH_SHORT).show();
        }
        else  {
            return super.onOptionsItemSelected(item);
        }

        return true;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Code to action made on click privacy policy item


    // This method call privacy policy link in other browser when user click on Privacy Policy item.
    public void browsePrivacy(MenuItem item) {

        String url = "https://freeapkstudios.blogspot.com/2019/08/privacy-policy-effective-date-august-09.html";
        Intent link = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(link);
    }
}

