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
package vladislav.kisliy.jff.test.file;

import java.util.Collection;
import java.util.Set;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public interface ArrayWriter<T> {
    
    /**
     * Writes array elements in file.
     * @param arrayToWrite
     * @param append 
     */
    void write(T[] arrayToWrite, boolean append);

    /**
     * Writes set elelments in file.
     * @param collection
     * @param append
     * @param clearFactor 
     */
    void dropToFile(Collection<T> collection, boolean append, float clearFactor);
}
