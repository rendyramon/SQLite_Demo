package com.example.sonet.sqlitedemov_1;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sonet.sqlitedemov_1.DataBase.DataBaseAdapter;

public class MainActivity extends AppCompatActivity {

    DataBaseAdapter dataBaseAdapter;
    SQLiteDatabase sqLiteDatabase;

    EditText studentName;
    EditText studentPassword;
    Button clickBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* studentName = (EditText) findViewById(R.id.studentName);
        studentPassword = (EditText) findViewById(R.id.studentPassword);
        clickBtn = (Button) findViewById(R.id.clickBtn);*/
        dataBaseAdapter = new DataBaseAdapter(this);
    }

  /*  public void click(View view) {

        String name = studentName.getText().toString();
        String password = studentPassword.getText().toString();

        long id = dataBaseAdapter.queryInsert(name,password);

        if(id<0)
        {
            Massage.getMassage(this,"All is wrong");
        }
        else
        {
            Massage.getMassage(this,"Inserted Successfully");
        }
  }
*/
  /*  public void getAllData(View view) {

    }*/

}
