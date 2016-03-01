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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vlad
 */
public class FunctionalProgrammingTest {
    
    public FunctionalProgrammingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

      @Test
  public void testJohnSmith() throws Exception {
    Student jSmith = new Student("John", "Smith", "js123");
    assertTrue("John Smith with student number js123 did not return true", FunctionalProgramming.f.apply(jSmith));
  }
    
    @Test
  public void testArea() throws Exception {
    Triangle t = new Triangle(5, 10);
    assertEquals("Incorrect area returned", 25D, FunctionalProgramming.triangleArea.applyAsDouble(t), 0.001);
    assertEquals("Incorrect area in Triangle object", 25D, t.getArea(), 0.001);
  }
    
}
