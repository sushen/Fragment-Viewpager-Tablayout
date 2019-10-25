package blog.video.biswas.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import blog.video.biswas.retrofit.databinding.FragmentLoginBinding;

public class FragmentLogin extends Fragment {

    private FragmentLoginBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false);


      binding.btnLogin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              getActivity().startActivity(new Intent(getActivity(),MainActivity.class));
          }
      });
      return binding.getRoot();
    }
}
