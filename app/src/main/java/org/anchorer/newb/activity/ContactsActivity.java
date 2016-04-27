package org.anchorer.newb.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import org.anchorer.newb.R;
import org.anchorer.newb.adapter.ContactsAdapter;
import org.anchorer.newb.model.Contact;

import java.util.List;

/**
 * ContactsActivity: display RecyclerView of ContactsList
 * Created by Anchorer on 16/4/27.
 */
public class ContactsActivity extends AppCompatActivity {

    private final int PAGE_SIZE = 5;

    // Contacts RecyclerView
    private RecyclerView mContactsRecyclerView;
    private ContactsAdapter mContactsAdapter;
    private List<Contact> mContactsList;

    // Button
    private Button mAddBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("ContactsActivity");

        mContactsRecyclerView = (RecyclerView) findViewById(R.id.contacts_list);

        mContactsList = Contact.getContactsList(20);
        mContactsAdapter = new ContactsAdapter(mContactsList);

        mContactsRecyclerView.setAdapter(mContactsAdapter);
        mContactsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAddBtn = (Button) findViewById(R.id.contacts_btn_add);
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentSize = mContactsAdapter.getItemCount();
                mContactsList.addAll(Contact.getContactsList(PAGE_SIZE));
                mContactsAdapter.notifyItemRangeInserted(currentSize, PAGE_SIZE);
                mContactsRecyclerView.smoothScrollToPosition(currentSize);
            }
        });
    }
}
