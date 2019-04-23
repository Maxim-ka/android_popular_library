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
import reschikov.geekbrains.popularlibraries.rxjava.presenter.PresenterTask2;

public class Task2Fragment extends Fragment {

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.task_2, container, false);
		Button subscription = view.findViewById(R.id.button_subscription);
		Button unsubscribe = view.findViewById(R.id.button_unsubscribe);
		Button spam = view.findViewById(R.id.button_spam);
		final PresenterTask2 presenter = new PresenterTask2();
		subscription.setOnClickListener(vButton -> presenter.subscribe());
		unsubscribe.setOnClickListener(vButton -> presenter.unsubscribe());
		spam.setOnClickListener(vButton -> presenter.toSpam());
		return view;
	}
}
