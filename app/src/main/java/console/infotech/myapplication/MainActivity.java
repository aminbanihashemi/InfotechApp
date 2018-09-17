package console.infotech.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import console.infotech.myapplication.Utility.Utilities;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView animationView;
    TextView dateAndTime;
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
        bind();

        Date currentTime = Calendar.getInstance().getTime();
//        dateAndTime.setText(currentTime.toString());
        dateAndTime.setText(Utilities.getCurrentShamsidate());

        animationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,SettingActivity.class);
                startActivity(intent);
            }
        });

    }

    private void bind() {

        dateAndTime = findViewById(R.id.dateAndTime);
        animationView = findViewById(R.id.animation_setting);
        animationView.playAnimation();

    }
}
