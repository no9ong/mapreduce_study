import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;

import java.io.IOException;

public class WordCount1 {
    public static void main(String[] args) throws IOException {
        //加载配置
        Configuration configuration = new Configuration();
        //创建job
        Job job = Job.getInstance(configuration);
        System.out.println("$DATE$");



    }
}
