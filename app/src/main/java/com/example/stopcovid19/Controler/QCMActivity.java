package com.example.stopcovid19.Controler;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stopcovid19.Model.TrueFalse;
import com.example.stopcovid19.R;

public class QCMActivity extends AppCompatActivity {

    Button mTrueButton;
    Button mFalseButton;
    TextView mQuestionTextView;
    int mIndex;
    int mQuestion;
    TextView mScoreTextView;
    ProgressBar mProgressBar;
    int mScore;

    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, true),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, true),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10,true),
            new TrueFalse(R.string.question_11,true),
            new TrueFalse(R.string.question_12,true),
            new TrueFalse(R.string.question_13,true)
    };

    final int PROGRESS_BAR_INCREMENT=(int)Math.ceil(100.0/mQuestionBank.length);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_c_m);

        if(savedInstanceState!=null)
        {
            mScore=savedInstanceState.getInt("ScoreKey");
            mIndex=savedInstanceState.getInt("IndexKey");


        }
        else
        {
            mScore=0;
            mIndex=0;

        }

        mTrueButton=(Button) findViewById(R.id.true_button);
        mFalseButton=(Button)findViewById(R.id.false_button);
        mQuestionTextView=(TextView)findViewById(R.id.question_text_view);
        mScoreTextView=(TextView)findViewById(R.id.score);
        mProgressBar=(ProgressBar)findViewById(R.id.progress_bar);


        mQuestion=mQuestionBank[mIndex].getmQuestionID();
        mQuestionTextView.setText(mQuestion);

        mScoreTextView.setText("Symptômes "+mScore+"/"+mQuestionBank.length);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                checkAnswer(true);
                updateQuestion();
            }
        });



        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(false);

                updateQuestion();



            }
        });

    }

    private void updateQuestion(){
        mIndex=(mIndex+1) % mQuestionBank.length;


        if(mIndex==0) {
            //--------------------
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 500 milliseconds
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && mScore >7) {
                v.vibrate(VibrationEffect.createOneShot(5000, VibrationEffect.DEFAULT_AMPLITUDE));
            }
            else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O &&  mScore >= 5) {
                v.vibrate(VibrationEffect.createOneShot(2000, VibrationEffect.DEFAULT_AMPLITUDE));
            }else {
                //deprecated in API 26
                v.vibrate(500);
            }

            //------------------------
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle( "TERMINER");
            alert.setCancelable(false);
            alert.setMessage("VOUS AVEZ "+mScore+" SYMPTÖMES");
            alert.setPositiveButton("Voir les résultats", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    if (mScore > 0){
                    start_resultats();}
                    else {
                    start_resultats_negatif();
                    }
                }

            });

            alert.show();
        }


        mQuestion=mQuestionBank[mIndex].getmQuestionID();
        mQuestionTextView.setText(mQuestion);

        mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        mScoreTextView.setText("Symptômes "+mScore+"/"+mQuestionBank.length);
    }



    private void checkAnswer(boolean userSelection){
        boolean correctAnswer = mQuestionBank[mIndex].ismAnswer();


        if (userSelection==correctAnswer){

            //Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
            mScore=mScore+1;

        }else
        {
           // Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putInt("ScoreKey",mScore);
        outState.putInt("IndexKey",mIndex);

    }
    public void start_resultats() {
        Intent inf =new Intent(this, ResulatPatientActivity.class);
        startActivity(inf);
    }
    private void start_resultats_negatif() {
        Intent inf =new Intent(this, NegatifResultatActivity.class);
        startActivity(inf);
    }
}