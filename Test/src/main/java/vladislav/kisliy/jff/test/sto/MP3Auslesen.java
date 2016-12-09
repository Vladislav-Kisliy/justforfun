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

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MP3Auslesen {

    public static void main(String[] args) {

        long groesseMP3 = 0;
        byte bTAG[] = new byte[3];
        byte bTitel[] = new byte[30];
        byte bInterpret[] = new byte[30];
        byte bCDTitel[] = new byte[30];
        byte bJahr[] = new byte[30];
        byte bKommentar[] = new byte[30];

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("MP3-Datei: ");
        String filename = null;
        try {
            filename = in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(MP3Auslesen.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (FileInputStream fis = new FileInputStream(filename)) {
            groesseMP3 = fis.available();
            fis.skip(groesseMP3 - 128);

            fis.read(bTAG);
            String strTAG = new String(bTAG);
            fis.read(bTitel);
            String strTitel = new String(bTitel);
            fis.read(bInterpret);
            String strInterpret = new String(bInterpret);
            fis.read(bCDTitel);
            String strCDTitel = new String(bCDTitel);
            fis.read(bJahr);
            String strJahr = new String(bJahr);
            String strKommentar = new String(bKommentar);
            fis.read(bKommentar);
            byte bGenre = (byte) fis.read();

            System.out.println("Dateigröße : " + groesseMP3);
            System.out.println("TAG : " + strTAG);
            System.out.println("Titel :" + strTitel);
            System.out.println("Interpret :" + strInterpret);
            System.out.println("CD-Titel : " + strCDTitel);
            System.out.println("Jahr :" + strJahr);
            System.out.println("Kommentar : " + strKommentar);
            System.out.println("Genre : " + bGenre);

        } catch (IOException err) {
            System.out.println("Fehler" + err);
        }
    }
}
