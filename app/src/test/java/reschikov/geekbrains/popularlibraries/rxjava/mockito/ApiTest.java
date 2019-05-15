package reschikov.geekbrains.popularlibraries.rxjava.mockito;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Single;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;
import reschikov.geekbrains.popularlibraries.rxjava.model.Data;
import reschikov.geekbrains.popularlibraries.rxjava.presenter.PresenterRetrofit;

@RunWith(MockitoJUnitRunner.class)
public class ApiTest {

	private PresenterRetrofit presenter;

	@Mock
	PresenterRetrofit.Loadable loadable;

	@BeforeClass
	public static void setupClass(){
		RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable -> Schedulers.trampoline());
	}

	@Before
	public void init(){
//		MockitoAnnotations.initMocks(this);
		presenter = Mockito.spy(new PresenterRetrofit(loadable));
		Data.Avatar myAvatar = new Data().new Avatar();
		myAvatar.setUrl("https://avatars0.githubusercontent.com/u/66577?v=4");
		Mockito.when(presenter.getReply()).thenReturn(Single.just(myAvatar));
	}

	@Test
	public void getUrl_isCorrect(){
		presenter.toRequest();
		Mockito.verify(loadable).download("https://avatars0.githubusercontent.com/u/66577?v=4");
	}
}
