package com.example.ridho.milla;

import android.graphics.Point;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.view.View.OnTouchListener;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.ConsoleHandler;

public class message extends AppCompatActivity implements OnTouchListener{

    private GestureDetectorCompat gestureObject;
    private TextToSpeech t1;
    private Button button1,button2,button3,button4,button5,button6;
    private ConstraintLayout layout_message;
    private TextView tvm;
    private boolean mbutton1 = false, mbutton2 = false, mbutton3 = false, mbutton4 = false, mbutton5 = false, mbutton6 = false;
    private String text = "";
    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        button4 = (Button) findViewById(R.id.btn4);
        button5 = (Button) findViewById(R.id.btn5);
        button6 = (Button) findViewById(R.id.btn6);
        tvm = (TextView) findViewById(R.id.tvmessage);
        layout_message = (ConstraintLayout) findViewById(R.id.layout1);
        button1.setOnTouchListener(this);
        button2.setOnTouchListener(this);
        button3.setOnTouchListener(this);
        button4.setOnTouchListener(this);
        button5.setOnTouchListener(this);
        button6.setOnTouchListener(this);

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.ENGLISH);
                }
            }
        });
        gestureObject = new GestureDetectorCompat(this, new message.LearnGesture());
        //{
            //public void onClick(View v) {
                // Perform action on click
                //Log.d("mylog","button1");
                //Toast.makeText(getBaseContext(),"This is button 1",Toast.LENGTH_LONG).show();
            //}
        //});
    }

    @Override
    public boolean onTouchEvent (MotionEvent event){
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


    class LearnGesture extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e2.getX()<e1.getX()){
                tvm.setText(tvm.getText().toString().substring(0,tvm.getText().length() - 1));
            }
            if (e2.getX()>e1.getX()){
                tvm.append(" ");
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction() & MotionEvent.ACTION_MASK) {

            case MotionEvent.ACTION_DOWN:
                //first finger went down
                if(v.getId() == R.id.btn1){
                    mbutton1 = true;
                    Log.d("mylog", "button1 true");
                }
                else if (v.getId() == R.id.btn2) {
                    mbutton2 = true;
                    Log.d("mylog", "button2 true");
                }
                else if (v.getId() == R.id.btn3) {
                    mbutton3 = true;
                    Log.d("mylog", "button3 true");
                }
                else if (v.getId() == R.id.btn4) {
                    mbutton4 = true;
                    Log.d("mylog", "button4 true");
                }
                else if (v.getId() == R.id.btn5) {
                    mbutton5 = true;
                    Log.d("mylog", "button5 true");
                }
                else if (v.getId() == R.id.btn6) {
                    mbutton6 = true;
                    Log.d("mylog", "button6 true");
                }
                break;

            case MotionEvent.ACTION_MOVE:
                //a touch placement has changed
                break;

            case MotionEvent.ACTION_UP:
                //first finger went up
                if(v.getId() == R.id.btn1){
                    mbutton1 = false;
                    Log.d("mylog", "button1 false");
                }
                else if (v.getId() == R.id.btn2) {
                    mbutton2 = false;
                    Log.d("mylog", "button2 false");
                }
                else if (v.getId() == R.id.btn3) {
                    mbutton3 = false;
                    Log.d("mylog", "button3 false");
                }
                else if (v.getId() == R.id.btn4) {
                    mbutton4 = false;
                    Log.d("mylog", "button4 false");
                }
                else if (v.getId() == R.id.btn5) {
                    mbutton5 = false;
                    Log.d("mylog", "button5 false");
                }
                else if (v.getId() == R.id.btn6) {
                    mbutton6 = false;
                    Log.d("mylog", "button6 false");
                }
                if (mbutton1 == false && mbutton2 == false && mbutton3 == false && mbutton4 == false && mbutton5 == false && mbutton6 == false)
                {
                    Log.d("cancel","ok");
                    tvm.append(text);
                    t1.speak(String.valueOf(tvm.getText()),TextToSpeech.QUEUE_FLUSH,null);
                    text = "";
                }
                break;

            case MotionEvent.ACTION_CANCEL:
                //gesture aborted (I think this means the finger was dragged outside of the touchscreen)
                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                //second finger (or third, or more) went down.

                break;

            case MotionEvent.ACTION_POINTER_UP:
                //second finger (or more) went up.
                break;

            default: break;
        }

        if(mbutton1 == true && mbutton2 == false && mbutton3 == false && mbutton4 == false && mbutton5 == false && mbutton6 == false) {
            text = "a";
        }
        if (mbutton1 == true && mbutton2 == true && mbutton3 == false && mbutton4 == false && mbutton5 == false && mbutton6 == false){
            text = "b";
        }
        if (mbutton1 == true && mbutton2 == false && mbutton3 == false && mbutton4 == true && mbutton5 == false && mbutton6 == false){
            text = "c";
        }
        if (mbutton1 == true && mbutton2 == false && mbutton3 == false && mbutton4 == true && mbutton5 == true && mbutton6 == false){
            text = "d";
        }
        if (mbutton1 == true && mbutton2 == false && mbutton3 == false && mbutton4 == false && mbutton5 == true && mbutton6 == false){
            text = "e";
        }
        if (mbutton1 == true && mbutton2 == true && mbutton3 == false && mbutton4 == true && mbutton5 == false && mbutton6 == false){
            text = "f";
        }
        if (mbutton1 == true && mbutton2 == true && mbutton3 == false && mbutton4 == true && mbutton5 == true && mbutton6 == false){
            text = "g";
        }
        if (mbutton1 == true && mbutton2 == true && mbutton3 == false && mbutton4 == false && mbutton5 == true && mbutton6 == false){
            text = "h";
        }
        if (mbutton1 == false && mbutton2 == true && mbutton3 == false && mbutton4 == true && mbutton5 == false && mbutton6 == false){
            text = "i";
        }
        if (mbutton1 == false && mbutton2 == true && mbutton3 == false && mbutton4 == true && mbutton5 == true && mbutton6 == false){
            text = "j";
        }
        if (mbutton1 == true && mbutton2 == false && mbutton3 == true && mbutton4 == false && mbutton5 == false && mbutton6 == false){
            text = "k";
        }
        if (mbutton1 == true && mbutton2 == true && mbutton3 == true && mbutton4 == false && mbutton5 == false && mbutton6 == false){
            text = "l";
        }
        if (mbutton1 == true && mbutton2 == false && mbutton3 == true && mbutton4 == true && mbutton5 == false && mbutton6 == false){
            text = "m";
        }
        if (mbutton1 == true && mbutton2 == false && mbutton3 == true && mbutton4 == true && mbutton5 == true && mbutton6 == false){
            text = "n";
        }
        if (mbutton1 == true && mbutton2 == false && mbutton3 == true && mbutton4 == false && mbutton5 == true && mbutton6 == false){
            text = "o";
        }
        if (mbutton1 == true && mbutton2 == true && mbutton3 == true && mbutton4 == true && mbutton5 == false && mbutton6 == false){
            text = "p";
        }
        if (mbutton1 == true && mbutton2 == true && mbutton3 == true && mbutton4 == true && mbutton5 == true && mbutton6 == false){
            text = "q";
        }
        if (mbutton1 == true && mbutton2 == true && mbutton3 == true && mbutton4 == false && mbutton5 == true && mbutton6 == false){
            text = "r";
        }
        if (mbutton1 == false && mbutton2 == true && mbutton3 == true && mbutton4 == true && mbutton5 == false && mbutton6 == false){
            text = "s";
        }
        if (mbutton1 == false && mbutton2 == true && mbutton3 == true && mbutton4 == true && mbutton5 == true && mbutton6 == false){
            text = "t";
        }
        if (mbutton1 == true && mbutton2 == false && mbutton3 == true && mbutton4 == false && mbutton5 == false && mbutton6 == true){
            text = "u";
        }
        if (mbutton1 == true && mbutton2 == true && mbutton3 == true && mbutton4 == false && mbutton5 == false && mbutton6 == true){
            text = "v";
        }
        if (mbutton1 == false && mbutton2 == true && mbutton3 == false && mbutton4 == true && mbutton5 == true && mbutton6 == true){
            text = "w";
        }
        if (mbutton1 == true && mbutton2 == false && mbutton3 == true && mbutton4 == true && mbutton5 == false && mbutton6 == true){
            text = "x";
        }
        if (mbutton1 == true && mbutton2 == true && mbutton3 == false && mbutton4 == true && mbutton5 == true && mbutton6 == true){
            text = "y";
        }
        if (mbutton1 == true && mbutton2 == false && mbutton3 == true && mbutton4 == false && mbutton5 == true && mbutton6 == true){
            text = "z";
        }

        return true;
    }



    /*@Override
    public void onClick(View v) {
        if((v.getId()==R.id.btn1) && (v.getId()==R.id.btn2))
        {
            Toast.makeText(getBaseContext(),"This is button 1 & 2",Toast.LENGTH_LONG).show();
        }
    }*/


    //CLASS TO HANDLE THE EVENT
    /*public class MultitouchButtonHandler {
        ArrayList<View> views_info = new ArrayList<View>();
        public MultitouchButtonHandlerResult onTouchEvent(View v, MotionEvent ev) {

            //GET EVENT INFO
            final int action = ev.getAction();
            int action_masked = action & MotionEvent.ACTION_MASK;
            if(action_masked==MotionEvent.ACTION_MOVE){
                return null;
            }

            //GET ABSOLUTE SIZE AND CHECK IF THIS ANY VIEW ATTACHED TO THIS POSITION
            final int original_location[] = { 0, 0 };
            v.getLocationOnScreen(original_location);
            final int actionPointerIndex = ev.getActionIndex();
            float rawX = (int) ev.getX(actionPointerIndex) + original_location[0];
            float rawY = (int) ev.getY(actionPointerIndex) + original_location[1];
            View eventView = getViewByLocation((int)rawX, (int)rawY);
            if(eventView==null) return null;

            MultitouchButtonHandlerResult result = new MultitouchButtonHandlerResult();
            result.view  = eventView;


            //CHECK WHAT KIND OF EVENT HAPPENED
            switch (action_masked) {
                case MotionEvent.ACTION_DOWN: {
                    result.event_type = MotionEvent.ACTION_DOWN;
                    return result;
                }

                case MotionEvent.ACTION_UP: {
                    result.event_type = MotionEvent.ACTION_UP;
                    return result;
                }

                case MotionEvent.ACTION_CANCEL: {
                    result.event_type = MotionEvent.ACTION_CANCEL;
                    return result;
                }

                case MotionEvent.ACTION_POINTER_UP: {
                    result.event_type = MotionEvent.ACTION_UP;
                    return result;
                }

                case MotionEvent.ACTION_POINTER_DOWN: {
                    result.event_type = MotionEvent.ACTION_DOWN;
                    return result;
                }

                default:

                    break;

            }

            return null;
        }

        public void addMultiTouchView(View v){
            views_info.add(v);;
        }
        public void removeMultiTouchView(View v){
            views_info.remove(v);;
        }

        public View getViewByLocation(int x, int y){

            for(int key=0; key!= views_info.size(); key++){
                View v = views_info.get(key);
                //GET BUTTON ABSOLUTE POSITION ON SCREEN
                int[] v_location = { 0, 0 };
                v.getLocationOnScreen(v_location);

                //FIND THE BOUNDS
                Point min = new Point(v_location[0], v_location[1]);
                Point max = new Point(min.x + v.getWidth(), min.y + v.getHeight());


                if(x>=min.x && x<=max.x && y>=min.y && y<=max.y){
                    Log.d("mylog", "***Found a view: " + v.getId());
                    return v;
                }

            }

            Log.d("mylog", "Searching: " + x +", " + y + " but not found!");

            return null;
        }

        //CLASS TO FULLFILL WITH RESULT
        public class MultitouchButtonHandlerResult {
            public View view;
            public int event_type;
        }

        //In your view
      /*  private OnTouchListener listener_touch_button = new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                MultitouchButtonHandlerResult result=multitouch_handler.onTouchEvent(v, event);
                if(result==null) return true;

                switch(result.event_type){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("mylog", "DOWN");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d("mylog", "UP");
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        Log.d("mylog", "CANCEL");
                        break;

                }

                Log.d("mylog", "View ID: " + result.view.getId());

                return false;
            }

        };

    }*/
}
