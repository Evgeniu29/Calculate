package genius.paad.com.task;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

    public class Factorial  extends Fragment {

        @BindView(R.id.textView)
        TextView textView;
        @BindView(R.id.text)
        EditText _text;
        @BindView(R.id.calculate)
        Button calculate;
        @BindView(R.id.factorial)
        TextView  factorial;

        static ArrayList<Integer> v=new ArrayList<Integer>();


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View view = inflater.inflate(R.layout.fragment_two, container, false);
            ButterKnife.bind(this, view);
            return view;
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            _text.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(!hasFocus) return;
                    int position =  _text.length();
                    _text.setSelection(position);
                }
            });
            calculate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        if (!_text.getText().toString().isEmpty() && Long.valueOf(_text.getText().toString()) < 100000) {

                            factorial.setText(String.valueOf(sumDigits(getFactorial(Integer.valueOf(_text.getText().toString())).toString())));

                        } else {
                            factorial.setText("Слишком большое значение, не хватает памяти");
                        }


                }
            });
        }


        public BigInteger getFactorial(int n) {
            BigInteger result = BigInteger.ONE;
            for (int i = 2; i <= n; i++)
                result = result.multiply(BigInteger.valueOf(i));
            return result;

        }

        public Long sumDigits(String s) {
            long sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += Long.parseLong(s.substring(i, i + 1));

            }

            return sum;

        }

        public void setText(String text){
            _text.setText(text);
        }


    }


