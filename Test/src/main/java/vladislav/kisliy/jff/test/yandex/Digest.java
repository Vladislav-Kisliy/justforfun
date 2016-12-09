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
package vladislav.kisliy.jff.test.yandex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public abstract class Digest {

    private final Map cache = new ConcurrentHashMap();

    public byte[] digest(byte[] input) {
        if (input == null) {
            throw new IllegalArgumentException("Input parameter can't be null");
        }
        cache.putIfAbsent(input, doDigest(input));
        return (byte[]) cache.get(input);
    }

    protected abstract byte[] doDigest(byte[] input);
}
