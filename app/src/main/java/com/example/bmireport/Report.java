package com.example.bmireport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Report extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("Ciclo", getLocalClassName() +  ": Activity iniciada!");

		try {
			final Intent it = getIntent();
			final Bundle extras = it.getExtras();

			setContentView(R.layout.activity_report);

			final TextView name = (TextView) findViewById(R.id.getName);
			final TextView age = (TextView) findViewById(R.id.getAge);
			final TextView weight = (TextView) findViewById(R.id.getWeight);
			final TextView height = (TextView) findViewById(R.id.getHeight);
			final TextView bmi = (TextView) findViewById(R.id.getIndex);
			final TextView classif = (TextView) findViewById(R.id.getClassification);

			try {
				final float index = extras.getFloat("weight") / (extras.getFloat("height") * extras.getFloat("height"));
				final String classification =
						(index < 18.5) ?
								getString(R.string.underWeight)
								: (index < 25) ?
								getString(R.string.healthy)
								: (index < 30) ?
								getString(R.string.overWeight)
								: (index < 35) ?
								getString(R.string.g1obesity)
								: (index < 40) ?
								getString((R.string.g2obesity))
								: getString(R.string.g3obesity);

				name.setText(extras.getString("name"));
				age.setText(Integer.toString(extras.getInt("age")));
				weight.setText(String.format("%.2f", extras.getFloat("weight")) + " kg");
				height.setText(String.format("%.2f", extras.getFloat("height")) + " m");
				bmi.setText(String.format("%.2f", index) + " kg/m²");
				classif.setText(classification);
			} catch(Exception e) {
				Toast.makeText(this, getContextString(R.string.errorCalc), Toast.LENGTH_SHORT).show();
				Log.e("AppError", Objects.requireNonNull(e.getMessage()));
			}
		} catch(Exception e) {
			Toast.makeText(this, getContextString(R.string.errorGetValues), Toast.LENGTH_SHORT).show();
			Log.e("AppError", Objects.requireNonNull(e.getMessage()));
		}
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

	public void newCalc(View v) {
		finish();
	}

	private String getContextString(int id) {
		return this.getResources().getString(id);
	}
}