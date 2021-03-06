/*
 * Copyright (C) 2015 Weigandt Consulting
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
package vladislav.kisliy.jff.tictactoe.network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;
import vladislav.kisliy.jff.tictactoe.beans.CellState;
import vladislav.kisliy.jff.tictactoe.beans.RefereeRequest;
import vladislav.kisliy.jff.tictactoe.beans.Request;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author vlad
 */
public class Network {

    public enum NetworkMode {

        SERVER, CLIENT
    };

    public static final int TCP_PORT = 54555;
    public static final int UDP_PORT = 54777;

    // This registers objects that are going to be sent over the network.
    static public void register(EndPoint endPoint) {
        Kryo kryo = endPoint.getKryo();
        kryo.register(CellState.class);
        kryo.register(CopyOnWriteArrayList.class);
        kryo.register(RefereeRequest.class);
        kryo.register(List.class);
        kryo.register(Request.class);
        kryo.register(java.util.ArrayList.class);
    }
}
