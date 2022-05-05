package com.github.nalukit.nalu.complex.app.module.person;

import com.github.nalukit.nalu.client.module.IsModule;
import com.github.nalukit.nalu.client.module.annotation.Module;
import com.github.nalukit.nalu.complex.app.common.AppContext;

@Module(name = "personModule", context = AppContext.class, loader = PersonModuleLoader.class)
public interface PersonModule
    extends IsModule<AppContext> {

}
