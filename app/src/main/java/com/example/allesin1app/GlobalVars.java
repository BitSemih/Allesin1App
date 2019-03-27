package com.example.allesin1app;

import android.app.Application;

import com.example.allesin1app.album.Album;
import com.example.allesin1app.album.AlbumDataProvider;

import java.util.ArrayList;

public class GlobalVars extends Application {
    public AlbumDataProvider adp = new AlbumDataProvider();
}
