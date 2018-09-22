package console.infotech.myapplication;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import console.infotech.myapplication.customView.MyButtonView;
import console.infotech.myapplication.customView.MyEditTextView;
import es.dmoral.toasty.Toasty;

public class TerminalSettingActivity extends AppCompatActivity implements View.OnClickListener {
    MyButtonView btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero,btnDot;
    MyButtonView btnConfirm, btnDelete;
    MyButtonView btnBack;
    MyEditTextView etEntryPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminal_setting);
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

        NiceSpinner niceSpinner = findViewById(R.id.nice_spinner);
        List<String> dataset = new LinkedList<>(Arrays.asList("Choose one of the following:","Terminal1 IP", "Terminal1 ID", "Terminal1 Port", "Terminal1 SN", "Device ID","Terminal2 IP", "Terminal2 ID", "Terminal2 Port", "Terminal2 SN"));
        niceSpinner.attachDataSource(dataset);

        btnBack.setOnClickListener(this);

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
        btnDot.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }
    private void bind() {
        btnBack  = findViewById(R.id.btnBack);
        etEntryPass = findViewById(R.id.etEntryPass);
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
        btnDot = findViewById(R.id.btnDot);
        btnConfirm = findViewById(R.id.btnConfirm);
        btnDelete = findViewById(R.id.btnDelete);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,SettingActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnBack){
            onBackPressed();
        }else if(v.getId()==R.id.btnOne){
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
        } else if (v.getId()==R.id.btnDot){
            etEntryPass.append(".");
        }else if (v.getId()==R.id.btnConfirm){
            confirmMethod(etEntryPass.getText().toString());
        }else if (v.getId()==R.id.btnDelete){
            deleteMethod(etEntryPass.getText().toString());
        }
    }
    private void deleteMethod(String value) {
        if(value.length()!=0) {
            value = value.substring(0, value.length() - 1);
            etEntryPass.setText(value);
        }
    }
    private void confirmMethod(String s) {



    }
}
