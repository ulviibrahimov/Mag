package kainat.questions.mag.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kainat.questions.mag.R;
import kainat.questions.mag.controller.ParseQuestions;
import kainat.questions.mag.model.Question;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
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
		getMenuInflater().inflate(R.menu.questions_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.itemrussian:
	        	int i=0;
	            for (i =0;i<questionL.size();i++){
	            	if(questionL.get(i).getQuestionType().equals("russian")){
	            		break;
	            	}
	            }
	            questionIndex=i;
	            displayQuestion(questionL.get(questionIndex),questionIndex);
	            return true;
	        case R.id.itemenglish:
	        	int j=0;
	            for (j =0;j<questionL.size();j++){
	            	if(questionL.get(j).getQuestionType().equals("english")){
	            		break;
	            	}
	            }
	            questionIndex=j;
	            displayQuestion(questionL.get(questionIndex),questionIndex);
	            return true;
	        case R.id.itemlogic:
	        	int z=0;
	            for (z =0;z<questionL.size();z++){
	            	if(questionL.get(z).getQuestionType().equals("logic")){
	            		break;
	            	}
	            }
	            questionIndex=z;
	            displayQuestion(questionL.get(questionIndex),questionIndex);
	            return true;
	        case R.id.itemfrench:
	        	int f=0;
	            for (f =0;f<questionL.size();f++){
	            	if(questionL.get(f).getQuestionType().equals("french")){
	            		break;
	            	}
	            }
	            questionIndex=f;
	            displayQuestion(questionL.get(questionIndex),questionIndex);
	            return true;
	        case R.id.choosequestion:
	        	AlertDialog.Builder alert = new AlertDialog.Builder(this);

	        	alert.setTitle("Sual seç");
	        	alert.setMessage("Sualın nömrəsini daxil edin : ( 1 - "+questionL.size()+" )");

	        	// Set an EditText view to get user input 
	        	final EditText input = new EditText(this);
	        	alert.setView(input);

	        	alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	        	public void onClick(DialogInterface dialog, int whichButton) {
	        	  Editable value = input.getText();
	        	  String questionNumber=value.toString();
	        	  try{
	        		  
	        		  int temp=Integer.parseInt(questionNumber)-1;
	        		  if(temp>=questionL.size() || temp<0){
	        			  Toast.makeText(context, "( 1 - "+questionL.size()+" ) intervalında ədəd daxil edin!", 1).show();
	        		  }
	        		  
	        		  else{
	        			  questionIndex=Integer.parseInt(questionNumber)-1;
	        			  displayQuestion(questionL.get(questionIndex),questionIndex);
	        		  }
	        		  }catch(NumberFormatException e){
	        			  Toast.makeText(context, "( 1 - "+questionL.size()+" ) intervalında ədəd daxil edin!", 1).show();
	        		  }
	        	  }
	        	});

	        	alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	        	  public void onClick(DialogInterface dialog, int whichButton) {
	        	    // Canceled.
	        	  }
	        	});

	        	alert.show();
	        	return true;
	        case R.id.randomquestion:
	        	Random rand = new Random();
	        	questionIndex = rand.nextInt(questionL.size());
	        	displayQuestion(questionL.get(questionIndex),questionIndex);
	        	return true;
	        case R.id.exit:
	        	AlertDialog.Builder exitAlert = new AlertDialog.Builder(this);

	        	exitAlert.setTitle("Çıxış");
	        	exitAlert.setMessage("Çıxmaq istədiyinizdən əminsinizmi?");
	        	exitAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	        	public void onClick(DialogInterface dialog, int whichButton) {
	        		System.exit(1);
	        	  }
	        	});

	        	exitAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	        	  public void onClick(DialogInterface dialog, int whichButton) {
	        	    // Canceled.
	        	  }
	        	});

	        	exitAlert.show();
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
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
