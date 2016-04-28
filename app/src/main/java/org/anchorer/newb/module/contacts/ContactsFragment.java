package org.anchorer.newb.module.contacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.anchorer.newb.R;
import org.anchorer.newb.adapter.ContactsAdapter;
import org.anchorer.newb.model.Contact;

/**
 * Fragment for Contacts List.
 * Created by Anchorer on 16/4/28.
 */
public class ContactsFragment extends Fragment {

    private static final String FIELD_COUNT = "count";

    private RecyclerView mRecyclerView;
    private ContactsAdapter mAdapter;

    public static ContactsFragment getInstance(int contactsCount) {
        ContactsFragment fragment = new ContactsFragment();
        Bundle data = new Bundle();
        data.putInt(FIELD_COUNT, contactsCount);
        fragment.setArguments(data);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_contacts_rv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();
    }

    private void initRecyclerView() {
        // set LayoutManager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // set Adapter
        mAdapter = new ContactsAdapter(Contact.getContactsList(getArguments().getInt(FIELD_COUNT)));
        mRecyclerView.setAdapter(mAdapter);

        // Add ItemTouchHelper
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ContactsItemTouchCallback(mAdapter));
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }
}
