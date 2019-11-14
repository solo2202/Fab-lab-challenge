package e.anidiot.fab_challenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ControlActivity extends AppCompatActivity implements View.OnClickListener{
    Wifi wifi;

    int SERVERPORT_MAIN = 0;
    String SERVER_MAIN = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


            setContentView(R.layout.activity_control);


            Intent intent = getIntent();
            SERVERPORT_MAIN = Integer.valueOf(intent.getStringExtra("SERVERPORT"));
            SERVER_MAIN = intent.getStringExtra("SERVER_IP");

            wifi = new Wifi(getBaseContext());
            new Thread(wifi.new CT(SERVER_MAIN, SERVERPORT_MAIN)).start();

            findViewById(R.id.f).setOnClickListener(this);
        findViewById(R.id.l).setOnClickListener(this);
        findViewById(R.id.r).setOnClickListener(this);
        findViewById(R.id.u).setOnClickListener(this);
        findViewById(R.id.d).setOnClickListener(this);
        findViewById(R.id.s).setOnClickListener(this);
        findViewById(R.id.b).setOnClickListener(this);



        }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.f: wifi.send("f");break;
            case R.id.l: wifi.send("l");break;
            case R.id.r: wifi.send("r");break;
            case R.id.b: wifi.send("b");break;
            case R.id.u: wifi.send("u");break;
            case R.id.d: wifi.send("d");break;
            case R.id.s: wifi.send("s");break;

        }
    }
}



