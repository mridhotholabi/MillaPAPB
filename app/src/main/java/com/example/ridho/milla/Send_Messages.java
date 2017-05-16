package com.example.ridho.milla;

import android.speech.tts.TextToSpeech;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Send_Messages extends AppCompatActivity implements View.OnTouchListener {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    private GestureDetectorCompat gestureObject;
    private Button button1,button2,button3,button4,button5,button6;
    public TextView tvsm;
    private boolean mbutton1 = false, mbutton2 = false, mbutton3 = false, mbutton4 = false, mbutton5 = false, mbutton6 = false;
    private String text = "";
    String phoneNo;
    String sms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Main.t1.speak("Enter your destination number",TextToSpeech.QUEUE_FLUSH,null);
        setContentView(R.layout.activity_send__messages);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        button4 = (Button) findViewById(R.id.btn4);
        button5 = (Button) findViewById(R.id.btn5);
        button6 = (Button) findViewById(R.id.btn6);
        tvsm = (TextView) findViewById(R.id.tvmessage);
        tvsm.setText("5554");
        button1.setOnTouchListener(this);
        button2.setOnTouchListener(this);
        button3.setOnTouchListener(this);
        button4.setOnTouchListener(this);
        button5.setOnTouchListener(this);
        button6.setOnTouchListener(this);

        gestureObject = new GestureDetectorCompat(this, new LearnGesture());
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
                tvsm.setText(tvsm.getText().toString().substring(0,tvsm.getText().length() - 1));
            }
            if (e2.getX()>e1.getX()){
                tvsm.append(" ");
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            sms = message.tvm.getText().toString();
            phoneNo = tvsm.getText().toString();

            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNo, null, sms, null, null);
                Main.t1.speak("Your message is sent!",TextToSpeech.QUEUE_FLUSH,null);

                Toast.makeText(getApplicationContext(), "SMS Sent!",
                        Toast.LENGTH_LONG).show();
            }
            catch (Exception e1) {
                Main.t1.speak("Your message is failed, please try again!",TextToSpeech.QUEUE_FLUSH,null);
                Toast.makeText(getApplicationContext(),
                        "SMS failed, please try again later!",
                        Toast.LENGTH_LONG).show();
                e1.printStackTrace();
            }
            finish();
            message.getInstance().finish();
            return super.onDoubleTap(e);
        }
    }

    /*protected void sendSMSMessage() {
        sms = (String) message.tvm.getText();
        phoneNo = (String) tvsm.getText();

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, sms, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS failed, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }
    }*/

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                //first finger went down
                if (v.getId() == R.id.btn1) {
                    mbutton1 = true;
                    Log.d("mylog", "button1 true");
                } else if (v.getId() == R.id.btn2) {
                    mbutton2 = true;
                    Log.d("mylog", "button2 true");
                } else if (v.getId() == R.id.btn3) {
                    mbutton3 = true;
                    Log.d("mylog", "button3 true");
                } else if (v.getId() == R.id.btn4) {
                    mbutton4 = true;
                    Log.d("mylog", "button4 true");
                } else if (v.getId() == R.id.btn5) {
                    mbutton5 = true;
                    Log.d("mylog", "button5 true");
                } else if (v.getId() == R.id.btn6) {
                    mbutton6 = true;
                    Log.d("mylog", "button6 true");
                }
                break;

            case MotionEvent.ACTION_MOVE:
                //a touch placement has changed
                break;

            case MotionEvent.ACTION_UP:
                //first finger went up
                if (v.getId() == R.id.btn1) {
                    mbutton1 = false;
                    Log.d("mylog", "button1 false");
                } else if (v.getId() == R.id.btn2) {
                    mbutton2 = false;
                    Log.d("mylog", "button2 false");
                } else if (v.getId() == R.id.btn3) {
                    mbutton3 = false;
                    Log.d("mylog", "button3 false");
                } else if (v.getId() == R.id.btn4) {
                    mbutton4 = false;
                    Log.d("mylog", "button4 false");
                } else if (v.getId() == R.id.btn5) {
                    mbutton5 = false;
                    Log.d("mylog", "button5 false");
                } else if (v.getId() == R.id.btn6) {
                    mbutton6 = false;
                    Log.d("mylog", "button6 false");
                }
                if (mbutton1 == false && mbutton2 == false && mbutton3 == false && mbutton4 == false && mbutton5 == false && mbutton6 == false) {
                    Log.d("cancel", "ok");
                    tvsm.append(text);
                    Main.t1.speak(String.valueOf(tvsm.getText()), TextToSpeech.QUEUE_FLUSH, null);
                    //text = "";
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
            text = "1";
        }
        if (mbutton1 == true && mbutton2 == true && mbutton3 == false && mbutton4 == false && mbutton5 == false && mbutton6 == false){
            text = "2";
        }
        if (mbutton1 == true && mbutton2 == false && mbutton3 == false && mbutton4 == true && mbutton5 == false && mbutton6 == false){
            text = "3";
        }
        if (mbutton1 == true && mbutton2 == false && mbutton3 == false && mbutton4 == true && mbutton5 == true && mbutton6 == false){
            text = "4";
        }
        if (mbutton1 == true && mbutton2 == false && mbutton3 == false && mbutton4 == false && mbutton5 == true && mbutton6 == false){
            text = "5";
        }
        if (mbutton1 == true && mbutton2 == true && mbutton3 == false && mbutton4 == true && mbutton5 == false && mbutton6 == false){
            text = "6";
        }
        if (mbutton1 == true && mbutton2 == true && mbutton3 == false && mbutton4 == true && mbutton5 == true && mbutton6 == false){
            text = "7";
        }
        if (mbutton1 == true && mbutton2 == true && mbutton3 == false && mbutton4 == false && mbutton5 == true && mbutton6 == false){
            text = "8";
        }
        if (mbutton1 == false && mbutton2 == true && mbutton3 == false && mbutton4 == true && mbutton5 == false && mbutton6 == false){
            text = "9";
        }
        if (mbutton1 == false && mbutton2 == true && mbutton3 == false && mbutton4 == true && mbutton5 == true && mbutton6 == false) {
            text = "0";
        }
        return true;
    }
}
