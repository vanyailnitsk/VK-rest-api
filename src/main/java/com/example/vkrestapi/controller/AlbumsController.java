package com.example.vkrestapi.controller;

import com.example.vkrestapi.models.Album;
import com.example.vkrestapi.models.Photo;
import com.example.vkrestapi.service.AlbumsService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/albums")
@RequiredArgsConstructor
public class AlbumsController {
    private final AlbumsService albumsService;

    @GetMapping
    public List<Album> getAlbums(@SpringQueryMap Map<String,Object> params) {
        return albumsService.getAlbums(params);
    }

    @GetMapping("{albumId}")
    public Album getAlbum(@PathVariable Integer albumId) {
        return albumsService.getAlbum(albumId);
    }

    @GetMapping("{albumId}/photos")
    public List<Photo> getAlbumPhotos(@PathVariable Integer albumId) {
        return albumsService.getAlbumPhotos(albumId);
    }

    @PostMapping
    public Album createAlbum(@RequestBody Album album) {
        return albumsService.createAlbum(album);
    }

    @PutMapping("{albumId}")
    public Album updateAlbum(@PathVariable Integer albumId, @RequestBody Album album) {
        return albumsService.updateAlbum(albumId,album);
    }

    @PatchMapping("{albumId}")
    public Album editAlbum(@PathVariable Integer albumId, @RequestBody Map<String, Object> album) {
        return albumsService.editAlbum(albumId,album);
    }

    @DeleteMapping("{albumId}")
    public void deleteAlbum(@PathVariable Integer albumId) {
        albumsService.deleteAlbum(albumId);
    }
}
