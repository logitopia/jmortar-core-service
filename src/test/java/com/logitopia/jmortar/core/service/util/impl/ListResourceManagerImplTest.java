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

import com.logitopia.jmortar.core.service.util.impl.ListResourceManagerImpl;
import com.logitopia.jmortar.core.service.model.TestModel;
import com.logitopia.jmortar.core.service.model.impl.TestModelImpl;
import com.logitopia.jmortar.core.service.util.ListResourceManager;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The <tt>ListResourceManagerImplTest</tt> unit test class is a unit test of
 * the <tt>ListResourceManagerImpl</tt> module.
 *
 * @author &lt;Stephen Cheesley stephen.cheesley@gmail.com&gt;
 */
public class ListResourceManagerImplTest {

  /**
   * The logger for this class.
   */
  public static final Logger LOG
          = Logger.getLogger(ListResourceManagerImplTest.class);

  /**
   * The test model name value.
   */
  public static final String TEST_MODEL_NAME = "testName";

  /**
   * The subject of this test.
   */
  private ListResourceManager<TestModel> subject;

  /**
   * A model to test the resource manager with.
   */
  private TestModel testModel;

  /**
   * Default Constructor.
   */
  public ListResourceManagerImplTest() {
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
    subject = new ListResourceManagerImpl<TestModel>();
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
   * Test that we can add a resource to the managed list.
   */
  @Test
  public void testAddResource() {
    LOG.info("Test add resource to list.");

    List<TestModel> initialList = subject.getResource();
    assertNotNull("initialList null test", initialList);
    assertEquals("initialList size", 0, initialList.size());

    boolean returnVal = subject.addResource(testModel);
    assertTrue("return value", returnVal);

    List<TestModel> updatedList = subject.getResource();
    assertNotNull("updatedList null test", updatedList);
    assertEquals("updatedList size", 1, updatedList.size());

    TestModel resultModel = updatedList.get(0);
    testModel.equals(resultModel);
  }
  
  /**
   * Test that an item can be removed from the resource list.
   */
  @Test
  public void testRemoveResource() {
    LOG.info("Test remove resource from list.");

    subject.addResource(testModel);
    List<TestModel> initList = subject.getResource();
    assertEquals("updatedList size", 1, initList.size());
    
    /* Remove the testModel */
    boolean resultVal = subject.removeResource(testModel);
    assertTrue("result value test", resultVal);
    List<TestModel> resultList = subject.getResource();
    assertEquals("resultList size", 0, resultList.size());
  }
  
  /**
   * Test that the resource list can be reset.
   */
  @Test
  public void testResetResources() {
    LOG.info("Test reset resource from list.");

    subject.addResource(testModel);
    List<TestModel> initList = subject.getResource();
    assertEquals("updatedList size", 1, initList.size());
    
    /* Remove the testModel */
    subject.clearResources();
    List<TestModel> resultList = subject.getResource();
    assertEquals("resultList size", 0, resultList.size());
  }
}
