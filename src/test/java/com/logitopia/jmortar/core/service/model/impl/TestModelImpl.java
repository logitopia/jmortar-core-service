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

/**
 * Title: TestModelImpl.java
 *
 * Author: Stephen Cheesley stephen.cheesley@gmail.com Date Created: 16-Jun-2015
 *
 * This code is the intellectual property of Logitopia Technologies.
 */
package com.logitopia.jmortar.core.service.model.impl;

import com.logitopia.jmortar.core.service.model.TestModel;
import org.apache.log4j.Logger;

/**
 * The <tt>TestModelImpl</tt> class is an implementation that ...(TODO)
 *
 * @author &lt;Stephen Cheesley stephen.cheesley@gmail.com&gt;
 */
public class TestModelImpl implements TestModel {

  /**
   * The logger for this class.
   */
  public static final Logger LOG
          = Logger.getLogger(TestModelImpl.class);

  /**
   * The string value member.
   */
  private String name;

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setName(String name) {
    this.name = name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    boolean result = false;
    if (obj != null && obj instanceof TestModel) {
      TestModel that = (TestModel) obj;
      
      if (this.getName() != null && this.getName().equals(that.getName())) {
        result = true;
      }
    }
    return result;
  }
  
  
}
