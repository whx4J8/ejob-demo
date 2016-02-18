package job;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.internal.job.AbstractElasticJob;

import java.util.Date;
import java.util.List;

/**
 * Created by wanghongxing on 16/2/17.
 */
public class DemoJob extends AbstractElasticJob {

    @Override
    protected void executeJob(JobExecutionMultipleShardingContext shardingContext) {

        System.out.println("job1 run-------------");

        //job in this
        int count = shardingContext.getShardingTotalCount();
        List<Integer> shardingItems = shardingContext.getShardingItems();

        System.out.println("demo job execute "  + new Date());
        System.out.println("sharding total count : " + count);
        System.out.print("shanrding items : ");
        shardingContext.getShardingItems().forEach(item->System.out.print(item + " "));
        System.out.println();

    }
}
