package org.pursuit.blastoff.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.pursuit.blastoff.R;
import org.pursuit.blastoff.model.SpaceResponse;
import org.pursuit.blastoff.ui.rc.UniverseAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class UniverseFragment extends Fragment {

    private FragmentListener fragmentListener;

    public static UniverseFragment newInstance() {
        return new UniverseFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            fragmentListener = (FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() +
                    " must implement FragmentListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_universe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView(view);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentListener = null;
    }

    public void initRecyclerView(View view) {
        final RecyclerView recyclerView = view.findViewById(R.id.universe_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new UniverseAdapter(parsedJSON(view).getSpace().get(1).getUniverse(), fragmentListener));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public SpaceResponse parsedJSON(View view) {
        SpaceResponse result = null;
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<SpaceResponse> gameJsonAdapter = moshi.adapter(SpaceResponse.class);
        try {
            result = gameJsonAdapter.fromJson(getJSONString(view));
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String getJSONString(View view) {
        String jsonString = "";
        InputStream is = view.getResources().openRawResource(R.raw.spacejson);
        Writer writer = new StringWriter();
        try {
            char[] buffer = new char[is.available()];
            Reader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            jsonString = writer.toString();
        } catch (
                UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonString;
    }
}