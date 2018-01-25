/*
 *     JMortar - Tools to make your Java life easier.
 *     Copyright (C) 2015-2018 Stephen Cheesley
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.logitopia.jmortar.core.service.util.impl;

import com.logitopia.jmortar.core.service.util.impl.BasicResourceManager;
import com.logitopia.jmortar.core.service.model.TestModel;
import com.logitopia.jmortar.core.service.model.impl.TestModelImpl;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The <tt>BasicResourceManagerTest</tt> unit test class is a unit test of the
 * <tt>BasicResourceManager</tt> module.
 *
 * @author &lt;Stephen Cheesley stephen.cheesley@gmail.com&gt;
 */
public class BasicResourceManagerTest {

  /**
   * The logger for this class.
   */
  public static final Logger LOG
          = Logger.getLogger(BasicResourceManagerTest.class);
  
  /**
   * The test model name value.
   */
  public static final String TEST_MODEL_NAME = "testName";

  /**
   * The subject of this test.
   */
  private BasicResourceManager<TestModel> subject;
  
  /**
   * A model to test the resource manager with.
   */
  private TestModel testModel;
  
  /**
   * Default Constructor.
   */
  public BasicResourceManagerTest() {
  }

  /**
   * {@inheritDoc}
   */
  @BeforeClass
  public static void setUpClass() {
  }

  /**
   * {@inheritDoc}
   */
  @AfterClass
  public static void tearDownClass() {
  }

  /**
   * {@inheritDoc}
   */
  @Before
  public void setUp() {
    subject = new BasicResourceManager<>();
    testModel = new TestModelImpl();
    testModel.setName(TEST_MODEL_NAME);
  }

  /**
   * {@inheritDoc}
   */
  @After
  public void tearDown() {
  }
  
  /**
   * Test that the getter and setters perform as expected.
   */
  @Test
  public void testGetterAndSetter() {
    LOG.info("Test the getter and setter.");
    TestModel initialModel = subject.getResource();
    assertNull("initial model null test", initialModel);
    
    subject.setResource(testModel);
    TestModel result = subject.getResource();
    
    assertNotNull("result null test", result);
    assertEquals("result expected outcome test", testModel, result);
  }
}
