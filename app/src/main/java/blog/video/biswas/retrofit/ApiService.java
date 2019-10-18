package blog.video.biswas.retrofit;

import blog.video.biswas.retrofit.model.CategoryResponse;
import blog.video.biswas.retrofit.model.UserResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {
    @POST("user/login")
    @FormUrlEncoded
    Call<UserResponse> login(
            @Field("username") String username,
            @Field("password") String password
            );

    @GET("blog/getAllCategories")
    Call<CategoryResponse> getAllCagerories(
            @Header("Authorization") String token
    );
}
