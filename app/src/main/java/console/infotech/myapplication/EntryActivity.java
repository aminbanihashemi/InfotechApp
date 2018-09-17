package console.infotech.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class EntryActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvEntry;
    Handler handler;
    Button btnTurnOff,btnSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_entry);
        bind();
        btnSetting.setOnClickListener(this);
        btnTurnOff.setOnClickListener(this);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(EntryActivity.this,MainActivity.class);
                intent.putExtra("message", "12345");
                startActivity(intent);
                finish();
            }
        },5500);

    }

    private void bind() {
        tvEntry= findViewById(R.id.tvEntry);
        btnSetting=findViewById(R.id.btnSetting);
        btnTurnOff=findViewById(R.id.btnTurnOff);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnTurnOff){
            finish();
        }else if(v.getId()==R.id.btnSetting){
            Intent intent = new Intent(this,SettingActivity.class);
            startActivity(intent);

        }

    }
}
