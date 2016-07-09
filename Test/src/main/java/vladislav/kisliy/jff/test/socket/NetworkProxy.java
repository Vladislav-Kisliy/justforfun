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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author vlad
 */
public class NetworkProxy {

    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(4466);
                Socket clientConnection = ss.accept();
                Socket serverConnection = new Socket()) {
            System.out.println("Connection from IP=" + clientConnection.getInetAddress() + ", port=" + clientConnection.getPort());
            // Connect to server
            InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 4456);
            serverConnection.connect(socketAddress);
            // send data from connected client to server
            byte[] buffer = new byte[1024];
            int bytesRead = clientConnection.getInputStream().read(buffer);
            serverConnection.getOutputStream().write(buffer, 0, bytesRead);
            serverConnection.getOutputStream().flush();
            // send data from server to connected client
            bytesRead = serverConnection.getInputStream().read(buffer);
            clientConnection.getOutputStream().write(buffer, 0, bytesRead);
            clientConnection.getOutputStream().flush();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
