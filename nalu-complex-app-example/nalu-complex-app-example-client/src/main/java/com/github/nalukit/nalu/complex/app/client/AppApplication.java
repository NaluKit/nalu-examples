package com.github.nalukit.nalu.complex.app.client;

import com.github.nalukit.nalu.client.application.IsApplication;
import com.github.nalukit.nalu.client.application.annotation.Application;
import com.github.nalukit.nalu.client.application.annotation.Filters;
import com.github.nalukit.nalu.client.application.annotation.Logger;
import com.github.nalukit.nalu.client.application.annotation.Version;
import com.github.nalukit.nalu.client.module.annotation.Modules;
import com.github.nalukit.nalu.client.tracker.annotation.Tracker;
import com.github.nalukit.nalu.complex.app.client.filter.BartSimpsonFilter;
import com.github.nalukit.nalu.complex.app.client.filter.LoginFilter;
import com.github.nalukit.nalu.complex.app.client.tracker.UpdateClockTracker;
import com.github.nalukit.nalu.complex.app.common.AppContext;
import com.github.nalukit.nalu.complex.app.common.ui.Routes;
import com.github.nalukit.nalu.complex.app.common.ui.common.popup.ShowDirtyDialog;
import com.github.nalukit.nalu.complex.app.module.person.PersonModule;
import com.github.nalukit.nalu.plugin.elemental2.client.DefaultElemental2ClientLogger;

/**
 * Copyright (C) 2018 - 2019 Frank Hossfeld <frank.hossfeld@googlemail.com>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@Application(context = AppContext.class,
             startRoute = Routes.ROUTE_LOGON,
             illegalRouteTarget = Routes.ROUTE_LOGON,
             useColonForParametersInUrl = true,
             confirmPresenter = ShowDirtyDialog.class,
             loader = AppLoader.class)
@Modules({ PersonModule.class })
@Filters(filterClasses = { LoginFilter.class,
                           BartSimpsonFilter.class })
@Logger(clientLogger = DefaultElemental2ClientLogger.class, logger = AppLogger.class)
@Tracker(UpdateClockTracker.class)
@Version("HEAD-SNAPSHOT")
public interface AppApplication
    extends IsApplication {

}
