package com.example.bmireport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class Report extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("Ciclo", getLocalClassName() +  ": Activity iniciada!");
		setContentView(R.layout.activity_report);
	}

	protected void onStart() {
		super.onStart();
		Log.d("Ciclo", getLocalClassName() +  ": Activity iniciada!");
	}

	protected void onRestart() {
		super.onRestart();
		Log.d("Ciclo", getLocalClassName() +  ": Activity reiniciada!");
	}

	protected void onResume() {
		super.onResume();
		Log.d("Ciclo", getLocalClassName() +  ": Activity retomada!");
	}

	protected void onPause() {
		super.onPause();
		Log.d("Ciclo", getLocalClassName() +  ": Activity pausada!");
	}

	protected void onStop() {
		super.onStop();
		Log.d("Ciclo", getLocalClassName() +  ": Activity interrompida!");
	}

	protected void onDestroy() {
		super.onDestroy();
		Log.d("Ciclo", getLocalClassName() +  ": Activity destruída!");
	}
}