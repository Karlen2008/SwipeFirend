
package com.example.swipefriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import com.wefika.flowlayout.FlowLayout;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import Model.Keyword;
public class questions extends AppCompatActivity {
    List<String> answers = new ArrayList<>();
    int ActivityId = 0;

private FlowLayout mflowLayout;
 Button NextButton;
TextView questionText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        NextButton = findViewById(R.id.nextbutton);
        mflowLayout = findViewById(R.id.flow_layout);
   questionText = findViewById(R.id.textView3);

setData(new String[] {"Reading", "Exploring", "Creativity", "Sports", "Watching movies and series", "Socializing with friends", "Traveling",  "Entertainment events", "Gaming", "Cooking", "Learning"});





        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              switch (ActivityId)
              {

                case 1:
                    questionText.setText("Choose from the following options those that best describe your personal preferences and interests:");
                    setData(new String[] {"Nature walks", "Technology gadgets", "Art exhibitions", "Live concerts", "Culinary adventures", "DIY projects", "Fitness classes", "Board games", "Photography", "Music festivals", "Language learning"});


                    break;
                  case 2:
                      questionText.setText("What are your favorite movie genres?");
                      setData(new String[]{
                              "Action",
                              "Comedy",
                              "Drama",
                              "Science Fiction",
                              "Fantasy",
                              "Romance",
                              "Thriller",
                              "Horror",
                              "Documentary",
                              "Animated",
                              "Mystery",
                              "Adventure"
                      });
                      break;
                  case 3:
                      questionText.setText("What are your favorite music genres?");
                      setData(new String[]{
                              "Pop",
                              "Rock",
                              "Hip-Hop",
                              "Jazz",
                              "Electronic",
                              "Classical",
                              "Country",
                              "R&B",
                              "Indie",
                              "Reggae",
                              "Metal",
                              "Folk",
                              "I don't listen to music"
                      });
                      break;
                  case 4:

                      String dreamDestinationsQuestion = "If you could travel to any destination in the world, which would be your dream destination?";


                      setData(new String[]  {
                              "Bora Bora, French Polynesia",
                              "Kyoto, Japan",
                              "Santorini, Greece",
                              "Marrakech, Morocco",
                              "Banff National Park, Canada",
                              "New York City, USA",
                              "Cape Town, South Africa",
                              "Venice, Italy",
                              "Sydney, Australia",
                              "Machu Picchu, Peru",
                              "Reykjavik, Iceland"
                      });
NextButton.setText("Finish");
                      break;
                  case 5:
Intent intent = new Intent(questions.this, Personalinfo.class);
                      intent.putStringArrayListExtra("answers", new ArrayList<>(answers));
startActivity(intent);
                      break;






              }

            }
        });
    }

    private void setData(String[] mListKeyword) {
ActivityId++;
        if (mflowLayout == null) {
            return;
        }

        mflowLayout.removeAllViews();

        if (mListKeyword != null && mListKeyword.length > 0) {
            for (int i = 0; i < mListKeyword.length; i++) {
                String keyword = mListKeyword[i];
                TextView textView = new TextView(this);

                FlowLayout.LayoutParams params = new FlowLayout.LayoutParams(
                        FlowLayout.LayoutParams.WRAP_CONTENT,
                        FlowLayout.LayoutParams.WRAP_CONTENT
                );

            //    params.setMargins(0, 0, 16, 15);

                float scale = getResources().getDisplayMetrics().density;
                params.rightMargin =  (dpToPixels(16));
                params.topMargin =  (dpToPixels(15) );
                textView.setLayoutParams(params);

                Typeface typeface = Typeface.create("roboto", Typeface.NORMAL);
                textView.setTypeface(typeface);

                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                textView.setText(keyword);

                textView.setTextColor(getResources().getColor(R.color.black));
                textView.setBackgroundResource(R.drawable.box_);
                textView.setGravity(Gravity.CENTER);
                textView.setPadding(dpToPixels(12), dpToPixels(3), dpToPixels(12) , dpToPixels(3));



                mflowLayout.addView(textView);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Object tag = textView.getTag();

                        if (tag == null || (int) tag == R.drawable.box_) {
                            textView.setBackgroundResource(R.drawable.box_blue);
                            textView.setTag(R.drawable.box_blue);
                            answers.add(textView.getText().toString());
                        } else if ((int) tag == R.drawable.box_blue) {
                            textView.setBackgroundResource(R.drawable.box_);
                            textView.setTag(R.drawable.box_);
                            answers.remove(answers.indexOf(textView.getText().toString()));
                        }
                    }
                });


            }
        }
    }


    private int dpToPixels(float dp) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
    private List<Keyword> makeData()
    {
        List<Keyword>  mListKeyword = new ArrayList<>();
        mListKeyword.add(new Keyword( "TinCoder"));
        mListKeyword.add(new Keyword( "Tin"));
        mListKeyword.add(new Keyword( "Android Studio"));
        mListKeyword.add(new Keyword( "The eyes chico they"));
        mListKeyword.add(new Keyword("Coder"));
        mListKeyword.add(new Keyword("Professionaltiy"));
        mListKeyword.add(new Keyword("Monster"));
        mListKeyword.add(new Keyword( "TinCoder"));
        mListKeyword.add(new Keyword("Tin"));
        mListKeyword.add(new Keyword( "Android Studio"));
        mListKeyword.add(new Keyword("The eyes chico they"));
return mListKeyword;
    }

}