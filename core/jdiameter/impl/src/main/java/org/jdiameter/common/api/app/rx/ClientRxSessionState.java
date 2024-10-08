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

package org.jdiameter.common.api.app.rx;

import org.jdiameter.common.api.app.IAppSessionState;

/**
 * Diameter 3GPP IMS Rx Reference Point Client Session States
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 */
public enum ClientRxSessionState implements IAppSessionState<ClientRxSessionState> {

    IDLE(0),
    PENDING_AAR(1),
    PENDING_STR(2),
    PENDING_EVENT(3),
    PENDING_BUFFERED(4),
    OPEN(5);

    private int stateValue;

    ClientRxSessionState(int stateV) {
        this.stateValue = stateV;
    }

    @Override
    public ClientRxSessionState fromInt(int v) throws IllegalArgumentException {
        switch (v) {
            case 0:
                return IDLE;
            case 1:
                return PENDING_AAR;
            case 2:
                return PENDING_STR;
            case 3:
                return PENDING_EVENT;
            case 4:
                return PENDING_BUFFERED;
            case 5:
                return OPEN;
            default:
                throw new IllegalArgumentException("Illegal value of int representation!!!!");
        }
    }

    @Override
    public int getValue() {
        return stateValue;
    }
}
