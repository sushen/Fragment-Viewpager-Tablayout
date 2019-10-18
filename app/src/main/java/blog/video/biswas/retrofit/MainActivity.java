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


        ApiClint.getClint().create(ApiService.class)
                .login("demo","12345678")
                .enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        UserResponse userResponse = response.body();
                        Toast.makeText(MainActivity.this,userResponse.getMessage(),Toast.LENGTH_LONG).show();
                        binding.tvEmail.setText(userResponse.getData().getEmail());
                        getAllCategories(userResponse.getData().getToken());

                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void getAllCategories(String token){
        ApiClint.getClint()
                .create(ApiService.class)
                .getAllCagerories(token)
                .enqueue(new Callback<CategoryResponse>() {
                    @Override
                    public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                        CategoryResponse categoryResponse = response.body();
                        Toast.makeText(MainActivity.this,categoryResponse.getMessage(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<CategoryResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }
}
