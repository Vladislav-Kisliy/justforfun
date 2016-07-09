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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.net.Proxy.Type.HTTP;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;

/**
 *
 * @author vlad
 */
public class ElasticSearch {
    
    public static void main(String[] args) throws IOException {
        
//        String url = "http://localhost:9200/testindex2/test/2";
//        HttpClient client = new DefaultHttpClient();
//
//        HttpPut put = new HttpPut(url);
////        JSONObject json = new JSONObject();
//
////        json.put("email", "abc@abof.com");
////        json.put("first_name", "abc");
////        StringEntity se = new StringEntity("JSON: " + json.toString());
////        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "Text"));
////        put.setEntity(se);
//
//        HttpResponse response = client.execute(put);
//        System.out.println("\nSending 'PUT' request to URL : " + url);
//        System.out.println("Put parameters : " + put.getEntity());
//        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
//
//        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//
//        StringBuffer result = new StringBuffer();
//        String line = "";
//        while ((line = rd.readLine()) != null) {
//            result.append(line);
//        }
//
//        System.out.println(result.toString());
    }
}
