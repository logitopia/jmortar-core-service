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
package com.logitopia.jmortar.core.service;

import com.logitopia.jmortar.core.service.exception.ServiceException;
import com.logitopia.jmortar.core.service.mock.MockService;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author s.cheesley
 */
public final class AbstractServiceTest {

  /**
   * The logger for this class.
   */
  public static final Logger LOG
          = Logger.getLogger(AbstractServiceTest.class);

  /**
   * Application Context.
   */
  private ApplicationContext context
          = new ClassPathXmlApplicationContext("app.xml");

  /**
   * The service being tested.
   */
  private Service subject = (Service) context.getBean("subject");

  /**
   * The default constructor for the test suite.
   */
  public AbstractServiceTest() {
  }

  /**
   * {@inheritDoc}
   */
  @Before
  public void setUp() {
    try {
      subject.start();
    } catch (ServiceException ex) {
      LOG.error("Service Error", ex);
      fail("Service unable to start");
    }
  }

  /**
   * {@inheritDoc}
   */
  @After
  public void tearDown() {
    try {
      subject.stop();
    } catch (ServiceException ex) {
      LOG.error("Service Error", ex);
      fail("Service unable to stop");
    }
  }

  /**
   * Test that we can create the blank instance.
   */
  @Test
  public void testBlankInstance() {
    try {
      MockService m = new MockService();
      m.setInitialiseOutcome(true);
      m.setValidateOutcome(true);
      m.setPostStartOutcome(true);
      m.setStartupOutcome(true);
      assertTrue("blank name instance status check", m.getStatus() == 0);
    } catch (Exception ex) {
      LOG.error("An unknown exception has occured", ex);
      fail("An exception has occured.");
    }
  }

  /**
   * Test that the service can start and stop.
   */
  @Test
  public void testBasicLifecycle() {
    /* Check that service starts and stops. */
    assertTrue("Service running test", subject.isRunning());

    /* Check that the lifecycle ran correctly */
    MockService mock = (MockService) subject;
    List<String> calls = mock.getMethodCalls();

    assertEquals("No of calls test", 4, calls.size());

    String initCall = calls.get(0);
    assertEquals("initialise call test", "initialise", initCall);

    String validateCall = calls.get(1);
    assertEquals("validate call test", "validate", validateCall);

    String startupCall = calls.get(2);
    assertEquals("startup call test", "startup", startupCall);

    String postStartCall = calls.get(3);
    assertEquals("postStart call test", "postStart", postStartCall);
  }

  /**
   * Test that start fails when initialise returns false.
   */
  @Test
  public void testInitialiseFailure() {
    LOG.info("Testing initialise failure");
    MockService mock = new MockService();
    mock.setInitialiseOutcome(false);
    mock.setValidateOutcome(true);
    mock.setPostStartOutcome(true);
    mock.setStartupOutcome(true);
    try {
      /* Check that service starts and stops. */
      mock.start();
    } catch (ServiceException ex) {
      String message = ex.getMessage();
      assertNotNull("exception message null test", message);
      assertEquals("exception message test",
              "[SVC_UNABLE_TO_START]The implementing class failed on initialise.", message);
    }

    assertTrue("Service failed test", mock.isErrored());
  }
  
  /**
   * Test that start fails when validate returns false.
   */
  @Test
  public void testValidateFailure() {
    LOG.info("Testing validate failure");
    MockService mock = new MockService();
    mock.setInitialiseOutcome(true);
    mock.setValidateOutcome(false);
    mock.setPostStartOutcome(true);
    mock.setStartupOutcome(true);
    try {
      /* Check that service starts and stops. */
      mock.start();
    } catch (ServiceException ex) {
      String message = ex.getMessage();
      assertNotNull("exception message null test", message);
      assertEquals("exception message test",
              "[SVC_UNABLE_TO_START]The implementing class failed on validate.", message);
    }

    assertTrue("Service failed test", mock.isErrored());
  }
  
  /**
   * Test that start fails when startup returns false.
   */
  @Test
  public void testStartupFailure() {
    LOG.info("Testing startup failure");
    MockService mock = new MockService();
    mock.setInitialiseOutcome(true);
    mock.setValidateOutcome(true);
    mock.setPostStartOutcome(true);
    mock.setStartupOutcome(false);
    try {
      /* Check that service starts and stops. */
      mock.start();
    } catch (ServiceException ex) {
      String message = ex.getMessage();
      assertNotNull("exception message null test", message);
      assertEquals("exception message test",
              "[SVC_UNABLE_TO_START]The implementing class failed on startup.", message);
    }

    assertTrue("Service failed test", mock.isErrored());
  }
  
  /**
   * Test that start fails when post start returns false.
   */
  @Test
  public void testPostStartFailure() {
    LOG.info("Testing post start failure");
    MockService mock = new MockService();
    mock.setInitialiseOutcome(true);
    mock.setValidateOutcome(true);
    mock.setPostStartOutcome(false);
    mock.setStartupOutcome(true);
    try {
      /* Check that service starts and stops. */
      mock.start();
    } catch (ServiceException ex) {
      String message = ex.getMessage();
      assertNotNull("exception message null test", message);
      assertEquals("exception message test",
              "[SVC_UNABLE_TO_START]The implementing class failed on post start.", message);
    }

    assertTrue("Service failed test", mock.isErrored());
  }
}
