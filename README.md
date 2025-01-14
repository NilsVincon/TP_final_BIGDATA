Commande du TP :

hdfs dfs -put /data/data.txt /user/root/relationships/

Job1 :  hadoop jar /jars/tpfinal-nils_vincon_job1.jar org.epf.hadoop.colfil1.RelationShipJob /user/epfuser/relationships/data.txt /user/epfuser/output1/

Job2 : Job1 :  hadoop jar /jars/tpfinal-nils_vincon_job2.jar org.epf.hadoop.colfil2.CommonFriendJob /user/epfuser/output1/part-r-00000 /user/epfuser/output2/

Job3 : hadoop jar /jars/tpfinal-nils_vincon_job3.jar org.epf.hadoop.colfil1.RecommendationJob /user/epfuser/output2/part-r-00000 /user/epfuser/output3/
