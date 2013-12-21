package kainat.questions.mag.activity;

import java.util.ArrayList;
import java.util.List;

import kainat.questions.mag.R;
import kainat.questions.mag.controller.ParseQuestions;
import kainat.questions.mag.model.Question;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends Activity {
	List<Question> questionL= new ArrayList<Question>();
	Integer questionIndex=0;
	Context context=this;
	Button aButton;
	Button bButton;
	Button cButton;
	Button dButton;
	Button eButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_questions);
		ParseQuestions test=new ParseQuestions(this.getApplicationContext());
		questionL=test.questions("questions.xml");
		this.displayQuestion(questionL.get(0), 0);
		addListenerOnButtonPrev();
		addListenerOnButtonNext();
		addListenerOnButtonA();
		addListenerOnButtonB();
		addListenerOnButtonC();
		addListenerOnButtonD();
		addListenerOnButtonE();
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

	public void addListenerOnButtonPrev() {
		 
		Button prevButton = (Button) findViewById(R.id.prevbutton);
 
		prevButton.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				if(questionIndex>0){
					questionIndex--;
				}
				else if (questionIndex==0){
					questionIndex=questionL.size()-1;
				}
				displayQuestion(questionL.get(questionIndex),questionIndex);
			}
 
		});
 
	}	
	
	public void addListenerOnButtonNext() {
		 
		Button prevButton = (Button) findViewById(R.id.nextbutton);
 
		prevButton.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				if(questionIndex<questionL.size()-1){
					questionIndex++;
				}
				else if (questionIndex==questionL.size()-1){
					questionIndex=0;
				}
				displayQuestion(questionL.get(questionIndex),questionIndex);
			}
 
		});
 
	}	
	
	public void addListenerOnButtonA() {
		 
		aButton = (Button) findViewById(R.id.abutton);
 
		aButton.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				if(questionL.get(questionIndex).getCorrectAnswer().equals("a")){
					Toast toast=Toast.makeText(context, "Cavabınız düzgündür!", 1);
					toast.getView().setBackgroundColor(Color.GREEN);
					toast.show();
				}
				else{
					Toast toast=Toast.makeText(context, "Cavabınız səhvdir!", 1);
					toast.getView().setBackgroundColor(Color.RED);
					toast.show();
				}
			}
 
		});
 
	}	
	public void addListenerOnButtonB() {
		 
		bButton = (Button) findViewById(R.id.bbutton);
 
		bButton.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				if(questionL.get(questionIndex).getCorrectAnswer().equals("b")){
					Toast toast=Toast.makeText(context, "Cavabınız düzgündür!", 1);
					toast.getView().setBackgroundColor(Color.GREEN);
					toast.show();
				}
				else{
					Toast toast=Toast.makeText(context, "Cavabınız səhvdir!", 1);
					toast.getView().setBackgroundColor(Color.RED);
					toast.show();
				}
			}
 
		});
 
	}
	
	public void addListenerOnButtonC() {
		 
		cButton = (Button) findViewById(R.id.cbutton);
 
		cButton.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				if(questionL.get(questionIndex).getCorrectAnswer().equals("c")){
					Toast toast=Toast.makeText(context, "Cavabınız düzgündür!", 1);
					toast.getView().setBackgroundColor(Color.GREEN);
					toast.show();
				}
				else{
					Toast toast=Toast.makeText(context, "Cavabınız səhvdir!", 1);
					toast.getView().setBackgroundColor(Color.RED);
					toast.show();
				}
			}
 
		});
 
	}
	
	public void addListenerOnButtonD() {
		 
		dButton = (Button) findViewById(R.id.dbutton);
 
		dButton.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				if(questionL.get(questionIndex).getCorrectAnswer().equals("d")){
					Toast toast=Toast.makeText(context, "Cavabınız düzgündür!", 1);
					toast.getView().setBackgroundColor(Color.GREEN);
					toast.show();
				}
				else{
					Toast toast=Toast.makeText(context, "Cavabınız səhvdir!", 1);
					toast.getView().setBackgroundColor(Color.RED);
					toast.show();
				}
			}
 
		});
 
	}
	
	public void addListenerOnButtonE() {
		 
		eButton = (Button) findViewById(R.id.ebutton);
 
		eButton.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				if(questionL.get(questionIndex).getCorrectAnswer().equals("e")){
					Toast toast=Toast.makeText(context, "Cavabınız düzgündür!", 1);
					toast.getView().setBackgroundColor(Color.GREEN);
					toast.show();
				}
				else{
					Toast toast=Toast.makeText(context, "Cavabınız səhvdir!", 1);
					toast.getView().setBackgroundColor(Color.RED);
					toast.show();
				}
			}
 
		});
 
	}
}
