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
package com.logitopia.jmortar.core.service.exception;

/**
 * The <tt>ServiceException</tt> class is an exception implementation that
 * demonstrates exceptional states in services.
 *
 * @author Stephen Cheesley &lt;stephen.cheesley@gmail.com&gt;
 */
public final class ServiceException extends Exception {

  /**
   * Create an exception with the given message.
   *
   * @param serviceName The name of the service throwing the exception.
   * @param message The description of the exceptional circumstance.
   */
  public ServiceException(final String serviceName,
          final String message) {
    super(message);
  }

  /**
   * Create an exception with the given message and reason.
   *
   * @param serviceName The name of the service throwing the exception.
   * @param message The description of the exceptional circumstance.
   * @param reasonCode The defined reason for the exception.
   */
  public ServiceException(final String serviceName,
          final String message, final ServiceExceptionReasonCode reasonCode) {
    super("[" + reasonCode.getReasonCode() + "]" + message);
  }
}
