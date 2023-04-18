package pl.devcezz.optimisticlock;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PostMeters {

    private static final Long ZERO = 0L;

    @GeneratedValue
    @Id
    private Long id;

    private Long postId;

    private Long numberOfComments = ZERO;

    private Long numberOfLikes = ZERO;

    private Long numberOfShares = ZERO;

    public PostMeters() {
    }

    public PostMeters(Long postId) {
        this.postId = postId;
    }

    public void increaseNumberOfComments() {
        numberOfComments++;
    }

    public void decreaseNumberOfComments() {
        if (numberOfComments < 0) {
            throw new IllegalStateException("number of comments cannot be negative");
        }
        numberOfComments--;
    }

    public void increaseNumberOfLikes() {
        numberOfLikes++;
    }

    public void decreaseNumberOfLikes() {
        if (numberOfLikes < 0) {
            throw new IllegalStateException("number of likes cannot be negative");
        }
        numberOfLikes--;
    }

    public void increaseNumberOfShares() {
        numberOfShares++;
    }

    public void decreaseNumberOfShares() {
        if (numberOfShares < 0) {
            throw new IllegalStateException("number of shares cannot be negative");
        }
        numberOfShares--;
    }

    public Long getNumberOfComments() {
        return numberOfComments;
    }

    public Long getNumberOfLikes() {
        return numberOfLikes;
    }

    public Long getNumberOfShares() {
        return numberOfShares;
    }

    public Long getPostId() {
        return postId;
    }
}
