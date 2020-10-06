package com.zhoushiya.shop.sentinel;

import com.alibaba.csp.sentinel.cluster.server.ClusterTokenServer;
import com.alibaba.csp.sentinel.cluster.server.SentinelDefaultTokenServer;
import com.alibaba.csp.sentinel.cluster.server.config.ClusterServerConfigManager;
import com.alibaba.csp.sentinel.cluster.server.config.ServerTransportConfig;
import com.zhoushiya.shop.sentinel.constants.Constants;

import java.util.Collections;

/**
 * @author zhoushiya
 * @date 2020/10/6 13:28
 */
public class SentinelServer {
    public static void main(String[] args) throws Exception {
        // Not embedded mode by default (alone mode).
        ClusterTokenServer tokenServer = new SentinelDefaultTokenServer();

        // A sample for manually load config for cluster server.
        // It's recommended to use dynamic data source to cluster manage config and rules.
        // See the sample in DemoClusterServerInitFunc for detail.
        ClusterServerConfigManager.loadGlobalTransportConfig(new ServerTransportConfig()
                .setIdleSeconds(600)
                .setPort(11111));
        ClusterServerConfigManager.loadServerNamespaceSet(Collections.singleton(Constants.APP_NAME));

        // Start the server.
        tokenServer.start();
    }
}
