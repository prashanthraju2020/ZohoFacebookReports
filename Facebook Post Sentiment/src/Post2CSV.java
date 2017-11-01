import com.restfb.types.Post;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;

import java.util.HashMap;
import java.util.Map;

class Post2CSV {

    String[] postData(Post post, MyCommentClass myCommentClass) {

        String id = post.getId();
        String message = post.getMessage();
        String timeStamp = post.getCreatedTime().toString();
        String postSentiment = "";
        String totalComments = "";
        String commentsSentiment = "";
        try {
            RConnection rConnection = new RConnection();
            rConnection.eval("library(RSentiment)");
            rConnection.assign("post", message);
            postSentiment = rConnection.eval("calculate_sentiment(post)").asList().at(1).asString();
            if (myCommentClass.getCommentsCount() > 0) {
                totalComments = Integer.toString(myCommentClass.getCommentsCount());
                rConnection.assign("comments", myCommentClass.getAllPostComments());
                rConnection.eval("sentiData <- calculate_sentiment(comments)[2]");
                String commentsSentiments[] = rConnection.eval("sentiData").asList().at(0).asStrings();
                commentsSentiment = commonWord(commentsSentiments);
            }
            else {
                totalComments = "None";
                commentsSentiment = "None";
            }
            rConnection.close();

        } catch (REXPMismatchException | REngineException e) {
            System.out.println("Problem with R Engine.");
            e.printStackTrace();
        }
        return new String[] {id, message, timeStamp, postSentiment, totalComments, commentsSentiment};
    }


    private String commonWord(String comments[]) {
        Map<String, Integer> repeats = new HashMap<>();
        for (String comment : comments) {
            repeats.merge(comment, 1, (a, b) -> a + b);
        }
        return maxVal(repeats);
    }

    private String maxVal(Map<String, Integer> map) {
        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry != null ? maxEntry.getKey() : "None";
    }
}
