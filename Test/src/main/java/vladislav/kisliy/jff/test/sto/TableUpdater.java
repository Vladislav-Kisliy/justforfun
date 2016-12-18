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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class TableUpdater extends Application {

    private final int maxItems = 30;
    private final AtomicBoolean pending = new AtomicBoolean();

    public static void main(String[] args) {
        launch(args);
    }

    private int counter = 0;
    private ObservableList<Thing> data;
    private final List<Thing> itemsToAdd = Collections.synchronizedList(new ArrayList<Thing>());

//    @Override
//    public void start(Stage stage) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
    @Override
    public void start(Stage primaryStage) throws Exception {
        TableView<Thing> table = new TableView<>();
        data = FXCollections.observableArrayList();
        table.setItems(data);

        TableColumn<Thing, String> fooCol = new TableColumn<>("Foo");
        fooCol.setCellValueFactory(new PropertyValueFactory<>("foo"));
        table.getColumns().addAll(fooCol);

        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            add(new Thing(String.format("%08d", counter++)));
        }, 0, 2, TimeUnit.MILLISECONDS);

        primaryStage.setScene(new Scene(table));
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();
    }

    private void add(Thing thing) {
        itemsToAdd.add(thing);

        if (!pending.getAndSet(true)) {
            Platform.runLater(() -> {
                synchronized (itemsToAdd) {
                    Collections.reverse(itemsToAdd);
                    data.addAll(0, itemsToAdd);
                    itemsToAdd.clear();
                }
                if (data.size() > maxItems) {
                    data.remove(maxItems, data.size());
                }
                pending.set(false);
            });
        }
    }

    public class Thing {

        private final String foo;

        public Thing(String foo) {
            this.foo = foo;
        }

        public String getFoo() {
            return foo;
        }

        @Override
        public int hashCode() {
            return foo.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Thing)) {
                return false;
            }
            return ((Thing) obj).foo.equals(foo);
        }
    }
}
