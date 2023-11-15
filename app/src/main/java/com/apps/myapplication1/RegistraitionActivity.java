package com.apps.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.room.Room;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistraitionActivity extends AppCompatActivity {
 Button Reg ;
 EditText username;
 EditText userpassword;
 EditText useremail;
 EditText userphone;
    String usernametxt;
    String userpasswordtxt;
   String useremailtxt;
 String userphonetxt;
private userdao usrdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registraition);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Reg=findViewById(R.id.rgstr_btn);
     useremail=findViewById(R.id.usrmail);
        username=findViewById(R.id.usrnm);
        userphone=findViewById(R.id.usrphn);
        userpassword=findViewById(R.id.usrpss);
        LinearLayoutCompat regest = findViewById(R.id.r_layiout);
//        UserDatabase userDatabase = UserDatabase.getInstance(this);
        AnimationDrawable Animation = (AnimationDrawable) regest.getBackground();
        Animation.setEnterFadeDuration(2500);
        Animation.setExitFadeDuration(5000);
        Animation.start();

    usrdao=UserDatabase.getInstance(this).userdao();

        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernametxt=username.getText().toString();
                userpasswordtxt=userpassword.getText().toString();
                useremailtxt=useremail.getText().toString();
                userphonetxt=userphone.getText().toString();

                if (usernametxt.isEmpty()||userpasswordtxt.isEmpty()||useremailtxt.isEmpty()||userphonetxt.isEmpty()) {
                    Toast.makeText(RegistraitionActivity.this, "Please Fill The " +
                            "Form First ", Toast.LENGTH_LONG).show();
                            }
                else {
                    user usr = new user(usernametxt,userpasswordtxt);
                    usrdao.insertuser(usr);
                    Toast.makeText(RegistraitionActivity.this, "Registration Successful !", Toast.LENGTH_SHORT).show();
                    onBackPressed();

                }



        };
    });
}
}