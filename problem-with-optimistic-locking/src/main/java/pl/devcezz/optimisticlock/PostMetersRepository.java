package pl.devcezz.optimisticlock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostMetersRepository extends JpaRepository<PostMeters, Long> {

    Optional<PostMeters> findByPostId(Long postId);

    @Modifying
    @Query(
            value = "UPDATE post_meters SET number_of_comments = number_of_comments + 1 WHERE post_id = :#{postId}",
            nativeQuery = true
    )
    void increaseNumberOfComments(Long postId);

    @Modifying
    @Query(
            value = "UPDATE post_meters SET number_of_comments = number_of_comments - 1 WHERE post_id = :#{postId}",
            nativeQuery = true
    )
    void decreaseNumberOfComments(Long postId);

    @Modifying
    @Query(
            value = "UPDATE post_meters SET number_of_likes = number_of_likes + 1 WHERE post_id = :#{postId}",
            nativeQuery = true
    )
    void increaseNumberOfLikes(Long postId);

    @Modifying
    @Query(
            value = "UPDATE post_meters SET number_of_likes = number_of_likes - 1 WHERE post_id = :#{postId}",
            nativeQuery = true
    )
    void decreaseNumberOfLikes(Long postId);

    @Modifying
    @Query(
            value = "UPDATE post_meters SET number_of_shares = number_of_shares + 1 WHERE post_id = :#{postId}",
            nativeQuery = true
    )
    void increaseNumberOfShares(Long postId);

    @Modifying
    @Query(
            value = "UPDATE post_meters SET number_of_shares = number_of_shares - 1 WHERE post_id = :#{postId}",
            nativeQuery = true
    )
    void decreaseNumberOfShares(Long postId);
}
