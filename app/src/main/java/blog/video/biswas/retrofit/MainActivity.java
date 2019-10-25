package blog.video.biswas.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import blog.video.biswas.retrofit.databinding.ActivityMainBinding;
import blog.video.biswas.retrofit.model.CategoryResponse;
import blog.video.biswas.retrofit.model.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager());

        viewpagerAdapter.addFragment(new FragmentLogin(),"Login");
        viewpagerAdapter.addFragment(new FragmentSignup(),"SignUp");

        binding.vp.setAdapter(viewpagerAdapter);
        binding.tabLayout.setupWithViewPager(binding.vp);
    }
}
