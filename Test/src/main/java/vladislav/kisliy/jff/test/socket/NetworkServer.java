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
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 *
 * @author vlad
 */
public class NetworkServer {

    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(4456);
                Socket s = ss.accept(); InputStream input = s.getInputStream();
                OutputStream output = s.getOutputStream()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String line = br.readLine();
            System.out.println("Get from client =" + line);
            output.write(("HTTP/1.1 200 OK\n\n").getBytes());
            output.flush();
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }

}
