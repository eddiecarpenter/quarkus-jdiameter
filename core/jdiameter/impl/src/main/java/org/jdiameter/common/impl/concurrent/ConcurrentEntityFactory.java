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

package org.jdiameter.common.impl.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;

import org.jdiameter.api.Configuration;
import org.jdiameter.client.impl.helpers.Parameters;
import org.jdiameter.common.api.concurrent.IConcurrentEntityFactory;
import org.jdiameter.common.api.statistic.IStatistic;
import org.jdiameter.common.api.statistic.IStatisticRecord;

/**
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
@SuppressWarnings("all") //3rd party libs
public class ConcurrentEntityFactory implements IConcurrentEntityFactory {
    private Configuration config;

    // TODO: get rid of that?
    public ConcurrentEntityFactory(Configuration config) {
        this.config = config;
    }

    @Override
    public ThreadFactory newThreadFactory() {
        boolean useVirtualThreads = config.getBooleanValue(Parameters.UseVirtualThreads.ordinal(),
                (Boolean) Parameters.UseVirtualThreads.defValue());
        return new BaseThreadFactory(useVirtualThreads);
    }

    @Override
    public RejectedExecutionHandler newRejectedExecutionHandler(IStatisticRecord rejectedCount) {
        return new DefaultRejectedExecutionHandler(rejectedCount);
    }

    @Override
    public <L> Callable<L> newDefaultCallable(Callable<L> runnable, IStatistic statistic,
            IStatisticRecord... statisticRecords) {
        return new DefaultCallable<L>(runnable, statistic, statisticRecords);
    }

    @Override
    public Runnable newDefaultRunnable(Runnable runnable, IStatistic statistic, IStatisticRecord... statisticRecords) {
        return new DefaultRunnable(runnable, statistic, statisticRecords);
    }
}
