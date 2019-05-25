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

import butterknife.BindView;
import butterknife.ButterKnife;

public class Palindrome  extends Fragment {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.text)
    EditText _text;
    @BindView(R.id.calculate)
    Button calculate;
    @BindView(R.id.palindrome)
    TextView palindrome;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_one, container, false);
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
                if(_text.getText().toString().trim().length() != 0) {

                    String s  = _text.getText().toString();

                    if (palindrome(s)) {
                        palindrome.setText("Palindrome");
                    } else {
                        palindrome.setText("Not Palindrome");
                    }
                }


            }
        });
    }




        public boolean palindrome (String  s) {
            int n = s.length();
            for( int i = 0; i < n/2; i++ )
                if (s.charAt(i) != s.charAt(n-i-1)) return false;
            return true;
        }

    public void setText(String text){
        _text.setText(text);
    }



}
