package cn.edu.hqu.cst.android.chapter34;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import cn.edu.hqu.cst.android.chapter34.entity.Person;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView name=findViewById(R.id.txt_showname);
        TextView password=findViewById(R.id.txt_showpasswd);
        TextView gender=findViewById(R.id.txt_showgender);
        TextView city=findViewById(R.id.txt_showcity);
        Intent intent=getIntent();
        Person p=(Person)intent.getSerializableExtra("person");
        name.setText("您的用户名为："+p.getName());
        password.setText("您的密码为："+p.getPassword());
        gender.setText("您的性别为："+p.getGender());
        city.setText("您所在城市为："+p.getCity());

    }
}
