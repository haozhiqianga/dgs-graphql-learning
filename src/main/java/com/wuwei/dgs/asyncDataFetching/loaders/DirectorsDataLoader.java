package com.wuwei.dgs.asyncDataFetching.loaders;

import com.netflix.graphql.dgs.DgsDataLoader;
import com.wuwei.dgs.asyncDataFetching.client.DirectorServiceClient;
import com.wuwei.dgs.asyncDataFetching.types.Director;
import org.dataloader.BatchLoader;
import org.dataloader.MappedBatchLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * 区别于 Lambda 写法，此种方法在 DataFetchingEnvironment 加载 DataLoader 时，
 * 通过 DgsDataLoader name 传参，需要对这些 loaders name 进行管理
 *
 * 当一个key只对应一个value时，实现 BatchLoader<K,V> 接口，
 * 加载过程中 directors 的数据结构为 List<V>
 *
 * @author haozhiqiang
 */
@DgsDataLoader(name = "directors", caching = true, batching = true, maxBatchSize = 100)
public class DirectorsDataLoader implements BatchLoader<String, Director> {
    @Override
    public CompletionStage<List<Director>> load(List<String> keys) {
        return CompletableFuture.supplyAsync(
                () -> DirectorServiceClient.loadDirectors(new ArrayList<>(keys))
        );
    }
}
