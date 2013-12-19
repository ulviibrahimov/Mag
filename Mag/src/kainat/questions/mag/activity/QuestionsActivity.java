package kainat.questions.mag.activity;

import kainat.questions.mag.R;
import kainat.questions.mag.R.layout;
import kainat.questions.mag.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class QuestionsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_questions);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.questions, menu);
		return true;
	}

}
