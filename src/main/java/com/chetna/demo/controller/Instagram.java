package com.chetna.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chetna.demo.model.ChangePasswordRequest;
import com.chetna.demo.model.ChangePasswordResponse;
import com.chetna.demo.model.CommentRequest;
import com.chetna.demo.model.CommentResponse;
import com.chetna.demo.model.DeletePostResponse;
import com.chetna.demo.model.GetCommentResponse;
import com.chetna.demo.model.GetPostResponse;
import com.chetna.demo.model.LikesRequest;
import com.chetna.demo.model.LikesResponse;
import com.chetna.demo.model.LoginRequest;
import com.chetna.demo.model.LoginResponse;
import com.chetna.demo.model.PostRequest;
import com.chetna.demo.model.PostResponse;
import com.chetna.demo.model.RegisterRequest;
import com.chetna.demo.model.RegisterResponse;
import com.chetna.demo.service.InstagramService;

@Controller
public class Instagram {

    @Autowired
    InstagramService instagramService;
    public Instagram(){

    }

    @PostMapping(value = "/register")
    public @ResponseBody RegisterResponse instagramResponse(@RequestBody RegisterRequest instagramRequest)
    {
        RegisterResponse instaResponse = instagramService.instagramResponse(instagramRequest);
        return instaResponse;
    }

    @PostMapping(value = "/login")
    public @ResponseBody LoginResponse loginResponse(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = instagramService.loginResponse(loginRequest);
        return loginResponse;
    }

    @PostMapping(value = "/forgotpassword")
    public @ResponseBody ChangePasswordResponse changePasswordResponse(@RequestBody ChangePasswordRequest changePasswordRequest){
        ChangePasswordResponse changePasswordResponse = instagramService.changePasswordResponse(changePasswordRequest);
        return changePasswordResponse;
    }

    @PostMapping(value = "/post")
    public @ResponseBody PostResponse post(@RequestBody PostRequest postRequest){
        PostResponse postResponse = instagramService.post(postRequest);
        return postResponse;
    }

    @PostMapping(value = "/likes")
    public @ResponseBody LikesResponse like(@RequestBody LikesRequest likesRequest){
        LikesResponse likesResponse = instagramService.likes(likesRequest);
        return likesResponse;
    }

    @PostMapping(value = "/comment")  
    public @ResponseBody CommentResponse comment(@RequestBody CommentRequest commentRequest){
        CommentResponse commentResponse = instagramService.comment(commentRequest);
        return commentResponse;
    }

    @GetMapping(value = "/getcomment")
    public @ResponseBody GetCommentResponse getComment(){
        GetCommentResponse getComment = instagramService.getComment();
        return getComment;
    }

    @GetMapping(value = "/getPost")
    public @ResponseBody GetPostResponse getPost(){
        GetPostResponse getPost = instagramService.getPost();
        return getPost;
    }

    @DeleteMapping(value = "/deletePost")
    public @ResponseBody DeletePostResponse deletePost(){
        DeletePostResponse deletePost =  instagramService.deletePost();
        return deletePost;
    }

}
