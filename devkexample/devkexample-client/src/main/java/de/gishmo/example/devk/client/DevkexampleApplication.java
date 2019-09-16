package de.gishmo.example.devk.client;

import com.github.nalukit.nalu.client.application.IsApplication;
import com.github.nalukit.nalu.client.application.annotation.Application;
import com.github.nalukit.nalu.client.application.annotation.Debug;
import com.github.nalukit.nalu.client.application.annotation.Filters;
import com.github.nalukit.nalu.plugin.elemental2.client.DefaultElemental2Logger;
import de.gishmo.example.devk.client.filter.BartSimpsonFilter;
import de.gishmo.example.devk.client.filter.LoginFilter;

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
@Application(context = ApplicationContext.class,
             startRoute = Routes.ROUTE_LOGON,
             loader = ApplicationLoader.class)
@Debug(logger = DefaultElemental2Logger.class,
       logLevel = Debug.LogLevel.DETAILED)
@Filters(filterClasses = { LoginFilter.class,
                           BartSimpsonFilter.class })
public interface DevkexampleApplication
    extends IsApplication {

}
