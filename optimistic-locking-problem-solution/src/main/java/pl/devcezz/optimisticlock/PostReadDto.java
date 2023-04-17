package pl.devcezz.optimisticlock;

public record PostReadDto(String content, String author,
                          Long numberOfComments, Long numberOfLikes, Long numberOfShares) {

    static PostReadDto from(Post post, PostMeters postMeters) {
        return new PostReadDto(
                post.getContent(),
                post.getAuthor(),
                postMeters.getNumberOfComments(),
                postMeters.getNumberOfLikes(),
                postMeters.getNumberOfShares()
        );
    }
}
