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

/**
 * @author ulvi
 *
 */
public class ParseQuestions {
	private Context context;
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
	
}
