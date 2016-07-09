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
package vladislav.kisliy.jff.test.swing.old;

/*

This is client

 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PeerOne extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;

    JTextField outgoing;
    JTextArea incoming;
    JButton send;
    Thread t, t1;
    ObjectOutputStream output;  //for writing objects to a stream
    ObjectInputStream input;    //for reading objects from a stream
    Socket s;
    volatile boolean dataAvailable = false;
    String message = null;

    public PeerOne() {
        outgoing = new JTextField();
        outgoing.setEnabled(true);
        outgoing.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!(e.getActionCommand().isEmpty())) {
                    dataAvailable = true;
                    System.out.print("hi");
                }
            }
        });

        this.add(outgoing, BorderLayout.SOUTH);

        incoming = new JTextArea();
        incoming.setEditable(true);
        this.add(new JScrollPane(incoming), BorderLayout.CENTER);
        this.add(incoming);

        setSize(300, 150);
        setVisible(true);

        try {
            s = new Socket("localhost", 5500);
            incoming.append("Connection Successfull..." + "\n");

            output = new ObjectOutputStream(s.getOutputStream());
            output.flush();
            input = new ObjectInputStream(s.getInputStream());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        t = new Thread(this, "PeerOne");
        System.out.print("New Thread");
        //t1 = new Thread(this,"Two");
        t.start();
    }

    public static void main(String[] args) {
        new PeerOne();
    }

    public void run() {
        while (true) {
            if (dataAvailable == true) {
                try {
                    System.out.print(0);
                    output.writeUTF(outgoing.getText());
                    output.flush();
                    dataAvailable = false;
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            try {
                if (input.available() > 0) {
                    message = input.readUTF();
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            incoming.append(message);
                            incoming.append("\n");
                        }
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
