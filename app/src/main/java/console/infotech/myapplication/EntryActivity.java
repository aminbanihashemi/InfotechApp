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

import console.infotech.myapplication.customView.MyEditTextView;

public class EntryActivity extends AppCompatActivity implements View.OnClickListener {
     TextView tvEntry;

    MyEditTextView etEntryPass;
    Handler handler;
    Runnable mRunnable;
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

        mRunnable = new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(EntryActivity.this,MainActivity.class);
                intent.putExtra("message", "12345");
                startActivity(intent);
                finish();
            }
        };
//        Thread t = new Thread(){
//            @Override
//            public void run(){
//                try{
//                    while (!isInterrupted()){
//                        Thread.sleep(1000);
//                        if (tvEntry.getVisibility() == View.VISIBLE)
//                            tvEntry.setVisibility(View.INVISIBLE);
//                        runOnUiThread(new Runnable() {
//
//                            @Override
//                            public void run() {
//                                if (tvEntry.getVisibility() == View.INVISIBLE)
//                                    tvEntry.setVisibility(View.VISIBLE);
//                            }
//                        });
//                    }
//                }catch (InterruptedException e){
//
//                }
//            }
//        };
//        t.start();

        handler = new Handler();
        handler.postDelayed(mRunnable,5500);

    }

    private void bind() {


        btnSetting=findViewById(R.id.btnSetting);
        btnTurnOff=findViewById(R.id.btnTurnOff);

        tvEntry= findViewById(R.id.tvEntry);

        etEntryPass = findViewById(R.id.etEntryPass);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnTurnOff){
            finishAffinity();
            handler.removeCallbacks(mRunnable);
        }else if(v.getId()==R.id.btnSetting){
            Intent intent = new Intent(this,EnterPasswordActivity.class);
            startActivity(intent);
            handler.removeCallbacks(mRunnable);
            finish();

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
