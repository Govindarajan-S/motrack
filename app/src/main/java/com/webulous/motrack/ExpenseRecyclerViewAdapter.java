package com.webulous.motrack;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.webulous.motrack.ExpenseFragment.OnListFragmentInteractionListener;
import com.webulous.motrack.dummy.ExpenseContent;
import com.webulous.motrack.dummy.ExpenseContent.ExpenseItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ExpenseItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ExpenseRecyclerViewAdapter extends RecyclerView.Adapter<ExpenseRecyclerViewAdapter.ViewHolder> {

    private final List<ExpenseContent.ExpenseItem> mValues;
//    private final OnListFragmentInteractionListener mListener;

    public ExpenseRecyclerViewAdapter(List<ExpenseContent.ExpenseItem> items) {
        mValues = items;
//        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expense_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.descTxtView.setText(mValues.get(position).description);
        holder.costTxtView.setText(mValues.get(position).cost);
        holder.noteTxtView.setText(mValues.get(position).note);

//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null != mListener) {
//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView descTxtView;
        public final TextView costTxtView;
        public final TextView noteTxtView;
        public ExpenseContent.ExpenseItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            descTxtView = (TextView) view.findViewById(R.id.expense_description);
            costTxtView = (TextView) view.findViewById(R.id.expense_cost);
            noteTxtView = (TextView) view.findViewById(R.id.expense_note);
        }

        @Override
        public String toString() {
            return super.toString() + " '" +
                    descTxtView.getText() + ", " + costTxtView.getText() + ", " +
                    noteTxtView.getText() + "'";
        }
    }
}
