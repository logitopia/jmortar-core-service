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
package com.logitopia.jmortar.core.service.util.impl;

import com.logitopia.jmortar.core.service.util.MapResourceManager;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 * The <tt>MapResourceManagerImpl</tt> class is an implementation that ...(TODO)
 *
 * @author &lt;Stephen Cheesley stephen.cheesley@gmail.com&gt;
 */
public class MapResourceManagerImpl<K, T>
        extends AbstractResourceManager<Map<K, T>>
        implements MapResourceManager<K, T> {

  /**
   * The logger for this class.
   */
  public static final Logger LOG
          = Logger.getLogger(MapResourceManagerImpl.class);

  /**
   * Creates an instance of the <tt>MapResourceManagerImpl</tt> class with a
   * default <tt>java.util.HashMap</tt> implementation.
   */
  public MapResourceManagerImpl() {
    setResource(new HashMap<K, T>());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public T addResource(K key, T newResource) {
    T result;
    Map<K, T> resourceMap = getResource();
    result = resourceMap.put(key, newResource);
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public T removeResource(K key) {
    T result;
    Map<K, T> resourceMap = getResource();
    result = resourceMap.remove(key);
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void clearResources() {
    Map<K, T> resourceMap = getResource();
    resourceMap.clear();
  }
}
