package WordCount;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class WordCount1 {
    public static void main(String[] args) throws Exception  {
        //加载配置
        Configuration configuration = new Configuration();
        //创建job
        Job job = Job.getInstance(configuration);

        job.setJobName("WordCount");

        job.setJarByClass(WordCount1.class);
        job.setMapperClass(WCMapper.class);
        job.setReducerClass(WCReduce.class);
        // 3 指定mapper输出数据的kv类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        // 4 指定最终输出的数据的kv类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // 5 指定job的输入原始文件所在目录
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // 7 将job中配置的相关参数，以及job所用的java类所在的jar包， 提交给yarn去运行
//        job.submit();
        boolean result = job.waitForCompletion(true);
        System.exit(result?0:1);

    }
}
