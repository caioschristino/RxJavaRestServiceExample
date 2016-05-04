package com.example.caios.rxjavarestserviceexample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import com.example.caios.rxjavarestserviceexample.Adapter.CardFamousPeopleAdapter;
import com.example.caios.rxjavarestserviceexample.Adapter.CardGitHubAdapter;
import com.example.caios.rxjavarestserviceexample.Mocky.FamousPeopleMock;
import com.example.caios.rxjavarestserviceexample.Model.FamousPeople;
import com.example.caios.rxjavarestserviceexample.Model.FamousPeopleResponse;
import com.example.caios.rxjavarestserviceexample.Model.Github;
import com.example.caios.rxjavarestserviceexample.Service.FamousPeopleService;
import com.example.caios.rxjavarestserviceexample.Service.GithubService;
import com.example.caios.rxjavarestserviceexample.Service.ServiceFactory;

import java.util.List;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Set up Android CardView/RecycleView
         */
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        final CardGitHubAdapter mCardGitHubAdapter = new CardGitHubAdapter();
        final CardFamousPeopleAdapter mCardFamousPeople = new CardFamousPeopleAdapter();
        mRecyclerView.setAdapter(mCardFamousPeople);

        /**
         * START: button set up
         */
        Button bClear = (Button) findViewById(R.id.button_clear);
        Button bFetch = (Button) findViewById(R.id.button_fetch);
        bClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                mCardGitHubAdapter.clear();
                mCardFamousPeople.clear();
            }
        });

        bFetch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                executeGithubService(mCardGitHubAdapter);
                executeFamousPeopleService(mCardFamousPeople);
            }
        });


        FamousPeopleMock mock = new FamousPeopleMock();
        Log.e("-->", mock.getJsonObject());
    }

    public void executeGithubService(final CardGitHubAdapter mCardGitHubAdapter) {
        GithubService service = ServiceFactory.createRetrofitService(GithubService.class, GithubService.SERVICE_ENDPOINT);
        for (String login : Data.githubList) {
            service.getUser(login)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<Github>() {
                        @Override
                        public final void onCompleted() {
                            // do nothing
                        }

                        @Override
                        public final void onError(Throwable e) {
                            Log.e("GithubDemo", e.getMessage());
                        }

                        @Override
                        public final void onNext(Github response) {
                            mCardGitHubAdapter.addData(response);
                        }
                    });
        }
    }

    public void executeFamousPeopleService(final CardFamousPeopleAdapter mFamousPeopleAdapter) {
        FamousPeopleService service = ServiceFactory.createRetrofitService(FamousPeopleService.class, FamousPeopleService.SERVICE_ENDPOINT);
        for (String mock : Data.mockHost) {
            service.getUser(mock)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<FamousPeopleResponse>() {
                        @Override
                        public final void onCompleted() {
                            // do nothing
                        }

                        @Override
                        public final void onError(Throwable e) {
                            Log.e("FamousPeopleDemo", e.getMessage());
                        }

                        @Override
                        public final void onNext(FamousPeopleResponse response) {
                            mFamousPeopleAdapter.addData(response.getFamousPeople());
                        }
                    });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}