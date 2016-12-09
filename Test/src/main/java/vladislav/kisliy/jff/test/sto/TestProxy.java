/*
 * Copyright (C) 2016 Vladislav Kislyi <vladislav.kisliy@gmail.com>
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
package vladislav.kisliy.jff.test.sto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URL;

public class TestProxy {

    public static void main(String s[]) throws Exception {
        try {
            System.setProperty("proxySet", "true");
            System.setProperty("java.net.useSystemProxies", "true");
            System.setProperty("http.proxyHost", "abcd");
            System.setProperty("http.proxyPort", "8080");


//            URL u = new URL("http://forum.ru-board.com/e.pl");
            URL u = new URL("http://google.com");
            
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("host", 8080));
            HttpURLConnection con = (HttpURLConnection) u.openConnection(proxy);
            new Socket();
            
//            conn = new URL(jsonURL).openConnection(proxy);
            
            System.out.println("proxy ="+con.usingProxy());
            System.out.println(con.getResponseCode() + " : " + con.getResponseMessage());
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();

        } catch (Exception e) {
            System.out.println("ERROR!");
            e.printStackTrace();
            System.out.println(false);
        }
        Proxy proxy = (Proxy) ProxySelector.getDefault().select(new URI("http://www.google.com")).iterator().next();
        System.out.println("proxy Type : " + proxy.type());
        InetSocketAddress addr = (InetSocketAddress) proxy.address();
        if (addr == null) {
            System.out.println("No Proxy");
        } else {
            System.out.println("proxy hostname : " + addr.getHostName());
            System.out.println("proxy port : " + addr.getPort());
        }
    }
}
