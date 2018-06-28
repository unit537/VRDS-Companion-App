package com.dev.unit537.vrds_companion_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


enum Action{
    ADD, SUB
}

enum Player{
    ONE, TWO
}

public class LPCalculatorFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private SharedPreferences sharedPrefs;
    private Button num000Button;
    private Button num00Button;
    private Button num0Button;
    private Button num1Button;
    private Button num2Button;
    private Button num3Button;
    private Button num4Button;
    private Button num5Button;
    private Button num6Button;
    private Button num7Button;
    private Button num8Button;
    private Button num9Button;
    private Button resetButton;
    private Button clearButton;
    private Button diceButton;
    private Button coinButton;
    private Button p1AddLPButton;
    private Button p1SubLPButton;
    private Button p2AddLPButton;
    private Button p2SubLPButton;
    private Button passTurnButton;
    private EditText player1NameText;
    private EditText player2NameText;
    private EditText player1LifepointsText;
    private EditText player2LifepointsText;
    private EditText lifePointsModifierText;
    private TextView turnPlayerText;
    private boolean playersTurn = true; // Player 1 is the starting player
    private ViewPager phaseTracker;

    private String player_one = "Player 1";
    private String player_two = "Player 2";

    public LPCalculatorFragment() {
        // Required empty public constructor
    }

    public static LPCalculatorFragment newInstance() {
        return new LPCalculatorFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lp_calculator, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() +
                    " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        View view = getView();

        sharedPrefs = getActivity().getSharedPreferences("PlayerNames", Context.MODE_PRIVATE);
        num000Button = view.findViewById(R.id.button_num000);
        num00Button = view.findViewById(R.id.button_num00);
        num0Button = view.findViewById(R.id.button_num0);
        num1Button = view.findViewById(R.id.button_num1);
        num2Button = view.findViewById(R.id.button_num2);
        num3Button = view.findViewById(R.id.button_num3);
        num4Button = view.findViewById(R.id.button_num4);
        num5Button = view.findViewById(R.id.button_num5);
        num6Button = view.findViewById(R.id.button_num6);
        num7Button = view.findViewById(R.id.button_num7);
        num8Button = view.findViewById(R.id.button_num8);
        num9Button = view.findViewById(R.id.button_num9);
        resetButton = view.findViewById(R.id.button_reset);
        clearButton = view.findViewById(R.id.button_clear);
        diceButton = view.findViewById(R.id.button_dice);
        coinButton = view.findViewById(R.id.button_coin);
        p1AddLPButton = view.findViewById(R.id.button_player1AddLP);
        p1SubLPButton = view.findViewById(R.id.button_player1SubLP);
        p2AddLPButton = view.findViewById(R.id.button_player2AddLP);
        p2SubLPButton = view.findViewById(R.id.button_player2SubLP);
        passTurnButton = view.findViewById(R.id.button_passTurn);
        player1NameText = view.findViewById(R.id.editText_player1Name);
        player2NameText = view.findViewById(R.id.editText_player2Name);
        player1LifepointsText = view.findViewById(R.id.editText_player1LP);
        player2LifepointsText = view.findViewById(R.id.editText_player2LP);
        lifePointsModifierText = view.findViewById(R.id.editText_LifePointsModifier);
        turnPlayerText = view.findViewById(R.id.textView_turnPlayer);
        phaseTracker = view.findViewById(R.id.viewPager_PhaseTracker);

        phaseTracker.setAdapter(new PhaseTracker(getChildFragmentManager(), true));  // Hardcoded for Master Duel (Advanced) format

        loadPlayerNames();

        if (playersTurn){
            turnPlayerText.setText(player_one);
        } else {
            turnPlayerText.setText(player_two);
        }

        setupListeners();
        //resetLPCalc();
        clearAllFocus();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("playersTurn", playersTurn);
        super.onSaveInstanceState(outState);
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

    private void setupListeners(){
        num000Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToLPModifier("000");
            }
        });
        num00Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToLPModifier("00");
            }
        });
        num0Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToLPModifier("0");
            }
        });
        num1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToLPModifier("1");
            }
        });
        num2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToLPModifier("2");
            }
        });
        num3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToLPModifier("3");
            }
        });
        num4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToLPModifier("4");
            }
        });
        num5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToLPModifier("5");
            }
        });
        num6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToLPModifier("6");
            }
        });
        num7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToLPModifier("7");
            }
        });
        num8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToLPModifier("8");
            }
        });
        num9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToLPModifier("9");
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "reset", Toast.LENGTH_SHORT).show();
                // TODO: Dialogue to confirm reset whole calc
                resetLPCalc();
            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lifePointsModifierText.getText().clear();
                clearAllFocus();
            }
        });
        diceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Die Roll Coming Soon!", Toast.LENGTH_SHORT).show();
                // TODO: Implement Dice Feature
            }
        });
        coinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Coin Flip Coming Soon!", Toast.LENGTH_SHORT).show();
                // TODO: Implement Coin Feature
            }
        });
        p1AddLPButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyLPModifier(player1LifepointsText, Action.ADD);
            }
        });
        p1SubLPButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyLPModifier(player1LifepointsText, Action.SUB);
            }
        });
        p2AddLPButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyLPModifier(player2LifepointsText, Action.ADD);
            }
        });
        p2SubLPButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyLPModifier(player2LifepointsText, Action.SUB);
            }
        });
        passTurnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passTurn();
                // TODO: Implement Turn Logging
            }
        });

        player1NameText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean focus) {
                if (!focus) {
                    savePlayerName(Player.ONE);
                }
            }
        });
        player1NameText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent keyevent) {
                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    clearAllFocus();
                    return true;
                }
                return false;
            }
        });
        player2NameText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean focus) {
                if (!focus) {
                    savePlayerName(Player.TWO);
                }
            }
        });
        player2NameText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent keyevent) {
                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    clearAllFocus();
                    return true;
                }
                return false;
            }
        });
        player1LifepointsText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean focus) {
                if (!focus) {
                    // TODO: This
                }
            }
        });
        player2LifepointsText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean focus) {
                if (!focus) {
                    // TODO: This
                }
            }
        });
    }

    private void resetPhaseTracker(){
        phaseTracker.setCurrentItem(0, true);
    }

    private void passTurn(){
        playersTurn = !playersTurn;
        if (playersTurn){
            turnPlayerText.setText(player_one);
        } else {
            turnPlayerText.setText(player_two);
        }
        resetPhaseTracker();
        clearAllFocus();
    }

    private void resetLPCalc(){
        player1LifepointsText.setText(R.string._8000);
        player2LifepointsText.setText(R.string._8000);
        lifePointsModifierText.getText().clear();
        if (!playersTurn){
            passTurn();
        } else {
            resetPhaseTracker();
        }
        clearAllFocus();
    }

    private void loadPlayerNames(){
        if(sharedPrefs.getString("Player1Name", null) == null){
            player_one = getString(R.string.player_1);
        } else {
            player_one = sharedPrefs.getString("Player1Name", null);
        }

        if(sharedPrefs.getString("Player2Name", null) == null){
            player_two = getString(R.string.player_2);
        } else {
            player_two = sharedPrefs.getString("Player2Name", null);
        }

        player1NameText.setText(player_one);
        player2NameText.setText(player_two);
    }

    private void savePlayer1Name(){
        if(player1NameText.getText().toString().equals("")){
            sharedPrefs.edit().putString("Player1Name", null).apply();
        } else {
            sharedPrefs.edit().putString("Player1Name",
                    player1NameText.getText().toString()).apply();
        }
    }
    private void savePlayer2Name(){
        if(player2NameText.getText().toString().equals("")){
            sharedPrefs.edit().putString("Player2Name", null).apply();
        } else {
            sharedPrefs.edit().putString("Player2Name",
                    player2NameText.getText().toString()).apply();
        }
    }

    private void savePlayerName(Player player){
        if(player == Player.ONE){
            savePlayer1Name();
        } else if (player == Player.TWO){
            savePlayer2Name();
        } else {
            // TODO: Handle This
            // Something when wrong
        }
        loadPlayerNames();
    }

    private void addToLPModifier(String sequence){
        lifePointsModifierText.getText().insert(lifePointsModifierText.getSelectionEnd(), sequence);
        clearAllFocus();
    }

    private void applyLPModifier(EditText player, Action action){
        int lifePoints = Integer.parseInt(player.getText().toString());
        int modifier = 0;
        String modifiedLP;

        try {
            modifier = Integer.parseInt(lifePointsModifierText.getText().toString());
        } catch (Exception e){
            // TODO: Handle Exception
        }

        if(action == Action.SUB){
            modifier *= -1;
        }
        else if (action == Action.ADD) {
            modifier *= 1;
        }
        else {
            // TODO: Handle This
            // Something went wrong
        }
        modifiedLP = Integer.toString(lifePoints + modifier);
        lifePointsModifierText.getText().clear();
        player.setText(modifiedLP);
        clearAllFocus();
    }

    private void clearAllFocus(){
        player1NameText.clearFocus();
        player2NameText.clearFocus();
        player1LifepointsText.clearFocus();
        player2LifepointsText.clearFocus();
        lifePointsModifierText.clearFocus();
    }
}
