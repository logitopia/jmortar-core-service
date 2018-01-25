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

import com.logitopia.jmortar.core.service.util.ResourceManager;

/**
 * The <tt>AbstractResourceManager</tt> class is an abstract implementation that
 * implements the getters and setters for the resource manager.
 *
 * @author Stephen Cheesley &lt;stephen.cheesley@gmail.com&gt;
 */
public class AbstractResourceManager<T> implements ResourceManager<T> {

  /**
   * The resource being managed.
   */
  private T resource;
  
  /**
   * {@inheritDoc}
   */
  @Override
  public T getResource() {
    return resource;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setResource(final T newResource) {
    resource = newResource;
  }
}
