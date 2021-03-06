package com.sample.bankshare.createroom;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.sample.bankshare.R;
import com.sample.bankshare.server.ServerEasyHandler;

/**
 * Activity for creating a new room.
 */

public class CreateRoomActivity extends AppCompatActivity
        implements SetUpRoomFragment.OnSetUpRoomListener {

    private String mRoomName, mRoomDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_room);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_create_room);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            Fragment fragment = SetUpRoomFragment.newInstance();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.layout_create_room_container, fragment)
                    .commit();
        }
    }

    @Override
    public void onSetUpRoom(String roomName, String roomDescription) {
        mRoomName = roomName;
        mRoomDescription = roomDescription;
    }

    // TODO: implement
    public void createRoom() {
        ServerEasyHandler.createRoom(mRoomName, mRoomDescription, new ServerEasyHandler.OnCreateRoomListener() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onFail() {

            }
        });


        finish();
    }
}
