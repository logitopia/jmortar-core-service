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
 * The <tt>ServiceExceptionReasonCode</tt> enum is a type that defines reason
 * codes for a <tt>ServiceException</tt>.
 *
 * @author Stephen Cheesley &lt;stephen.cheesley@gmail.com&gt;
 */
public enum ServiceExceptionReasonCode {

  /**
   * The service is not running.
   */
  NOT_RUNNING("SVC_NOT_RUNNING"),
  /**
   * The service has attempted to start but was unable to.
   */
  UNABLE_TO_START("SVC_UNABLE_TO_START"),
  /**
   * The service has attempted to stop but was unable to.
   */
  UNABLE_TO_STOP("SVC_UNABLE_TO_STOP");

  /**
   * The reason code in this enum.
   */
  private String reasonCode;

  /**
   * Create a new instance of the <tt>ServiceExceptionReasonCode</tt>.
   *
   * @param newReasonCode The reason code.
   */
  private ServiceExceptionReasonCode(final String newReasonCode) {
    reasonCode = newReasonCode;
  }

  /**
   * Get the reason code set in this instance.
   *
   * @return The reason code.
   */
  public String getReasonCode() {
    return reasonCode;
  }
}
