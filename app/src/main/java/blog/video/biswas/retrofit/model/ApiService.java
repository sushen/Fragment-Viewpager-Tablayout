package blog.video.biswas.retrofit.model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @POST("user/login")
    @FormUrlEncoded
    Call<UserResponse> login(
            @Field("username") String username,
            @Field("password") String password
        );
}
