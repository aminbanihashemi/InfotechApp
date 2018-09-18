package console.infotech.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import console.infotech.myapplication.Utility.Utilities;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView animationView;
    TextView currentDate,currentTime;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        mContext=this;
        Intent intent = getIntent();

        Thread t = new Thread(){
            @Override
            public void run(){
                try{
                    while (!isInterrupted()){
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                currentTime = findViewById(R.id.currentTime);
                                long date = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss");
                                String dateString = sdf.format(date);
                                currentTime.setText(dateString);
                            }
                        });
                    }
                }catch (InterruptedException e){

                }
            }
        };
        t.start();
        bind();

        Date currentTimeValue = Calendar.getInstance().getTime();
//        currentTime.setText(currentTimeValue.toString());
        currentDate.setText(Utilities.getCurrentShamsidate());

        animationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,EnterPasswordActivity.class);
                startActivity(intent);
            }
        });

    }

    private void bind() {

        currentDate = findViewById(R.id.currentDate);
        animationView = findViewById(R.id.animation_setting);
        animationView.playAnimation();

    }
}
