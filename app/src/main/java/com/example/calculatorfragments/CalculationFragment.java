package com.example.calculatorfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalculationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculationFragment extends Fragment {

    TextView textView;
    Double firstValues;
    Double secondValues;
    Double result;
    String operation;
    Fragment fragment;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CalculationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalculationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalculationFragment newInstance(String param1, String param2) {
        CalculationFragment fragment = new CalculationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.text_view);

         Button save = view.findViewById(R.id.save);
save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       String someText = String.valueOf(result.doubleValue());
        fragment=new CalculationFragment();
        Bundle bundle=new Bundle();
        bundle.putString("result",someText);
        fragment.setArguments(bundle);
           Log.d("ololo", someText);

    }
});
        Button zero = view.findViewById(R.id.zero);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("0");
            }
        });
        Button one = view.findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("1");
            }
        });
        Button two = view.findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("2");
            }
        });
        Button three = view.findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("3");
            }
        });
        Button four = view.findViewById(R.id.four);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("4");
            }
        });
        Button five = view.findViewById(R.id.five);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("5");
            }
        });
        Button six = view.findViewById(R.id.six);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("6");
            }
        });
        Button seven = view.findViewById(R.id.seven);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("7");
            }
        });
        Button eight = view.findViewById(R.id.eight);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("8");
            }
        });
        Button nine = view.findViewById(R.id.nine);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("9");
            }
        });
        Button comma = view.findViewById(R.id.comma);
        comma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append(".");
            }
        });
        Button cancel = view.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
            }
        });


        Button plus = view.findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "+";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "+");
            }
        });
        Button minus = view.findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "-";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "-");
            }
        });
        Button division = view.findViewById(R.id.division);
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "/";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "/");
            }
        });
        Button multiplication = view.findViewById(R.id.multiplication);
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "X";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "X");
            }
        });
        Button equally=view.findViewById(R.id.equally);
        equally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

           if (textView != null) { String second = textView.getText().toString().replace(firstValues + operation + "", "");
                 secondValues = Double.valueOf(second);}
                    switch (operation) {
                        case "+":
                            result = firstValues + secondValues;
                            textView.setText(firstValues + "+" + secondValues + "=" + result);
                            break;
                        case "-":
                            result = firstValues - secondValues;
                            textView.setText(firstValues + "-" + secondValues + "=" + result);
                            break;
                        case "/":
                            result = firstValues / secondValues;
                            textView.setText(firstValues + "/" + secondValues + "=" + result);
                            break;
                        case "X":
                            result = firstValues * secondValues;
                            textView.setText(firstValues + "X" + secondValues + "=" + result);
                            break;

                    }


            }
        });
    }
}

