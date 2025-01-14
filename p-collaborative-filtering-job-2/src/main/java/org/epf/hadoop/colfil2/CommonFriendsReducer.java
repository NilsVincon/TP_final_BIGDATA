package org.epf.hadoop.colfil2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class CommonFriendsReducer extends Reducer<UserPair, Text, UserPair, Text> {

    @Override
    protected void reduce(UserPair key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        int sum = 0;

        for (Text value : values) {
            String val = value.toString();
            if (val.equals("1")) {
                sum++;
            }
        }
        if (sum > 0) {
            context.write(key, new Text(String.valueOf(sum)));
        }
    }
}
