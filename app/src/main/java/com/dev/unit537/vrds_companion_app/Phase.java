package com.dev.unit537.vrds_companion_app;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Phase extends Fragment {

    private boolean masterDuel;
    private int phaseNo = 0;
    private String[] masterDuelPhases = {"Draw Phase", "Standby Phase", "Main Phase 1", "Battle Phase", "Main Phase 2", "End Phase"};
    private String[] speedDuelPhases = {"Draw Phase", "Standby Phase", "Main Phase 1", "Battle Phase", "End Phase"};
    private String[] battlePhaseSteps = {"Start Step", "Battle Step", "Damage Step", "End Step"};

    public Phase(){
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        this.masterDuel = getArguments().getBoolean("masterDuel");
        this.phaseNo = getArguments().getInt("phaseNo");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.viewpager_phase_element, container, false);
        TextView phase = view.findViewById(R.id.textView_CurrentPhase);
        if (masterDuel){
            phase.setText(masterDuelPhases[phaseNo]);
        } else {
            phase.setText(speedDuelPhases[phaseNo]);
        }

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
