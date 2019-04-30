package reschikov.geekbrains.popularlibraries.rxjava.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import reschikov.geekbrains.popularlibraries.rxjava.R;
import reschikov.geekbrains.popularlibraries.rxjava.presenter.PresenterRetorfit;

public class RetorfitFragment extends Fragment implements PresenterRetorfit.Loadable{

	private ImageView imageView;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.task_2, container, false);
		Button button = view.findViewById(R.id.button_get);
		imageView = view.findViewById(R.id.image_view);
		final PresenterRetorfit presenter = new PresenterRetorfit(this);
		button.setOnClickListener(vButton -> presenter.toRequest());
		return view;
	}

	@Override
	public void download(String url) {
		Glide.with(imageView.getContext()).load(url).into(imageView);
	}
}
