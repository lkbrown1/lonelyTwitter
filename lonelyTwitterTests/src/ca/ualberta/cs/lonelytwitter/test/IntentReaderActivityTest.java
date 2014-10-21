package ca.ualberta.cs.lonelytwitter.test;

//import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

//@SuppressLint("NewApi") 
public class IntentReaderActivityTest extends
        ActivityInstrumentationTestCase2<IntentReaderActivity> {

    public IntentReaderActivityTest() {
        super(IntentReaderActivity.class);
    }

//TODO: Add your code here:
    public void testSendText(){
 	   Intent intent = new Intent();
 	   intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "hello");
 	   
 	   setActivityIntent(intent);
 	   IntentReaderActivity ira = getActivity();
 	   
 	   assertEquals("hello", ira.getText());
    }
    
    public void testDisplayText(){
 	   Intent intent = new Intent();
 	   intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "hello");
 	   
 	   setActivityIntent(intent);
 	   IntentReaderActivity ira = getActivity();
 	   
 	   TextView textView = (TextView) ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
 	   
 	   assertEquals("hello", textView.getText());
    }
    
    public void testDoubleText(){
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "double this!");
    	intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
    	setActivityIntent(intent);
    	IntentReaderActivity ira = getActivity();
    	assertEquals("double this!double this!", ira.getText());
    }
    
    public void testReverseText(){
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "reverse this!");
    	intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.REVERSE);
    	setActivityIntent(intent);
    	IntentReaderActivity ira = getActivity();
    	assertEquals("!siht esrever", ira.getText());
    }
    
    public void testDefaultMessage(){
    	Intent intent = new Intent();
    	setActivityIntent(intent);
    	
    	IntentReaderActivity ira = getActivity();
    	TextView textView = (TextView) ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
    	assertEquals("default text", textView.getText());
    }
    
    public void testTextViewIsVisible() {
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "hello");
        intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY,
            IntentReaderActivity.REVERSE);
            
        setActivityIntent(intent);
        IntentReaderActivity ira = getActivity();

        //To assert that the view is on the screen 
            //use ViewAsserts.assertOnScreen()
                //(first parameter contains the second parameter): 
        //To get a view that contains anything on screen:
            // Activity.getWindow().getDecorView()
        ViewAsserts.assertOnScreen(ira.getWindow().getDecorView(), 
            ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText));
        }

    
}
