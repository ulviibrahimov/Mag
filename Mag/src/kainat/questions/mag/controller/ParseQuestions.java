/**
 * 
 */
package kainat.questions.mag.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import kainat.questions.mag.model.Question;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;
import javax.xml.parsers.SAXParser;  
import javax.xml.parsers.SAXParserFactory;  
import org.xml.sax.Attributes;  
import org.xml.sax.SAXException;  
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author ulvi
 *
 */
public class ParseQuestions extends DefaultHandler{
	Question question;
	String questionType=null;
	List<Question> questionList= new ArrayList<Question>();
	boolean newQuestionFlag=true;
	private Context context;
	public ParseQuestions(Context context){
		this.context=context;
	}
	
	public List<Question> questions(String filename){  
		  try {  
		   // obtain and configure a SAX based parser  
		   SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();  
		  
		   // obtain object for SAX parser  
		   SAXParser saxParser = saxParserFactory.newSAXParser();  
		  
		   // default handler for SAX handler class  
		   // all three methods are written in handler's body  
		   DefaultHandler defaultHandler = new DefaultHandler(){  
		      
		    String questionTextTag="close";  
		    String choiceATag="close";  
		    String choiceBTag="close";  
		    String choiceCTag="close";
		    String choiceDTag="close";
		    String choiceETag="close";
		    String correctAnswerTag="close";
		    String imageTag="close";  
		    String russianTag="close";
		    String englishTag="close";
		    String logicTag="close";
		    String frenchTag="close";
		    String questionTag="close";
		    // this method is called every time the parser gets an open tag '<'  
		    // identifies which tag is being open at time by assigning an open flag  
		    public void startElement(String uri, String localName, String qName,  
		      Attributes attributes) throws SAXException {  
		     
		     if (qName.equalsIgnoreCase("russian")) {  
		      russianTag = "open";  
		     }  
		     if (qName.equalsIgnoreCase("english")) {  
		      englishTag = "open";  
		     }  
		     if (qName.equalsIgnoreCase("logic")) {  
		      logicTag = "open";  
		     }  
		     if (qName.equalsIgnoreCase("french")) {  
		      frenchTag = "open";  
		     }  
		     if (qName.equalsIgnoreCase("questionText")) {  
			      questionTextTag = "open";  
			     }  
		     if (qName.equalsIgnoreCase("choiceA")) {  
			      choiceATag = "open";  
			     }  
		     if (qName.equalsIgnoreCase("choiceB")) {  
			      choiceBTag = "open";  
			     } 
		     if (qName.equalsIgnoreCase("choiceC")) {  
			      choiceCTag = "open";  
			     } 
		     if (qName.equalsIgnoreCase("choiceD")) {  
			      choiceDTag = "open";  
			     } 
		     if (qName.equalsIgnoreCase("choiceE")) {  
			      choiceETag = "open";  
			     } 
		     if (qName.equalsIgnoreCase("correctAnswer")) {  
			      correctAnswerTag = "open";  
			     } 
		     if (qName.equalsIgnoreCase("question")) {  
			      questionTag = "open";  
			     } 
		    }  
		  
		    // prints data stored in between '<' and '>' tags  
		    public void characters(char ch[], int start, int length)  
		      throws SAXException {  
		       
		     if (russianTag.equals("open")) {  
		      questionType="russian";  
		     }  
		     if (englishTag.equals("open")) {  
		      questionType="english"; 
		     }  
		     if (logicTag.equals("open")) {  
		    	 questionType="logic";  
		     }  
		     if (frenchTag.equals("open")) {  
		    	 questionType="french";  
		     }  
		     
		     if(questionTag.equals("open")){
		    	 if(newQuestionFlag){
		    		 question = new Question();
		    		 newQuestionFlag=false;
		    	 }
		    	 question.setQuestionType(questionType);
		     }
		     
		     if (questionTextTag.equals("open")) {   
		    	  question.setQuestionText(new String(ch, start, length)); 
		    	  //System.out.println("text: "+question.getQuestionText());
		     }
		     if (choiceATag.equals("open")) {  
		    	  question.setChoiceA(new String(ch, start, length)); 
		     }
		     if (choiceBTag.equals("open")) {  
		    	  question.setChoiceB(new String(ch, start, length)); 
		     }
		     if (choiceCTag.equals("open")) {  
		    	  question.setChoiceC(new String(ch, start, length)); 
		     }
		     if (choiceDTag.equals("open")) {  
		    	  question.setChoiceD(new String(ch, start, length)); 
		     }
		     if (choiceETag.equals("open")) {  
		    	  question.setChoiceE(new String(ch, start, length)); 
		     }
		     if (correctAnswerTag.equals("open")) {  
		    	  question.setCorrectAnswer(new String(ch, start, length)); 
		     }
		     if (imageTag.equals("open")) {  
		    	  question.setImage(new String(ch, start, length)); 
		     }
		    }  
		  
		    // calls by the parser whenever '>' end tag is found in xml   
		    // makes tags flag to 'close'  
		    public void endElement(String uri, String localName, String qName)  
		      throws SAXException {  
		       
		    	if (qName.equalsIgnoreCase("russian")) {  
				      russianTag = "close";  
				     }  
				     if (qName.equalsIgnoreCase("english")) {  
				      englishTag = "close";  
				     }  
				     if (qName.equalsIgnoreCase("logic")) {  
				      logicTag = "close";  
				     }  
				     if (qName.equalsIgnoreCase("french")) {  
				      frenchTag = "close";  
				     }  
				     if (qName.equalsIgnoreCase("questionText")) {  
					      questionTextTag = "close";  
					     }  
				     if (qName.equalsIgnoreCase("choiceA")) {  
					      choiceATag = "close";  
					     }  
				     if (qName.equalsIgnoreCase("choiceB")) {  
					      choiceBTag = "close";  
					     } 
				     if (qName.equalsIgnoreCase("choiceC")) {  
					      choiceCTag = "close";  
					     } 
				     if (qName.equalsIgnoreCase("choiceD")) {  
					      choiceDTag = "close";  
					     } 
				     if (qName.equalsIgnoreCase("choiceE")) {  
					      choiceETag = "close";  
					     } 
				     if (qName.equalsIgnoreCase("correctAnswer")) {  
					      correctAnswerTag = "close";  
					     } 
				     if (qName.equalsIgnoreCase("question")) {  
					      questionTag = "close";  
					      newQuestionFlag=true;
					      //System.out.println(question.toString());
					      questionList.add(question);
					     } 
				    }  
		   };  
		     
		   // parse the XML specified in the given path and uses supplied  
		   // handler to parse the document  
		   // this calls startElement(), endElement() and character() methods  
		   // accordingly  
		   AssetManager mngr = context.getAssets();
		   InputStream is = mngr.open(filename);;
		   saxParser.parse(is, defaultHandler);  
		  } catch (Exception e) {  
		   e.printStackTrace();  
		  }
		return questionList;  
		 }  
		} 





















	/*private Context context;
	public ParseQuestions(Context context){
		this.context=context;
	}
	
	public List<Question> questions(String fileName){
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuilder = null;
			List<Question> questionList= new ArrayList<Question>();
			AssetManager mngr = context.getAssets();
		    InputStream is;
			try {
				dbuilder = dbf.newDocumentBuilder();
				is = mngr.open("questions.xml");
			    Document doc = dbuilder.parse(is);
			    doc.getDocumentElement().normalize();
			    NodeList qnodeList = doc.getElementsByTagName("questions");
			    
			
		        Node qnode = qnodeList.item(0);
		        Element fstElmnt = (Element) qnode;
		        Node russianNode=fstElmnt.getElementsByTagName("russian").item(0);
		        Element russianElement = (Element) russianNode;
		        //System.out.println("herere :  "+russianElement.getElementsByTagName("question").getLength());
		        for(int i=0;i<russianElement.getElementsByTagName("question").getLength();i++){
		        	Node rNode = russianElement.getElementsByTagName("question").item(i);
		        	Element rElement =(Element) rNode;
		        	Question rQuestion= new Question();
		        	rQuestion.setQuestionText(rElement.getElementsByTagName("questionText").item(0).getTextContent());
		        	rQuestion.setChoiceA(rElement.getElementsByTagName("choiceA").item(0).getTextContent());
		        	rQuestion.setChoiceB(rElement.getElementsByTagName("choiceB").item(0).getTextContent());
		        	rQuestion.setChoiceC(rElement.getElementsByTagName("choiceC").item(0).getTextContent());
		        	rQuestion.setChoiceD(rElement.getElementsByTagName("choiceD").item(0).getTextContent());
		        	rQuestion.setChoiceE(rElement.getElementsByTagName("choiceE").item(0).getTextContent());
		        	rQuestion.setCorrectAnswer(rElement.getElementsByTagName("correctAnswer").item(0).getTextContent());
		        	rQuestion.setImage(rElement.getElementsByTagName("image").item(0).getTextContent());
		        	rQuestion.setQuestionType("russian");
		        	questionList.add(rQuestion);
		        }
		        
		        Node englishNode=fstElmnt.getElementsByTagName("english").item(0);
		        Element englishElement = (Element) englishNode;
		        for(int i=0;i<englishElement.getElementsByTagName("question").getLength();i++){
		        	Node eNode = englishElement.getElementsByTagName("question").item(i);
		        	Element eElement =(Element) eNode;
		        	Question eQuestion= new Question();
		        	eQuestion.setQuestionText(eElement.getElementsByTagName("questionText").item(0).getTextContent());
		        	eQuestion.setChoiceA(eElement.getElementsByTagName("choiceA").item(0).getTextContent());
		        	eQuestion.setChoiceB(eElement.getElementsByTagName("choiceB").item(0).getTextContent());
		        	eQuestion.setChoiceC(eElement.getElementsByTagName("choiceC").item(0).getTextContent());
		        	eQuestion.setChoiceD(eElement.getElementsByTagName("choiceD").item(0).getTextContent());
		        	eQuestion.setChoiceE(eElement.getElementsByTagName("choiceE").item(0).getTextContent());
		        	eQuestion.setCorrectAnswer(eElement.getElementsByTagName("correctAnswer").item(0).getTextContent());
		        	eQuestion.setImage(eElement.getElementsByTagName("image").item(0).getTextContent());
		        	eQuestion.setQuestionType("english");
		        	questionList.add(eQuestion);
		        }
		        
		        
		            //Toast.makeText(context, fstElmnt.getElementsByTagName("russian").item(0).getTextContent(), 1).show();
		            //System.out.println(fstElmnt.getElementsByTagName("russian").item(0).getTextContent());
		            //fstElmnt.getElementsByTagName("countryn").item(0).getTextContent();
		        
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		return questionList;
	}
	
}*/
