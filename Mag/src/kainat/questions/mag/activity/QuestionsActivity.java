package kainat.questions.mag.activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kainat.questions.mag.R;
import kainat.questions.mag.controller.ParseQuestions;
import kainat.questions.mag.model.Question;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class QuestionsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_questions);
		ParseQuestions test=new ParseQuestions(this.getApplicationContext());
		List<Question> questionL= new ArrayList<Question>();
		questionL=test.questions("questions.xml");
		for(int i=0;i<questionL.size();i++){
			System.out.println(questionL.get(i).getQuestionText());
			System.out.println(questionL.get(i).getChoiceA());
			System.out.println(questionL.get(i).getChoiceB());
			System.out.println(questionL.get(i).getChoiceC());
			System.out.println(questionL.get(i).getChoiceD());
			System.out.println(questionL.get(i).getChoiceE());
			System.out.println(questionL.get(i).getCorrectAnswer());
			System.out.println(questionL.get(i).getQuestionType());
			System.out.println(questionL.get(i).getImage());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.questions, menu);
		return true;
	}

}
