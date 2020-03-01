//package com.lzz.es.config;
//
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import java.net.InetAddress;
//import java.net.InetSocketAddress;
//import java.net.UnknownHostException;
//
///**
// * @author 李振振
// * @version 1.0
// * @date 2020/2/29 14:07
// */
//@Configuration
//@PropertySource("classpath:elasticsearch.properties")
//@ConfigurationProperties(prefix = "node1")
//public class ElasticSearchConfig {
//    @Value("${node1.host}")
//    private String host;
//
//    @Value("${node1.clusterName}")
//    private String esClusterName;
//
//    @Value("${node1.port}")
//    private int esPort;
//
//    private TransportClient client;
//
//    @PostConstruct
//    public void initialize() throws Exception {
//        Settings settings = Settings.builder()
//                .put("cluster.name",esClusterName)
//                .put("client.transport.sniff",true)
//                .build();
//        client = new PreBuiltTransportClient(settings);
//        String [] hosts =host.trim().split(",");
//        for (String currHost : hosts) {
//            client.addTransportAddress(new InetSocketAddress(InetAddress.getByName(currHost)),esPort);
//        }
//    }
//    @Bean
//    public TransportClient client(){
//        return client;
//    }
//
//    @Bean
//    public ElasticsearchTemplate getTemplate(){
//        return new ElasticsearchTemplate(client);
//    }
//
//    @PreDestroy
//    public void destroy(){
//        if (client !=null){
//            client.close();
//        }
//    }
//}
