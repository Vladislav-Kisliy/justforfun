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
package vladislav.kisliy.jff.test.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author vlad
 */
public class SocketWrapper {

    public void conn() throws MalformedURLException, IOException {
        SocketAddress addr = new InetSocketAddress("127.0.0.1", 9010);
        Proxy proxy = new Proxy(Proxy.Type.SOCKS, addr);

        try (Socket server = new Socket(proxy)) {
            server.connect(new InetSocketAddress("94.242.214.240", 22));
            System.out.println("connected =" + server.isConnected());
//        URL url = new URL("http://java.sun.com/");
//        URLConnection conn = url.openConnection(proxy);
        }
    }

    public static void main(String args[]) throws IOException {
//        SocketWrapper socketWrapper = new SocketWrapper();
//        socketWrapper.conn();

        System.out.println("sss"+String.format("Hi %s, my name is %s", "name", "yourName"));
    }
    
    public static Double multiply(Double a, Double b) {
        return a * b;
    }
}
