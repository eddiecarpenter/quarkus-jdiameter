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

package org.jdiameter.api;

/**
 * An exception that provides information on a stack has application request overload.
 *
 * @author erick.svenson@yahoo.com
 * @version 1.5.1 Final
 */
@SuppressWarnings("all") //3rd party lib
public class OverloadException extends Exception {

    private static final long serialVersionUID = 1L;

    double lowThreshold, highThreshold, value;

    /**
     * Default constructor
     */
    public OverloadException() {
        super();
    }

    /**
     * Constructor with overload data
     *
     * @param lowThreshold low threshold overload value
     * @param highThreshold high threshold overload value
     * @param value current overload value
     */
    public OverloadException(double lowThreshold, double highThreshold, double value) {
        this.lowThreshold = lowThreshold;
        this.highThreshold = highThreshold;
        this.value = value;
    }

    /**
     * Constructor with reason string
     *
     * @param message reason string
     */
    public OverloadException(String message) {
        super(message);
    }

    /**
     * Constructor with reason string and parent exception
     *
     * @param message message reason string
     * @param cause parent exception
     */
    public OverloadException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with parent exception
     *
     * @param cause parent exception
     */
    public OverloadException(Throwable cause) {
        super(cause);
    }

    /**
     * @return current low threshold overload value
     */
    public double getLowThreshold() {
        return lowThreshold;
    }

    /**
     * @return current high threshold overload value
     */
    public double getHighThreshold() {
        return highThreshold;
    }

    /**
     * @return current overload value
     */
    public double getValue() {
        return value;
    }
}
