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

import com.logitopia.jmortar.core.service.util.impl.MapResourceManagerImpl;
import com.logitopia.jmortar.core.service.model.TestModel;
import com.logitopia.jmortar.core.service.model.impl.TestModelImpl;
import com.logitopia.jmortar.core.service.util.MapResourceManager;
import static com.logitopia.jmortar.core.service.util.impl.ListResourceManagerImplTest.LOG;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The <tt>MapResourceManagerImplTest</tt> unit test class is a unit test of the
 * <tt>MapResourceManagerImpl</tt> module.
 *
 * @author &lt;Stephen Cheesley stephen.cheesley@gmail.com&gt;
 */
public class MapResourceManagerImplTest {

  /**
   * The logger for this class.
   */
  public static final Logger LOG
          = Logger.getLogger(MapResourceManagerImplTest.class);
  
    /**
   * The test model name value.
   */
  public static final String TEST_MODEL_NAME = "testName";

  /**
   * The subject of this test.
   */
  private MapResourceManager<String, TestModel> subject;

  /**
   * A model to test the resource manager with.
   */
  private TestModel testModel;

  /**
   * Default Constructor.
   */
  public MapResourceManagerImplTest() {
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
    subject = new MapResourceManagerImpl<String, TestModel>();
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
   * Test that we can add a resource to the managed map.
   */
  @Test
  public void testAddResource() {
    LOG.info("Test add resource to map.");

    Map<String, TestModel> initialMap = subject.getResource();
    assertNotNull("initialMap null test", initialMap);
    assertEquals("initialMap size", 0, initialMap.size());

    TestModel returnModel = subject.addResource(TEST_MODEL_NAME, testModel);
    assertNull("return model test", returnModel);

    Map<String, TestModel> updatedMap = subject.getResource();
    assertNotNull("updatedMap null test", updatedMap);
    assertEquals("updatedMap size", 1, updatedMap.size());

    TestModel resultModel = updatedMap.get(TEST_MODEL_NAME);
    assertNotNull("resultModel", resultModel);
    assertTrue("resultModel value test", testModel.equals(resultModel));
  }
  
  /**
   * Test that an item can be removed from the resource map.
   */
  @Test
  public void testRemoveResource() {
    LOG.info("Test remove resource from map.");

    subject.addResource(TEST_MODEL_NAME, testModel);
    Map<String, TestModel> initMap = subject.getResource();
    assertEquals("initMap size", 1, initMap.size());
    
    /* Remove the testModel */
    TestModel resultVal = subject.removeResource(TEST_MODEL_NAME);
    assertNotNull("result value test", resultVal);
    Map<String, TestModel> resultList = subject.getResource();
    assertEquals("resultMap size", 0, resultList.size());
  }
  
  /**
   * Test that a resource map can be reset.
   */
  @Test
  public void testResetResources() {
    LOG.info("Test reset resource from map.");

    subject.addResource(TEST_MODEL_NAME, testModel);
    Map<String, TestModel> initMap = subject.getResource();
    assertEquals("initMap size", 1, initMap.size());
    
    /* Remove the testModel */
    subject.clearResources();
    Map<String, TestModel> resultList = subject.getResource();
    assertEquals("resultMap size", 0, resultList.size());
  }
}
