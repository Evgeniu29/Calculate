package genius.paad.com.task;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

import static genius.paad.com.task.Factorial.v;

public class Pairs extends Fragment {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.text)
    EditText _text;
    @BindView(R.id.calculate)
    Button calculate;
    @BindView(R.id.pairs)
    TextView pairs;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_three, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        _text.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) return;
                int position = _text.length();
                _text.setSelection(position);
            }
        });


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String s = "";

                ArrayList<String> pair = new ArrayList<String>();

                s = _text.getText().toString();


                Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(s);
                boolean b = m.find();

                if (b) {

                    s = _text.getText().toString().trim().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("[()]", "");


                    String[] strArray = s.split(",");


                    if (strArray.length >= 2 && strArray.length <= 20) {

                        if (dividesByTwo(strArray.length)) {


                            int[] int1array = StringArrToIntArr(strArray);

                            int[][] array2d = monoToBidi(int1array, int1array.length / 2, 2);


                            ArrayList<int[]> list = new ArrayList<int[]>();

                            list = findLagrestList(array2d);

                            String _pairs = "";

                            for (int i = 0; i < list.size(); i++) {
                                _pairs = _pairs + Arrays.toString(list.get(i)).toString() + " ";

                            }

                            pairs.setText(_pairs.toString());

                        }

                    }


                } else {

                        StringBuilder result = new StringBuilder();
                        for (int i = 0; i < s.length(); i++) {
                            if (i > 0) {
                                result.append(",");
                            }

                            result.append(s.charAt(i));
                        }

                        s = "";

                        s = result.toString();

                    String[] strArray = s.split(",");


                    if (strArray.length >= 2 && strArray.length <= 20) {

                        if (dividesByTwo(strArray.length)) {


                            int[] int1array = StringArrToIntArr(strArray);

                            int[][] array2d = monoToBidi(int1array, int1array.length / 2, 2);


                            ArrayList<int[]> list = new ArrayList<int[]>();

                            list = findLagrestList(array2d);

                            String _pairs = "";

                            for (int i = 0; i < list.size(); i++) {
                                _pairs = _pairs + Arrays.toString(list.get(i)).toString() + " ";

                            }

                            pairs.setText(_pairs.toString());

                        }
                    }


                }

            }



        });

    }

            public ArrayList<int[]> findLagrestList(int arr[][]) {

                ArrayList<int[]> resultSublist = new ArrayList<>();

                int result_arr[][] = {};

                int sum = 0;
                for (int i = 0; i < arr.length; i++) {
                    int[] inner_arr = arr[i];
                    int valuesum = arr[i][0] + arr[i][1];
                    if (valuesum > sum) {
                        if (resultSublist.size() > 0) {
                            for (int k = 0; k < resultSublist.size(); k++) {
                                int[] cvalue = resultSublist.get(k);
                                int summ = cvalue[0] + cvalue[1];
                                if (valuesum > summ) {
                                    resultSublist.remove(k);
                                }

                            }
                            resultSublist.add(inner_arr);
                        } else {
                            resultSublist.add(inner_arr);
                            sum = valuesum;
                        }

                    }
                }

                return resultSublist;
            }




            public static int[] StringArrToIntArr(String[] strArray) {
                int[] result = new int[strArray.length];
                for (int i = 0; i < strArray.length; i++) {
                    result[i] = Integer.parseInt(strArray[i]);
                }
                return result;
            }

            public int[][] monoToBidi(final int[] array, final int rows, final int cols) {
                if (array.length != (rows * cols))
                    throw new IllegalArgumentException("Invalid array length");

                int[][] bidi = new int[rows][cols];
                for (int i = 0; i < rows; i++)
                    System.arraycopy(array, (i * cols), bidi[i], 0, cols);

                return bidi;
            }

            public void setText(String text) {
                _text.setText(text);
            }

            static boolean dividesByTwo(int a) {
                return (a % 2 == 0);
            }


}
