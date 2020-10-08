package com.example.bmireport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("Ciclo", getLocalClassName() +  ": Activity iniciada!");
		setContentView(R.layout.activity_main);
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

	private String getContextString(int id) {
		return this.getResources().getString(id);
	}

	public void calculate(View v) {
		try {
			final String name = ((EditText) findViewById(R.id.editName)).getText().toString();
			final int age = Integer.parseInt(((EditText) findViewById(R.id.editAge)).getText().toString());
			final float weight = Float.parseFloat(((EditText) findViewById(R.id.editWeight)).getText().toString());
			final float height = Float.parseFloat(((EditText) findViewById(R.id.editHeight)).getText().toString());

			if(height == 0) {
				Toast.makeText(this, getContextString(R.string.errorDivByZero), Toast.LENGTH_SHORT).show();
				return;
			}

			Bundle extras = new Bundle();
			extras.putString("name", name);
			extras.putInt("age", age);
			extras.putFloat("weight", weight);
			extras.putFloat("height", height);

			final Intent it = new Intent(this, Report.class);
			it.putExtras(extras);
			startActivity(it);
		} catch(Exception e) {
			Toast.makeText(this, getContextString(R.string.errorInvalidValues), Toast.LENGTH_SHORT).show();
			Log.e("AppError", Objects.requireNonNull(e.getMessage()));
		}
	}
}