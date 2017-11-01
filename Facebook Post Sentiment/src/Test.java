import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.exception.FacebookOAuthException;
import com.restfb.types.Post;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {

//    private static String accessToken =
//            "EAAXQlJb03sgBALsOYynkL75OawE6EtgQIFPasxX3zZCPtQxRFXksIRNoXzZBOxUjjXZB8f" +
//                    "ZAwtaZAZAdrk4qddqs23YiGXR8GnAoM7g5rr7XOAWDjFxlZCFIfhZCALcE65Whq" +
//                    "kZB79kUeuACG4Jh9yrAuUhzjZCTcwz70ZD";
//    @Deprecated
//    private static FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
//
//    public static void main(String args[]) {
//
////        System.out.println("Please enter page ID : ");
//        String pageId = "TechnoKaizenCommuity";
//
//        try {
//
//            MyCommentClass myCommentClass;
//            MyPostClass myPostClass = new MyPostClass(pageId, facebookClient);
//            RConnection rConnection = new RConnection();
//            rConnection.eval("library(RSentiment)");
//
//            for (String postId : myPostClass.getPostIds()) {
//                Post post = myPostClass.getPostById(postId);
//                System.out.println("\nPost --->  " + post.getMessage() + "\nCreated Time --->  " + post.getCreatedTime());
//
//                rConnection.assign("post", post.getMessage());
//                System.out.println("The Sentiment for this post is : " +
//                        rConnection.eval("calculate_sentiment(post)").asList().at(1).asString());
//
//                myCommentClass = new MyCommentClass(postId, facebookClient);
//                System.out.println("Total number of comments : " + myCommentClass.getCommentsCount());
//                String postComments[] = myCommentClass.getAllPostComments();
//                System.out.println("Comments for this post : " + (postComments.length > 0 ? "" : "None"));
//                for (String s : postComments) {
//                    System.out.println(s);
//                }
//
//                if (postComments.length == 0) {
//                    System.out.println("No comments to calculate comments sentiment.");
//                }
//                else {
//                    rConnection.assign("comments", postComments);
//                    rConnection.eval("sentiData <- calculate_sentiment(comments)[2]");
//                    rConnection.eval("print(sentiData)");
//                    String commentsSentiment[] = rConnection.eval("sentiData").asList().at(0).asStrings();
//                    System.out.println(commonWord(commentsSentiment));
//                }
//
//                System.out.println("\n\n");
//            }
//
//        } catch (FacebookOAuthException e) {
//            System.out.println("Please check the Page ID !");
//        } catch (REngineException e) {
//            System.out.println("R Connection not found.");
//        } catch (REXPMismatchException e) {
//            System.out.println("REXP mismatch.");
//        }
//
//    }
//
//    private static String commonWord(String comments[]) {
//        Map<String, Integer> repeats = new HashMap<>();
//        for (String comment : comments) {
//            repeats.merge(comment, 1, (a, b) -> a + b);
//        }
//        System.out.println(repeats);
//        return maxVal(repeats);
//    }
//
//    private static String maxVal(Map<String, Integer> map) {
//        Map.Entry<String, Integer> maxEntry = null;
//
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
//                maxEntry = entry;
//            }
//        }
//        return maxEntry != null ? maxEntry.getKey() : "None";
//    }

}
