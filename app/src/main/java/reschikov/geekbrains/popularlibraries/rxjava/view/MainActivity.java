package reschikov.geekbrains.popularlibraries.rxjava.view;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import reschikov.geekbrains.popularlibraries.rxjava.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        if (savedInstanceState == null) loadFragment(new RoomFragment(), "Room");
    }

    private void loadFragment(Fragment newFragment, String tag){
        getSupportFragmentManager().beginTransaction()
        .replace(R.id.frame_master, newFragment, tag)
        .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                loadFragment(new GsonFragment(), "Gson");
                return true;
            case R.id.navigation_dashboard:
                loadFragment(new RetorfitFragment(), "Task2");
                return true;
            case R.id.navigation_notifications:
                loadFragment(new RoomFragment(), "Room");
                return true;
        }
        return false;
    }
}
