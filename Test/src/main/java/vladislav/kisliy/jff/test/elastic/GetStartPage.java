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
package vladislav.kisliy.jff.test.elastic;

import io.searchbox.action.AbstractAction;
import io.searchbox.action.GenericResultAbstractAction;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class GetStartPage extends GenericResultAbstractAction {

    protected GetStartPage(Builder builder) {
        super(builder);
        setURI(buildURI());
    }

    protected String buildURI() {
        return super.buildURI() + "/?pretty";
    }

    @Override
    public String getRestMethodName() {
        return "GET";
    }

    public static class Builder extends AbstractAction.Builder<GetStartPage, Builder> {

        @Override
        public GetStartPage build() {
            return new GetStartPage(this);
        }
    }
}
