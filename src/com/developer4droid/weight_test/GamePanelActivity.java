package com.developer4droid.weight_test;


import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Spinner;
import com.developer4droid.weight_test.views.GamePanelView;
import com.developer4droid.weight_test.views.PieceItem;

/**
 * GamePanelTestActivity class
 *
 * @author alien_roger
 * @created at: 06.03.12 7:39
 */
public class GamePanelActivity extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

	private GamePanelView gamePanel;
	private Spinner whiteSpinner;
	private Spinner blackSpinner;

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
		gamePanel = (GamePanelView) findViewById(R.id.gamePanel);
		
		
		findViewById(R.id.captureBtn).setOnClickListener(this);
		findViewById(R.id.restoreBtn).setOnClickListener(this);
		whiteSpinner = (Spinner) findViewById(R.id.whiteCaptures);
		whiteSpinner.setOnItemSelectedListener(this);
		blackSpinner = (Spinner) findViewById(R.id.blackCaptures);
    }


	@Override
	public void onClick(View view) {
		if(view.getId() == R.id.captureBtn){
			String item = (String) whiteSpinner.getSelectedItem();

			PieceItem pieceItem = new PieceItem();
			pieceItem.setStringCode(item); //Code(PieceItem.P);

			gamePanel.capturePiece(pieceItem);
		} else if(view.getId() == R.id.restoreBtn){
			String item = (String) whiteSpinner.getSelectedItem();

			PieceItem pieceItem = new PieceItem();
			pieceItem.setStringCode(item); //Code(PieceItem.P);
			gamePanel.restorePiece(pieceItem);
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
		String item = (String) adapterView.getItemAtPosition(i);
		
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> adapterView) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}