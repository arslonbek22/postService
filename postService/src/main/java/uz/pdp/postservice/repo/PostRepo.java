package uz.pdp.postservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import uz.pdp.postservice.entity.Post;

public interface PostRepo extends MongoRepository<Post, String> {

}
