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

package org.jdiameter.common.api.app.cxdx;

import org.jdiameter.api.app.AppSession;
import org.jdiameter.api.app.StateChangeListener;
import org.jdiameter.api.cxdx.ClientCxDxSessionListener;
import org.jdiameter.api.cxdx.ServerCxDxSessionListener;
import org.jdiameter.common.api.app.IAppSessionFactory;

/**
 * Session Factory interface for Diameter CxDx application.
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
@SuppressWarnings("all") //3rd party lib
public interface ICxDxSessionFactory extends IAppSessionFactory {

    /**
     * Get stack wide listener for sessions. In local mode it has similar effect as setting this directly in app
     * session. However clustered session use this value when recreated!
     *
     * @return the clientSessionListener
     */
    ClientCxDxSessionListener getClientSessionListener();

    /**
     * Set stack wide listener for sessions. In local mode it has similar effect as setting this directly in app
     * session. However clustered session use this value when recreated!
     *
     * @param clientSessionListener the clientSessionListener to set
     */
    void setClientSessionListener(ClientCxDxSessionListener clientSessionListener);

    /**
     * Get stack wide listener for sessions. In local mode it has similar effect as setting this directly in app
     * session. However clustered session use this value when recreated!
     *
     * @return the serverSessionListener
     */
    ServerCxDxSessionListener getServerSessionListener();

    /**
     * Set stack wide listener for sessions. In local mode it has similar effect as setting this directly in app
     * session. However clustered session use this value when recreated!
     *
     * @param serverSessionListener the serverSessionListener to set
     */
    void setServerSessionListener(ServerCxDxSessionListener serverSessionListener);

    /**
     * @return the messageFactory
     */
    ICxDxMessageFactory getMessageFactory();

    /**
     * @param messageFactory the messageFactory to set
     */
    void setMessageFactory(ICxDxMessageFactory messageFactory);

    /**
     * @return the stateListener
     */
    StateChangeListener<AppSession> getStateListener();

    /**
     * @param stateListener the stateListener to set
     */
    void setStateListener(StateChangeListener<AppSession> stateListener);
}
