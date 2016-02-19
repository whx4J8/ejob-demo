import com.dangdang.ddframe.job.api.JobConfiguration;
import com.dangdang.ddframe.job.api.JobScheduler;
import com.dangdang.ddframe.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.reg.zookeeper.ZookeeperRegistryCenter;
import job.DemoJob;

/**
 * Created by wanghongxing on 16/2/17.
 */
public class Main{

    /**
     * 启动job的main方法
      * @param args
     */
    public static void main(String[] args){

        ZookeeperConfiguration zkConf = new ZookeeperConfiguration(//配置zk
                "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183"
                ,"ejob-demo"
                ,1000
                ,3000
                ,3);

        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(zkConf);//注册中心

        JobConfiguration jobConfig = new JobConfiguration("simpleJob", DemoJob.class, 1, "0/5 * * * * ?");//配置job
        jobConfig.setOverwrite(true);// 将本地的任务更新到zk上,正在跑的任务也会被立即更新

        regCenter.init();//注册中心启动

        new JobScheduler(regCenter,jobConfig).init();//任务启动

        System.out.println("init complete.");
    }

}
