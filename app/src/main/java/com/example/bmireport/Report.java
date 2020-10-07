package com.example.bmireport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Report extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("Ciclo", getLocalClassName() +  ": Activity iniciada!");

		final Intent it = getIntent();
		final Bundle extras = it.getExtras();

		setContentView(R.layout.activity_report);

		final TextView name = (TextView) findViewById(R.id.getName);
		final TextView age = (TextView) findViewById(R.id.getAge);
		final TextView weight = (TextView) findViewById(R.id.getWeight);
		final TextView height = (TextView) findViewById(R.id.getHeight);
		final TextView bmi = (TextView) findViewById(R.id.getIndex);
		final TextView classif = (TextView) findViewById(R.id.getClassification);

		name.setText(extras.getString("name"));
		age.setText(Integer.toString(extras.getInt("age")));
		weight.setText(Float.toString(extras.getFloat("weight")));
		height.setText(Float.toString(extras.getFloat("height")));
		bmi.setText(Float.toString(extras.getFloat("bmi")));
		classif.setText(extras.getString("classif"));
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