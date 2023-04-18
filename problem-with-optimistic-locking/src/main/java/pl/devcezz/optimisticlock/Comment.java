package pl.devcezz.optimisticlock;

import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Service
public class Comment {

    @GeneratedValue
    @Id
    private Long id;

    private String author;

    private String content;

    private Long postId;

    @Version
    private Long version;

    public Comment() {
    }

    public Comment(String author, String content, Long postId) {
        this.author = author;
        this.content = content;
        this.postId = postId;
    }

    Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    String getAuthor() {
        return author;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    String getContent() {
        return content;
    }

    void setContent(String content) {
        this.content = content;
    }

    Long getPostId() {
        return postId;
    }

    void setPostId(Long postId) {
        this.postId = postId;
    }
}
