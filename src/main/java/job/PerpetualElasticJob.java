package job;

import com.dangdang.ddframe.job.api.AbstractPerpetualElasticJob;
import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Queue;

/**
 *
 * 流式获取数据,直到数据都被消耗
 *
 * Created by wanghongxing on 16/3/2.
 */
public class PerpetualElasticJob extends AbstractPerpetualElasticJob<Integer> {

    private static int now = 0;
    private static Queue<Integer> DATAS =  Lists.newLinkedList();
    static{
        for(int i=0;i<1000;i++){
            DATAS.add(i);
        }
    }

    @Override
    public List<Integer> fetchData(JobExecutionMultipleShardingContext shardingContext) {

        List<Integer> datas = fetchData();
        if(datas == null || datas.size() ==0 ){
            return null;
        }

        return datas;
    }

    private List<Integer> fetchData(){
        List<Integer> datas = Lists.newArrayList();
        append(DATAS.poll(),datas);
        append(DATAS.poll(),datas);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return datas;
    }

    private void append(Integer data , List<Integer> datas){
        if(data == null){
            return;
        }
        datas.add(data);
    }

    @Override
    public boolean processData(JobExecutionMultipleShardingContext shardingContext, Integer data) {//单线程处理
        System.out.println(" now count : " + now + " data : " + data);
        try {
            Thread.sleep(100);//do something
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return true;//用于纪录成功次数
    }

}
