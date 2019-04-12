package com.daggerandroid.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.daggerandroid.sample.entity.Student;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity{

    @Inject
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TAG", "student: " + student.toString());
    }
}
