package com.example.newsapplication.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.DocumentsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.newsapplication.Api;
import com.example.newsapplication.NewsRetrofit;
import com.example.newsapplication.R;
import com.example.newsapplication.model.Article;
import com.example.newsapplication.model.MainBranch;
import com.example.newsapplication.model.Source;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    Call<MainBranch> call;
    ArrayList<Article> mArticles;
    ArrayList<Source> mSources;
    public  NewsRetrofit retrofit;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }

        Api api = retrofit.getmRetrofitNews().create(Api.class);
        call =  api.getAllNews();
        //  call  = api.getAllNews("us","94b814eea3be4ffb8cdad8ea3d0d64eb");
        Log.d("ok","Renspones ======= " + call.toString());

        call.enqueue(new Callback<MainBranch>() {
            @Override
            public void onResponse(Call<MainBranch> call, Response<MainBranch> response) {
                Log.d("ok","Renspones ======= " + response);
            }

            @Override
            public void onFailure(Call<MainBranch> call, Throwable t) {
                Log.d("ok", " Exception inter " +t.getMessage());
            }
        });


//        call.enqueue(new Callback<Root>() {
//            @Override
//            public void onResponse(Call<Root> call, Response<Root> response) {
//                try {
//                    Root mRoot = response.body();
//                    Log.d("ok","Renspones ======= " + response);
//                    mArticles = new ArrayList(Arrays.asList(mRoot.getArticles()));
//                    Log.d("ok","Renspones = " +  mSources);
//
//                }catch (Exception e){
//                    Toast.makeText(getContext(), " ! pleses enter right Anime name" , Toast.LENGTH_SHORT).show();
//                    Log.d("ok", " Exception inter ");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Root> call, Throwable t) {
//                Toast.makeText(getContext(), "error in respones (internet)" + t.getMessage(), Toast.LENGTH_SHORT).show();
//                Log.d("ok", "response falied " + t.getMessage());
//            }
//        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);




    }
}