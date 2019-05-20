package reschikov.geekbrains.popularlibraries.rxjava.view;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import reschikov.geekbrains.popularlibraries.rxjava.R;
import reschikov.geekbrains.popularlibraries.rxjava.model.dagger.AppDagger;
import reschikov.geekbrains.popularlibraries.rxjava.presenter.PresenterNoDiAndDi;

public class NoDiAndDiFragment extends Fragment {

	private static Button take;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_1, container, false);
	    take = view.findViewById(R.id.button_task_1);
        final PresenterNoDiAndDi presenter = new PresenterNoDiAndDi();
        take.setOnClickListener(vButton -> presenter.start());
        create();
	    AppDagger.getInstance().getWatcher().watch(this, "NoDiAndDiFragment");
        return view;
    }

	private void create(){
		new AsyncTask<Void, Void, Void>() {
			@Override
			protected Void doInBackground(Void... voids) {
				double r = 1;
				for (int j = 0; j < 100_000_000; j++){
					r = j * 0.01 + r / 0.01;
				}
				return null;
			}
		}.execute();
	}
}
