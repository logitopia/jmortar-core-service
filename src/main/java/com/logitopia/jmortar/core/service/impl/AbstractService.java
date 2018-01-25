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
package com.logitopia.jmortar.core.service.impl;

import com.logitopia.jmortar.core.service.Service;
import com.logitopia.jmortar.core.service.exception.ServiceException;
import com.logitopia.jmortar.core.service.exception.ServiceExceptionReasonCode;
import org.apache.log4j.Logger;

/**
 * The <tt>AbstractService</tt> class is an abstract representation of the
 * <tt>Service</tt> interface. It implements the core functionality of the Service interface allowing concrete
 * implementations to concentrate on specifics.
 *
 * @author s.cheesley
 */
public abstract class AbstractService implements Service {

  /**
   * The logger for this class.
   */
  public static final Logger LOG
          = Logger.getLogger(AbstractService.class);

  /**
   * The default name given to all services not named.
   */
  public static final String DEFAULT_NAME = "SERVICE";

  /**
   * The name of this service.
   */
  private String serviceName;

  /**
   * The status of this service.
   */
  private int serviceStatus;

  /**
   * Default constructor. Service is set up with default name.
   */
  public AbstractService() {
    this(AbstractService.DEFAULT_NAME);
  }

  /**
   * Named constructor. Creates an instance of the service with the given name.
   *
   * @param name The name to give to the service.
   */
  public AbstractService(final String name) {
    serviceName = name;
    serviceStatus = AbstractService.NEW;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final String getName() {
    return serviceName;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final int getStatus() {
    return serviceStatus;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final boolean isRunning() {
    boolean result;
    result = getStatus() == AbstractService.RUNNING;
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final boolean isStopped() {
    boolean result;
    result = getStatus() == AbstractService.STOPPED;
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final boolean isErrored() {
    boolean result;
    result = getStatus() == AbstractService.ERROR;
    return result;
  }

  /**
   * {@inheritDoc}
   */
  public abstract boolean shutdown();

  /**
   * Start procedure - Stage One - Initialise. When the service starts the first part of the procedure is to
   * "initialise" the module. This can involve creating new instances of members e.t.c.
   *
   * @return A success flag (true == success)
   */
  public abstract boolean initialise();

  /**
   * Start procedure - Stage Two - Validate. Once all of the services members have been initialised, the next step is to
   * perform validation to ensure that the service is ready to run.
   *
   * @return A success flag (true == success)
   */
  public abstract boolean validate();

  /**
   * Start procedure - Stage Three - Startup. Once all validation has been carried out, this method is implemented by
   * the base implementation to perform any startup or calibration that is required of service members.
   *
   * @return A success flag (true == success)
   */
  public abstract boolean startup();

  /**
   * Start procedure - Stage Four - Post Start. Once the service is started, any post-startup calibration can be carried
   * out here.
   *
   * @return A success flag (true == success)
   */
  public abstract boolean postStart();

  /**
   * {@inheritDoc}
   */
  @Override
  public final void start() throws ServiceException {
    StringBuilder errMsg
            = new StringBuilder("Service [");
    errMsg.append(getName());
    errMsg.append("] unable to start: ");

    if (!isRunning()) {
      serviceStatus = AbstractService.STARTING;
      LOG.info("Service " + this.serviceName + " is now starting.");

      if (initialise()) {
        if (validate()) {
          if (startup()) {
            /* Startup successful! - Set service to running. */
            serviceStatus = AbstractService.RUNNING;
            LOG.info("Service " + serviceName + " is now running.");
            if (postStart()) {
              LOG.info("Service " + serviceName + " is now running and has completed Post Start procedures.");
            } else {
              /* Implementing class failed. */
              startErrorHandling("The implementing class failed on post start.");
            }
          } else {
            /* Implementing class failed. */
            startErrorHandling("The implementing class failed on startup.");
          }
        } else {
          /* Implementing class failed. */
          startErrorHandling("The implementing class failed on validate.");
        }
      } else {
        /* Implementing class failed. */
        startErrorHandling("The implementing class failed on initialise.");
      }
    } else {
      errMsg.append("The service is already running.");
      LOG.error(errMsg.toString());
    }
  }

  /**
   * Handle errors for the service start procedure.
   *
   * @param errorMsg The error message to write.
   * @throws A <tt>ServiceException</tt> when an error is encountered on startup.
   */
  private void startErrorHandling(final String errorMsg) throws ServiceException {
    /* Implementing class failed. */
    serviceStatus = AbstractService.ERROR;
    LOG.error(errorMsg);
    throw (new ServiceException(getName(), errorMsg,
              ServiceExceptionReasonCode.UNABLE_TO_START));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final void stop() throws ServiceException {
    StringBuilder errMsg
            = new StringBuilder("Service [");
    errMsg.append(getName());
    errMsg.append("] unable to stop: ");

    if (isRunning()) {
      serviceStatus = AbstractService.STOPPING;
      if (shutdown()) {
        /* Shutdown successful! - Set service to stopped. */
        serviceStatus = AbstractService.STOPPED;
      } else {
        /* Implementing class failed. */
        serviceStatus = AbstractService.RUNNING;
        errMsg.append("The implementing class has failed shutdown.");
        throw (new ServiceException(getName(), errMsg.toString(),
                ServiceExceptionReasonCode.UNABLE_TO_STOP));
      }
    } else {
      errMsg.append("The service is not running.");
      throw (new ServiceException(getName(), errMsg.toString(),
              ServiceExceptionReasonCode.UNABLE_TO_STOP));
    }
  }

}
