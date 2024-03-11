package com.example.vkrestapi.service;

import com.example.vkrestapi.client.AlbumsClient;
import com.example.vkrestapi.models.Album;
import com.example.vkrestapi.models.Photo;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AlbumsService {
    private final AlbumsClient albumsClient;

    public List<Album> getAlbums(@SpringQueryMap Map<String,Object> params) {
        return albumsClient.getAlbums(params);
    }

    public Album getAlbum(@PathVariable Integer albumId) {
        return albumsClient.getAlbum(albumId);
    }

    public List<Photo> getAlbumPhotos(@PathVariable Integer albumId) {
        return albumsClient.getAlbumPhotos(albumId);
    }

    public Album createAlbum(@RequestBody Album album) {
        return albumsClient.createAlbum(album);
    }

    public Album updateAlbum(@PathVariable Integer albumId, @RequestBody Album album) {
        return albumsClient.updateAlbum(albumId,album);
    }

    public Album editAlbum(@PathVariable Integer albumId, @RequestBody Map<String, Object> album) {
        return albumsClient.editAlbum(albumId,album);
    }

    public void deleteAlbum(@PathVariable Integer albumId) {
        albumsClient.deleteAlbum(albumId);
    }
}
