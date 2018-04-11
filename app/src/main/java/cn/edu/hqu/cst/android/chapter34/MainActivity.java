package cn.edu.hqu.cst.android.chapter34;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import cn.edu.hqu.cst.android.chapter34.entity.Person;

public class MainActivity extends Activity {
    private Button finishbtn;
    private Button selectbtn;
    EditText name;
    EditText password;
    RadioButton male;
    String gender;
    EditText city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        finishbtn=findViewById(R.id.bn);
        selectbtn=findViewById(R.id.selectCityBtn);
        name=findViewById(R.id.name);
        password=findViewById(R.id.passwd);
        male=findViewById(R.id.male);
        gender=male.isChecked()?"男":"女";
        city=findViewById(R.id.selectedcity);
        finishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Person p=new Person(name.getText().toString(),password.getText().toString(),gender,city.getText().toString());
                Bundle data=new Bundle();
                data.putSerializable("person",p);
                Intent intent=new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtras(data);
                startActivity(intent);


            }
        });
        selectbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SelectCityActivity.class);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if(requestCode==0 && resultCode==0){
            Bundle data=intent.getExtras();
            String resultCity=data.getString("city");
            city.setText(resultCity);

        }
    }

}
