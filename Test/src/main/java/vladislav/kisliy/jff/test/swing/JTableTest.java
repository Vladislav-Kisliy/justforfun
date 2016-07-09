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
package vladislav.kisliy.jff.test.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame {

    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JTable table;
    private int col;
    private int rowz;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    JTableTest frame = new JTableTest();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public JTableTest() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][]{{"", null, null, ""}, {null, null, null, null}, {null, null, null, ""},
        {null, null, null, null},}, new String[]{"Column 0", "Column 1", "Column 2", "Column 3"}));
        table.getColumnModel().getColumn(0).setMinWidth(200); // Here's how to
        // change a
        // column width
        scrollPane.setViewportView(table);
        table.setDefaultRenderer(Object.class, new CustomModel());
        table.addMouseListener(new CustomListener());
    }

    public class CustomListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent arg0) {
            super.mouseClicked(arg0);
            // Select the current cell
            rowz = table.getSelectedRow();
            col = table.getSelectedColumn();

            // Repaints JTable
            table.repaint();
        }
    }

    public class CustomModel extends DefaultTableCellRenderer {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Color c = Color.WHITE;
            if (isSelected && row == rowz & column == col) {
                c = Color.GREEN;
            }
            label.setBackground(c);
            return label;
        }
    }

}
