package uk.co.deanwild.materialshowcaseviewsample;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;


public class TooltipExample extends Activity implements View.OnClickListener {

    private Button mButtonShow;
    private Button mButtonReset;
    private FloatingActionButton fab;

    private static final String SHOWCASE_ID = "tooltip example";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tooltip_example);
        mButtonShow = findViewById(R.id.btn_show);
        mButtonShow.setOnClickListener(this);

        mButtonReset = findViewById(R.id.btn_reset);
        mButtonReset.setOnClickListener(this);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);

        presentShowcaseView(); // one second delay
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_show) {

            presentShowcaseView();

        } else if (v.getId() == R.id.btn_reset) {

            MaterialShowcaseView.resetSingleUse(this, SHOWCASE_ID);
            Toast.makeText(this, "Showcase reset", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.fab) {

        }

    }

    void presentShowcaseView() {

        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, SHOWCASE_ID);

        sequence.addSequenceItem(

                new MaterialShowcaseView.Builder(this)
                        .setTarget(mButtonShow)
                        .setToolTipText("This is a <b>very funky</b> tooltip")
                        .setShapePadding(50)
                        .setTooltipMargin(30)
                        .setDismissOnTouch(true)
                        .setMaskColour(getResources().getColor(R.color.tooltip_mask))
                        .build()
        );

        sequence.addSequenceItem(
                new MaterialShowcaseView.Builder(this)
                        .setTarget(fab)
                        .setTooltipMargin(30)
                        .setToolTipText("This is another <b>very funky</b> tooltip")
                        .setShapePadding(50)
                        .setDismissOnTouch(true)
                        .setMaskColour(getResources().getColor(R.color.tooltip_mask))
                        .build()
        );

        sequence.start();
    }
}
