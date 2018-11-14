package fr.wildcodeschool.quetesimpleui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        final EditText firstName = (EditText) findViewById(R.id.editText);
        final EditText lastName = (EditText) findViewById(R.id.editText2);
        final Button buttonAccept = (Button) findViewById(R.id.button);
        final TextView congratulations = (TextView) findViewById(R.id.textView2);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    firstName.setEnabled(true);
                    lastName.setEnabled(true);
                }else{
                    firstName.setEnabled(false);
                    lastName.setEnabled(false);
                }
            }
        });

        buttonAccept.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence toastString = getResources().getString(R.string.name_not_filled);
                int duration = Toast.LENGTH_SHORT;
                String firstNameString = firstName.getText().toString();
                String lastNameString = lastName.getText().toString();
                String congrats = getResources().getString(R.string.congrats);
                StringBuilder sb = new StringBuilder();
                ;

                if(firstNameString.matches("") || lastNameString.matches("")){
                    Toast buttonToast = Toast.makeText(context, toastString, duration);
                    buttonToast.setGravity(Gravity.BOTTOM, 0, 100);
                    buttonToast.show();
                }else{
                    congratulations.setText(sb.append(congrats).append(" ")
                            .append(firstNameString).append(" ")
                            .append(lastNameString).toString());

                    congratulations.setVisibility(View.VISIBLE);
                }



            }
        });



    }
}
