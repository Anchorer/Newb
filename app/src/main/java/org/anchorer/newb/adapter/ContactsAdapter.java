package org.anchorer.newb.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.anchorer.newb.R;
import org.anchorer.newb.model.Contact;

import java.util.List;

/**
 * Adapter: Adapter for Contacts RecyclerView
 * Created by Anchorer on 16/4/27.
 */
public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private List<Contact> mContactsList;

    public ContactsAdapter(List<Contact> contactsList) {
        this.mContactsList = contactsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = mContactsList.get(position);

        holder.mNameView.setText(contact.getName());

        Button onlineBtn = holder.mOnlineBtn;
        if (contact.isOnline()) {
            onlineBtn.setText("Message");
            onlineBtn.setEnabled(true);
        } else {
            onlineBtn.setText("OffLine");
            onlineBtn.setEnabled(false);
        }
    }

    @Override
    public int getItemCount() {
        return mContactsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mNameView;
        private Button mOnlineBtn;

        public ViewHolder(View itemView) {
            super(itemView);

            mNameView = (TextView) itemView.findViewById(R.id.item_contact_name);
            mOnlineBtn = (Button) itemView.findViewById(R.id.item_contact_online);
        }
    }

}
