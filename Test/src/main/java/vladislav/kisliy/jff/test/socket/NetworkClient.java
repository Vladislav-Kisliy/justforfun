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
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;

/**
 *
 * @author vlad
 */
public class NetworkClient {

    public static void main(String[] args) {
        try {
            try (Socket socket = new Socket()) {
                InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 4466);
                socket.connect(socketAddress);
                String[] straten = new String[]{"One", "Two", "Three"};
                // send data
                for (String straat : straten) {
                    socket.getOutputStream().write(straat.getBytes());
                }
                socket.getOutputStream().write('\r');
                socket.getOutputStream().flush();
                // get data
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("server answer =" + in.readLine());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
