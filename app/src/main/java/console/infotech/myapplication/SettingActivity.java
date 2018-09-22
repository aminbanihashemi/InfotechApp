package console.infotech.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import console.infotech.myapplication.customView.MyButtonView;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
    MyButtonView btnBack;
    MyButtonView ibOne,ibTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Intent intent = getIntent();
        bind();
        btnBack.setOnClickListener(this);
        ibOne.setOnClickListener(this);
        ibTwo.setOnClickListener(this);
    }

    private void bind() {
        btnBack = findViewById(R.id.btnBack);
        ibOne = findViewById(R.id.ibOne);
        ibTwo = findViewById(R.id.ibTwo);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnBack){
            onBackPressed();
        }else if(v.getId()==R.id.ibOne){
            ibOneMethod();
        }else if(v.getId()==R.id.ibTwo){
            ibTwoMethod();
        }
    }

    private void ibTwoMethod() {
        Intent intent = new Intent(this,TerminalSettingActivity.class);
        startActivity(intent);
    }

    private void ibOneMethod() {
        Intent intent = new Intent(this,ChangePasswordActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,EntryActivity.class);
        startActivity(intent);
        finish();
    }
}
