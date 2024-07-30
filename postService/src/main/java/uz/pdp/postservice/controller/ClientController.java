package uz.pdp.postservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import uz.pdp.postservice.entity.Comment;

import java.util.List;

@FeignClient(name = "ClientController", url = "http://localhost:8084/comment")
public interface ClientController {

    @GetMapping("{id}")
    List<Comment> getComments(@PathVariable("id") String id);

    @PostMapping("{id}")
    Comment addComment(@PathVariable("id") String id, @RequestBody Comment comment);

    @PutMapping("{id}")
    Comment updateComment(@PathVariable("id") String id, @RequestBody Comment comment);

    @DeleteMapping("{id}")
    void deleteComment(@PathVariable("id") String id);

}
