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

/**
 * The <tt>ResourceManager</tt> interface is a manager that handles resources
 * for a service.
 *
 * @author Stephen Cheesley &lt;stephen.cheesley@gmail.com&gt;
 * @param <T> This type of resource to be managed by this class.
 */
public interface ResourceManager<T> {

  /**
   * Get the resource being managed.
   *
   * @return The <tt>T</tt> resource being managed.
   */
  T getResource();

  /**
   * Set the resource being managed.
   *
   * @param newResource The <tt>T</tt> resource being managed. 
   */
  void setResource(T newResource);
}
