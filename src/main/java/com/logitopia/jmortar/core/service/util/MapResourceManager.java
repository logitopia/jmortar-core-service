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

import java.util.Map;

/**
 * The <tt>MapResourceManager</tt> interface is a resource manager that holds a
 * map of resources to String.
 *
 * @author &lt;Stephen Cheesley stephen.cheesley@gmail.com&gt;
 * @param <K> The key to map the resource to.
 * @param <T> This type of resource to be managed by this class.
 */
public interface MapResourceManager<K, T>
        extends ResourceManager<Map<K, T>> {

  /**
   * Add a resource <tt>T</tt> to the <tt>java.util.Map</tt> of <tt>K</tt> to
   * <tt>T</tt>.
   *
   * @param key The unique value to identify the resource by.
   * @param newResource The resource to add to the <tt>java.util.Map</tt>.
   * @return The resource previously associated with the key, or null, if it was
   * empty before.
   */
  T addResource(K key, T newResource);

  /**
   * Remove a resource from the <tt>java.util.Map</tt> associated with the key
   * <tt>K</tt>.
   *
   * @param key The key of the resource to remove.
   * @return The resource that is being removed, null is returned if no resource
   * matched the given key.
   */
  T removeResource(K key);

  /**
   * Empty the collection of resources in the manager.
   */
  void clearResources();
}
