package reschikov.geekbrains.popularlibraries.rxjava.presenter;

import reschikov.geekbrains.popularlibraries.rxjava.model.Green;
import reschikov.geekbrains.popularlibraries.rxjava.model.RedDi;
import reschikov.geekbrains.popularlibraries.rxjava.model.RedNoDi;
import reschikov.geekbrains.popularlibraries.rxjava.model.WhiteDi;
import reschikov.geekbrains.popularlibraries.rxjava.model.WhiteNoDi;
import reschikov.geekbrains.popularlibraries.rxjava.model.dagger.AppDagger;

public class PresenterNoDiAndDi {

    public void start(){
	    new RedNoDi();
	    new WhiteNoDi();
	    Green green = new Green();
	    new RedDi(green);
	    new WhiteDi(green);
	    AppDagger.getInstance().getWatcher().watch(green, "Green");
    }
}
