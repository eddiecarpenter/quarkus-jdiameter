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

 package org.jdiameter.impl.ha.server.auth;

 import org.jdiameter.api.auth.ServerAuthSession;
 import org.jdiameter.common.api.app.auth.ServerAuthSessionState;
 import org.jdiameter.impl.ha.common.AppSessionDataReplicatedImpl;
 import org.jdiameter.impl.ha.data.CachedSessionDatasource;
 import org.jdiameter.server.impl.app.auth.IServerAuthSessionData;

 import java.io.Serializable;

 /**
  * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
  * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
  */
 public class ServerAuthSessionDataReplicatedImpl extends AppSessionDataReplicatedImpl implements IServerAuthSessionData
 {

     private static final String STATELESS = "STATELESS";
     private static final String STATE = "STATE";
     private static final String TS_TIMEOUT = "TS_TIMEOUT";
     private static final String TS_TIMERID = "TS_TIMERID";

     public ServerAuthSessionDataReplicatedImpl(String sessionId, CachedSessionDatasource datasource)
     {
         super(sessionId, datasource);

         setAppSessionIface(ServerAuthSession.class);
     }

     /*
      * (non-Javadoc)
      *
      * @see org.jdiameter.server.impl.app.cca.IServerCCASessionData#isStateless()
      */
     @Override
     public boolean isStateless()
     {
         return toPrimitive(getFieldValue(STATELESS), true);
     }

     /*
      * (non-Javadoc)
      *
      * @see org.jdiameter.server.impl.app.cca.IServerCCASessionData#setStateless( boolean)
      */
     @Override
     public void setStateless(boolean stateless)
     {
         setFieldValue(STATELESS, stateless);
     }

     /*
      * (non-Javadoc)
      *
      * @see org.jdiameter.server.impl.app.cca.IServerCCASessionData# getServerCCASessionState()
      */
     @Override
     public ServerAuthSessionState getServerAuthSessionState()
     {
         return ServerAuthSessionState.valueOf(getFieldValue(STATE, "IDLE"));
     }

     /*
      * (non-Javadoc)
      *
      * @see org.jdiameter.server.impl.app.cca.IServerCCASessionData# setServerCCASessionState
      * (org.jdiameter.common.api.app.cca.ServerCCASessionState)
      */
     @Override
     public void setServerAuthSessionState(ServerAuthSessionState state)
     {
         if (getFieldValue(STATE) == null) {
             setFieldValue(STATE, state.name());
         }
     }

     @Override
     public void setTsTimeout(long value)
     {
         setFieldValue(TS_TIMEOUT, value);
     }

     @Override
     public long getTsTimeout()
     {
         return toPrimitive((Long) getFieldValue(TS_TIMEOUT));
     }

     @Override
     public void setTsTimerId(Serializable value)
     {
         setFieldValue(TS_TIMERID, value);
     }

     @Override
     public Serializable getTsTimerId()
     {
         return getFieldValue(TS_TIMERID);
     }
 }
