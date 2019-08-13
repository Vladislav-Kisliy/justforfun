/*
 * Copyright (C) 2016 vlad
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package vladislav.kisliy.jff.test.elastic;

import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequestBuilder;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author vlad
 */
public class ClientConnection {

    public static void main(String[] args) throws UnknownHostException, InterruptedException, ExecutionException {

        TransportClient client = TransportClient.builder()
                //                .addPlugin(ShieldPlugin.class)
                .settings(Settings.builder()
                        .put("cluster.name", "elasticsearch")
                        //                        .put("shield.user", "es_admin:vlad13")
                        .build())
                .build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
        
        
//        QueryBuilder qb = multiMatchQuery(
//                "org", // George
//                "firstname", "lastname"
//        ).fuzziness(Fuzziness.build(2));
//
//        SearchResponse response = client.prepareSearch("objects")
//                .setQuery(qb)
//                .execute()
//                .get();
//
//        for (SearchHit hit : response.getHits()) {
//            System.out.println(hit.getSource());
//        }

        // client connection code
        String newIndex = "test_index";
        Settings indexSettings = Settings.settingsBuilder().put("number_of_shards", 4)
		.put("number_of_replicas", 3).build();
        CreateIndexRequestBuilder createIndexBuilder = client.admin().indices().prepareCreate(newIndex);
        createIndexBuilder.setSettings(indexSettings);
        CreateIndexResponse createIndexResponse = createIndexBuilder.execute().actionGet();
        System.out.printf("acknowledged: %s%n", createIndexResponse.isAcknowledged());

        // Check status
        ClusterHealthRequestBuilder healthRequest = client.admin().cluster().prepareHealth();
        healthRequest.setIndices(newIndex); // only request health of this index...
        healthRequest.setWaitForYellowStatus();
        ClusterHealthResponse healthResponse = healthRequest.execute().actionGet();
        System.out.printf("status: %s%n", healthResponse.status());
        
        GetRequestBuilder get = client.prepareGet();
        get.setIndex(newIndex);
        get.setType("mytype");
        get.setId("myid");

        try {
            GetResponse response = get.execute().actionGet(1000);
            System.out.printf("exists: %s%n", response.isExists());
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

//        IndexResponse indexResponse = client.prepareIndex(newIndex, "tests")
//                .setSource("test")
//                .execute().actionGet();
//        System.out.println("id =" + indexResponse.getId());
        
        
//        SearchResponse searchResponse = client.prepareSearch("test_index").setTypes("tests")
//                .execute().actionGet();

        client.close();
    }
}
