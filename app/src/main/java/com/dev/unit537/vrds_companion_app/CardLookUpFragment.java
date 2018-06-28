package com.dev.unit537.vrds_companion_app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CardLookUpFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private Retrofit retrofit;
    private YGOHubAPI ygoHubAPI;
    private Thread workerThread;

    private Button searchButton;
    private Button cardTipsButton;
    private Button rulingsButton;
    private Button yugipediaButton;
    private Button AddToTrunkButton;
    private Button AddToDeckButton;
    private Button checkPricesButton;
    private EditText searchQueryEditText;
    private ImageView cardScanImageView;
    private TextView cardDescTextView;
    private TextView cardTextTextView;

    public CardLookUpFragment() {
        // Required empty public constructor
    }

    public static CardLookUpFragment newInstance() {
        return new CardLookUpFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_card_look_up, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        View view = getView();

        if (savedInstanceState != null) {
            //Restore the fragment's state here
        }

        searchButton = view.findViewById(R.id.button_cardSearch);
        cardTipsButton = view.findViewById(R.id.button_cardTips);
        rulingsButton = view.findViewById(R.id.button_rulings);
        yugipediaButton = view.findViewById(R.id.button_yugipedia);
        AddToTrunkButton = view.findViewById(R.id.button_addToTrunk);
        AddToDeckButton = view.findViewById(R.id.button_addToDeck);
        checkPricesButton = view.findViewById(R.id.button_checkPrices);
        searchQueryEditText = view.findViewById(R.id.editText_cardSearch);
        cardScanImageView = view.findViewById(R.id.imageView_cardScan);
        cardDescTextView = view.findViewById(R.id.textView_cardDesc);
        cardTextTextView = view.findViewById(R.id.textView_cardText);

        retrofit = new Retrofit.Builder()
                .baseUrl(ygoHubAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ygoHubAPI = retrofit.create(YGOHubAPI.class);

        setupListeners();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save the fragment's state here
    }

    public void setupListeners(){
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = searchQueryEditText.getText().toString().trim();

                Call<YGOHubResponse> call = ygoHubAPI.getCardByName(query);
                call.enqueue(new Callback<YGOHubResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<YGOHubResponse> call, @NonNull Response<YGOHubResponse> response) {
                        try {
                            Card card = response.body().getCard();
                            UpdateUICardImage(card.getImagePath());
                            cardDescTextView.setText(card.getCardStats());
                            cardTextTextView.setText(card.getCardTexts());
                        } catch (Exception e){
                            Toast.makeText(getContext(), "Card Not Found on YGOHub", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<YGOHubResponse> call, @NonNull Throwable t) {
                        // TODO: Handle This
                        Toast.makeText(getContext(), "Card Not Found on YGOHub", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void UpdateUICardImage(final String url) {
        workerThread = new Thread(new Runnable() {
            public void run() {
                try {
                    InputStream is = (InputStream) new URL(url).getContent();
                    final Drawable d = Drawable.createFromStream(is, url);
                    cardScanImageView.post(new Runnable() {
                        @Override
                        public void run() {
                            cardScanImageView.setImageDrawable(d);
                        }
                    });
                } catch (Exception e) {
                    Looper.prepare();
                    Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
                    cardScanImageView.setImageResource(R.drawable.card);
                }
            }
        });
        workerThread.start();
    }
}
