package com.cyanogenmod.settings.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
// import android.hardware.TvOut;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;

public class DeviceSettings extends PreferenceActivity  {

    public static final String KEY_COLOR_TUNING = "color_tuning";
    public static final String KEY_MDNIE = "mdnie";
    public static final String KEY_GSENSOR = "gsensor";
    public static final String KEY_BACKLIGHT_WAKELOCK = "backlight_wakelock";
    public static final String KEY_BACKLIGHT_TIMEOUT = "backlight_timeout";
    public static final String KEY_HSPA = "hspa";
    public static final String KEY_HSPA_CATEGORY = "category_radio";
//    public static final String KEY_TVOUT_ENABLE = "tvout_enable";
//    public static final String KEY_TVOUT_SYSTEM = "tvout_system";
    public static final String KEY_VOLUME_BOOST = "volume_boost";
    public static final String KEY_VOLUME_CATEGORY = "category_volume_boost";

    /*private ColorTuningPreference mColorTuning;
    private ListPreference mMdnie;*/
    private ListPreference mBacklightTimeout;
    private CheckBoxPreference mBacklightWakelock;
    private Preference mGSensor;
    /*private ListPreference mHspa;
    private CheckBoxPreference mTvOutEnable;
    private ListPreference mTvOutSystem;
    private TvOut mTvOut;
    private VolumeBoostPreference mVolumeBoost;

    private BroadcastReceiver mHeadsetReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            int state = intent.getIntExtra("state", 0);
            updateTvOutEnable(state != 0);
        }

    };*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.main);

        /*mColorTuning = (ColorTuningPreference) findPreference(KEY_COLOR_TUNING);
        mColorTuning.setEnabled(ColorTuningPreference.isSupported());

        mMdnie = (ListPreference) findPreference(KEY_MDNIE);
        mMdnie.setEnabled(Mdnie.isSupported());
        mMdnie.setOnPreferenceChangeListener(new Mdnie());*/

        mBacklightWakelock = (CheckBoxPreference) findPreference(KEY_BACKLIGHT_WAKELOCK);
        mBacklightWakelock.setEnabled(TouchKeyBacklightWakelock.isSupported());
        mBacklightWakelock.setOnPreferenceChangeListener(new TouchKeyBacklightWakelock());

        mBacklightTimeout = (ListPreference) findPreference(KEY_BACKLIGHT_TIMEOUT);
        mBacklightTimeout.setEnabled(TouchKeyBacklightTimeout.isSupported());
        mBacklightTimeout.setOnPreferenceChangeListener(new TouchKeyBacklightTimeout());

		mGSensor = (Preference) findPreference(KEY_GSENSOR);
        mGSensor.setEnabled(GSensor.isSupported());

        /*mHspa = (ListPreference) findPreference(KEY_HSPA);
        if (Hspa.isSupported()) {
           mHspa.setOnPreferenceChangeListener(new Hspa(this));
        } else {
           PreferenceCategory category = (PreferenceCategory) getPreferenceScreen().findPreference(KEY_HSPA_CATEGORY);
           category.removePreference(mHspa);
           getPreferenceScreen().removePreference(category);
        }

        mVolumeBoost = (VolumeBoostPreference) findPreference(KEY_VOLUME_BOOST);
        if (!VolumeBoostPreference.isSupported()) {
            PreferenceCategory category = (PreferenceCategory) getPreferenceScreen().findPreference(KEY_VOLUME_CATEGORY);
            category.removePreference(mVolumeBoost);
            getPreferenceScreen().removePreference(category);
        }

        mTvOut = new TvOut();
        mTvOutEnable = (CheckBoxPreference) findPreference(KEY_TVOUT_ENABLE);
        mTvOutEnable.setChecked(mTvOut._isEnabled());

        mTvOutEnable.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {

            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean enable = (Boolean) newValue;
                Intent i = new Intent(DeviceSettings.this, TvOutService.class);
                i.putExtra(TvOutService.EXTRA_COMMAND, enable ? TvOutService.COMMAND_ENABLE : TvOutService.COMMAND_DISABLE);
                startService(i);
                return true;
            }

        });

        mTvOutSystem = (ListPreference) findPreference(KEY_TVOUT_SYSTEM);
        mTvOutSystem.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {

            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if (mTvOut._isEnabled()) {
                    int newSystem = Integer.valueOf((String) newValue);
                    Intent i = new Intent(DeviceSettings.this, TvOutService.class);
                    i.putExtra(TvOutService.EXTRA_COMMAND, TvOutService.COMMAND_CHANGE_SYSTEM);
                    i.putExtra(TvOutService.EXTRA_SYSTEM, newSystem);
                    startService(i);
                }
                return true;
            }

        });*/
    }
/*
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mHeadsetReceiver, new IntentFilter(Intent.ACTION_HEADSET_PLUG));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mHeadsetReceiver);
    }

    private void updateTvOutEnable(boolean connected) {
        mTvOutEnable.setEnabled(connected);
        mTvOutEnable.setSummaryOff(connected ? R.string.tvout_enable_summary : R.string.tvout_enable_summary_nocable);

        if (!connected && mTvOutEnable.isChecked()) {
            // Disable on unplug (UI)
            mTvOutEnable.setChecked(false);
        }
    }

    @Override
    protected void onDestroy() {
        mTvOut.finalize();
        super.onDestroy();
    }
*/
	// private void updateTvOutEnable(boolean connected) {}
}