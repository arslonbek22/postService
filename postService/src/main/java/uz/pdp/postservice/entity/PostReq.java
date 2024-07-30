package uz.pdp.postservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostReq {

    private Post post;

    private List<Comment> comments = new ArrayList<>();
}
