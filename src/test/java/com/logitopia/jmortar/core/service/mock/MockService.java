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

/*
 * Title: MockService
 *
 * Author: s.cheesley @ Logitopia Technologies
 * Date Created: Dec 15, 2013
 *
 * This code is the intelectual property of Logitopia Technologies.
 */
package com.logitopia.jmortar.core.service.mock;

import com.logitopia.jmortar.core.service.Service;
import com.logitopia.jmortar.core.service.impl.AbstractService;
import java.util.ArrayList;
import java.util.List;

/**
 * The class <tt>MockService</tt> represents a service that exists to conduct testing on the abstract implementation of
 * the service.
 */
public final class MockService extends AbstractService implements Service {

  /**
   * The outcome from the <tt>initialise</tt> call.
   */
  private boolean initialiseOutcome;

  /**
   * The outcome from the <tt>validate</tt> call.
   */
  private boolean validateOutcome;

  /**
   * The outcome from the <tt>startup</tt> call.
   */
  private boolean startupOutcome;

  /**
   * The outcome from the <tt>postStart</tt> call;
   */
  private boolean postStartOutcome;

  /**
   * Contains all calls made to the list of this mock. The string contains the name of the method being called.
   */
  private List<String> methodCalls;

  /**
   * Default Constructor.
   */
  public MockService() {
    this("MockService");
  }

  /**
   * Named Constructor. Create the service with the given name.
   *
   * @param name The name of the service being created.
   */
  public MockService(final String name) {
    super(name);
    methodCalls = new ArrayList<>();
  }

  /**
   * Reset the method calls made to these mock methods.
   */
  public void resetCalls() {
    methodCalls.clear();
  }

  /**
   * Get method calls made to this mock object.
   *
   * @return The method calls made.
   */
  public List<String> getMethodCalls() {
    return methodCalls;
  }

  /**
   * Get the outcome of the <tt>initialise</tt> call.
   *
   * @return The outcome of the initialise call.
   */
  public boolean getInitialiseOutcome() {
    return initialiseOutcome;
  }

  /**
   * Set the outcome of the <tt>initialise</tt> call.
   *
   * @param newInitialiseOutcome The outcome of the initialise call.
   */
  public void setInitialiseOutcome(final boolean newInitialiseOutcome) {
    initialiseOutcome = newInitialiseOutcome;
  }

  /**
   * Get the outcome of the <tt>validate</tt> call.
   *
   * @return The outcome of the validate call.
   */
  public boolean getValidateOutcome() {
    return validateOutcome;
  }

  /**
   * Set the outcome of the <tt>validate</tt> call.
   *
   * @param newValidateOutcome The outcome of the validate call.
   */
  public void setValidateOutcome(final boolean newValidateOutcome) {
    validateOutcome = newValidateOutcome;
  }

  /**
   * Get the outcome of the <tt>startup</tt> call.
   *
   * @return The outcome of the startup call.
   */
  public boolean getStartupOutcome() {
    return startupOutcome;
  }

  /**
   * Set the outcome of the <tt>startup</tt> call.
   *
   * @param newStartupOutcome The outcome of the startup call.
   */
  public void setStartupOutcome(final boolean newStartupOutcome) {
    startupOutcome = newStartupOutcome;
  }

  /**
   * Get the outcome of the <tt>postStart</tt> call.
   *
   * @return The outcome of the <tt>postStart</tt> call.
   */
  public boolean getPostStartOutcome() {
    return postStartOutcome;
  }

  /**
   * Set the outcome of the <tt>postStart</tt> call.
   *
   * @param newPostStartOutcome The outcome of the <tt>postStart</tt> call.
   */
  public void setPostStartOutcome(final boolean newPostStartOutcome) {
    postStartOutcome = newPostStartOutcome;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean startup() {
    methodCalls.add("startup");
    return getStartupOutcome();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean shutdown() {
    boolean result = true;
    methodCalls.add("shutdown");
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean initialise() {
    methodCalls.add("initialise");
    return getInitialiseOutcome();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean validate() {
    methodCalls.add("validate");
    return getValidateOutcome();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean postStart() {
    methodCalls.add("postStart");
    return getPostStartOutcome();
  }
}
