package console.infotech.myapplication;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import console.infotech.myapplication.customView.MyButtonView;
import es.dmoral.toasty.Toasty;

public class EnterPasswordActivity extends AppCompatActivity implements View.OnClickListener {
    MyButtonView btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero;
    MyButtonView btnConfirm, btnDelete;
    MyButtonView btnBack;
    private TextInputEditText etEntryPass;
    private String userPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_enter_password);
        Intent intent = getIntent();

        bind();
        etEntryPass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int inType = etEntryPass.getInputType(); // backup the input type
                etEntryPass.setInputType(InputType.TYPE_NULL); // disable soft input
                etEntryPass.onTouchEvent(event); // call native handler
                etEntryPass.setInputType(inType); // restore input type
                return true; // consume touch even
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);
        btnDelete.setOnClickListener(this);


    }

    private void bind() {

        btnBack = findViewById(R.id.btnBack);
        etEntryPass = findViewById(R.id.etEntryPass);
        userPassword ="246810";
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnZero = findViewById(R.id.btnZero);
        btnConfirm = findViewById(R.id.btnConfirm);
        btnDelete = findViewById(R.id.btnDelete);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnOne){
            etEntryPass.append("1");
        }else if (v.getId()==R.id.btnTwo){
            etEntryPass.append("2");
        }else if (v.getId()==R.id.btnThree){
            etEntryPass.append("3");
        }else if (v.getId()==R.id.btnFour){
            etEntryPass.append("4");
        }else if (v.getId()==R.id.btnFive){
            etEntryPass.append("5");
        }else if (v.getId()==R.id.btnSix){
            etEntryPass.append("6");
        }else if (v.getId()==R.id.btnSeven){
            etEntryPass.append("7");
        }else if (v.getId()==R.id.btnEight){
            etEntryPass.append("8");
        }else if (v.getId()==R.id.btnNine){
            etEntryPass.append("9");
        }else if (v.getId()==R.id.btnZero){
            etEntryPass.append("0");
        }else if (v.getId()==R.id.btnConfirm){
            confirmMethod(etEntryPass.getText().toString());
        }else if (v.getId()==R.id.btnDelete){
            deleteMethod(etEntryPass.getText().toString());
        }
    }

    private Boolean validatePassword(){
        String password = etEntryPass.getText().toString();
        if(!userPassword.equals(password)){
            etEntryPass.setError("Password is Wrong!\nPlease enter correct Password");
            return false;
        }else {
            etEntryPass.setError(null);
            return true;
        }
    }

    private void deleteMethod(String value) {
        if(value.length()!=0) {
            value = value.substring(0, value.length() - 1);
            etEntryPass.setText(value);
        }
    }

    private void confirmMethod(String value) {

        if (value.isEmpty()){
            etEntryPass.setError("Please Fill The field");
        }else if(!validatePassword()){
            return;
        }else {
            Toasty.success(this, "Success!", Toast.LENGTH_SHORT, true).show();
            Intent intent=new Intent(EnterPasswordActivity.this,SettingActivity.class);
            startActivity(intent);
            finish();
        }


    }
}
