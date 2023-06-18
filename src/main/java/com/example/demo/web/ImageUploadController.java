package com.example.demo.web;

import com.example.demo.entity.ImageModel;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping("api/image")
@CrossOrigin
public class ImageUploadController {

    @Autowired
    private ImageUploadService imageUploadService;

    @PostMapping("/upload")
    public ResponseEntity<MessageResponse> uploadImageToUser(@RequestParam("file") MultipartFile file,
                                                             Principal principal) throws IOException {
        imageUploadService.uploadImageToUser(file, principal);
        return ResponseEntity.ok(new MessageResponse("Image uploaded successfully"));
    }

    @PostMapping("/{postId}/upload")
    public ResponseEntity<MessageResponse> uploadImageToPost(@PathVariable("postId") String postId,
                                                             @RequestParam("file") MultipartFile file,
                                                             Principal principal) throws IOException {
        imageUploadService.uploadImageToPost(file, principal, Long.parseLong(postId));
        return ResponseEntity.ok(new MessageResponse("Image uploaded successfully"));
    }

    @PostMapping("/profileImage")
    public ResponseEntity<ImageModel> getImageForUser(Principal principal) throws IOException {
        ImageModel imageToUser = imageUploadService.getImageToUser(principal);
        return new ResponseEntity<>(imageToUser, HttpStatus.OK);
    }

    @PostMapping("/{postId}/image")
    public ResponseEntity<ImageModel> getImageForPost(@PathVariable("postId") String postId) throws IOException {
        ImageModel imageToPost = imageUploadService.getImageToPost(Long.parseLong(postId));
        return new ResponseEntity<>(imageToPost, HttpStatus.OK);
    }
}
