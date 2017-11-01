import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.types.Comment;

import java.util.ArrayList;
import java.util.List;

class MyCommentClass {

    private int commentsCount = 0;
    private String[] comments;

    MyCommentClass(String postId, FacebookClient facebookClient) {
        Connection<Comment> allComments = facebookClient.fetchConnection(postId + "/comments", Comment.class);
        List<String> commentsList = new ArrayList<>();
        for (List<Comment> postComments : allComments) {
            for (Comment comment : postComments) {
                commentsList.add(comment.getMessage());
            }
        }
        this.comments = commentsList.toArray(new String[commentsList.size()]);
        this.commentsCount = comments.length;
    }

    String[] getAllPostComments() {
        return comments;
    }

    int getCommentsCount() {
        return this.commentsCount;
    }

}
