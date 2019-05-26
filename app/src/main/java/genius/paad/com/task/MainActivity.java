package genius.paad.com.task;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import genius.paad.com.task.Factorial;
import genius.paad.com.task.Pairs;
import genius.paad.com.task.Palindrome;
import genius.paad.com.task.R;
import genius.paad.com.task.TabAdapter;

public class MainActivity extends AppCompatActivity  {




    // This tag is used in console log output.
    private static final String TAG_CALCULATOR = "CALCULATOR";

    // Used to show calculate number and operator.
    private EditText resultEditText = null;

    // Record the first number before operator.
    private double firstNumber = Double.MIN_VALUE;

    // Record the second number before = operator.
    private double secondNumber = Double.MIN_VALUE;

    // Record user clicked operator.
    private String operator = "";

    private TabAdapter adapter;

    Palindrome palindrome = new Palindrome();
    Factorial factorial = new Factorial();
    Pairs pairs = new Pairs();



    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager  viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.button_0)
    Button button0;
    @BindView(R.id.button_1)
    Button button1;
    @BindView(R.id.button_2)
    Button button2;
    @BindView(R.id.button_3)
    Button button3;
    @BindView(R.id.button_4)
    Button button4;
    @BindView(R.id.button_5)
    Button button5;
    @BindView(R.id.button_6)
    Button button6;

    @BindView(R.id.button_7)
    Button button7;
    @BindView(R.id.button_8)
    Button button8;
    @BindView(R.id.button_9)
    Button button9;
    @BindView(R.id.b)
    ImageButton b;

    @BindView(R.id.button_done)
    Button done;




    @OnClick(R.id.button_0)
    public void onClick() {
        append(button0, tabLayout.getSelectedTabPosition());
    }
    @OnClick(R.id.button_1)
    public void onClick1() {
        append(button1, tabLayout.getSelectedTabPosition());
    }
    @OnClick(R.id.button_2)
    public void onClick2() {
        append(button2, tabLayout.getSelectedTabPosition());
    }
    @OnClick(R.id.button_3)
    public void onClick3() {
        append(button3, tabLayout.getSelectedTabPosition());
    }
    @OnClick(R.id.button_4)
    public void onClick4() {
        append(button4, tabLayout.getSelectedTabPosition());
    }
    @OnClick(R.id.button_5)
    public void onClick5() {
        append(button5, tabLayout.getSelectedTabPosition());
    }
    @OnClick(R.id.button_6)
    public void onClick6() {
        append(button6, tabLayout.getSelectedTabPosition());
    }
    @OnClick(R.id.button_7)
    public void onClick7() {
        append(button7, tabLayout.getSelectedTabPosition());
    }
    @OnClick(R.id.button_8)
    public void onClick8() {
        append(button8, tabLayout.getSelectedTabPosition());
    }
    @OnClick(R.id.button_9)
    public void onClick_9() {
        append(button9, tabLayout.getSelectedTabPosition());
    }
    @OnClick(R.id.b)
    public void onClickB() {
        b(tabLayout.getSelectedTabPosition());

    }
    @OnClick(R.id.button_done)
    public void onClickDone() {
        done(tabLayout.getSelectedTabPosition());
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        adapter = new TabAdapter(getSupportFragmentManager());



        adapter.addFragment(palindrome, this.getResources().getString(R.string.palindrome));
        adapter.addFragment(factorial, this.getResources().getString(R.string.factorial));
        adapter.addFragment(pairs, this.getResources().getString(R.string.pairs));

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new
                                                   TabLayout.OnTabSelectedListener() {
                                                       @Override
                                                       public void onTabSelected(TabLayout.Tab tab) {
                                                           viewPager.setCurrentItem(tab.getPosition());




                                                       }

                                                       @Override
                                                       public void onTabUnselected(TabLayout.Tab tab) {

                                                       }

                                                       @Override
                                                       public void onTabReselected(TabLayout.Tab tab) {

                                                       }

                                                   });


    }



    public void append(Button btn, int position){


        if (position == 0) {
            appendPalindrome(btn);
        }

        if (position == 1) {
            appendFactorial(btn);
        }

        if (position == 2) {
            appendPairs(btn);
        }


}



    public void b(int position){
        if (position==0){
         if    (palindrome._text.length()==0){
             return;
         }
            palindrome._text.setText( palindrome._text.getText().subSequence(0,palindrome._text.getText().length()-1));
            palindrome._text.setSelection(palindrome._text.getText().length());
        }

        if (position==1){
            if    (factorial._text.length()==0){
                return;
            }
            factorial._text.setText(factorial._text.getText().subSequence(0,factorial._text.getText().length()-1));
            factorial._text.setSelection(factorial._text.getText().length());
        }


        if (position==2){
            if    (pairs._text.length()==0){
                return;
            }
            pairs._text.setText(pairs._text.getText().subSequence(0,pairs._text.getText().length()-1));
            pairs._text.setSelection(pairs._text.getText().length());
        }
    }



    public void done(int position){

        if (position==0){

            palindrome.calculate.callOnClick();

            }

        if (position==1){
            factorial.calculate.callOnClick();

        }

        if (position==2){
            pairs.calculate.callOnClick();

        }

        }

       public void  appendPalindrome(Button btn){
           if (btn == button0) {
               palindrome._text.setText(palindrome._text.getText()+"0");
               palindrome._text.setSelection(palindrome._text.getText().length());
           }
           if (btn == button1) {
               palindrome._text.setText(palindrome._text.getText().toString() + "1");
               palindrome._text.setSelection(palindrome._text.getText().length());

           }
           if (btn == button2) {
               palindrome._text.setText(palindrome._text.getText().toString() + "2");
               palindrome._text.setSelection(palindrome._text.getText().length());

           }
           if (btn == button3) {
               palindrome._text.setText(palindrome._text.getText().toString() + "3");
               palindrome._text.setSelection(palindrome._text.getText().length());

           }
           if (btn == button4) {
               palindrome._text.setText(palindrome._text.getText().toString() + "4");
               palindrome._text.setSelection(palindrome._text.getText().length());

           }
           if (btn == button5) {
               palindrome._text.setText(palindrome._text.getText().toString() + "5");
               palindrome._text.setSelection(palindrome._text.getText().length());

           }
           if (btn == button6) {
               palindrome._text.setText(palindrome._text.getText().toString() + "6");
               palindrome._text.setSelection(palindrome._text.getText().length());

           }
           if (btn == button7) {
               palindrome._text.setText(palindrome._text.getText().toString() + "7");
               palindrome._text.setSelection(palindrome._text.getText().length());

           }
           if (btn == button8) {
               palindrome._text.setText(palindrome._text.getText().toString() + "8");
               palindrome._text.setSelection(palindrome._text.getText().length());

           }
           if (btn == button9) {
               palindrome._text.setText(palindrome._text.getText().toString() + "9");
               palindrome._text.setSelection(palindrome._text.getText().length());

           }

        }

    public void  appendFactorial(Button btn){
        if (btn == button0) {
            int i = 0;
            factorial._text.setText(factorial._text.getText().toString()+ 0);
            factorial._text.setSelection( factorial._text.getText().length());

        }
        if (btn == button1) {
            factorial._text.setText(factorial._text.getText().toString() + "1");
            factorial._text.setSelection( factorial._text.getText().length());

        }
        if (btn == button2) {
            factorial._text.setText(factorial._text.getText().toString() + "2");
            factorial._text.setSelection( factorial._text.getText().length());

        }
        if (btn == button3) {
            factorial._text.setText(factorial._text.getText().toString() + "3");
            factorial._text.setSelection( factorial._text.getText().length());

        }
        if (btn == button4) {
            factorial._text.setText(factorial._text.getText().toString() + "4");
            factorial._text.setSelection( factorial._text.getText().length());

        }
        if (btn == button5) {
            factorial._text.setText(factorial._text.getText().toString() + "5");
            factorial._text.setSelection( factorial._text.getText().length());

        }
        if (btn == button6) {
            factorial._text.setText(factorial._text.getText().toString() + "6");
            factorial._text.setSelection( factorial._text.getText().length());

        }
        if (btn == button7) {
            factorial._text.setText(factorial._text.getText().toString() + "7");
            factorial._text.setSelection( factorial._text.getText().length());

        }
        if (btn == button8) {
            factorial._text.setText(factorial._text.getText().toString() + "8");
            factorial._text.setSelection( factorial._text.getText().length());

        }
        if (btn == button9) {
            factorial._text.setText(factorial._text.getText().toString() + "9");
            factorial._text.setSelection( factorial._text.getText().length());

        }

    }

    public void  appendPairs(Button btn){
        if (btn == button0) {

            pairs._text.setText(pairs._text.getText().toString() + 0 );
            pairs._text.setSelection( pairs._text.getText().length());

        }
        if (btn == button1) {
            pairs._text.setText(pairs._text.getText().toString() + "1");
            pairs._text.setSelection( pairs._text.getText().length());

        }
        if (btn == button2) {
            pairs._text.setText(pairs._text.getText().toString() + "2");
            pairs._text.setSelection( pairs._text.getText().length());

        }
        if (btn == button3) {
            pairs._text.setText(pairs._text.getText().toString() + "3");
            pairs._text.setSelection( pairs._text.getText().length());

        }
        if (btn == button4) {
            pairs._text.setText(pairs._text.getText().toString() + "4");
            pairs._text.setSelection( pairs._text.getText().length());

        }
        if (btn == button5) {
            pairs._text.setText(pairs._text.getText().toString() + "5");
            pairs._text.setSelection( pairs._text.getText().length());

        }
        if (btn == button6) {
            pairs._text.setText(pairs._text.getText().toString() + "6");
            pairs._text.setSelection( pairs._text.getText().length());

        }
        if (btn == button7) {
            pairs._text.setText(pairs._text.getText().toString() + "7");
            pairs._text.setSelection( pairs._text.getText().length());

        }
        if (btn == button8) {
            pairs._text.setText(pairs._text.getText().toString() + "8");
            pairs._text.setSelection( pairs._text.getText().length());

        }
        if (btn == button9) {
            pairs._text.setText(pairs._text.getText().toString() + "9");
            pairs._text.setSelection( pairs._text.getText().length());

        }

    }





}
