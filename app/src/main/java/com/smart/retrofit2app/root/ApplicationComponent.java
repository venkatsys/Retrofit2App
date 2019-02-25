package com.smart.retrofit2app.root;



import com.smart.retrofit2app.MainActivity;
import com.smart.retrofit2app.http.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(MainActivity target);

}
