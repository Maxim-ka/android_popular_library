package reschikov.geekbrains.popularlibraries.rxjava.presenter;

import android.os.AsyncTask;
import android.util.Log;

public class PresenterTask1 {

    public void start(){
       new MyAsyncTask().execute();
       Log.i("task_1", "метод завершён");
    }

    private static class MyAsyncTask extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i < 5; i++) {
                calculate();
                Log.i("Message", String.format("message %d - %s", i, Thread.currentThread().getName()));
            }
            return null;
        }

        private void calculate() {
            double r = 1;
            for (int j = 0; j < 80_000_000; j++)
                r = j * 0.01 + r / 0.01;
        }
    }
}
