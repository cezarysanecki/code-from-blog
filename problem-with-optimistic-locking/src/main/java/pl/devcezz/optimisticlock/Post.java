package pl.devcezz.optimisticlock;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String content;

    private String author;

    //... other fields

    @Version
    private Long version;

    static Post of(PostDto dto) {
        Post post = new Post();
        post.content = dto.content();
        //... others assignments

        return post;
    }

    public void changeContent(String changedContent) {
        content = changedContent;
    }

    public Long getPostId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    //... other methods, getters & setters
}
