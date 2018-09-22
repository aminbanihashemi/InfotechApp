package console.infotech.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import console.infotech.myapplication.customView.MyButtonView;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener{
    MyButtonView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        bind();
        btnBack.setOnClickListener(this);
    }

    private void bind() {
        btnBack = findViewById(R.id.btnBack);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnBack){
            onBackPressed();
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,SettingActivity.class);
        startActivity(intent);
        finish();
    }
}
