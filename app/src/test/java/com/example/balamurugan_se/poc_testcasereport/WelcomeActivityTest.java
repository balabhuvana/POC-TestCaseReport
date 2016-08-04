package com.example.balamurugan_se.poc_testcasereport;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

/**
 * Created by balamurugan_se on 8/4/2016.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class WelcomeActivityTest {

    private WelcomeActivity mWelcomeActivity;

    @Before
    public void setup() {
        mWelcomeActivity = Robolectric.setupActivity(WelcomeActivity.class);
    }

    @Test
    public void checkActivityNotNull() throws Exception {
        Assert.assertNotNull(mWelcomeActivity);
    }

    @Test
    public void clickingLogin_shouldStartLoginActivity() {

        Button mButton = (Button) mWelcomeActivity.findViewById(R.id.login);
        mButton.performClick();

        Intent presentIntent = Shadows.shadowOf(mWelcomeActivity).getNextStartedActivity();
        Intent expectedIntent = new Intent(mWelcomeActivity, LoginActivity.class);
        Assert.assertEquals(LoginActivity.class.getCanonicalName(), presentIntent.getComponent().getClassName());

    }

    @Test
    public void clickingButton_shouldChangeResultsViewText() throws Exception {
        Activity activity = Robolectric.setupActivity(MyActivity.class);

        Button button = (Button) activity.findViewById(R.id.press_me_button);
        TextView results = (TextView) activity.findViewById(R.id.results_text_view);

        button.performClick();
        Assert.assertEquals(results.getText().toString(), "Testing Android Rocks!");

    }

}
