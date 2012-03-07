package com.developer4droid.weight_test;


import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.*;
import com.developer4droid.weight_test.adapters.ItemsAdapter;

import java.util.List;

/**
 * GamePanelTestActivity class
 *
 * @author alien_roger
 * @created at: 06.03.12 7:39
 */
public class GamePanelActivity extends Activity{

    private LinearLayout whiteCapturedPieces;
    private LinearLayout blackCapturedPieces;
    private ListView movesListView;

//    private static final int ITEMS_CNT = 4;
    private static final float WEIGHT_SUM = 16f;

    private LinearLayout weightView;
    private LinearLayout seekView;
    private LinearLayout changeView;
    private TextView total;

	@Override
	public void onAttachedToWindow() {
		super.onAttachedToWindow();
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
		// Eliminates color banding
		getWindow().setFormat(PixelFormat.RGBA_8888);
	}

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_panel);
//        whiteCapturedPieces = (LinearLayout) findViewById(R.id.whiteCapturedPieces);
//        blackCapturedPieces = (LinearLayout) findViewById(R.id.blackCapturedPieces);
//        movesListView = (ListView) findViewById(R.id.movesListView);
//
//
//
//        List<String> itemList = new ArrayList<String>();
//
//        itemList.add("42. Bf3  Ke7");
//        itemList.add("43. Nd5+  Nxd5");
//        itemList.add("44. exd5  Ke7");
//        itemList.add("44. exd5  Ke7");
//        itemList.add("44. exd5  Ke7");
//        itemList.add("44. exd5  Ke7");
//        itemList.add("44. exd5  Ke7");
//        itemList.add("44. exd5  Ke7");
//        itemList.add("44. exd5  Ke7");
//
//        movesListView.setAdapter(new MovesAdapter(this,itemList));
//
//        addItems(whiteCapturedPieces, R.drawable.captured_bq, 1, 1.0f);
//        addItems(whiteCapturedPieces, R.drawable.captured_br, 2, 1.0f);
//        addItems(whiteCapturedPieces, R.drawable.captured_bb, 2, 1.0f);
//        addItems(whiteCapturedPieces, R.drawable.captured_bn, 2, 1.0f);
//        addItems(whiteCapturedPieces, R.drawable.captured_bp, 8, 1.0f);
//        addItems(whiteCapturedPieces, R.drawable.captured_bk, 1, 1.0f);
//
//        addItems(blackCapturedPieces, R.drawable.captured_wq, 1, 1.0f);
//        addItems(blackCapturedPieces, R.drawable.captured_wr, 2, 1.0f);
//        addItems(blackCapturedPieces, R.drawable.captured_wb, 2, 1.0f);
//        addItems(blackCapturedPieces, R.drawable.captured_wn, 2, 1.0f);
//        addItems(blackCapturedPieces, R.drawable.captured_wp, 8, 1.0f);
//        addItems(blackCapturedPieces, R.drawable.captured_wk, 1, 1.0f);
//
//		movesListView.setSelection(movesListView.getAdapter().getCount()-1);

    }


    private void addItems(LinearLayout viewGroup, int pieceId, int layersCnt, float itemWeight) {

        Drawable[] layers = new Drawable[layersCnt];

        for (int j = 0; j < layersCnt; j++) {
            layers[j] = getResources().getDrawable(pieceId);
        }

        LayerDrawable pieceDrawable = new LayerDrawable(layers);

        for (int i = 0; i < layersCnt; i++) {
            shiftLayer(pieceDrawable, i);
        }

        ImageView imageView = new ImageView(this);
        imageView.setAdjustViewBounds(false);
        imageView.setScaleType(ImageView.ScaleType.CENTER);


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        params.weight = itemWeight;
        params.gravity = Gravity.LEFT;

        imageView.setImageDrawable(pieceDrawable);
        imageView.setLayoutParams(imageParams);
        viewGroup.setWeightSum(16f);

        // put iamge inside frame to get left gravity
        FrameLayout frame = new FrameLayout(this);
        frame.addView(imageView);
        frame.setLayoutParams(params);

        viewGroup.addView(frame);
        viewGroup.setGravity(Gravity.LEFT);
    }

    private int shiftSize = 6;

    private void shiftLayer(LayerDrawable pieceDrawable, int level) {

        int l = level * shiftSize;
        int r = 0;
        int t = 0;
        int b = 0;
        pieceDrawable.setLayerInset(level, l, t, r, b);
        ((BitmapDrawable) pieceDrawable.getDrawable(level)).setGravity(Gravity.LEFT | Gravity.TOP);
    }


    private class MovesAdapter extends ItemsAdapter<String> {


		public MovesAdapter(Context context, List<String> itemList) {
			super(context, itemList);
		}

		@Override
		protected View createView(ViewGroup parent) {
			View view = inflater.inflate(R.layout.game_panel_list_item,parent,false);
			return view;
		}

		@Override
		protected void bindView(String item, int pos, View convertView) {
			((TextView)convertView).setText(item);
		}
	}
}