import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.types.Page;
import com.restfb.types.Post;

import java.util.ArrayList;
import java.util.List;

class MyPostClass {

    private List<Post> postList = new ArrayList<>();

    MyPostClass(String pageId, FacebookClient facebookClient) {
        Page page = facebookClient.fetchObject(pageId, Page.class);
        Connection<Post> posts = facebookClient.fetchConnection(page.getId()+"/feed", Post.class);
        for (List<Post> post : posts) {
            postList.addAll(post);
        }
    }

    Post getPostById(String postId) {
        Post mPost = new Post();
        for (Post aPost : postList) {
            if (aPost.getId().equals(postId))
                mPost = aPost;
        }
        return mPost;
    }

    String[] getPostIds() {
        List<String> postIDs = new ArrayList<>();
         for (Post aPost : postList) {
             postIDs.add(aPost.getId());
         }
        return postIDs.toArray(new String[postIDs.size()]);
    }

}
