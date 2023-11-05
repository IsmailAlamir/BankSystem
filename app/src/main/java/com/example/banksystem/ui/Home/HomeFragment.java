package com.example.banksystem.ui.Home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.banksystem.R;
import com.example.banksystem.data.model.Transaction;
import com.example.banksystem.ui.Login.LoginActivity;
import com.example.banksystem.ui.adapters.TransactionAdapter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;


public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {
        // Required empty public constructor
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
        View v= inflater.inflate(R.layout.fragment_home, container, false);
        TextView totalBalance= v.findViewById(R.id.tv_total_balance);
        ImageView toggle= v.findViewById(R.id.iv_toggle_total_balance);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView allView=v.findViewById(R.id.tv_view_all_transactions);


        ArrayList<Transaction> transactions = new ArrayList<>();
        // TODO : API required , only 5 items
        transactions.add(new Transaction("Tariq","13th March 2023", 10.00d ));
        transactions.add(new Transaction("Ismail","14th March 2023", -100.50d ));
        transactions.add(new Transaction("Ismail","14th March 2023", -100.50d ));
        transactions.add(new Transaction("Ismail","14th March 2023", -100.50d ));
        transactions.add(new Transaction("Ismail","14th March 2023", -100.50d ));
        transactions.add(new Transaction("Ismail","14th March 2023", -100.50d ));
        transactions.add(new Transaction("Ismail","14th March 2023", -100.50d ));
        transactions.add(new Transaction("Ismail","14th March 2023", -100.50d ));



        RecyclerView transactionRecyclerView= v.findViewById(R.id.rv_recent_transactions);
        transactionRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext(),LinearLayoutManager.VERTICAL,false));

        TransactionAdapter transactionAdapter =new TransactionAdapter(transactions);
        transactionRecyclerView.setAdapter(transactionAdapter);



        // TODO : change the activity
        allView.setOnClickListener(view -> {
            Intent intent = new Intent(HomeFragment.this.getActivity(), LoginActivity.class);
            startActivity(intent);
        });


        // TODO : make it dynamic
        double amount= 10;
        String formattedAmount = String.format("%.3f", amount); // 10. 000

        String accountNumberPlaceholder = getString(R.string.var_total_balance,formattedAmount);
//        String formattedUsername = String.format(accountNumberPlaceholder, "ssss");
        totalBalance.setText(accountNumberPlaceholder);




        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totalBalance.getTransformationMethod() instanceof PasswordTransformationMethod) {
                    totalBalance.setTransformationMethod(null);
                    toggle.setImageResource(R.drawable.ic_visibility_on);
                } else {
                    toggle.setImageResource(R.drawable.ic_visibility_off);
                    totalBalance.setTransformationMethod(new PasswordTransformationMethod());
                }

            }
        });


        return v;
    }


}

