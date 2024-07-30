package uz.pdp.postservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.bootstrap.config.PropertySourceBootstrapConfiguration;
import org.springframework.stereotype.Service;
import uz.pdp.postservice.controller.ClientController;
import uz.pdp.postservice.entity.Comment;
import uz.pdp.postservice.entity.Post;
import uz.pdp.postservice.entity.PostReq;
import uz.pdp.postservice.repo.PostRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {


    private final PostRepo postRepo;

    private final ClientController clientController;

    public List<Post> getAllPost() {
        return postRepo.findAll();
    }

    public Post savePost(Post post) {
        return postRepo.save(post);
    }

    public Comment savePostReq(String postId, Comment comment) {
        Comment comment1 = clientController.addComment(postId, comment);
        return comment1;
    }

    public PostReq getPostById(String id) {
        Optional<Post> byId = postRepo.findById(id);
        PostReq postReq = new PostReq();
        if (byId.isPresent()) {
            Post post = byId.get();
            postReq.setPost(post);
            postReq.setComments(clientController.getComments(post.getId()));
            return postReq;
        }
        return null;
    }

    public Post updatePost(String id, Post post) {
        Post post1 = postRepo.findById(id).orElse(null);
        if (post1 != null) {
            post1.setTitle(post.getTitle());
            return postRepo.save(post1);
        }
        return null;
    }

    public void deletePostById(String id) {
        clientController.deleteComment(id);
        postRepo.deleteById(id);
    }
}
