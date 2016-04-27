package org.anchorer.newb.module.contacts;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import org.anchorer.newb.adapter.ContactsAdapter;
import org.anchorer.newb.model.Contact;

import java.util.Collections;
import java.util.List;

/**
 * Touch Callback for Contacts RecyclerView.
 * Created by Anchorer on 16/4/27.
 */
public class ContactsItemTouchCallback extends ItemTouchHelper.Callback {
    private ContactsAdapter mAdapter;

    public ContactsItemTouchCallback(ContactsAdapter adapter) {
        this.mAdapter = adapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags;
        final int swipeFlags = 0;
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        } else {
            dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        }
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        final int fromPosition = viewHolder.getAdapterPosition();
        final int toPosition = target.getAdapterPosition();
        List<Contact> contactsList = mAdapter.getContactsList();

        if (fromPosition <= toPosition) {
            for (int i = fromPosition; i < toPosition; ++i) {
                Collections.swap(contactsList, i, i + 1);
            }
        } else {
            for (int i = toPosition; i > fromPosition; --i) {
                Collections.swap(contactsList, i, i - 1);
            }
        }
        mAdapter.notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }
}
