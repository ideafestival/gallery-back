package jonghan.gallery.board.post.bucket;

public enum BucketName {
    PROFILE_IMAGE("ap-northeast-2");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
