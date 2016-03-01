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
package vladislav.kisliy.jff.test.codewars;

/**
 *
 * @author vlad
 */
public class JadenCase {

    public String toJadenCase(String phrase) {
        String result = null;
        if (phrase != null && !phrase.isEmpty()) {
            StringBuilder strBuf = new StringBuilder();
            String[] phraseParts = phrase.split(" ");
            for (String phrasePart : phraseParts) {
                strBuf.append(phrasePart.substring(0, 1).toUpperCase());
                strBuf.append(phrasePart.substring(1));
                strBuf.append(" ");
            }
            result = strBuf.toString().trim();
        }
        return result;
    }
}
