package job;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.internal.job.AbstractElasticJob;

/**
 * Created by wanghongxing on 16/2/17.
 */
public class DemoJob extends AbstractElasticJob {
    @Override
    protected void executeJob(JobExecutionMultipleShardingContext shardingContext) {

        //job in this
        System.out.println(System.currentTimeMillis());

    }
}
