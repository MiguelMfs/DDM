package com.ifsc.imc;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.ifsc.imc.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button.setOnClickListener(v -> {
            
        })

        Log.d("ciclodevida", "onResume");
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ciclodevida", "onStart");
        Toast.makeText(this,"onStart",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("ciclodevida", "onResume");
        Toast.makeText(this,"onResume",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("ciclodevida", "onPause");
        Toast.makeText(this,"onPause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("ciclodevida", "onStop");
        Toast.makeText(this,"onStop",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("ciclodevida", "onRestart");
        Toast.makeText(this,"onRestart",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ciclodevida", "onDestroy");
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show();
    }

}