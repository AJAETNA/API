package com.chetna.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chetna.demo.entity.UserActivityEntity;
import com.chetna.demo.entity.UserEntity;
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

@Service
public class InstagramService {
    
    @Autowired
    UserEntity userEntity;

    @Autowired
    UserActivityEntity userActivityEntity;

    public InstagramService(){

    }

    public RegisterResponse instagramResponse(RegisterRequest instagramRequest){
        RegisterResponse instaResponse = new RegisterResponse();
        instaResponse.setMessage("Register Successfully");

        userEntity.setUserID(instagramRequest.getUserID());
        userEntity.setPassword(instagramRequest.getPassword());
        return instaResponse;
    }

    public LoginResponse loginResponse(LoginRequest loginRequest){
        LoginResponse logResponse = new LoginResponse();
        if(loginRequest.getUserID().equals(userEntity.getUserID()) && loginRequest.getPassword().equals(userEntity.getPassword())){
            logResponse.setMessage("login Successful");
        } else {
            logResponse.setMessage("Incorrect details");
        }
        return logResponse;
    }

    public ChangePasswordResponse changePasswordResponse(ChangePasswordRequest changePasswordRequest){
        ChangePasswordResponse changepassword = new ChangePasswordResponse();
        if(!changePasswordRequest.getNewPassword().equals(userEntity.getPassword())){
            changepassword.setMessage("Password changed");
        } else {
            changepassword.setMessage("Password is same");
        }
        userEntity.setPassword(changePasswordRequest.getNewPassword());
        return changepassword;
    }

    public PostResponse post(PostRequest postRequest){
        PostResponse postResponse = new PostResponse();
        postResponse.setMessage("Post Created");
        userActivityEntity.setTitle(postRequest.getTitle());
        userActivityEntity.setBody(postRequest.getBody());
        return postResponse;
    }

    public LikesResponse likes(LikesRequest likesRequest){
        LikesResponse likesResponse = new LikesResponse();
        likesResponse.setMessage("liked");
        userActivityEntity.setLike(likesRequest.getLikes());
        return likesResponse;
    }

    public CommentResponse comment(CommentRequest commentRequest){
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setMessage("Comment Created");

        // userActivityEntity.getComments().add(commentRequest.getComment());

         List<String> l = userActivityEntity.getComments();
         String c = commentRequest.getComment();
         l.add(c);
         userActivityEntity.setComments(l);


        //  userActivityEntity.setComment(commentRequest.getComment());
        return commentResponse;
    }

    public GetCommentResponse getComment(){
        GetCommentResponse getCommentResponse = new GetCommentResponse();
        getCommentResponse.setComments(userActivityEntity.getComments());
        return getCommentResponse;
    }

    public GetPostResponse getPost(){
        GetPostResponse getpostResponse = new GetPostResponse();
        getpostResponse.setTitle(userActivityEntity.getTitle());
        getpostResponse.setBody(userActivityEntity.getBody());
        getpostResponse.setLikes(userActivityEntity.getLike());
        getpostResponse.setComments(userActivityEntity.getComments());
        return getpostResponse;
    }

    public DeletePostResponse deletePost(){
        DeletePostResponse deletePostResponse = new DeletePostResponse();
        userActivityEntity.setComments(new ArrayList<String>());
        deletePostResponse.setDeletePost("Post Deleted");
        return deletePostResponse;
    }
}
