package com.dev.unit537.vrds_companion_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PhaseTracker extends FragmentStatePagerAdapter {

    boolean masterDuel;

    public PhaseTracker(FragmentManager fm, boolean masterDuel) {
        super(fm);
        this.masterDuel = masterDuel;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("masterDuel", masterDuel);
        bundle.putInt("phaseNo", position);
        Phase phase = new Phase();
        phase.setArguments(bundle);
        return phase;
    }

    @Override
    public int getCount() {
        return 6;
    }
}
