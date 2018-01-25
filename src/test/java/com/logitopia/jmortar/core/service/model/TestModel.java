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
 * Title: TestModel.java
 *
 * Author: Stephen Cheesley stephen.cheesley@gmail.com Date Created: 16-Jun-2015
 *
 * This code is the intellectual property of Logitopia Technologies.
 */
package com.logitopia.jmortar.core.service.model;

/**
 * The <tt>TestModel</tt> interface is a ...TODO
 *
 * @author &lt;Stephen Cheesley stephen.cheesley@gmail.com&gt;
 */
public interface TestModel {

  /**
   * Get the name of the test model.
   *
   * @return The name.
   */
  String getName();

  /**
   * Set the name of the test model.
   *
   * @param name The name.
   */
  void setName(final String name);
}
