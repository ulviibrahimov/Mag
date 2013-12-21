package kainat.questions.mag.activity;

import java.util.ArrayList;
import java.util.List;

import kainat.questions.mag.R;
import kainat.questions.mag.controller.ParseQuestions;
import kainat.questions.mag.model.Question;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class QuestionsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_questions);
		ParseQuestions test=new ParseQuestions(this.getApplicationContext());
		List<Question> questionL= new ArrayList<Question>();
		questionL=test.questions("questions.xml");
		this.displayQuestion(questionL.get(0), 0);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.questions, menu);
		return true;
	}
	
	public void displayQuestion(Question question, Integer index){
		TextView t=new TextView(this);
		t=(TextView)findViewById(R.id.textView2);
		t.setText("Sual: "+(index+1));
		t=(TextView)findViewById(R.id.textView1);
		t.setText(question.getQuestionText());
		Button aButton=(Button)findViewById(R.id.abutton);
        aButton.setText(question.getChoiceA());
        aButton.setTextSize(10);
        
        Button bButton=(Button)findViewById(R.id.bbutton);
        bButton.setText(question.getChoiceB());
        
        Button cButton=(Button)findViewById(R.id.cbutton);
        cButton.setText(question.getChoiceC());
        
        Button dButton=(Button)findViewById(R.id.dbutton);
        dButton.setText(question.getChoiceD());
        
        Button eButton=(Button)findViewById(R.id.ebutton);
        eButton.setText(question.getChoiceE());
	}

}
