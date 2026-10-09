package com.example.firstform;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText userName;
        userName=findViewById(R.id.username);
        EditText fullname=findViewById(R.id.fullName);
        EditText country=findViewById(R.id.country);
        EditText email=findViewById(R.id.email);
        EditText phone=findViewById(R.id.phone);
        RadioGroup gender=findViewById(R.id.gender);
        EditText password=findViewById(R.id.pwd);
        CheckBox terms=findViewById(R.id.termsAndConditions);

        Button button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RadioButton spol = findViewById(gender.getCheckedRadioButtonId());
                String agree="No";
                if(terms.isChecked())
                    agree="Yes";
                String msg = "Username: "+userName.getText().toString()+
                        "\nName: "+fullname.getText().toString()+
                        "\nCountry: "+country.getText().toString()+
                        "\nEmail: "+email.getText().toString()+
                        "\nPhone: "+phone.getText().toString()+
                        "\nPassword: "+password.getText().toString()+
                        "\nGender: "+spol.getText().toString()+
                        "\nTerms Accepted: "+agree;

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Registration details");
                builder.setMessage(msg);
                builder.show();
            }
        });

    }
}