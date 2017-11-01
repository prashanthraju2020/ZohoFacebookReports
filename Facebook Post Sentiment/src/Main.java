import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.csvreader.CsvWriter;
import java.io.FileWriter;


public class Main {

    private static String accessToken =
            "EAAXQlJb03sgBALsOYynkL75OawE6EtgQIFPasxX3zZCPtQxRFXksIRNoXzZBOxUjjXZB8f" +
                    "ZAwtaZAZAdrk4qddqs23YiGXR8GnAoM7g5rr7XOAWDjFxlZCFIfhZCALcE65Whq" +
                    "kZB79kUeuACG4Jh9yrAuUhzjZCTcwz70ZD";
    @Deprecated
    private static FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
    public static void main(String args[]) {

//        System.out.println("Please enter page ID : ");
        String pageId = "TechnoKaizenCommuity";
//        String pageId = "RGV";

        MyCommentClass myCommentClass;
        MyPostClass myPostClass = new MyPostClass(pageId, facebookClient);
        Post2CSV post2CSV = new Post2CSV();

        CsvWriter csvOutput;

        try {
            csvOutput = new CsvWriter(new FileWriter("fb.csv", true), ',');
            csvOutput.write("ID");
            csvOutput.write("Post");
            csvOutput.write("Time Stamp");
            csvOutput.write("Post Sentiment");
            csvOutput.write("Total Comments");
            csvOutput.write("Comments Sentiment");
            csvOutput.endRecord();
            for (String postId : myPostClass.getPostIds()) {
                myCommentClass = new MyCommentClass(postId, facebookClient);
                String data[] = post2CSV.postData(myPostClass.getPostById(postId), myCommentClass);
                csvOutput.write(data[0]);
                csvOutput.write(data[1]);
                csvOutput.write(data[2]);
                csvOutput.write(data[3]);
                csvOutput.write(data[4]);
                csvOutput.write(data[5]);
                csvOutput.endRecord();
            }
            csvOutput.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
