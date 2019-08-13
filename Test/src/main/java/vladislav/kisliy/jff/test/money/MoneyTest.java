/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vladislav.kisliy.jff.test.money;

import java.util.Locale;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryRounding;
import javax.money.NumberValue;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

/**
 *
 * @author Vladislav Kisliy <vladislav.kisliy@gmail.com>
 */
public class MoneyTest {

    public static void main(String[] args) {
        MonetaryAmount eurAmount1 = Monetary.getDefaultAmountFactory().setNumber(1.1111).setCurrency("EUR").create();
        MonetaryAmount eurAmount2 = Monetary.getDefaultAmountFactory().setNumber(1.1141).setCurrency("EUR").create();

        MonetaryAmount eurAmount3 = eurAmount1.add(eurAmount2);
        NumberValue number = eurAmount3.getNumber();

        MonetaryAmount specAmount = Monetary.getDefaultAmountFactory()
                .setNumber(123.45)
                .setCurrency("UAH")
                .create();
        System.out.println("UAH ="+specAmount);
        System.out.println("UAH ="+specAmount.getNumber().doubleValueExact());
//        eurAmount3.getNumber().getScale()
//        eurAmount3.s
        System.out.println("eur 3 =" + eurAmount3.toString());
        System.out.println("eur 3 =" + eurAmount3.getNumber());

//        assertThat(eurAmount3.toString(), is("EUR 2.2252"));
        MonetaryRounding defaultRounding = Monetary.getDefaultRounding();
        MonetaryAmount eurAmount4 = eurAmount3.with(defaultRounding);
//        assertThat(eurAmount4.toString(), is("EUR 2.23"));

        MonetaryAmountFormat germanFormat = MonetaryFormats.getAmountFormat(Locale.GERMAN);
//        assertThat(germanFormat.format(eurAmount4), is("EUR 2,23") );
    }
}
