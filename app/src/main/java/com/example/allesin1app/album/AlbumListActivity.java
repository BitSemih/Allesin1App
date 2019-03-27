package com.example.allesin1app.album;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.allesin1app.GlobalVars;
import com.example.allesin1app.R;

import java.util.ArrayList;

public class AlbumListActivity extends AppCompatActivity {
    private ArrayList<Album> albums = new ArrayList<>();
    private ArrayList<String> albumNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GlobalVars gv = (GlobalVars) getApplicationContext();
        albums = gv.adp.getAlbums();
        for (Album album : albums) {
            albumNames.add(album.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.generic_list_item, albumNames);

        ListView listView = findViewById(R.id.albumList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView c = view.findViewById(R.id.label);
                String albumName = c.getText().toString();
                Album album = gv.adp.findAlbumByName(albumName);
                goToAlbum(album.getId());
            }
        });
    }

    public void goToAlbum(int albumId){
        Intent intent = new Intent(this, AlbumActivity.class);
        intent.putExtra("album id", albumId);
        startActivity(intent);
    }

    public void goAddAlbum(View view) {
        Intent intent = new Intent(this, AlbumAddActivity.class);
        startActivity(intent);
    }
}
