package uz.pdp.postservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.postservice.entity.Comment;
import uz.pdp.postservice.entity.PostReq;
import uz.pdp.postservice.service.PostService;
import uz.pdp.postservice.entity.Post;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<Post> getAllPost() {
        return postService.getAllPost();
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @PostMapping("/comment/{id}")
    public Comment createComment(@PathVariable String id, @RequestBody Comment comment) {
        return postService.savePostReq(id, comment);
    }

    @GetMapping("{id}")
    public PostReq getPostById(@PathVariable String id) {
        return postService.getPostById(id);
    }

    @PutMapping("{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable String id) {
        postService.deletePostById(id);
    }
}
