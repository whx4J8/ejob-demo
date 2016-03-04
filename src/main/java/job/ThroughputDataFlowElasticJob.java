package job;

import com.dangdang.ddframe.job.internal.job.AbstractJobExecutionShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.AbstractThroughputDataFlowElasticJob;

import java.util.List;

/**
 * Created by wanghongxing on 16/3/4.
 */
public class ThroughputDataFlowElasticJob extends AbstractThroughputDataFlowElasticJob {

    @Override
    public List fetchData(AbstractJobExecutionShardingContext shardingContext) {

        return null;
    }

    @Override
    public boolean processData(AbstractJobExecutionShardingContext shardingContext, Object data) {
        return false;
    }

    @Override
    public boolean isStreamingProcess() {
        return false;
    }
}
