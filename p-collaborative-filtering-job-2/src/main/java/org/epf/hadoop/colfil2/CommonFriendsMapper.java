package org.epf.hadoop.colfil2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommonFriendsMapper extends Mapper<Object, Text, UserPair, Text> {
    private UserPair userPair = new UserPair();
    private Text valueText = new Text();  // Changer le nom de la variable

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] parts = line.split("\t");

        if (parts.length != 2) {
            return;
        }

        String user = parts[0];
        String[] friends = parts[1].split(",");
        Set<String> friendSet = new HashSet<>(Arrays.asList(friends));

        for (String friend1 : friends) {
            for (String friend2 : friends) {
                if (!friend1.equals(friend2)) {
                    userPair = new UserPair(friend1, friend2);
                    valueText.set("1");
                    context.write(userPair, valueText);
                }
            }
        }

        for (String friend : friendSet) {
            userPair = new UserPair(user, friend);
            valueText.set("0");
            context.write(userPair, valueText);
        }
    }
}
