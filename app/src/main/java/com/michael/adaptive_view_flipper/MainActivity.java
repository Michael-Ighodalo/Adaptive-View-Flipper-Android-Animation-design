package com.michael.adaptive_view_flipper;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private AdapterViewFlipper adapterViewFlipper;
    private Button btnPrevious,btnNext;
    private static final String[] TEXT = {"When in Rome, do as the Romans","The squeaky wheel gets the grease",
            "Two wrongs does not make a right","Hope for the best, but prepare for the worst","A picture is worth a thousand words"};
    private static final int[] IMAGES = {R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground};
    private int mPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.idAdapterViewFlipper);

        //creating adapter object
        FlipperAdapter adapter = new FlipperAdapter(this, TEXT,IMAGES);
        adapterViewFlipper.setAdapter(adapter);
        adapterViewFlipper.setAutoStart(true);
        //adapterViewFlipper.setFlipInterval();
        //adapterViewFlipper.setBackground();
        //adapterViewFlipper.setAnimation();
    }

    class FlipperAdapter extends BaseAdapter{
        Context ctx;
        int[] images;
        String[] text;
        LayoutInflater inflater;

        public FlipperAdapter (Context context, String[] myText, int[] myimages){
            this.ctx = context;
            this.images = myimages;
            this.text = myText;
            inflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount(){
            return text.length;
        }

        @Override
        public Object getItem(int i){
            return null;
        }

        @Override
        public long getItemId(int i){
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup){
            view = inflater.inflate(R.layout.flipper_items, null);
            TextView txtName = (TextView) view.findViewById(R.id.idTextView);
            ImageView txtImage = (ImageView) view.findViewById(R.id.idImageView);
            txtName.setText(text[i]);
            txtImage.setImageResource(images[i]);
            return view;
        }

    }
}
