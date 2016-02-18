package job;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.internal.job.AbstractElasticJob;

import java.util.Date;
import java.util.List;

/**
 * Created by wanghongxing on 16/2/18.
 */
public class DemoJob2 extends AbstractElasticJob {

    @Override
    protected void executeJob(JobExecutionMultipleShardingContext shardingContext) {

        System.out.println("job2 run-------------");

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
