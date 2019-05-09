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
import reschikov.geekbrains.popularlibraries.rxjava.presenter.PresenterRoom;

public class RoomFragment extends Fragment {

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.room, container, false);
		Button buttonAdd = view.findViewById(R.id.button_add);
		Button buttonAddFew = view.findViewById(R.id.button_add_few);
		Button buttonDel = view.findViewById(R.id.button_del);
		Button buttonUpdate = view.findViewById(R.id.button_update);
		Button buttonCheck = view.findViewById(R.id.button_check);
		PresenterRoom presenter = new PresenterRoom();
		buttonAdd.setOnClickListener(v -> presenter.add());
		buttonAddFew.setOnClickListener(v -> presenter.addFew());
		buttonDel.setOnClickListener(v -> presenter.delete());
		buttonUpdate.setOnClickListener(v -> presenter.update());
		buttonCheck.setOnClickListener(v -> presenter.check());
		return view;
	}
}
