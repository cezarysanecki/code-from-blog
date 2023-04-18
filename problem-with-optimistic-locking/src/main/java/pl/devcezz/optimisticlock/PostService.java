package pl.devcezz.optimisticlock;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMetersRepository postMetersRepository;

    public PostService(PostRepository postRepository, PostMetersRepository postMetersRepository) {
        this.postRepository = postRepository;
        this.postMetersRepository = postMetersRepository;
    }

    @Transactional
    public void addPost(PostDto dto) {
        Post post = postRepository.save(Post.of(dto));
        postMetersRepository.save(new PostMeters(post.getPostId()));
    }

    @Transactional
    public void editPost(Long postId, String content) {
        postRepository.findById(postId)
                .ifPresentOrElse(
                        post -> post.changeContent(content),
                        () -> { throw new IllegalArgumentException("post not found: " + postId); }
                );
    }

    @Transactional(readOnly = true)
    public PostReadDto findPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("post not found: " + postId));

        PostMeters postMeters = postMetersRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("post meters not found for post: " + postId));

        return PostReadDto.from(post, postMeters);
    }
}
