package e.anidiot.fab_challenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button connect=(Button) findViewById(R.id.connect);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ipaddress =(EditText)findViewById(R.id.ip);
                EditText portnumber =(EditText)findViewById(R.id.port);
                String str = ipaddress.getText().toString();
                String a=portnumber.getText().toString();
                if (a.matches("")) {
                    Toast.makeText(getApplication(),"PORT number is empty",Toast.LENGTH_SHORT).show();
                    return;
                }
                else { Intent intent = new Intent(getApplicationContext(), ControlActivity.class);
                    intent.putExtra("SERVERPORT",a);
                    intent.putExtra("SERVER_IP",str);
                    startActivity(intent);}
            }
        });

    }
}