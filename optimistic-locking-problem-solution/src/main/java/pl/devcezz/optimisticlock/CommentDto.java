package pl.devcezz.optimisticlock;

public record CommentDto(Long postId, String content, String author) {
}
