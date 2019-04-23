package reschikov.geekbrains.popularlibraries.rxjava.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import reschikov.geekbrains.popularlibraries.rxjava.R;
import reschikov.geekbrains.popularlibraries.rxjava.presenter.PresenterTask3;

public class Task3Fragment extends Fragment {

	private PresenterTask3 presenter;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.task_3, container, false);
		Button subscription = view.findViewById(R.id.button_subscription);
		Button unsubscribe = view.findViewById(R.id.button_unsubscribe);
		presenter = new PresenterTask3();
		subscription.setOnClickListener(vButton -> presenter.toRegister());
		unsubscribe.setOnClickListener(vButton -> presenter.unsubscribe());
		return view;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		presenter.unsubscribe();
	}
}
