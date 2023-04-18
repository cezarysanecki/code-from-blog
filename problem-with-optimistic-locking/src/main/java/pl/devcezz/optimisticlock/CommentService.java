package pl.devcezz.optimisticlock;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {

    private final PostMetersRepository postMetersRepository;
    private final CommentRepository commentRepository;

    public CommentService(PostMetersRepository postMetersRepository, CommentRepository commentRepository) {
        this.postMetersRepository = postMetersRepository;
        this.commentRepository = commentRepository;
    }

    @Transactional
    public void addComment(CommentDto dto) {
        postMetersRepository.findByPostId(dto.postId())
                .ifPresentOrElse(
                        PostMeters::increaseNumberOfComments,
                        () -> { throw new IllegalArgumentException("post meters not found for post id: " + dto.postId()); }
                );

        Comment comment = new Comment(dto.author(), dto.content(), dto.postId());
        commentRepository.save(comment);
    }

    //... other methods
}
