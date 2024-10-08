/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, TeleStax Inc. and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *   JBoss, Home of Professional Open Source
 *   Copyright 2007-2011, Red Hat, Inc. and individual contributors
 *   by the @authors tag. See the copyright.txt in the distribution for a
 *   full listing of individual contributors.
 *
 *   This is free software; you can redistribute it and/or modify it
 *   under the terms of the GNU Lesser General Public License as
 *   published by the Free Software Foundation; either version 2.1 of
 *   the License, or (at your option) any later version.
 *
 *   This software is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *   Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this software; if not, write to the Free
 *   Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 *   02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jdiameter.client.api;

/**
 * This interface provide IOC functionality Data: $Date: 2009/10/10 20:17:57 $ Revision: $Revision: 1.2 $
 *
 * @author erick.svenson@yahoo.com
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @version 1.5.0.1
 */
@SuppressWarnings("all") //3rd party lib
public interface IAssembler {
    /**
     * Return parent IOC
     *
     * @return IOC instance
     */
    IAssembler getParent();

    /**
     * Return all children
     *
     * @return all children
     */
    IAssembler[] getChilds();

    /**
     * Register new component
     *
     * @param aClass class of component
     *
     * @return instance of component
     */
    <T> T getComponentInstance(Class<T> aClass);

    /**
     * Register new component
     *
     * @param object instance of component
     */
    void registerComponentInstance(Object object);

    /**
     * Register new component
     *
     * @param aClass class of component
     * @param object instance of component
     */
    void registerComponentImplementation(Class<?> aClass, Object object);

    /**
     * Release all attached resources
     */
    void destroy();
}
