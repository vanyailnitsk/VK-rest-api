package com.example.vkrestapi.client;

import com.example.vkrestapi.models.Comment;
import com.example.vkrestapi.models.Album;
import com.example.vkrestapi.models.Photo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(url = "https://jsonplaceholder.typicode.com/albums/",name="albums")
public interface AlbumsClient {

    @GetMapping
    List<Album> getAlbums(@SpringQueryMap Map<String,Object> params);

    @GetMapping("{albumId}")
    Album getAlbum(@PathVariable Integer albumId);

    @GetMapping("{albumId}/photos")
    List<Photo> getAlbumPhotos(@PathVariable Integer albumId);

    @PostMapping
    Album createAlbum(@RequestBody Album album);

    @PutMapping("{albumId}")
    Album updateAlbum(@PathVariable Integer albumId, @RequestBody Album album);

    @PatchMapping("{albumId}")
    Album editAlbum(@PathVariable Integer albumId, @RequestBody Map<String, Object> album);

    @DeleteMapping("{albumId}")
    void deleteAlbum(@PathVariable Integer albumId);
}
