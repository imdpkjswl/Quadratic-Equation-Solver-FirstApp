package com.freeapkstudios.qes;



import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Contact_Developer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Below one is use to hide the Title bar.AND also replaced AppCompatActivity --> Activity
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_contact__developer);

        // This code used to hide status bar or notification bar of Contact_Developer Activity.

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
