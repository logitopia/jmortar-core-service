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
package com.logitopia.jmortar.core.service.util;

import java.util.List;

/**
 * The <tt>ListResourceManager</tt> interface is a resource manager that holds a list of resources
 *
 * @author &lt;Stephen Cheesley stephen.cheesley@gmail.com&gt;
 * @param <T> This type of resource to be managed by this class.
 */
public interface ListResourceManager<T> extends ResourceManager<List <T>> {

  /**
   * Add a resource <tt>T</tt> to the <tt>java.util.List</tt> of <tt>T</tt>.
   *
   * @param newResource The resource to be added.
   * @return The result of the add operation (true = success).
   */
  boolean addResource(T newResource);

  /**
   * Remove a resource <tt>T</tt> from the <tt>java.util.List</tt> of
   * <tt>T</tt>.
   *
   * @param newResource The resource to be added.
   * @return The result of the remove operation (true = success).
   */
  boolean removeResource(T newResource);
  
  /**
   * Empty the list of resources in the manager.
   */
  void clearResources();
}
