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

import com.logitopia.jmortar.core.service.util.ListResourceManager;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * The <tt>ListResourceManagerImpl</tt> class is an implementation that
 * ...(TODO)
 *
 * @author &lt;Stephen Cheesley stephen.cheesley@gmail.com&gt;
 */
public final class ListResourceManagerImpl<T>
        extends AbstractResourceManager<List<T>>
        implements ListResourceManager<T> {

  /**
   * The logger for this class.
   */
  public static final Logger LOG
          = Logger.getLogger(ListResourceManagerImpl.class);

  /**
   * Creates an instance of the <tt>ListResourceManagerImpl</tt> class
   * with a default <tt>java.util.ArrayList</tt> implementation.
   */
  public ListResourceManagerImpl() {
    setResource(new ArrayList<T>());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean addResource(final T newResource) {
    boolean result;
    List<T> resourceList = getResource();
    result = resourceList.add(newResource);
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean removeResource(T newResource) {
    boolean result;
    List<T> resourceList = getResource();
    result = resourceList.remove(newResource);
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void clearResources() {
    List<T> resourceList = getResource();
    resourceList.clear();
  }
}
