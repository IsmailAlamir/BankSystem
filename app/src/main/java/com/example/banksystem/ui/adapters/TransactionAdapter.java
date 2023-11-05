package com.example.banksystem.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banksystem.R;
import com.example.banksystem.data.model.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {
    List<Transaction> transactionList;
    Context context;

    public TransactionAdapter(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @NonNull
    @Override
    public TransactionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_recent_transactions,parent,false);
        context =parent.getContext();

        return new ViewHolder(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.ViewHolder holder, int position) {
        holder.name.setText((CharSequence) transactionList.get(position).getAmount());
        holder.date.setText(transactionList.get(position).getDate());
        holder.amount.setText(transactionList.get(position).getAmount()+" JD");


        int comparisonResult = transactionList.get(position).getAmount().compareTo(new BigDecimal(0));
        if (comparisonResult < 0) {
            holder.iconPath.setImageResource(R.drawable.ic_pay_money);
            } else {
            holder.iconPath.setImageResource(R.drawable.ic_receive_money);
            }

    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,date,amount;
        ImageView iconPath;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.transaction_name);
            date = itemView.findViewById(R.id.transaction_date);
            amount = itemView.findViewById(R.id.tv_transaction_amount);
            iconPath = itemView.findViewById(R.id.iv_money_transfer);



        }
    }
}
