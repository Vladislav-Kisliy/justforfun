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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class RegExpManifest {
    private static final String PV_MANIFEST = "Manifest-Version: 1.0\n"
            + "Ant-Version: Apache Ant 1.8.2\n"
            + "Created-By: 1.3.1-rc2 (Sun Microsystems Inc.)\n"
            + "Codebase: *\n"
            + "Permissions: all-permissions\n"
            + "Application-Name: Retail Price Management\n"
            + "\n"
            + "Name: pv/jfcx/JPVTable$Icon3.class\n"
            + "SHA1-Digest: aLCxOTT58V2eqr1eQmWuaHaLuLk=\n"
            + "SHA-256-Digest: O/sEah/XM+CwoY0Rds0yfwZom3koNmt5Th6p7cSgC+Q=\n"
            + "\n"
            + "Name: pv/jfcx/Tbl32.gif\n"
            + "SHA1-Digest: ivn6/jLY8CbvPzR6E2j7mbzfGxc=\n"
            + "SHA-256-Digest: kOrz7fP4fUPb4Tlti3TWt99a9Ejvz4DcXQEbuQc3BFE=\n"
            + "\n"
            + "Name: pv/jfcx/JPVTable.class\n"
            + "SHA1-Digest: WayNCIR/4VrhXqF8KyW7Gp32vs4=\n"
            + "SHA-256-Digest: HjxpYEpx1JGEmCIlG3zFMC8rZ9gMKYjhwItC3pxKang=\n"
            + "\n"
            + "Name: pv/jfcx/JPVTableViewBeanInfo.class\n"
            + "SHA1-Digest: GT+2vQxdqdWYPqHJBoZcKMfQn9w=\n"
            + "SHA-256-Digest: 5vGQS400LgKsUysefdbdlmkFv1sEQug1H64wSj/JF2Q=\n"
            + "\n"
            + "Name: pv/jfcx/JPVTableViewCustomizer.class\n"
            + "SHA1-Digest: 5T94dE65smXZ8GL5vycLKAvC4C0=\n"
            + "SHA-256-Digest: qKNpwo3xgNTQkt+nZ1ez+ENNxvz7mlznZ2rmQf2yzZw=\n"
            + "\n"
            + "Name: pv/jfcx/JPVTable$4.class\n"
            + "SHA1-Digest: 3Ax4igH5svJusPHLsYGexGDl4fQ=\n"
            + "SHA-256-Digest: n9YPa2EkgmGuR804h+TUghdCg5dojL6C7tfxghJXmuQ=\n"
            + "\n"
            + "Name: pv/jfcx/PVTableRenderer.class\n"
            + "SHA1-Digest: +4uPLnAoIem/B0UTCT/Q87prjyM=\n"
            + "SHA-256-Digest: e79mV2QiIGU6XRmiXLH6kboKMQWKOKOblKQ0rvmeuE8=\n"
            + "\n"
            + "Name: pv/jfcx/JPVTable$1.class\n"
            + "SHA1-Digest: YlALDuC4H+0omml2LEMDq9bZA4A=\n"
            + "SHA-256-Digest: DelaUS6UuEYuoFkBVIm0stcOT9VaDt9oT5vjma4CxsY=\n"
            + "\n"
            + "Name: pv/jfcx/Tbl16.gif\n"
            + "SHA1-Digest: y06VyH40HqILnAdl7guJCW9k4/U=\n"
            + "SHA-256-Digest: 21zYA6MxhBAtGv/l1hA3fMGzCxPbK8gEArTryu6KxYo=\n"
            + "\n"
            + "Name: pv/util/PVConvert.class\n"
            + "SHA1-Digest: dGmZJYsSYevPe9wUqEp/pM90iqw=\n"
            + "SHA-256-Digest: 6OaOEEPeJ3j0/9WBAFjC8qAUyLsk7gLdKkI7d8dPmzk=\n"
            + "\n"
            + "Name: pv/jfcx/JPVEdit$AccessibleJPVEdit.class\n"
            + "SHA1-Digest: sAJiBFFKY+7pvBTE2wyE+4bos7Y=\n"
            + "SHA-256-Digest: 8VzDv4fc5ZduvFoxEMLbszFy/vG8AKJWMfkSEIyWLoE=\n"
            + "\n"
            + "Name: pv/jfcx/JPVTable$2.class\n"
            + "SHA1-Digest: WQ3cgf7zdH2C/9DNTBy1GAg8cNo=\n"
            + "SHA-256-Digest: mcsq+nDrZwDwQUVwM7mQls0LIPIIvh8dyjsgEtZEMKI=\n"
            + "\n"
            + "Name: pv/jfcx/JPVTable$Head.class\n"
            + "SHA1-Digest: grjL4OAO1DeWiHa0jdc74Xh4HpM=\n"
            + "SHA-256-Digest: uXvsN6pdkYOPfqpPV+7wxleLMvgUY6jr2WIAv11rGzY=\n"
            + "\n"
            + "Name: pv/jfcx/PVPanel.class\n"
            + "SHA1-Digest: fRvB8HiImt4ztMyvxfRwM5/T4mg=\n"
            + "SHA-256-Digest: rb5E+EPf4++kcwsfSfCSlB/oTCoMhgNssY3NC7DnFbY=\n"
            + "\n"
            + "Name: pv/jfcx/JPVTable$3.class\n"
            + "SHA1-Digest: cvHMpt8q0wNqx8dMoZcLL1CG9h4=\n"
            + "SHA-256-Digest: zIvRuB5/h8+HuT8vaWdmI5iLAikof7D7m/fOCv0ffZQ=\n"
            + "\n"
            + "Name: pv/jfcx/PVTableModel$SrtItem.class\n"
            + "SHA1-Digest: zolLtBb2bvPoCawOa3qUMeCMX50=\n"
            + "SHA-256-Digest: RGQuQSTJCnL1MFpE2dyvi4z8mw8Au6k5/kEYSBJzDG8=\n"
            + "\n"
            + "Name: pv/jfcx/PVTableModel.class\n"
            + "SHA1-Digest: /1/s06pdeA6nMzfn5rMqy3UwmQ8=\n"
            + "SHA-256-Digest: +RkHXjtzlqJsKSIDRKuBqtKxpbeIOApZ8j1s8+piuzM=\n"
            + "\n"
            + "Name: pv/jfcx/JPVNumeric.class\n"
            + "SHA1-Digest: XEDu4mw7NC8JjaBtACiFhF/7dYk=\n"
            + "SHA-256-Digest: 28oAPLOUCo9rio5qVfEbsUiiKZPDgqnYDcAvWcxJJJc=\n"
            + "\n"
            + "Name: pv/util/PVBorder.class\n"
            + "SHA1-Digest: xqUkK5N8FqQJciCLOO50tCK8bG8=\n"
            + "SHA-256-Digest: pjxy0+ZkY5z5AIKE9TF0xQJ1tIFthQqjQQKoSI7/HOM=\n"
            + "\n"
            + "Name: pv/jfcx/JPVTableView.class\n"
            + "SHA1-Digest: QuqB9reKNmCURETA2dOQhD1PZmI=\n"
            + "Java-Bean: True\n"
            + "SHA-256-Digest: eN+y/qQrz9ld9e4nqi5S6fb0mVtg2t/RKQWhl738zLw=\n"
            + "\n"
            + "Name: pv/jfcx/JPVDate.class\n"
            + "SHA1-Digest: m9Iuh2QR0Uqd3QmhPSLW5FFeYI4=\n"
            + "SHA-256-Digest: 7Dr+mNurh19+bvo9w08OklgR5sKR2naZrpJ2htSd7hA=\n"
            + "\n"
            + "Name: pv/util/PVMultiLine.class\n"
            + "SHA1-Digest: R2XNbfHzgzsKEU8CYt12bcj6K5E=\n"
            + "SHA-256-Digest: 3zmCfbODqoDkOynRi5BeTGuwy5Iz2luViwBAzB0rCD8=\n"
            + "\n"
            + "Name: pv/util/PVDate0.class\n"
            + "SHA1-Digest: LHr8Zwvw25YQwGLP5r+Audf/JYQ=\n"
            + "SHA-256-Digest: n/tM4HcMVcT0nLRzeKB7hFVi+M10b4fIzU0UYF77VJI=\n"
            + "\n"
            + "Name: pv/jfcx/JPVEdit.class\n"
            + "SHA1-Digest: IFW7fhfONSgwh1RmwCBGGqm4yo4=\n"
            + "SHA-256-Digest: 2cI+hZTUo5jO0jdk4o1z3MDCx1OLERplJ2gzQiXW7uM=\n"
            + "\n"
            + "Name: pv/jfcx/PVTableEditorListener.class\n"
            + "SHA1-Digest: 3dDufC2YDy50O05dVMNKUrzZtiI=\n"
            + "SHA-256-Digest: e8WBuIgIJ8aeP/+KH6s+IsLYrbhxoU1jME0CwqdXKqM=\n"
            + "\n"
            + "Name: pv/jfcx/PVTableEditor.class\n"
            + "SHA1-Digest: +xbmZfHtIRB27yjO1EFC0CVzPlg=\n"
            + "SHA-256-Digest: trySNGoEjrtPAy7GAKfCvMtoauaZQQ5O+iOnDzLbZx8=\n"
            + "";

    private static final String FOXTROT_MANIFEST = "Manifest-Version: 1.0\n"
            + "Ant-Version: Apache Ant 1.8.2\n"
            + "Created-By: Ant 1.5.1\n"
            + "Implementation-Version: 2.0\n"
            + "Codebase: *\n"
            + "Permissions: all-permissions\n"
            + "Application-Name: Retail Price Management\n"
            + "\n"
            + "Name: foxtrot/pumps/SunJDK140ConditionalEventPump.class\n"
            + "SHA1-Digest: RImGi5dI/9KbJQFT7SEjrqQYA7o=\n"
            + "SHA-256-Digest: hd+dU4i1bIFP3o6JWzyZ6vWXWpps+qm+o5ubQpIf2Sk=\n"
            + "\n"
            + "Name: foxtrot/pumps/SunJDK141ConditionalEventPump$1.class\n"
            + "SHA1-Digest: SvmbF2taP0o0eGcXdvL5ViQVpo8=\n"
            + "SHA-256-Digest: Y5DOO/1VEHlruFESO2ZJE6eV5q1KFS9mbLig1fItmn0=\n"
            + "\n"
            + "Name: foxtrot/Worker.class\n"
            + "SHA1-Digest: mQi43njJTSs1n0hyFBdmAz4XYBs=\n"
            + "SHA-256-Digest: 1MkMVYgmPFrHMhlJxbIUZfHI2aOL8ZvDeuLbLr5clCw=\n"
            + "\n"
            + "Name: foxtrot/AbstractWorkerThread.class\n"
            + "SHA1-Digest: UUkIDL5EFxnG1CY94Eqgjsqh2QU=\n"
            + "SHA-256-Digest: w480mE6VYn6Nx9+JJuJSnxXBx4jzPBvHWJO6tp19Sug=\n"
            + "\n"
            + "Name: foxtrot/AbstractWorkerThread$2.class\n"
            + "SHA1-Digest: pSqZ/IOWvnyvnhPHoYkOjZteLys=\n"
            + "SHA-256-Digest: 0zDCyeFL3B0EuRCzZax1tgo8n6rUrCkzNniCewJ6nCE=";

    private static final String EJB_MANIFEST = "Manifest-Version: 1.0\n"
            + "Implementation-Version: 2.1\n"
            + "Application-Name: Retail Price Management\n"
            + "Specification-Vendor: Sun Microsystems, Inc.\n"
            + "Created-By: 1.4.0 (Sun Microsystems Inc.)\n"
            + "SCCS-ID: @(#)Manifest	1.1 00/10/19\n"
            + "Ant-Version: Apache Ant 1.8.2\n"
            + "Implementation-Vendor: Sun Microsystems, Inc.\n"
            + "Implementation-Vendor-Id: com.sun\n"
            + "Permissions: all-permissions\n"
            + "Specification-Title: Enterprise JavaBeans(TM) Specification\n"
            + "Specification-Version: 2.1\n"
            + "Extension-Name: javax.ejb\n"
            + "Codebase: *\n"
            + "\n"
            + "Name: javax/ejb/TransactionRolledbackLocalException.class\n"
            + "SHA-256-Digest: LWT1IfGcnWo96brvKsiWPF4ZPN7hKrx1WdIX/MVibgU=\n"
            + "\n"
            + "Name: javax/ejb/HomeHandle.class\n"
            + "SHA-256-Digest: ZRDdXIviTTmplU2ImQajCJGfNezPXI5DTw0R5VwI9sk=\n"
            + "\n"
            + "Name: javax/ejb/EJBContext.class\n"
            + "SHA-256-Digest: YU+Ynwinvx9X4xi3cCUHwQtC2iAQVTt3jaikWHM29fY=\n"
            + "\n"
            + "Name: javax/ejb/SessionSynchronization.class\n"
            + "SHA-256-Digest: LGN+PtXKMEpazCxS3Weo69ypUpPVdcnMQuzs0tmHBLY=\n"
            + "\n"
            + "Name: javax/ejb/MessageDrivenBean.class\n"
            + "SHA-256-Digest: DGPCAm4hnCufBbgfDCbKZFtZlvGLRDp2WcEHX6guuxQ=\n"
            + "\n"
            + "Name: javax/ejb/NoSuchObjectLocalException.class\n"
            + "SHA-256-Digest: YjEPrzP85vRgYHOANHs94lJZZ0PIrIIsKi7ZPjD+4M4=\n"
            + "\n"
            + "Name: javax/ejb/RemoveException.class\n"
            + "SHA-256-Digest: UoJKqXPdfYpWEeJqsmq+vUQ9Nom2L6HxC10y7+Bh198=\n"
            + "\n"
            + "Name: javax/ejb/EJBLocalObject.class\n"
            + "SHA-256-Digest: nvxstvQKF6crcd3iRTWr3ZLkoQYkryfL4G3J3PWoLZE=\n"
            + "\n"
            + "Name: javax/ejb/TimerService.class\n"
            + "SHA-256-Digest: QRTxzfOkX6rQw+PQkYY9gXz63rNZW3mHH4eZBvRMdUo=\n"
            + "\n"
            + "Name: javax/ejb/EJBHome.class\n"
            + "SHA-256-Digest: r0if6QVxYz2SLeeZ3a5xmxbTkAPonWwu6tY3UkuCfmE=\n"
            + "\n"
            + "Name: javax/ejb/EntityBean.class\n"
            + "SHA-256-Digest: gb2B61/vXzsfn2pUS2QVcKfWmuxOrq+0GpAcy7l9yFM=\n"
            + "\n"
            + "Name: javax/ejb/EJBLocalHome.class\n"
            + "SHA-256-Digest: fC47yzcxTvVm4DOKi8mP81+yTc02ZScgMPLALaiOzLc=\n"
            + "\n"
            + "Name: javax/ejb/NoSuchEntityException.class\n"
            + "SHA-256-Digest: avMg3lwvP4YfTyk3uvqZ2G5dRgsP6YSNwnp4RG4JR40=\n"
            + "\n"
            + "Name: javax/ejb/FinderException.class\n"
            + "SHA-256-Digest: LVTgd/VSBAaty7TGB8ZCPhiBocbaLvc3FmwXdPZZfkY=\n"
            + "\n"
            + "Name: javax/ejb/EJBObject.class\n"
            + "SHA-256-Digest: Dy/j7aF586E/6UQnnri8Z2mCRAaINHVRgfDQppO8SbY=\n"
            + "\n"
            + "Name: javax/ejb/TimerHandle.class\n"
            + "SHA-256-Digest: vZpQsYcD8FrRxg6J6KbRhWBTSlNBCmDm2aJ77ppnIM8=\n"
            + "\n"
            + "Name: javax/ejb/EJBException.class\n"
            + "SHA-256-Digest: GU3k/VpoDd/+K7a2RJiuPZGtH9Ab4d1d4bVj8uXq2Qc=\n"
            + "\n"
            + "Name: javax/ejb/SessionBean.class\n"
            + "SHA-256-Digest: 2xLj85YswQnCAEQgDrwfoqQAS/rQP0tmQT/mqNns+Ao=\n"
            + "\n"
            + "Name: javax/ejb/Handle.class\n"
            + "SHA-256-Digest: Xw3IbD4Z+Wj60jJMW4jbL6psX9GUh65H1oo3jGOvrCQ=\n"
            + "\n"
            + "Name: javax/ejb/EJBMetaData.class\n"
            + "SHA-256-Digest: 2Yybhv1blgGLz2JoI/l116JrIDqTDJ2d3RXn925ho84=\n"
            + "\n"
            + "Name: javax/ejb/CreateException.class\n"
            + "SHA-256-Digest: IWfVDMZwFgKBq1ur7oIhtpP2BjnskFZolaqqulUUKSk=\n"
            + "\n"
            + "Name: javax/ejb/TransactionRequiredLocalException.class\n"
            + "SHA-256-Digest: +1C6h7XavL+1zGsNBaH2o2ffMwifJ4xEpESiY3QBHck=\n"
            + "\n"
            + "Name: javax/ejb/EnterpriseBean.class\n"
            + "SHA-256-Digest: J3jPOxdXz2PX25jflD0pSqLctZp9MB7t4fj/mOTJPYw=\n"
            + "\n"
            + "Name: javax/ejb/MessageDrivenContext.class\n"
            + "SHA-256-Digest: lgY75uZUrbzhOs2fGb02zz4aXyO5a8tN4E3mt418TMs=\n"
            + "\n"
            + "Name: javax/ejb/DuplicateKeyException.class\n"
            + "SHA-256-Digest: hVP9pr37JMlYuJoByIP0dK8cLhw+aPuGFDZG0yqIBlg=\n"
            + "\n"
            + "Name: javax/ejb/ObjectNotFoundException.class\n"
            + "SHA-256-Digest: nGTBwLBIxgSfCgw4xbGpAHtLMDQt+8KSl/bnu6pJsnM=\n"
            + "\n"
            + "Name: javax/ejb/AccessLocalException.class\n"
            + "SHA-256-Digest: Ti5kVtrnddCwsMwgNZB9q2OXmtlVzUpq9CI21O94+Ew=\n"
            + "\n"
            + "Name: javax/ejb/EntityContext.class\n"
            + "SHA-256-Digest: gnNJiHZMUx/5ceQx4SetqrhweKbhjdFLUboX/BbzJPs=\n"
            + "\n"
            + "Name: javax/ejb/Timer.class\n"
            + "SHA-256-Digest: l8jeHyS/QpHabLByiNEtSW7ca9B0rQNGBBY1mQ2ufww=\n"
            + "\n"
            + "Name: javax/ejb/spi/HandleDelegate.class\n"
            + "SHA-256-Digest: ZcpgbKlZrKTx4xQYZE63T55IfrWzW6ITHbGJ0aPlPqI=\n"
            + "\n"
            + "Name: javax/ejb/TimedObject.class\n"
            + "SHA-256-Digest: WqASPKbSRQdurBBjlH8O0cpO7EM7pVK5T51SYJjePO0=\n"
            + "\n"
            + "Name: javax/ejb/SessionContext.class\n"
            + "SHA-256-Digest: PCUpcc21fNPXEgkm8zhOzUwRDKctQ4ndPzBqqbAd1Zk=\n"
            + ""
            + "\n";

    public static void main(String[] args) {
//        Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(20, 0.8f, true);
//        linkedHashMap.put(1, "1");
//        linkedHashMap.put(2, "2");
//        linkedHashMap.put(4, "4");
//        linkedHashMap.put(3, "3");
//        linkedHashMap.put(12, "12");
//        linkedHashMap.put(5, "5");
//        
//        System.out.println("get block. 12 ="+linkedHashMap.get(12)+", 1="+linkedHashMap.get(1));
//        System.out.println("values ="+linkedHashMap.values());

        String workString = PV_MANIFEST;
        System.out.println(workString);
        System.out.println("================");
        Pattern firstPattern = Pattern.compile("Name:.*(?:\\n .*)*?\\n.*-Digest.*:.*");
        Matcher matcher = firstPattern.matcher(workString);
        String firstReplace = matcher.replaceAll("");
        System.out.println("result 1 =\n" + matcher.replaceAll(""));
        Pattern secondPattern = Pattern.compile(".*-Digest.*:.*");
        matcher = secondPattern.matcher(firstReplace);
        System.out.println("result 2 =\n" + matcher.replaceAll(""));
        
//        if (matcher.find()) {
//            matcher.appendReplacement(buffer, "-");
//            matcher.
//            System.out.println("group =" + matcher.group());
//        }
//        matcher.appendTail(buffer);
//       System.out.println("result =" + buffer);
    }

}
